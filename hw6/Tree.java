package hw6;
// This Tree needs to inherit BTreePrinter
////////////////////////////       Q1    ////////////////////////////
public class Tree extends BTreePrinter { // Fix this
  Node root;

  public Tree(Node root){
    this.root = root;
  }

  public Tree(){} // Dummy constructor (No need to edit)

  public void printTree(){
    if(root!=null)
    {
      super.printTree(root);
    }
    else
    {
      System.out.println("Empty tree!!!");
    }
  }

  public static void printNode(Node node){
    if(node!=null){
      System.out.println(node.key);
    }else{
      System.out.println("Node not found!!!");
    }
    //System.out.println("Node not found!!!");
  }

  public Node find(int search_key){
    if(root!=null){
      return find(root,search_key);
    }
    else{
      return null; // Call the recursive version
    }

  }

  public static Node find(Node node, int search_key){
    // this function should be recursive
    // You should check null in this function
    if(node!=null){
      if (search_key== node.key){
        return node;
      }
      else if (search_key > node.key) {
        return find(node.right,search_key);
      }
      else{
        return find(node.left,search_key);
      }
    }
    else return null;

  }


  public Node findMin(){
    // return null; // Call the recursive version
    if(root!=null){
      return findMin(root);
    }else{
      return null;
    }
  }

  public static Node findMin(Node node){
    // this function should be recursive
    // return null;
    if(node.left!=null){
      return findMin(node.left);
    }
    else{
      return node;}
    }

    public Node findMax(){
      // return null; // Call the recursive version
      if(root!=null){
        return findMax(root);
      }
      else{
        return null;
      }
    }

    public static Node findMax(Node node){
      // this function should be recursive
      // return null;
      if(node.right!=null){
        return findMax(node.right);
      }
      else{
        return node;}
      }

      public Node findClosestLeaf(int search_key){
        // return null; // Call the recursive version
        if(root!=null)
        {
          return findClosestLeaf(root,search_key);
        }
        else{
          return null;
        }

      }

      public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        // return null;

        if(search_key==node.key){
          return node;
        }
        else if(search_key>node.key){
          if(node.right!=null){
            return findClosestLeaf(node.right, search_key);
          }
          else {return node;}
        }
        else {
          if(node.left!=null){
            return findClosestLeaf(node.left, search_key);
          }
          else{ return node;}
        }

      }

      public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion

        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        while (current!= null){
          if (search_key == current.key){
            return current;
          }
          else{
            if(Math.abs(current.key - search_key) < min_diff){
              min_diff = Math.abs(current.key - search_key);
              closest = current;
            }

          }

          if(search_key < current.key)
          {current = current.left;}
          else{current = current.right;}
        }

        // Use while loop to traverse from root to the closest leaf

        return closest;}
      }
      ////////////////////////////       Q2    ////////////////////////////





      // Implement this function using the findClosestLeaf technique
      // Do not implement the recursive function
      public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()
        if(root!=null){
          Node n = findClosestLeaf(key);
          if(n.key!= key){
            if(key > n.key){
              n.right = new Node(key);
              n.right.parent = n;
            }

            else {
              n.left = new Node(key);
              n.left.parent = n;
            }
          }
          else
          {
            return;
          }

        }else{
          root = new Node(key);
        }
      }

      public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        if(root != null){
          printPreOrderDFT(root);
        }
        System.out.println("]");
      }

      public static void printPreOrderDFT(Node node){
        // this function should be recursive
        if (node!=null){

          System.out.print(node.key+" ");
          printPreOrderDFT(node.left);
          printPreOrderDFT(node.right);
        }
        else {return;}

      }

      public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        if(root!=null){
          printInOrderDFT(root);
        }
        // Call the recursive version
        System.out.println("]");
      }

      public static void printInOrderDFT(Node node){
        if (node!=null){
          printInOrderDFT(node.left);
          System.out.print(node.key+" ");
          printInOrderDFT(node.right);

        }
        else {
          return;
        }
        // this function should be recursive
      }

      public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        if (root!=null){
          printPostOrderDFT(root);
        }
        System.out.println("]");
      }

      public static void printPostOrderDFT(Node node){
        // this function should be recursive
        if (node!=null){
          printPostOrderDFT(node.left);
          printPostOrderDFT(node.right);
          System.out.print(node.key+" ");
        }
        else{return;}
      }
      ////////////////////////////       Q3    ////////////////////////////

      public int height(){ // Tree height
        // Hint: call the static function
        if(root!=null){
          return height(root);

        }
        else{return -1;}
      }
      public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if(node!=null){
          return 1 + Math.max(height(node.left), height(node.right));
        }else{
          return -1;
        }

      }

      public int size(){ // Tree size
        // Hint: call the static function
        if(root!=null){
          return size(root);
        }
        else{
          return 0;
        }
      }

      public static int size(Node node){
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if(node!=null){

            return 1 + size(node.left) + size(node.right);

        }
        else{
          return 0;
        }
      }

      public int depth(){ // Tree depth
        // Hint: call the static function
        if(root!=null){
          return height(root);
        }
        else {return -1;}
      }

      public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if(node!=root){
          return 1 +  depth (root,node.parent) ;

        }
          else {
            return 0;
          }

      }


      public Node findKthSmallest(int k){
        if(root!=null){

          return findKthSmallest(root,k);
        }
        else {
          return null;
          }
      }

      public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        if(node!=null){
          int l = size(node.left);
          if(k==l+1){
            return node;
          }else if(k<l+1){
            return findKthSmallest(node.left,k);
          }else{
            return findKthSmallest(node.right,k-l-1);
          }
        }
          else {
            return null;
          }

      }

////////////////////////////       Q4    ////////////////////////////

      public static Node findNext(Node node){
        //this function should call other functions
        return null;
      }

      public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        return null;
      }

      public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        return null;
      }

      public List rangeSearch(int x, int y){
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        return new List(100);
      }


      // This function is for deleting the root node
      // If the node is not the root, please call the recursive version
      public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
      }

      // Use this function to delete non-root nodes
      public static void delete(Node node){
        // There should be 7 cases here
      }
    }
