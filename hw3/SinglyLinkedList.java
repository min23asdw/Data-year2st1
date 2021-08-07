package hw3;

public class SinglyLinkedList {
  Node head; // adress ของ node (data||next)
  String listName;

  public SinglyLinkedList(String name){
    // Constructor กำหนดช่ือ list
    this.listName = name;   // ชื่อ list name = name
  }

  public void popBack() {
    // เอาโนดตัวหลังสุดออก
    if (isEmpty()){// หาก head||  ชี้  null
      System.out.println("ERROR");

    }
    else if(head.next == null){ // หากมี 1 โนด
      head = null;}
      else{
        Node current = head;
        while(current.next.next != null){ // ลูปจนไปถึงก่อนของก่อนตัวสดท้าย
          //  [] -> [#] ->  []  -> null
          current = current.next;
        }
        current.next = null;   // ตัวถัดไปของตัวก่อนสุดท้าย เท่ากับ null
        //  [] -> [#] ->  [null]
      }
    }

    public void popFront(){
      //เอาโนดตัวแรกสุดออก
      if (isEmpty()){
        // หาก head||  ชี้  null
        System.out.println("ERROR");
      }else if(head.next != null){ // หากไม่ได้มีแค่โนดเดียว
        head = head.next; //  ชี้ head ข้าม node ตัวแรก ไปตัวถัดไป
        head.previous = null; // ตัวก่อนหน้าของ ตัวถัดไป  คือ null
      }
      else{// หากมีแค่ตัวเดียว
        head = null;
      }
    }

    public Node topFront(){
      // return ตัวแรกหสุดของ LinkedList
      if (isEmpty()){   //หาก head||  ชี้  null
        System.out.println("ERROR");
        return new Node("Empty List!"); // sent error to Constructor

      } else {// หากมีข้อมูลอยู่ก่อนแล้ว
        return head;
      }
    }

    public Node topBack(){
      // แสดงโนดตัวหลังสุด
      if (isEmpty()){//หาก head หรือ   ชี้  null
        System.out.println("ERROR");
        return new Node("Empty List!"); // sent error to Constructor

      } else {
        Node current = head;
        while( current.next != null){ // ลูปจนไปถึงตัวก่อนสดท้าย
          current = current.next;
        }
        return current;
      }
    }

    public void pushFront(Node node){
      // นำโนดแทรกหน้าสุด
      if (isEmpty()){
        // หาก head||  ชี้  null
        head = node;

      }else{// หากมีข้อมูลอยู่ก่อนแล้ว
        node.next = head;    // ชี้ .next ของข้อมูลใหม่ ไปที่  node ตัวแรก (head)
        head = node;   // head ชี้ไปที่ node ใหม่ (ต่อสาย)
        //  head -> (node)  -> [] -> ....

      }
    }

    public void pushBack(Node node) {
      if (isEmpty()){
        // หาก head||  ชี้  null
        head = node;
        node.next = null;
      } else {// หากมีข้อมูลอยู่ก่อนแล้ว
        Node current = head;
        while(current.next != null){ // ลูปจนไปถึงก่อนตัวสดท้าย
          current = current.next;
        }
        current.next = node;  // ตัวต่อไปของสาย คือ โนด
        node.next  =null;
      }
    }

    public Node findNode(int id){
      // หา node ที่มีมี student_id = id
      if (isEmpty()){// หาก head||  ชี้  null
        return new Node("Empty List!"); // sent error to Constructor
      } else {// หากมีข้อมูลอยู่ก่อนแล้ว
        Node current = head;  // สร้าง node current เพื่อเทียบค่าในแต่ละโนด
        while (current != null) {    // ไล่ทุก node ใน LinkedList
          if(current.student_id == id)   { // เจอก็ return โนดที่เจอ
            return current;
          }
          current = current.next;   // เขยิบไป โนดตัวถัดไป
        }

        return new Node("Student Not Found!");
      }
    }

