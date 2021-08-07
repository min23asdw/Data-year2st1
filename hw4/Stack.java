package hw4;

public class Stack implements List{  // LIFO   s ll
    // Implement Stack using Linked List without tail
    Node head;

    public void push(Node node){
        if (head == null){   // หาก Linked Listไม่มีข้อมูลอยู๋   ข้อมูลที่ใส่มาคือ  head
          head = node;
        }else{
          node.next = head;    // pushFront
          head = node;
        }
    }

    public void pop(){
        // Fix this function
        if (head != null){   // Linked Listต้องไม่ว่าง
            head = head.next;   // เลื่อน pointer head ชี้ตัวถััดไป
        }else{
            System.out.println("Error: Stack Underflow");
        }
    }

    public Node top(){
        // Fix this
        return head;   //ตัวแรกคือ head
    }

}
