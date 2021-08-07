package Linklist;

public class List{

  Node head;


  public void pushFront(int key){
    Node node = new Node(key);
    if(head == null){  // เซ็ค ว่าชี้ null ไหม
      head = node;
    }else{
        node.next = head;
        head = node;

    }



  }

  public void printHead2Tail(){
System.out.print("head  ");
    Node current = head;
while(current!=null){
  System.out.print(current.key + " -> ");
  current = current.next;
}
System.out.print("  null");

  }




}
