import java.util.Arrays;
/**
 *  In this class we create a node class that creates the nodes storing the country
 *  name and GDP per Capita. The create a constuctor that creates the tree.
 *  Next is the insert method that inserts the nodes based on the Name of the countries.
 *  Then the find method searches for nodes based on the name and prints how many 
 *  nodes are visited. The delete method works with the getSuccessor method to delete
 *  a Node and recreate the tree as a correct binary search tree. Print Inorder, Preorder 
 *  and Postorder traverse the tree in the given ways. Insert bestelement and remove are all used to 
 *  print the top and bottom 10 countires by GDP per Capita
 * 
 * @author <Chase Goodband>
 * @version<11/16/2019>
 * 
 *
 */
public class BinarySearchTree {
	
	public Node root;
	Node[] queArray = new Node[155];
	Node[] anArray = new Node[155];
	public class Node{
		String name;
		 
		Node leftChild;
		Node rightChild;

		private double gdpPerCapita;
		
		/**
		 * 
		 * @param name this is the name for the country 
		 * @param gdpPerCapita this is the GDP per Capita for the country
		 * this is the constrcutor for the Node class.
		 */
		public Node(String name, double gdpPerCapita)
		{
			this.name = name;
			this.gdpPerCapita = gdpPerCapita;
		
		}
		/**
		 * This method prints the nodes in the desired way
		 */
		public void printNode() {
			System.out.printf("%-25s%,-20.2f\n", name, gdpPerCapita);
		}
	}
	
	
	/**
	 * this method created the Binary Search Tree
	 */
	public BinarySearchTree()
	{
		 root = null;
	}
	/**
	 * 
	 * @param name This is the name of the country in the Node
	 * @param gdpPerCapita This is the GDP per Capita of the country in the Node
	 * this method inserts the nodes into the tree based on the name of the country.
	 */
	public void insert(String name, double gdpPerCapita) {
		Node newNode = new Node(name, gdpPerCapita);
		
		//newNode.name = name;
		//newNode.gdpPerCapita = gdpPerCapita;
		
		if(root==null) {
			root = newNode;
		}
		else
		{
			Node current = root;
			Node parent;
			while(true) 
			{
				parent = current;
				if(0 > name.compareToIgnoreCase(current.name))
				{
					current = current.leftChild;
					if(current == null) 
					{
					parent.leftChild = newNode;
					return;
					}
				}  // end if go left 
				else 
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}   // end if go right 
			}       // end while 
		}           // end else not root 
	}               // end insert() 
	
	int counter = 0;
	/**
	 * 
	 * @param name This is the name of the country inside the node
	 * This method finds the desired country in the Tree and prints how many nodes 
	 * were visited
	 */
	public void find(String name)
	{
		Node current = root;
		counter = 0;
		while(name.compareToIgnoreCase(current.name) != 0)
		{
			counter++;
			if(0 > name.compareToIgnoreCase(current.name ))
					{
				current = current.leftChild;
					}
			else
			{
				current = current.rightChild;
			}
			if(current == null)
			{
				System.out.println(name + " is not found");
				System.out.println(counter + " nodes have been visted");
				return;
			}
		}
		System.out.println(current.name + " is found with GDP per Capita " + current.gdpPerCapita);
		System.out.println(counter + " nodes have been visted");
	} // end find 
	
	
	/**
	 * 
	 * @param name this is the name of the country inside of the Node
	 * This method deletes the node and uses getSuccessor to find the successor of 
	 * the node deleted to create a correct Binary Search Tree.
	 */
	public void delete(String name) {
		Node current = root;
		Node parent = root;
		Boolean isLeftChild = true;
		
		while(name.compareToIgnoreCase(current.name) != 0)
		{
			parent = current;
			if(name.compareToIgnoreCase(current.name) < 0)
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else 
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)
			{
				return ;
			}
		}   //end while 
		if(current.leftChild == null && current.rightChild == null)
		{
			if(current == root)
			{
				root = null;
			}
			else if(isLeftChild)
			{
				parent.leftChild = null;
			}
			else
			{
				parent.rightChild = null;
			}
		}
			//  if no right child, replace with left subtree
			else if(current.rightChild == null)
			{
				if(current == root)
				{
					root = current.leftChild;
				}
				else if(isLeftChild)
				{
					parent.leftChild = current.leftChild;
				}
				else
				{
					parent.rightChild = current.leftChild;
				}
			}
			
				//if no left child replace with right subtree
				else if(current.leftChild == null)
				{
					if(current == root)
					{
						root = current.rightChild;
					}
					else if(isLeftChild)
					{
						parent.leftChild = current.rightChild;
					}
					else
					{
						parent.rightChild = current.rightChild;
					}
					
				}
				else 
				{
					Node successor = getSuccessor(current);
					if(current == root)
					{
						root = successor;
					}
					else if(isLeftChild)
					{
						parent.leftChild = successor;
					}
					else
					{
						parent.rightChild = successor;
					}
					successor.leftChild = current.leftChild;
				} // end else two children
		return ;
			
			} // end of delete()
	
	/**
	 * 
	 * @param delNode this is the node that is being deleted 
	 * @return this returns the successor of the deleted node
	 * This method find the successor of the node that is being deleted
	 */
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		
			
		}
		if(successor != delNode.rightChild)
		{
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
		
	
	
	
	
	/**
	 * 
	 * @param root this is the root of the tree
	 * this method traverses the tree in order and prints each Node
	 */
	public void printinOrder(Node root)
	{
		if(root != null)
		{
			printinOrder(root.leftChild);
			
			root.printNode();
			printinOrder(root.rightChild);
			
		}
	}
/**
 * 
 * @param root This is the root of the tree
 * this method traverses the tree in preorder and prints each Node
 */
	public void printpreOrder(Node root)
	{
		if(root != null)
		{
			root.printNode();
			printpreOrder(root.leftChild);
			
			printpreOrder(root.rightChild);
		}
	}
	/**
	 * 
	 * @param root this is the root of the tree
	 * this method traverses the tree in Postorder and prints each Node
	 */
	public void printpostOrder(Node root)
	{
		if(root != null)
		{
			
			printpostOrder(root.leftChild);
			
			printpostOrder(root.rightChild);
			root.printNode();
			insert(root);
		}
	}
	int nItems;
	int bestElementPos;
	
	/**
	 * 
	 * @param j this is the node being inserted into the array
	 * this method inserts the remaining tree into an array based on GDP per Capita
	 */
	public void insert(Node j)               // insert item
	{
	
		
	    if (nItems == 0) {
			bestElementPos = 0;
		} else {
			if (j.gdpPerCapita < queArray[bestElementPos].gdpPerCapita) {
				bestElementPos = nItems;
			}
			  
		}
		queArray[nItems] = j;              // insert on top of array 
		nItems++;   
		                         //increment nItems
	}
	
	/**
	 * 
	 * @return This returns the Node with the highest GDP per Capita
	 * This method finds the node with the highest GDP per Capita
	 */
	private int findBestElement() {
		if (nItems == 0) return -1;
		if (nItems == 1) return 0;
	    int best = 0;
	    
	    for (int ktr = 1; ktr < nItems; ktr++) {
	        if (queArray[ktr].gdpPerCapita > queArray[best].gdpPerCapita) {
	            best = ktr;
	        }
	    }
	    return best;
	}	
	
	/**
	 * this method prints out the top ten countries by GDP per Capita
	 */
	public void remove()
	{


		for (int i = 0; i < 10; i++) {
		if (bestElementPos != nItems - 1) {
			queArray[bestElementPos] = queArray[ nItems - 1];
		}

		int res = bestElementPos;
		bestElementPos = findBestElement();
		
		
		
		
	    queArray[bestElementPos].printNode();
		}
	}
	/**
	 * This method prints out the bottom 10 countries based on GDP per Capita
	 */
	public void print()
	{


		for (int i = 10; i < 20; i++) {
		if (bestElementPos != nItems - 1) {
			queArray[bestElementPos] = queArray[ nItems - 1];
		}

		int res = bestElementPos;
		bestElementPos = findElement();
		
		
		
		
	    queArray[bestElementPos].printNode();
		}
		 
	}
	/**
	 * 
	 * @return this returns the element with the lowest GDP per capita 
	 * This method find the element with the lowest GDP per Capita
	 */
	private int findElement() {
		if (nItems == 0) return -1;
		if (nItems == 1) return 0;
	    int best = 0;
	    
	    for (int ktr = 1; ktr > nItems; ktr++) {
	        if (queArray[ktr].gdpPerCapita < queArray[best].gdpPerCapita) {
	            best = ktr;
	        }
	    }
	    return best;
	}
	
}


