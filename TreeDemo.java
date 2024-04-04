/**
 * A class used to store a single node's information.
 */
class Node{
   /**
    * The integer value of the current node
    */
   int value;
   /**
    * The left and right children of the current node
    */
   Node left, right;

   /**
    * Constructor to create a new node with the specified value
    * @param value The value of the new node to be created.
    */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

/**
 * A class used to create and modify BinarySearchTrees
 */
class BinarySearchTree{

   /**
    * The root node of the BinarySearchTree
    */
   Node root;

   /**
    * Inserts a new node with the specified value into the binary search tree.
    * @param value The value of the new node to be added to the tree.
    */
   public void insert(int value) {
      this.root = insert(this.root, value);//Call the recursive method to add the new node. This method will return the root, so set the root of the current tree equal to the returned node.
   }

   /**
    * Recursive helper method to insert a new node into the specified tree. This method should only be called from the insert(int value) method.
    * @param The root node of the current branch being traversed.
    * @param value The value of the new node to be added to the tree.
    * @return The root node of the current tree.
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }



   /**
    * Pre-Order Traversal
    * Prints the contents of the tree in pre-order.
    * @param root The root of the tree to be printed.
    */
   public void preOrderTraversal(Node root){
      if(root == null) return;//Base case: root parameter is null, this branch of the tree traversal is finished, so do nothing and exit the function.
      System.out.print(" " + root.value + " ");//Print the current node
      preOrderTraversal(root.left);//Recursively traverse left
      preOrderTraversal(root.right);//Recursively traverse right
   }

   
   
   /**
    * In-Order Traversal
    * Prints the contents of the tree in sorted order.
    * @param root The root of the tree to be printed.
   */
   public void inOrderTraversal(Node root){
      if(root == null) return;//Base case: root parameter is null, this branch of the tree traversal is finished, so do nothing and exit the function.
      inOrderTraversal(root.left);//Recursively traverse left
      System.out.print(" " + root.value + " ");//Print the current node
      inOrderTraversal(root.right);//Recursively traverse right
   }



   /**
    * Post-Order Traversal
    * Prints the contents of the tree in post-order.
    * @param root The root of the tree to be printed.
    */
   public void postOrderTraversal(Node root){
      if(root == null) return;//Base case: root parameter is null, this branch of the tree traversal is finished, so do nothing and exit the function.
      postOrderTraversal(root.left);//Recursively traverse left
      postOrderTraversal(root.right);//Recursively traverse right
      System.out.print(" " + root.value + " ");//Print the current node
   }
   
   
   
   /**
    * A method to find the node in the tree with a specific value
    * @param root The root of the tree to be searched
    * @param key The key of the node to be found in the tree
    * @return Returns true if the node is found in the tree. Returns false if the node with the specified key could not be found.
   */
   public boolean find(Node root, int key){
      Node temp = root;//Start searching for the node at the root of the tree.

      while(temp != null) {//Loop through the tree until you reach a null branch. 
         if(temp.value == key) return true;//If the current node matches the key, return true.
         if(temp.value < key) temp = temp.right;//If the current node is smaller than the requested key, move to the right.
         if(temp.value > key) temp = temp.left;//If the current node is larger than the requested key, move to the left.
      }
      return false;//If the tree has been traversed and the key wasn't found, return false. They key is not in the tree.
   }
   
   
   
   /**
   * A method to find the node in the tree
   * with a smallest key
    * @param root The root of the tree
    * @return The minimum value of the tree with the provided root.
   */
   public int getMin(Node root){
      Node temp = root;//Begin at the root of the current tree

      while(temp.left != null) {//Continue looping until temp is the left-most node in the tree.
         temp = temp.left;//Update temp to be its left node.
      }
      return temp.value;//Return the minimum node value in the tree. 
   }



   /**
    * A method to find the node in the tree
    * with the largest key
    * @param root The root of the tree
    * @return The maximum value of the tree with the provided root.
    */
   public int getMax(Node root){
      Node temp = root;//Begin at the root of the current tree

      while(temp.right != null) {//Continue looping until temp is the right-most node in the tree.
         temp = temp.right;//Update temp to be its right node.
      }
      return temp.value;//Return the maximum node value in the tree.
   }


   /**
    * Deletes a node with the specified key value from the tree.
    * @param root The root of the tree
    * @param key The key of the node to be deleted from the tree.
    * @return The root node of the tree
    */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   /**
    * The starting point of the program
    * @param args The initial argument
    */
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();//Create a new binary search tree and populate it with nodes.
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);

      System.out.println("Min Value: " + t1.getMin(t1.root));//Test the minValue method
      System.out.println("Max Value: " + t1.getMax(t1.root));//Test the maxValue method
      System.out.println("Try to find a good value: " + t1.find(t1.root, 18));//This should print true because 18 is in the tree.
      System.out.println("Try to find a bad value: " + t1.find(t1.root, 81));//This should print false because 81 is not in the tree.

      //Test the inOrderTraversal method
      System.out.print("in-order : ");
      t1.inOrderTraversal(t1.root);
      System.out.println();

      //Test the preOrderTraversal method
      System.out.print("pre-order : ");
      t1.preOrderTraversal(t1.root);
      System.out.println();

      //Test the postOrderTraversal method
      System.out.print("post-order : ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
   }  
}