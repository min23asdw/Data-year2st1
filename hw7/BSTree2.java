public class BSTree2 extends BTreePrinter{
    Node root;
    
    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key){
        if(root!=null){
            Node curr = root;

            while(curr!=null){


                if(curr.key==search_key){
                    return curr;
                }

                if(search_key<curr.key){
                    curr = curr.left;
                }
                if(search_key>curr.key){
                    curr = curr.right;
                }

            }
            return null;


        }else{
            return null; // Fix this
        }
        
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin(){
        Node node = root;
        if(node != null){
            Node curr = node;
            while(curr.left!= null){
                curr = curr.left;

            }
            return curr;
        }
        
        return null; // Fix this
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax(){
        Node node = root;
        if(node != null){
            Node curr = node;
            while(curr.right!= null){
                curr = curr.right;

            }
            return curr;
        }
        
        return null; // Fix this
    }
    
    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
        if(root!=null){
            
            Node curr = root;
            while(curr!=null){

                  if(key==curr.key){
                    //   System.out.println("curr.key" + curr.key);
                    }else if(key<curr.key){
                    
                     if(curr.left==null){
                         curr.left = new Node(key);
                          curr.left.parent = curr;
                           break;
                       }
                        curr = curr.left;
                 }else if(key>curr.key){
                      if(curr.right==null){
                            curr.right = new Node(key);
                            curr.right.parent = curr;
                         break;

                     }
                        curr = curr.right;
                  }else{
                  System.out.println("Duplicated key:" + key);
                  }
            }
        }else{
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