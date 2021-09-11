package hw6;
// This Tree needs to inherit BTreePrinter
////////////////////////////       Q1    ////////////////////////////
public class Tree extends BTreePrinter { // สืบทอด class
  Node root;

  public Tree(Node root){
    this.root = root;
  }

  public Tree(){} // Dummy constructor (No need to edit)

  public void printTree(){
    if(root!=null)      // มี node ใน tree
    {
      super.printTree(root);   // ปริ้นโดยส่ง node root ไป static fn
    }
    else
    {
      System.out.println("Empty tree!!!");
    }
  }

  public static void printNode(Node node){
    if(node!=null){                        // node ที่รับมาต้องมีตัวตน
      System.out.println(node.key);
    }else{
      System.out.println("Node not found!!!");
    }

  }

  public Node find(int search_key){   //ค้นหา node จากค่า
    if(root!=null){        // มี node ใน tree
      return find(root,search_key);  // Call the recursive version
    }
    else{
      return null;
    }

  }

  public static Node find(Node node, int search_key){
    // this function should be recursive
    // You should check null in this function
    if(node!=null){                 // node  ที่รับมาต้องมีตัวตน
      if (search_key== node.key){    //ถ้าเจอ node ที่ตามหา  ส่งค่าออกไป
        return node;
      }
      else if (search_key > node.key) {     //ถ้า search_key มากกว่า  node.key ตอนนี้ แสดงว่า อยู่ทางด้านขวา
        return find(node.right,search_key);    //  recursive โดยส่ง   right-subtree
      }
      else{
        return find(node.left,search_key);     //  recursive โดยส่ง   left-subtree
      }
    }
    else return null;

  }


  public Node findMin(){

    if(root!=null){  // มี node ใน tree
      return findMin(root); // Call the recursive version
    }else{
      return null;
    }
  }

  public static Node findMin(Node node){
    // this function should be recursive
    if(node.left!=null){
      return findMin(node.left);     // recursive left-subtree จนตกเกือบ null แล้ว return node นั้น
    }
    else{
      return node;}
    }

    public Node findMax(){
      // Call the recursive version
      if(root!=null){  // มี node ใน tree
        return findMax(root);  // Call the recursive version
      }
      else{
        return null;
      }
    }

    public static Node findMax(Node node){
      // this function should be recursive
      if(node.right!=null){            // recursive right-subtree จนตกเกือบ null แล้ว return node นั้น
        return findMax(node.right);
      }
      else{
        return node;}
      }

      public Node findClosestLeaf(int search_key){

        if(root!=null)      // มี node ใน tree
        {
          return findClosestLeaf(root,search_key); // Call the recursive version
        }
        else{
          return null;
        }

      }

      public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive

