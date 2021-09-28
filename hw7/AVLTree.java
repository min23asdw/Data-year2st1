public class AVLTree extends BTreePrinter{
  Node root;

  public AVLTree(Node root){
    this.root = root;
}

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
        System.out.println("hey y" + y.key);
        System.out.println("hey y.parent" + y.parent.key);
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
        System.out.println("hey it work");
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
            System.out.println("z.left" + z.left.key + "z.right " + z.right.key);
          }
        }
      }
    }
  }

  public static void rebalance(AVLTree tree, Node node){
    Node current = node;
    int balanceFactor = Math.abs(height(current.left)-height(current.right));              // Calculate balanceFactor
    

    while(current.parent!=null){
      if(Math.abs(height(current.left)-height(current.right)) > 1){
        break;
      }
      current = current.parent;
    }

    if ( balanceFactor > 1 ){                          // if diff more 1  =  unbalanced

      if (   height(current.left) > height(current.right)    ) {                      //left heavy
        if (height(current.left.left)>height(current.left.right)){                  // Use the grandchild to check if Outer or Inner?
          System.out.println("Perform SingleRotationFromLeft(Node " + current.key +")");   // Fix ??? and call a function
          // use singleRotateFromLeft
          tree.singleRotateFromLeft(current);

        }else{
          System.out.println("Perform DoubleRotationFromLeft(Node " + current.key +")");   // Fix ??? and call a function
          // use doubleRotateFromLeft
          tree.doubleRotateFromLeft(current);
        }
      }else{        //right heavy
        if (height(current.right.left)>height(current.right.right)){                  // Use the grandchild to check if Outer or Inner?
          System.out.println("Perform DoubleRotationFromRight(Node " + current.key +")");   // Fix this and call a function
          //use doubleRotateFromRight
          tree.doubleRotateFromRight(current);
        }else{
          System.out.println("Perform SingleRotationFromRight(Node " + current.key +")");   // Fix this and call a function
          //use singleRotateFromRight
          tree.singleRotateFromRight(current);
        }
      }
    }

  }

  // Fix this function to have the rebalancing feature
  // There should be rebalance() function calling somewhere in the code
  public static void insert(AVLTree tree, Node node, int key) {
    if (key == node.key) {
      System.out.println("Duplicated key:" + key);
    }else if (key < node.key) {//Go left
      if (node.left == null) {
        node.left = new Node(key);
        node.left.parent = node;
      }else {
        insert(tree, node.left, key);
        rebalance(tree,node);

      }
    }else{  // Go right
      if (node.right == null) {
        node.right = new Node(key);
        node.right.parent = node;
      }else {
        insert(tree, node.right, key);
        rebalance(tree,node);

      }
    }
  }

  // This function is complete, no need to edit
  public void insert(int key) {
    if (root == null) {
      root = new Node(key);
    } else {
      insert(this, root, key);
    }
  }

  // This function is for deleting the root node
  // If the node is not the root, please call the recursive version
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
          delete(this,child);
        }

      }
      else {  //ตัวที่ลบไม่ใช่ root
        delete(this,node);
      }
    }
  }

  // Use this function to delete non-root nodes
  // Also, fix the code to have the rebalancing feature
  public static void delete(AVLTree tree, Node node){
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
      delete(tree,n);
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

    Node now = node.parent;
    while(now.parent!=null){
      rebalance(tree, now);

      now = now.parent;
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


  public static boolean isMergeable(Node r1, Node r2){
        if (r1 != null && r2 == null) return true;
        if(r1 == null && r2 != null) return true;
        if(r1 == null && r2 == null) return true;
        if(  findMax(r1).key < findMin(r2).key   ){
          
          return true;
        }
        else{
          System.out.println("All nodes in T1 must be smaller than all nodes from T2");
          return false;
        }

  

  }


  public  static Node mergeWithRoot(Node r1, Node r2, Node t){
    ///////////////////////////////////////////////////////////////////////////// this Fn
    System.out.println(isMergeable(r1, r2));
    if (r1 == null && r2 == null) {
        return t;
    }
    // AVLTree caller = new AVLTree(r1);

    if (isMergeable(r1, r2)) {
  

        int diff = height(r1) - height(r2);

        if (Math.abs(diff) <= 1) {
            t.left = r1;
            t.right = r2;
            if (r1 != null) {r1.parent = t;}
            if (r2 != null) {r2.parent = t;}
            return t;
        }
        else if (diff > 0) {

            Node temp = mergeWithRoot(r1.right, r2, t);
            r1.right = temp;

            // System.out.println("r1 pa" + r1.parent.key);
            // System.out.println("r1  i" + r1.key);
            // System.out.println("r1  R" + r1.right.key);
            temp.parent = r1;
            AVLTree caller = new AVLTree(r1);
            rebalance(caller , r1);
           
            return caller.root;
        }
        else if (diff < 0) {
          
            Node temp = mergeWithRoot(r1, r2.left, t);

            r2.left = temp;
            temp.parent = r2;
            AVLTree caller = new AVLTree(r2);
            
            rebalance(caller , r2);
            return caller.root;
        }

        return t;
    } else {
      return null;
    }
  }


  public void merge(AVLTree tree2){
    if (isMergeable(this.root, tree2.root)){
      Node maxleft = findMax(this.root);

      delete( this ,findMax(this.root) );

      this.root = mergeWithRoot(this.root, tree2.root ,maxleft);
    }
  }



  // Fix this function
  public Node[] split(int key){

      return split(root, key);


  }

  // Fix this function
  public static Node[] split(Node r, int key){
    Node[] arr = new Node[2];

    if (r == null) {
      arr[0] = null;
      arr[1] = null;
      return arr;
  }
  else if (key < r.key) {
    arr= split(r.left, key);
      arr[1] = mergeWithRoot(arr[1], r.right, r);
    
      return arr;
  }
  else if (key >= r.key) {
    arr = split(r.right, key);
    System.out.println("r.leftr.left   " + r.left.key);
    if(key == r.key){
      r.left.parent = null;
    }
    arr[0] = mergeWithRoot(r.left,arr[0], r);
    // System.out.println(arr[1].key);
    return arr;
  }
    return arr;
  }

  // Use this function to check the node height
  // This function is complete, no need to edit
  public static int height(Node node){
    if (node == null)
    return -1;
    else
    return 1 + Math.max(height(node.left), height(node.right));
  }

  // This function is complete, no need to edit
  public void printTree() {
    if (root == null) {
      System.out.println("Empty tree!!!");
    } else {
      super.printTree(root);
    }
  }

  public AVLTree() {} // Dummy Constructor, no need to edit
}
