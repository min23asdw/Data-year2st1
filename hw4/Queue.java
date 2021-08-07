package hw4;

public class Queue implements List{         // FIFO    s ll t
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;

    public void push(Node node){ //pushBack
        if (head == null){         // หากLinked List ไม่มีข้อมูลอยู๋   ข้อมูลที่ใส่มาคือ pushBack ที่  tails
            head = node;
            tail = node;
        }else{
            tail.next = node;    //pushBack โเยใช้ pointer tail
            tail = node;
        }
    }

    public void pop(){ //popFront
        if (head != null){ // Linked Listต้องไม่ว่าง

            if (head != tail){ //  Linked List มีข้อมูลหลาย โนด
                head = head.next;   // เลื่อน pointer head ชี้ตัวถััดไป
            }else{                   // มีโนดเดียว
                head =null;
                tail = null;
            }
        }
        else {
          System.out.println("Error: Queue Underflow");
            }
    }

    public Node top(){
        // Fix this
        return head;  //ตัวแรกคือ head
    }

}
