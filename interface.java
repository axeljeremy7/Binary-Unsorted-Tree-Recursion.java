


public interface Node {
	/**
     * This method creates a new Node and
     * adds it to the children of the node it was called on
  * if its ID matches the parentID, otherwise it looks through
  * all its children
* @param ID : string id node
* @param parentID: string parent node id 
* @return true if successful, false otherwise 
* */
public boolean addChild(String ID, String parentID);

/**
* Looks within the tree to find if value is contained
* in that subtree. The node you use to call the find function * acts as the root of the tree.
* @param value a string to be found in the tree
* @return the node if found.
*/
public Node find(String value); /**
     * Gets the parent of that node.
* @return the parent node of the Node that is used to call this function.
*/
public Node getParent(); /**
     * Gets the size of the tree.
* @return the size of the tree starting from the node that is used to call
* this function, all the way down to the leaf nodes.
*/
public int size();
/**
* Converts the data into a string and returns it * For example, Node A has 2 children B and C.
* A.toString() will return A B C
* @return String representation of the node.
*/
public String toString();
/**
* Function to get the ID of the node.
* @return String representation of the node ID */
public String getId();
/**
* Prints the node upon which this method is called * as well as all the children node.
* Use the toString() format to print.
*/
public void printTree();

}
