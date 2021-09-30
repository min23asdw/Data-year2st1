import java.util.LinkedList;
import java.util.Queue;

public class SplayTree extends BTreePrinter{
    Node root;
    
    public SplayTree(Node root){
        this.root = root;
        root.parent = null; // Clear parent of the root (Important for SplayTree)
    }
    
    // zig() function will move up the node x one level
    // Case 1: x == root
    // Case 2-3: x.parent == root (sig from left, zig from right)
    // Case 4-5: x.parent != root (sig from left, zig from right)
    public void zig(Node x){
  
        if(x!=null){
        Node y = x.parent;
        if (y == null){
            System.out.println("Cannot perform Zig operation on the root node");
        }
        else if (y == root){ // If the node is a child of the root
            if (x.key < y.key){  // x เป็น left subtree
                root = x;
                x.parent = null;
                if(x.right!=null){   // ถ้า x มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
                    y.left =x.right;
                    x.right.parent = y;
                }else{
                    y.left = null;
                }
                x.right = y;
                y.parent =x;
            }
            else {  // x = right subtree ของ y
                root = x;
                x.parent =null;
                if(x.left!=null){  // ถ้า x มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
                    y.right = x.left;
                    x.left.parent = y;
                }else{
                    y.right = null;
                }
                x.left = y;
                y.parent = x;
            }
        }



        else if (y != root) { // y is not root
            Node w = y.parent;
            if(w.key > y.key){ // y เป็น left subtree ของ w
                w.left = x;
              }
              else{ // y เป็น right subtree ของ w
                w.right = x;
              }
    
              x.parent = w;

            if (x.key < y.key){
 
                if(x.right!=null){   // ถ้า x มีลูกทางฝั่งขวา จะไปผูกกับ  y left subtree
                    y.left =x.right;
                    x.right.parent = y;
                }else{
                    y.left = null;
                }

                x.right = y;
                y.parent =x;

            }
            else {
                if(x.left!=null){ // ถ้า x มีลูกทางฝั่งซ้าย จะไปผูกกับ  y right subtree
                    y.right = x.left;
                    x.left.parent = y;
                }else{
                    y.right = null;
                }
                x.left = y;
                y.parent = x;
            }

        }
    }
        
    }
    
      
    
    // zigzig() function will move up node x two levels along the outer path
    // Pls call zig() to perform zigzig()
    public void zigzig(Node x){
        zig(x.parent);  //ฮือ  ฮึบ
        zig(x);
    }
    
    
    // zigzag() function will move up node x two levels along the inner path
    // Pls call zig() to perform zigzag()
    public void zigzag(Node x){
        zig(x);  // ฮึบๆ
        zig(x);
    }
    
    // This function will interatively splay (move up) node x all the way to the root
    public void splay(Node x){
        while (x != null && x != root){ // ลากขึ้นไปจนถึง root
            Node y = x.parent;    
            // y is root just zig x
            if (y == root){
                zig(x);
                break;
            }
            else {
                Node w = y.parent;   
                // แบบวงนอก
                if (w.left != null && w.left.left == x || w.right != null && w.right.right == x) {
                    zigzig(x);
                }
                // วงใน
                else if (w.left != null && w.left.right == x || w.right != null && w.right.left == x) {
                    zigzag(x);
                }
            }
        }  
    }
    
    public void insert(int key) {
        if(root!=null){ // root มี node อื่นอยู่แลว้
            
            Node curr = root; // เริ่มจาก root
            while(curr!=null){  // ไล่ลงตาม subtree ไปเรื่อยๆจนเจอ null

                  if(key==curr.key){
                    System.out.println("Duplicated key:" + key); // มี  node ที่มีค่านี้อยู๋แเล้วว
                    }else if(key<curr.key){ // ค่าที่จะใส่น้อยว่า node ตอนนี้   = ลงไปทางด้านซ้าย
                    
                        if(curr.left==null){ //  ด้านซ้ายของ node นี้ ว่าง 
 
                               break;
                         }
                        curr = curr.left;

                     }else if(key>curr.key){ // ค่าที่จะใส่มากว่า node ตอนนี้   = ลงไปทางด้านขวา
                      if(curr.right==null){ //  ด้านขวาของ node นี้ ว่าง 

                         break;

                     }
                        curr = curr.right;

                  }
                }

                  Node temp = new Node(key);  
                  if(key<curr.key){  // ลง node ใหม่ที่ตำแน่งนั้น
                    curr.left = temp;
                    temp.parent = curr;
                  }else{
                    curr.right = temp;
                    temp.parent = curr;
                  }
                  splay(temp);  // ลาก node.ใหม่ ที่เพิ่ง insert มาที่ root
            
        }else{
            root = new Node(key); // root = null  insert โดย เป็น root 
        }
    }
    
