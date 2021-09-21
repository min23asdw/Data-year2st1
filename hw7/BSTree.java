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

    if(root!=null){
      return  find(root,search_key);
    }else {
      return  null;
    }

  }

  public static Node find(Node node, int search_key) {
    // Pls copy the code from the previous homework
    if (node!=null) {
      if(node.key==search_key){
        return  node;
      }
      if(node.key > search_key){
        return find(node.left,search_key);
      }else {
        return find(node.right,search_key);
      }
    }else {
      return null;
    }

  }

  public static Node findMin(Node node){
    // Pls copy the code from the previous homework
    if(node!=null){
      if(node.left!=null){
        return findMin(node.left);
      }else{
        return node;
      }
    }else {
      return null;
    }

  }

  public static Node findMax(Node node){
    // Pls copy the code from the previous homework
    if(node!=null){
      if(node.right!=null){
        return findMax(node.right);
      }else{
        return node;
      }
    }else {
      return null;
    }
  }

  public static void insert(Node node, int key) {
    if (key == node.key) {
      System.out.println("Duplicated key:" + key);
    }else if (key < node.key) {//Go left
      if (node.left == null) {
        node.left = new Node(key);
        node.left.parent = node;
      }else {
        insert(node.left, key);


      }
    }else{  // Go right
      if (node.right == null) {
        node.right = new Node(key);
        node.right.parent = node;
      }else {
        insert(node.right, key);


      }
    }
  }

  // This function is complete, no need to edit
  public void insert(int key) {
    if (root == null) {
      root = new Node(key);
    } else {
      insert(root, key);
    }
  }

  public void delete(int key) {
    // There should be 6 cases here
    // Non-root nodes should be forwarded to the static function
    if(root == null) {
      System.out.println("Empty Tree!!!");  // ไม่มี node ใน tree
    }
    else{
      //////////////////////////
      Node node = find(key);
      /////////////////////////
      if (node == null) System.out.println("Key not found!!!");   //ไม่เจอ  node



      else if(node == root){          //ตัวที่ลบเป็น root
        if (root.left == null && root.right == null) {  //ใน tree มีแค่ root ตัสเดียว ก็หายไปสิ จะรอไร
          root = null;
        }
        else if (root.left != null && root.right == null) {  //่ root มีลูกฝั่งซ้าย   เอาตัวลูกขึ้นมาแทน
          root.left.parent = null;
          root = root.left;
        }
        else {   //่ root มีลูกฝั่งขวา   เอาตัวลูกขึ้นมาแทน
          Node child = findMin(root.right);
          root.key = child.key;
          delete(child);
        }

      }
      else {  //ตัวที่ลบไม่ใช่ root
        delete(node);
      }
    }
  }

  // Use this function to delete non-root nodes
  // Also, fix the code to have the rebalancing feature
  public static void delete( Node node){
    // Pls copy the code from the previous homework
    // Add code segments to enable the rebalancing feature
    // recive node cant be root
    ///////////////////////////
    Node temp = new Node(0);
    ///////////////////////////
    if (node == null) return;

    if(node.left!=null && node.right!=null){ // full node case // หา min ของ right-subtree เอา key มาเขียนทับ key ของ node เลย
      Node n = findMin(node.right);
      node.key = n.key;
      delete(n);
    }
    else { // none full node

      if(node.left!=null&&node.right==null){   // node have left subtree
        temp.left = node.left;
        node.left.parent = node.parent;
      }
      else if(node.left==null&&node.right!=null){  // node have right subtree
        temp.left = node.right;
        node.right.parent = node.parent;
      }
      else{
        temp.left = null;
      }


      if(node.key < node.parent.key){   //node are left subtree
        node.parent.left = temp.left;

      }else {  //node are right subtree
        node.parent.right = temp.left;

      }


    }

  }

  public static boolean isMergeable(Node r1, Node r2){
    if(findMax(r1).key < findMin(r2).key ){
      return true;
    }else{
      return false;// Fix this
    }

  }


  public static Node mergeWithRoot(Node r1, Node r2, Node t){
    if (isMergeable(r1, r2)) {
      // Fix this
      Node mergeroot = t;
      mergeroot.left = r1;
      r1.parent = mergeroot;

      mergeroot.right = r2;
      r2.parent = mergeroot;
      return mergeroot;
    } else {
      System.out.println("All nodes in T1 must be smaller than all nodes from T2");
      return null;
    }
  }

  public void merge(BSTree tree2){
    if (isMergeable(this.root, tree2.root)){
       Node maxleft = findMax(this.root);

       delete( findMax(this.root) );

       Node temp = this.root;

       this.root = maxleft;
       maxleft.parent = null;

       maxleft.left = temp;
       maxleft.left.parent = maxleft;




       maxleft.right = tree2.root;
       tree2.root.parent = maxleft;


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
