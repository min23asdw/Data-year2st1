package hw5;

public class Main {


    public static void main(String[] args) {

      public static Node constructTree1(){
    Node root = new Node(3); //Node root key(3) have
    root.left = new Node(7);
    root.right = new Node(5);

    root.left.left = new Node(2);
    root.left.right = new Node(6);

    root.right.right = new Node(9);

    root.left.right.left = new Node(1);
    root.left.right.right = new Node(8);

    root.right.right.left = new Node(4);
    // do something

    return root;
}
public static Node constructTree2(){
    Node root = new Node(1); //Node root key(3) have
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.right = new Node(6);

    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);

    root.right.right.left = new Node(9);

    root.left.right.right.right = new Node(10);
    return root;
}
        //tree.printTree();


    }
}
