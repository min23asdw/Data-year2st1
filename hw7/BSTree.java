public class BSTree extends BTreePrinter{
  Node root;
  public void singleRotateFromLeft(Node y) {
    if(y!= null){
      if(y.left!=null){
        Node x = y.left; //y = 6 x=5
        if(y.parent!=null){  // y not root
          Node w = y.parent;

          if(w.key > y.key){ // y เป็น left subtree ของ w
            w.left = x;
          }
          else{ // y เป็น right subtree ของ w
            w.right = x;
          }

          x.parent = w;

          if(x.right!=null){
            y.left = x.right;
            x.right.parent = y;
          }else{
            y.left = null;
          }

          y.parent = x; /////////////
          x.right = y; /////////////

        }


        else{  // y are root
          root = x;
          x.parent = null;
          if(x.right!=null){
            y.left = x.right;
            x.right.parent = y;
          }else{
            y.left = null;
          }
          x.right = y;
          y.parent = x;

        }
      }
    }
  }

  public void singleRotateFromRight(Node y) {
    // Do something
    if(y!=null){
      if(y.right!=null){
        Node x = y.right;
        if(y.parent!=null){  // y not root
          Node w = y.parent;

          if(w.key > y.key){ // y เป็น left subtree ของ w
            w.left = x;
          }
          else{  // y เป็น right subtree ของ w
            w.right = x;
          }

          x.parent = w;

          if(x.left!=null){
            y.right = x.left;
            x.left.parent = y;
          }else{
            y.right = null;
          }
          y.parent = x;
          x.left = y;

        }


        else{  // y are root
          root = x;
          x.parent = null;
          if(x.right!=null){
            y.right = x.left;
            x.left.parent = y;
          }else{
            y.right = null;
          }
          x.left =y;
          y.parent = x;
        }
      }
    }
  }

  public void doubleRotateFromLeft(Node y) {
    // Do something
    if(y!=null){
      if(y.parent!=null){  // y not root
        Node w = y.parent;
        if(y.left!=null){
          Node x = y.left;
          if(x.right!=null){
            Node z = x.right;
            if(w.key > y. key){   // y are left subtree
              w.left = z;
            }
            else{   // y are right subtree
              w.right = z;
            }
            z.parent = w;
            if(z.left!=null){
              x.right = z.left;
              z.left.parent = x;
            }else{
              x.right = null;
            }

            if(z.right!=null){
              y.left = z.right;
              z.right.parent = z;
            }else{
              y.left = null;
            }

            z.left = x;
            z.right = y;
            x.parent = z;
            y.parent = z;
          }
        }
      }
      else{  // y are root
        if(y.left!=null){
          Node x = y.left;
          if(x.right!=null){
            Node z = x.right;
            root = z;
            z.parent = null;

            if(z.left!=null){
              x.right = z.left;
              z.left.parent = x;
            }else{
              x.right = null;
            }

            if(z.right!=null){
              y.left = z.right;
              z.right.parent = y;
            }else{
              y.left = null;
            }

            z.left = x;
            z.right = y;
            x.parent =z;
            y.parent = z;
          }
        }
      }
    }
  }

  public void doubleRotateFromRight(Node y) {
    // Do something
    if(y!=null){
      if(y.parent!=null){ // y not root
        Node w =y.parent;
        if(y.right!=null){
          Node x = y.right;
          if(x.left!=null){
            Node z = x.left;

            if(w.key > y.key){ // y is left subtree
              w.left = z;
            }else{   // y is right subtree
              w.right = z;
            }
            z.parent = w;


            if(z.left!=null){
              y.right = z.left;
              z.left.parent = y;
            }else{
              y.right = null;
            }

            if(z.right!=null){
              x.left = z.right;
              z.right.parent = x;
            }else{
              x.left = null;
            }

            z.left = y;
            z.right = x;
            x.parent = z;
            y.parent = z;
          }
        }

      }else{  // y are root
        if(y.right!=null){
          Node x = y.right;
          if(x.left!=null){
            Node z = x.left;
            root = z;
            z.parent = null;
            if(z.left!=null){
              y.right = z.left;
              z.left.parent = y;

            }else{
              y.right =null;
            }
            if(z.right!=null){
              x.left = z.right;
              z.right.parent = x;
            }else{
              x.left = null;
            }

            z.left = y;
            z.right = x;
            y.parent = z;
            x.parent = z;
          }
        }
      }
    }
  }

  public Node find(int search_key) {
    // Pls copy the code from the previous homework
    return null; // Fix this
  }

  public static Node find(Node node, int search_key) {
    // Pls copy the code from the previous homework
    return null; // Fix this
  }

  public static Node findMin(Node node){
    // Pls copy the code from the previous homework
    return null; // Fix this
  }

  public static Node findMax(Node node){
    // Pls copy the code from the previous homework
    return null; // Fix this
  }

  public void insert(int key) {
    // Pls copy the code from the previous homework
  }

  public static void insert(Node node, int key) {
    // Pls copy the code from the previous homework
  }

  public void delete(int key) {
    // Pls copy the code from the previous homework
  }

  public static void delete(Node node){
    // Pls copy the code from the previous homework
  }

  public static boolean isMergeable(Node r1, Node r2){
    return false;// Fix this
  }

  public static Node mergeWithRoot(Node r1, Node r2, Node t){
    if (isMergeable(r1, r2)) {
      // Fix this
      return null;
    } else {
      System.out.println("All nodes in T1 must be smaller than all nodes from T2");
      return null;
    }
  }

  public void merge(BSTree tree2){
    if (isMergeable(this.root, tree2.root)){
      // Do something
    }else{
      System.out.println("All nodes in T1 must be smaller than all nodes from T2");
    }
  }

  // This function is complete, no need to edit
  public void printTree() {
    if (root == null) {
      System.out.println("Empty tree!!!");
    } else {
      super.printTree(root);
    }
  }
}
