public class BSTree2 extends BTreePrinter{
    Node root;
    
    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key){
        if(root!=null){  // มี root
            Node curr = root;  // เรืมจาก root

            while(curr!=null){  // ลงไปจนกว่าจะตก null


                if(curr.key==search_key){  //เจอก็ return node
                    return curr;
                }

                if(search_key<curr.key){  //ค่า ที่่จะหาน้อยกว่า node ตอนนี้ก็ลงไปทาง  node.left
                    curr = curr.left;
                }
                if(search_key>curr.key){ //ค่า ที่่จะหามากกว่า node ตอนนี้ก็ลงไปทาง  node.right
                    curr = curr.right;
                }

            }
            return null;   // ไม่เจอ


        }else{
            return null; // 
        }
        
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin(){
        if(root != null){ // root ไม่ใช่ null
            Node curr = root;  // เริ่มจาก root
            while(curr.left!= null){ // ไล่ลงตาม leftsubtree ไปเรื่อยๆ จนเกือบตก null
                curr = curr.left;

            }
            return curr;
        }
        
        return null; // Fix this
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax(){
        if(root != null){ // root ไม่ใช่ null
            Node curr = root; // เริ่มจาก root
            while(curr.right!= null){ // ไล่ลงตาม rightsubtree ไปเรื่อยๆ จนเกือบตก null
                curr = curr.right;

            }
            return curr;
        }
        
        return null; // Fix this
    }
    
    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
        if(root!=null){ // root ไม่ใช่ null
            
            Node curr = root; // เริ่มจาก root
            while(curr!=null){ // ไล่ลงตาม subtree ไปเรื่อยๆจนเจอ null

                  if(key==curr.key){
                    System.out.println("Duplicated key:" + key); // มี  node ที่มีค่านี้อยู๋แเล้วว
                    }else if(key<curr.key){ // ค่าที่จะใส่น้อยว่า node ตอนนี้   = ลงไปทางด้านซ้าย
                    
                        if(curr.left==null){  //  ด้านซ้ายของ node นี้ ว่าง 
                             curr.left = new Node(key);
                              curr.left.parent = curr;
                               break;   // ใส่ key ที่ต้องการ insert  แล้วหยุด
                         } 
                        curr = curr.left;  //ลงไปทางด้านซ้าย

                     }else if(key>curr.key){ // ค่าที่จะใส่มากว่า node ตอนนี้   = ลงไปทางด้านขวา
                      if(curr.right==null){ //  ด้านขวาของ node นี้ ว่าง 
                            curr.right = new Node(key);
                            curr.right.parent = curr;
                         break; // ใส่ key ที่ต้องการ insert  แล้วหยุด

                     }
                        curr = curr.right;   // ลงไปทางด้านขวา

                  }
            }
        }else{ // root = null  insert โดย เป็น root 
            root = new Node(key);  
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