    // Have the splaying feature (if withSplay is true)
    public Node find(int search_key, boolean withSplay){
        Node curr = root; // เรืมจาก root
        // loop through tree and compare key till we find the node
        while (curr != null) {   // ลงไปจนกว่าจะตก null

            if (curr.key == search_key) { //เจอก็ return node
                if (withSplay){ //if true ลากขึ้น root
                splay(curr); 
                }
                return curr;
            }
            else if (search_key < curr.key) {  //ค่า ที่่จะหาน้อยกว่า node ตอนนี้ก็ลงไปทาง  node.left
                curr = curr.left; 
            }
            else if (search_key > curr.key) {  //ค่า ที่่จะหามากกว่า node ตอนนี้ก็ลงไปทาง  node.right
                curr = curr.right;
            }
        }




        return curr;
    }
    
    public void delete(int key) {
        if (root.left == null && root.right == null && key == root.key) {
            root = null;  // node ที่จะลบเป็น root และไม่มีลูก   หายไปซธ
            return;     
        }

        
        splay(find(key, true));    // ลาก  node ที่จะลบ ขึ้นมาเป็น root ก่อน
        //fin min rightsubtree
        Node min = root.right;
        while (min != null && min.left != null) {   // หา min ของ lefttree ของ root
            min = min.left;
        }

        splay(min);  // ลาก min ขึ้นมาเป็น root
        root = min;
        min.parent = null;

        //node ตัวที่จะลบ จะเป็น leftsubtree ของ min ที่เพิ้งลากขึ้นมาเสมอ
        if( root.left.left != null ){  // remove by shift
            root.left = root.left.left;
        }else{
            root.left = null; // remove
        }

        // เชือ่ม parent left subtree
        if (root.left != null) root.left.parent = root;
    }
    
    // This function does not have the splaying feature
    public Node findMin() {
        Node curr = root; // เริ่มจาก root
        while (curr.left != null) {  // ไล่ลงตาม leftsubtree ไปเรื่อยๆ จนเกือบตก null
            curr = curr.left;
        }
        return curr;
    }
    
    
    // This is another version of height() called iterative method to find BST height
    // This function is complete, no need to edit
    @SuppressWarnings("unchecked")
    public int height(){
        if (root==null)
            return -1;
        Queue<Node> q = new LinkedList();
        q.add(root);
        int height = -1;
        while (true){
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0){
                Node newnode = q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
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
    
    public SplayTree() {} // Dummy Constructor, no need to edit
    
    // This is the editable testcase (test#4)
    // No need to edit
    public static void test4(){
        BSTree2 tree1 = new BSTree2();
        long start = System.currentTimeMillis();
        int N = 40000;
        for (int i = 0; i < N; i++)
            tree1.insert(i);
        System.out.println("Time for sequentially inserting " + N + " objects into BST = " + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree1.find((int) (Math.random() * N ));

        System.out.println("Time for finding " + N + " different objects in BST= " + (System.currentTimeMillis() - start) + " msec");
        SplayTree tree2 = new SplayTree();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.insert(i);

        System.out.println("Time for sequentially inserting " + N + " objects into SplayTree = " + (System.currentTimeMillis() - start) + " msec");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            tree2.find((int)(Math.random() * N ), true);
        System.out.println("Time for finding " + N + " different objects in SplayTree = " + (System.currentTimeMillis() - start) + " msec");
        
        System.out.println("Which one is faster: BSTree or SplayTree?");
    }
    
}