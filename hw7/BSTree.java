public class BSTree extends BTreePrinter{
  Node root;
  public void singleRotateFromLeft(Node y) {  // การหมุนลูกฝั่งซ้้ายของ  y ให้ขึ้นไปแทน y 
    if(y!= null && y.left!=null){
        Node x = y.left; //     x =  left subtree ของ y

        if(y.parent!=null){  // y is not root
          Node w = y.parent;

          if(w.key > y.key){ // y เป็น left subtree ของ w
            w.left = x;
          }
          else{ // y เป็น right subtree ของ w
            w.right = x;
          }

          x.parent = w;

          if(x.right!=null){    // ถ้า x มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
            y.left = x.right;
            x.right.parent = y;
          }else{
            y.left = null;
          }

          y.parent = x; // 
          x.right = y; //

        }


        else{  // y are root
          root = x;            // หมนโดน x เป็น root แทน แล้ว  y เป็ฯ right subtree ของ x
          x.parent = null;
          if(x.right!=null){  // ถ้า x มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
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

  public void singleRotateFromRight(Node y) { // การหมุนลูกฝั่งขวาของ  y ให้ขึ้นไปแทน y 
    if(y!=null && y.right!=null){
        Node x = y.right;     // x = right subtree ของ y

        if(y.parent!=null){  // y is not root
          Node w = y.parent;

          if(w.key > y.key){ // y เป็น left subtree ของ w
            w.left = x;
          }
          else{  // y เป็น right subtree ของ w
            w.right = x;
          }

          x.parent = w;

          if(x.left!=null){   // ถ้า x มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
            y.right = x.left;
            x.left.parent = y;
          }else{
            y.right = null;
          }
          y.parent = x;
          x.left = y;

        }


        else{  // y are root  
          root = x;   // หมนโดน x เป็น root แทน แล้ว  y เป็น left subtree ของ x
          x.parent = null;
          if(x.right!=null){  // ถ้า x มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
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

  public void doubleRotateFromLeft(Node y) {  // นำหลาน  z  ที่อยู่ระหว่าง y.left  กับ y ขึ้นมาแทน y
    if(y!=null){

      if(y.parent!=null){  // y is not root
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
            if(z.left!=null){        // ถ้า z มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
              x.right = z.left;
              z.left.parent = x;
            }else{
              x.right = null;
            }

            if(z.right!=null){  // ถ้า z มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
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
            z.parent = null;   // ดึง z มาเป็น root แทน

            if(z.left!=null){  // ถ้า z มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
              x.right = z.left;
              z.left.parent = x;
            }else{
              x.right = null;
            }

            if(z.right!=null){ // ถ้า z มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
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

  public void doubleRotateFromRight(Node y) {     // นำหลาน  z  ที่อยู่ระหว่าง y.right  กับ y ขึ้นมาแทน y
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


            if(z.left!=null){  // ถ้า z มีลูกทางฝั่งซ้าย จะไปผูกกับ  y left subtree
              y.right = z.left;
              z.left.parent = y;
            }else{
              y.right = null;
            }

            if(z.right!=null){  // ถ้า z มีลูกทางฝั่งขวา จะไปผูกกับ x  left subtree
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
            root = z;  // ดึง z มาเป็น root แทน
            z.parent = null; 
            if(z.left!=null){  // ถ้า z มีลูกทางฝั่งซ้าย จะไปผูกกับ  y left subtree
              y.right = z.left;  
              z.left.parent = y;

            }else{
              y.right =null;
            }
            if(z.right!=null){      // ถ้า z มีลูกทางฝั่งขวา จะไปผูกกับ x  left subtree
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

    if(root!=null){  // tree มี node ให้หา
      return  find(root,search_key);
    }else {
      return  null;
    }

  }

  public static Node find(Node node, int search_key) {
    // Pls copy the code from the previous homework
    if (node!=null) { 
      if(node.key==search_key){   //เจอก็ return node
        return  node;
      }
      if(node.key > search_key){     //  search_key  มีค่าน้อยกว่า node ลงไปหาลูกฝั่งซ้ายของ node ต่อ
        return find(node.left,search_key);
      }else {
        return find(node.right,search_key);   //  search_key  มีค่ามากกว่า node ลงไปหาลูกฝั่งขวาของ node ต่อ
      }
    }else {
      return null;
    }

  }

  public static Node findMin(Node node){
    // Pls copy the code from the previous homework
    if(node!=null){
      if(node.left!=null){
        return findMin(node.left);    // recurrsive ลูกฝั่งซ้ายของตัวเองไปเรื่ออย  จนเกือบตก null
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
        return findMax(node.right);  // recurrsive ลูกฝั่งขวาของตัวเองไปเรื่ออย  จนเกือบตก null
      }else{
        return node;
      }
    }else {
      return null;
    }
  }

  public static void insert(Node node, int key) {    // ใส่ new node(key) ลงใน subtree ที่ว่าง
    if (key == node.key) {    // มี node ที่มี key  นี้อยู่แล้ว
      System.out.println("Duplicated key:" + key); 
    }else if (key < node.key) {//Go left  key ที่จะใส่มีค่าน้อยกว่า
      if (node.left == null) {       // node นี้ left subtree ว่างอยู๋
        node.left = new Node(key);   
        node.left.parent = node;
      }else {
        insert(node.left, key);   // เรียก recursive โดยลงไปทาง left subtree


      }
    }else{  // Go right key ที่จะใส่มีค่ามากกว่า
      if (node.right == null) {   // node นี้ right subtree ว่างอยู๋
        node.right = new Node(key);
        node.right.parent = node;
      }else {
        insert(node.right, key);    // เรียก recursive โดยลงไปทาง right subtree


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
    if (r1 != null && r2 == null) return true;   // มี node เดิยวทำได้
    if(r1 == null && r2 != null) return true;
    if(r1 == null && r2 == null) return true;  // ไม่มี  node เลยก็ทำได้
    if(  findMax(r1).key < findMin(r2).key   ){  //All nodes in r1 must be smaller than all nodes from r2
      
      return true;
    }
    else{    // จะไม่ได้ถ้า ตัวมากสุดของ r1 ไม่น้อยกว่าตัวน้อยสุดของ r2   
      System.out.println("All nodes in T1 must be smaller than all nodes from T2");
      return false;
    }


  }


  public static Node mergeWithRoot(Node r1, Node r2, Node t){
    if (r1 == null && r2 == null) {     // null merge null return t
      return t;     
  }
  if (isMergeable(r1, r2)) {    //ถ้า merge ได้
    Node mergeroot = t;  // merge เอา t เป็น root magic ด่านซ้ายเป็น r1 ขวา r2
    t.parent = null;
    mergeroot.left = r1;
    r1.parent = mergeroot;

    mergeroot.right = r2;
    r2.parent = mergeroot;

    return mergeroot;
  } else {
    return null;
  }
}

public void merge(BSTree tree2){
  if (isMergeable(this.root, tree2.root)){ //merge ระหว่าง this.root, tree2.root
    Node maxleft = findMax(this.root);       // max ของ this.root จะเป็น magic node

    delete( findMax(this.root) );  // ลบ max ของ this.root
    
    this.root = mergeWithRoot(this.root, tree2.root,maxleft);   // merge โดย มี maxleft เป็น magic node

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
