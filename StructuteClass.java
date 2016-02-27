

public class TreeDataStructure implements Node {
	private String parentID;
	private String id;
	TreeDataStructure left;
	TreeDataStructure rigth;
	
/**
 * a constructor to initialize the tree
 * @param id: string 
 * 
 */
	public TreeDataStructure(String id){
		this.id=id;
		
	}
	/**
	 * Constructor from id and parentId
	 * @param id: string
	 * @param parentID: string 
	 */
    public TreeDataStructure(String id, String parentID ){
		this.id=id;
		this.parentID = parentID;
		
	}
    /**
     * Method to get the leftChild
     * @return left: object leftChild
     */
    public TreeDataStructure getLeft(){
    	return left;
    }
    /**
     * Method to get the rigthChild
     * @return rigth : object rigthChild
     */
    public TreeDataStructure getRigth(){
    	return rigth;
    }
    
	/**
	 * A boolean method to add child only to the left or right using recursion
	 * only when  the parentID match  the id of the parent
	 * @param  ID :the child
	 * @param parentID :the parent 
	 */
    public boolean addChild(String ID, String parentID) {
		 TreeDataStructure nodetoadd = new TreeDataStructure(ID, parentID);
		 boolean eval;
		 if(parentID.equals(this.id) ){// match the parentID to the id of the parent
			 if(this.left == null){// if is empty
				 this.left = nodetoadd;// add to the left
				 return true;
			 }else{// if left is not empty
				 if(this.rigth == null){//  if right is empty
					 this.rigth = nodetoadd;// add to the right
					 return true;
				 }else{
					 return false;// because only have two options, so return false and cannot be added
				 }
			 }	
		 }else{// when it is not matched  
			 if(this.left != null){// if the left is not empty, so there is chance to be added
				 eval =left.addChild(ID, parentID);// go to the left evaluating after has to go the right to add using recursion
			      if(eval == true){// adding when is true
			    	  return true;
			      }else{
			    	  if(this.rigth != null){// if the right is not empty,  so there is chance to be added
							 return rigth.addChild(ID, parentID);	// just add using recursion		 
						 }else{
							 return false;// return false because only we have 2 options
						}
			      }
	
			 }else{
				 
				 return false;
			 }
		 }
		
	}
	
	 
    @Override
	
	/**
	* Looks within the tree to find if value is contained
	* in that subtree with recursion 
	* @param value: a string to be found in the tree
	* @return the node if is founded
	*/
	public Node find(String value) {
    	Node temp;
       if(this.left !=null  ){//if the left is not empty
    		if(this.left.id.equals(value) ){// the left match the value
    				return left;
    		}else{// the left does not match
    			if(this.rigth !=null){// if the right is not empty
    				if(this.rigth.id.equals(value)){//the right match the value
    					return rigth;
    				}else{
    					temp = left.find(value);// go to the left recursively until there is no more left and return null
    					if(temp != null){
    						return left.find(value);
    					}else{// if is null , now go to the right recursively 
    						return rigth.find(value);	
    					}
    				}
    			}else{// when one child without brothers have a child
    				temp = left.find(value);
					if(temp != null){
						return left.find(value);
					}// it does not need to go to the right because always check the left in the base case
    			}
    		}
    	}else{
    		return null;
    	}
	return null;
       

	}
    /**
     * A method to return a String in a format: parentID + " has " + id
     * @return String: parentID + " has " + id
     */
    
    public String toString(){
		return " "+parentID + " has " + id;
    }

	@Override
	/**
	 * This method is to print the parent with the children each line
	 * using recursion method and the function toString
	 * First print the left part of the tree and then rigth part of the tree
	 * 
	 */
	
	public void printTree() {
	
		if (left != null) {
			System.out.println(left.toString());
			left.printTree();
		}
		
		if(rigth != null){
			System.out.println(rigth.toString());
			rigth.printTree();
		}

	}
	
	 
	@Override
	/**
	 * Get the parent of the node received
	 * @return a node 
	 */
	public Node getParent() {
		TreeDataStructure	node = new TreeDataStructure(parentID);
		return node;
	}

	@Override
	/**
	 * method to get the size of the tree from the node that is  
	 *called or consider parent by the user.
     * @return the size of the tree starting from the node called.
     * 
     */
	public int size() {
		int count =1;
		if(this.rigth !=null) {// while the rigthChild is not empty count using recursion
			count+=rigth.size();
			}
		if(this.left !=null){ //// while the leftChild is not empty count using recursion
			count+=left.size();
			}
		return count ;
	}

	@Override
	/**
	* method to get the ID of the node.
	* @return String representation of the node ID 
	* 
	* */
	public String getId() {
		return id;
	}

	
}
