class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;

   public void insert(int value) {
      this.root = insert(this.root, value);
   }

   /*
   recursive insert method
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
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      return false;           
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
   
   
   
   /*
   this method will not compile until getMax
   is implemented
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
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      /*System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();*/

      System.out.println("Min Value: " + t1.getMin(t1.root));
      System.out.println("Max Value: " + t1.getMax(t1.root));
           
      
   }  
}