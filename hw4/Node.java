package hw4;

public class Node {
    int shares; //จำนวนหุ้น
    double price;  //ราคาหุ้นตอนซื้อ
    Node next;
    public Node(int shares, double price){
        this.shares = shares;
        this.price = price;
    }
}