    public Node eraseNode(int id){
      // หา node ที่มีมี student_id = id แล้วลบ
      if (isEmpty()){// หาก head||  ชี้  null
        System.out.println("ERROR");
        return new Node("Empty List!"); // sent error to Constructor

      } else {// หากมีข้อมูลอยู่ก่อนแล้ว
        Node current = head;  // สร้าง node current เพื่อเทียบค่าในแต่ละโนด
        Node temp; // สร้าง node current เพื่อเก็บค่าตัวที่ลบ
        if(current.student_id == id){ //หากเจอในโนด แรก
          temp = current;
          head = head.next;
          return temp;
        }

        while (current.next != null) {    // ไล่ทุก node ใน LinkedList จนก่อนถึงตัวสุดท้าย
          if(current.next.student_id == id)   {   //หากโนดข้างหน้า มี id เท่ากับที่หา
            temp = current.next;   // เก็บค่า
            if(current.next.next == null){ // เจอในโนดตัวสุดท้าย
               current.next = null;

            }
            else {   // เจอในสักที่
              current.next = current.next.next;   // ลัดสาย
            }
            return temp;
          }
          current = current.next;   // เขยิบไป โนดตัวถัดไป
        }

        return new Node("Student Not Found!");
      }
    }

    public void addNodeAfter(Node node1, Node node2){
      // เอา node2 ไปแทรกหลัง node1
      if(node1.next == null)  // หาก node1 อยู่หลังสุด
      {
        node1.next = node2; //  ตัวหลังจาก node1 คือ node2
        node2.next = null; // ตัวหลังจาก node2 คือ null
        //    node1 ==> node2 ==> null   (next)
      }
      else{
        node2.next = node1.next;    // ตัวถัดไป  node2 คือตัวถัดไปของ node1
        //        node2
        //          V
        //   node1     node#
        node1.next = node2;   // ตัวถัดไปของ node1 คือ node2
      }
    }

    public void addNodeBefore(Node node1, Node node2){
      // เอา node2 ไปแทรกก่อน node1
      if(head == node1) // หาก node1 อยู่หน้าสุด
      {
        node2.next = head;
        head = node2;
      }
      else{

        Node current = head;
        while (current.next != null) {    // ไล่ทุก node ใน LinkedList

        if(current.next == node1){
          node2.next =node1;
          current.next = node2;
          break;
        }
          current = current.next;   // เขยิบไป โนดตัวถัดไป
        }
      }
    }

    public boolean isEmpty(){
      if(head == null)  //หาก head  ชี้ null แสดงว่าเป็น LinkedList ว่าง
      {return true;    }
      else
      {return false;   }
    }
    public void merge(SinglyLinkedList list){
      // [this list]  + [list]
      Node current = head;  // สร้าง node current เพื่อเทียบค่าในแต่ละโนด
      while (current.next != null) {    // ไล่ทุก node ใน LinkedList
        current = current.next;
      }
      current.next = list.head;
    }

    public void printStructure(){
      Node current=head;
      System.out.print(listName + ": head -> ");
      while(current!=null){
        System.out.print("{" + current.student_id + "} -> ");
        current = current.next;
      }
      System.out.println("null");
    }

    public Node whoGotHighestGPA(){
      //หาว่า node ไหนมี GPA สูงสุด

      if (isEmpty()) { // หาก head||  ชี้  null
        return new Node("Empty List!");
      } else {
        Node temp = head;  // เก็บ node ที่มี gpa มากสุด และ ล่าสุด
        Node current = head;  // สร้าง node current เพื่อเทียบค่าในแต่ละโนด
        double GPAMax = current.gpa;
        while (current != null) {    // ไล่ทุก node ใน LinkedList
          if(current.gpa >= GPAMax)   {   // หาก gpa ของโนด มากว่า GPAMax
            GPAMax = current.gpa;      // เปลี่ยนค่า GPAMax
            temp = current;   //     จำตำแหน่ง
          }
          current = current.next;   // เขยิบไป โนดตัวถัดไป
        }
        return temp;
      }
    }
  }