        if(search_key==node.key){  //เมื่อเจอ return ค่า
          return node;
        }
        else if(search_key>node.key){    //ถ้า search_key มากกว่า  node.key ตอนนี้ แสดงว่า อยู่ทางด้านขวา
          if(node.right!=null){                                       //ถ้า node ตอนนี้มี right-subtree เรียก   recursive โดยส่ง   right-subtree
            return findClosestLeaf(node.right, search_key);
          }
          else {return node;}                 //ถ้า node ตอนนี้มีไม่มี right-subtree แสดงว่า node ตอนนีใกล้ search_key ที่สุด
        }
        else {                //ถ้า search_key น้อยกว่า node.key ตอนนี้ แสดงว่า อยู่ทางด้านซ้าย
          if(node.left!=null){            //ถ้า node ตอนนี้มี left-subtree เรียก   recursive โดยส่ง   left-subtree
            return findClosestLeaf(node.left, search_key);
          }
          else{ return node;}   ////ถ้า node ตอนนี้มีไม่มี  left-subtree แสดงว่า node ตอนนีใกล้ search_key ที่สุด
        }

      }

      public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion

        Node current, closest;    //จำตำแหน่ง node ตอนนี้
        closest = current = root;   // เก็บตำแหน่ง node ที่ใกล้ค่าที่หามากสุด
        int min_diff = Integer.MAX_VALUE;    // ตัวเปรียบเทียบคสาต่าง
        while (current!= null){                 // Use while loop to traverse from root to the closest leaf
          if (search_key == current.key){     //ถ้าเจอก็ return
            return current;
          }
          else{
            if(Math.abs(current.key - search_key) < min_diff){  //หาค่าความต่าง  ถ้าอันใหม่ต่างน้อยกว่า แสดงว่าใกล้กว่า
              min_diff = Math.abs(current.key - search_key);
              closest = current;
            }

          }

          if(search_key < current.key)      // กำหยดว่าจะลงไปในทิศทางไหนของ subtree
          {current = current.left;}
          else{current = current.right;}
        }



        return closest;
      }

      ////////////////////////////       Q2    ////////////////////////////





      // Implement this function using the findClosestLeaf technique
      // Do not implement the recursive function
      public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()

        if(root!=null){   // มี node ใน tree
          Node n = findClosestLeaf(key); //หา Leaf n ที่ใกล้ค่าที่ใส่มากที่สุด โดย  call findClosestLeaf()


          if(n.key!= key){    // ค่าที่จะใส่ต้องไม่มีใน tree
            if(key > n.key){  // ค่าที่จะใส่มากกว่า  Leaf n  ให้ใส่เป็นลูฏของ Leaf ด้านขวา
              n.right = new Node(key);
              n.right.parent = n;
            }

            else {  // ค่าที่จะใส่น้อยกว่า  Leaf n  ให้ใส่เป็นลูฏของ Leaf ด้านซ้าย
              n.left = new Node(key);
              n.left.parent = n;
            }
          }
          else
          {
            return;
          }

        }else{   // ไม่มี node ใน tree  ดังนั้นค่าที่ใส่เข้ามาจะกลายเป็ฯ root
          root = new Node(key);
        }
      }

      public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        if(root != null){      // มี node ใน tree
          printPreOrderDFT(root);
        }
        System.out.println("]");
      }

      public static void printPreOrderDFT(Node node){
        // this function should be recursive
        if (node!=null){         // node มีตัวตน

          System.out.print(node.key+" ");       //เจอ node ไหน print ค่า และ recursive ซ้ายตามด้วยขวา
          printPreOrderDFT(node.left);
          printPreOrderDFT(node.right);
        }
        else {return;}

      }

      public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        if(root!=null){ // มี node ใน tree
          printInOrderDFT(root);
        }
        // Call the recursive version
        System.out.println("]");
      }

      public static void printInOrderDFT(Node node){
        if (node!=null){    // node มีตัวตน
          printInOrderDFT(node.left);             //เจอ node ไหน  recursive ซ้าย และ print ค่า  และ  recursive  ขวา
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
        if (root!=null){  // มี node ใน tree
          printPostOrderDFT(root);
        }
        System.out.println("]");
      }

      public static void printPostOrderDFT(Node node){
        // this function should be recursive
        if (node!=null){  // node มีตัวตน
          printPostOrderDFT(node.left);     //เจอ node ไหน  recursive ซ้าย และ  recursive  ขวา  และ print ค่า
          printPostOrderDFT(node.right);
          System.out.print(node.key+" ");
        }
        else{return;}
      }
      ////////////////////////////       Q3    ////////////////////////////

      public int height(){ // Tree height
        // Hint: call the static function
        if(root!=null){  // มี node ใน tree
          return height(root);

        }
        else{return -1;}  // tree เปล่า  height -1
      }
      public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if(node!=null){   // node มีตัวตน
          return 1 + Math.max(height(node.left), height(node.right));     // ความสูง node ตอนนี้คือ 1  บวกด้วยความสูงที่มากที่สุด subtree
        }else{
          return -1;
        }

      }

      public int size(){ // Tree size
        // Hint: call the static function
        if(root!=null){  // มี node ใน tree
          return size(root);
        }
        else{
          return 0; // tree เปล่า  size 0
        }
      }

      public static int size(Node node){
        // Use recursion to implement this function

        if(node!=null){  // node มีตัวตน

          return 1 + size(node.left) + size(node.right);   // size = #children + 1(itself)
        }
        else{
          return 0;
        }
      }

      public int depth(){ // Tree depth
        // Hint: call the static function
        if(root!=null){  // มี node ใน tree
          return height(root);
        }
        else {return -1;}
      }

      public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root

        if(node!=root){ // node มีตัวตน
          return 1 +  depth (root,node.parent) ;  // depth = length(path{node->root})

        }
        else {
          return 0;
        }

      }


      public Node findKthSmallest(int k){
        if(root!=null){  // มี node ใน tree

          return findKthSmallest(root,k);
        }
        else {
          return null;
        }
      }

      public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        if(node!=null){   // node มีตัวตน
          int l = size(node.left);
          if(k==l+1){
            return node;
          }else if(k<l+1){     //ถ้า k is น้อยกว่า size  ค่าของ kth จะอยูที่ left subtree.
            return findKthSmallest(node.left,k);
          }else{
            return findKthSmallest(node.right,k-l-1); // recursive right-subtree  และค่า k ลบด้วย size ทางขวา และตัวมันเอง(1)
          }
        }
        else {
          return null;
        }

      }

      ////////////////////////////       Q4    ////////////////////////////

      public static Node findNext(Node node){
        //this function should call other functions
        if(node!=null){  // node มีตัวตน
          if(node.right!=null){
            return leftDescendant(node.right);   //node นี้มีลูกด้านขวา   หา (findMin) ลูกด้านขวา
          }
          else{

            return rightAncestor(node);   //node นี้ ไม่มี

          }
        }
        else {
          return null;
        }
      }

      public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        if(node.left!=null){
          return leftDescendant(node.left);  // คือการ (findMin) ด้ายซ้าย
        }
        else{
          return node;}
        }

        public static Node rightAncestor(Node node) {// Case 1 (first right parent)
          // this function should be recursive


          if(node.parent!=null){
            if(node.key>node.parent.key){ // หา parent ตัวแรกี่มีคค่ามากกว่า
              return rightAncestor(node.parent);
            }
            else {return node.parent;}
          }else{return null;}//////
        }

        public List rangeSearch(int x, int y){
          // This function utilizes findCloest() and findNext()
          // Use List list append(node) to add node to the list
          // List is the static Array
          List list = new List(y-x);
          Node current = findClosest(x);
          Node end = findClosest(y);

          //  list.append(current);
          // System.out.print("end 1  =  " + end.key+"    ");
          while(current.key<=end.key)
          {

            // System.out.print("current 2=  " + current.key+"    ");
            if(current.key<=y){             // ใส่ node ที่มีค่าไม่เกิน rangeSearch
              list.append(current);
            }

            if(current.key>=end.key){break;}

            current = findNext(current);



            //  System.out.print("current 3=  " + current.key);

          }


          return list;
        }

        ////////////////////////////       Q5    ////////////////////////////


        // This function is for deleting the root node
        // If the node is not the root, please call the recursive version
        public void delete(int key) {


          // There should be 6 cases here
          // Non-root nodes should be forwarded to the static function
          if (root == null) System.out.println("Empty Tree!!!");  // ไม่มี node ใน tree
          else {

            Node node = find(key);

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
                Node n = findMin(root.right);
                root.key = n.key;
                delete(n);
              }

            }


            else {  //ตัวที่ลบไม่ใช่ root
              delete(node);
            }
          }
        }

        // Use this function to delete non-root nodes
        public static void delete(Node node){
          // There should be 7 cases here
          if (node == null) return;

          if (node.left == null && node.right == null) { //  sub-tree is empty case
            if (node.key < node.parent.key) { // node น้อยกว่าข้างบน
              node.parent.left = null;
            }
            else {
              node.parent.right = null;
            }

            return;
          }

          else if (node.left != null && node.right == null) { // right sub-tree is empty case
            if (node.left.key < node.parent.key) { // sub-tree  อยู่ทางซ้ายของ parent
              node.left.parent = node.parent;
              node.parent.left = node.left;
            }
            else {
              node.left.parent = node.parent;
              node.parent.right = node.left;
            }
            return;
          }
          else if (node.right != null && node.left == null) { // left sub-tree is empty case
            if (node.right.key < node.parent.key) {  // sub-tree  อยู่ทางซ้ายของ parent
              node.right.parent = node.parent;
              node.parent.left = node.right;
            }
            else {
              node.right.parent = node.parent;
              node.parent.right = node.right;
            }
            return;
          }
          else { // full node case
            // หา min ของ right-subtree เอา key มาเขียนทับ key ของ node เลย
            Node n = findMin(node.right);
            node.key = n.key;
            delete(n);
          }
        }
      }
