package TestPackage;
import java.util.Scanner;

import edu.wmich.cs1120.spring16.lab2Axel.TreeDataStructure;

public class TestClassForTrees {
	/**
	 * In here is going to be implemented all the methods
	 * that are from class TreeDataStructure to add node or find a node or get the size of the tree
	 * @param args string array
	 */

	public static void main(String[] args) {
		TreeDataStructure root = new TreeDataStructure("A");
		root.addChild("B", "A");
		root.addChild("C", "A");
		root.addChild("D", "B"); 
		root.addChild("E", "B"); 
		root.addChild("F", "C"); 
		root.addChild("G", "C"); 
		root.addChild("H", "D"); 
		root.addChild("I", "D"); 
		root.addChild("J", "E"); 
		root.addChild("K", "E"); 
		root.addChild("L", "F");
		printMenu();// show the user the menu
		Scanner key = new Scanner(System.in);// use scanner to get the answer of the user
		int n = key.nextInt();// getting the answer in integer
		boolean conti = true;// a boolean just for the loop
		while(conti){	
            if(n==0){
				System.exit(0);// exit for the user
			}
			if(n==1){
				optionOne(root);// method about the first choice which is ADD NODE
                printMenu();
                n=getChoice(key);// getting the choice
                if (n == 0) {// evaluating the preference of the user
                	root.printTree();
                	System.exit(0);// exit
                } else {
                    conti = true;// continue the program 
                }
			}
			if(n==2){
				optionTwo(root);// method about the second choice which is TREEE SIZE
				printMenu();
                n=getChoice(key);// getting the choice
                if (n == 0) {// evaluating the preference of the user
                	root.printTree();
                	System.exit(0);// exit
                } else {
                    conti = true;// continue the program 
                }
			}
			if(n==3){
				optionThree(root);// method about the third choice which is FIND NODE
				printMenu();
                n=getChoice(key);// getting the choice
                if (n == 0) {// evaluating the preference of the user
                	root.printTree();
                	System.exit(0);// exit
                } else {
                    conti = true;// continue the program 
                }
			}
		}
	}
	/**
	 * Method to print the options for the user such as
	 * 1.add a node, 2.find a node , 3.size of the tree and 0.exit
	 */
	public static void printMenu(){
		System.out.print(" Please, write an integer for your choice:" + 
	        " \n 1.Add a node \n 2.Tree Size \n 3.Find Node \n 0.exit \n");
	}
	/**
	 * Method to get the choice of the user
	 * @param keyboard: an object of the class Scanner to read the input of the user
	 * @return n: an integer , this represent the choice of the user
	 */
	public static int getChoice(Scanner keyboard) {
        int n = keyboard.nextInt();
        return n;
    }
	/**
	 * Method for the option one which is ADD NODE
	 * @param root: an object to pass all the information about the tree
	 */
	public static void optionOne(TreeDataStructure root){
		Scanner key1 = new Scanner(System.in);
		System.out.print("Please input the Node you want to add-> ");
		String child = key1.nextLine().toUpperCase();
		System.out.print("Please input the parent node of " + child + "->" );
		String parent = key1.nextLine().toUpperCase();
		if (root.find(parent) != null){// node has to exist to find
			if(root.addChild(child, parent) == true){// check is full or not
				System.out.println("Node successfully Added.");
				System.out.println("\n The Updated tree:");
				root.printTree();
				System.out.println("---------------------------");
			}else{// it is full
				System.out.println("Node is full.");
				System.out.println("---------------------------");
			}
			
		}else{// not exists
			System.out.println("The parent node: "+ parent+ " does not exist.");
			System.out.println("---------------------------");
		}
	}
	/**
	 * Method for the option two which is TREE SIZE
	 * @param root: : an object to pass all the information about the tree
	 */
	public static void optionTwo(TreeDataStructure root){
		Scanner key2 = new Scanner(System.in);
		System.out.print("Please input the root node -> ");
		String rootNode = key2.nextLine().toUpperCase();
		
		if (root.find(rootNode) != null){// node has to exist to find
			if(root.find(rootNode).size() ==1){// leaf node
				System.out.println("There is " +root.find(rootNode).size() + " node in the tree.");
				System.out.println("---------------------------");
			}else{// other nodes
			    System.out.println("There are " +root.find(rootNode).size() + " nodes in the tree.");
			}
			System.out.println("---------------------------");
		}
		
		else{
			if (rootNode.equals("A")){// this case is when "A" is the root of the node
				System.out.println( "You choose the root of the tree which is " + rootNode +". \n" +
			                "The total number of nodes in the tree is  " +root.size() );
				System.out.println("---------------------------");
			}else{// not node exist
			System.out.println("The root node: " + rootNode +" does not exist.");
			System.out.println("---------------------------");
			}
		}
		
	}
	/**
	 * Method for the option three which is FIND NODE
	 * @param root: an object to pass all the information about the tree
	 */
	public static void optionThree(TreeDataStructure root){
		Scanner key3 = new Scanner(System.in);
		System.out.print("Please input the node you want to look for -> ");
		String nodeToFind = key3.nextLine().toUpperCase();
		if (root.find(nodeToFind) != null){// node has to exist to find
			System.out.println("There exists " +  nodeToFind );
			System.out.println("---------------------------");
		}

		else{
			 if (nodeToFind.equals("A")){//this case is when "A" is the root of the node
					System.out.println("You choose the root of the tree which is " +  nodeToFind );
					System.out.println("---------------------------");
				}else{// not node exist
			        System.out.println("Node " + nodeToFind  + " does not exist");
			        System.out.println("---------------------------");
				}
		}
		
	}

}
