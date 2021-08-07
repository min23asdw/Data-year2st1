package hw3;


public class DoublyLinkedList {
  Node head;  // adress ของ node (data||next||previous)
  Node tail; // adress ของ previous node (data||next||previous)
  String listName;

  public DoublyLinkedList(String name){
    // Constructor กำหนดช่ือ list
    this.listName = name;   // ชื่อ list name = name
  }




  public void popBack() {
    // เอาโนดตัวหลังสุดออก
    if (isEmpty()){ // หาก head||tail ชี้  null
      System.out.println("ERROR");
    }else if(head.next == null){ // หากมี 1 โนด
      head = null;
      tail = null;
    }else{


      tail.previous.next = null; // ตัวก่อนสุดท้ายของ node => null
      tail = tail.previous; //  ตัวก่อนหน้าของ tail คือตัวก่อนสุดท้าย
    }
  }


  public void popFront(){
    //เอาโนดตัวแรกสุดออก
    if (isEmpty()){ // หาก head||tail ชี้  null
      System.out.println("ERROR");
    }else if(head.next != null){ // หากไม่ได้มีแค่โนดเดียว
      head = head.next; //  ชี้ head ข้าม node ตัวแรก ไปตัวถัดไป
      head.previous = null; // ตัวก่อนหน้าของ ตัวถัดไป  คือ null
    }else{   // หากมีแค่ตัวเดียว   ลัดวงจรเลย
      head = null;
      tail = null;
    }

  }


  public Node topFront(){
    // return ตัวแรกหสุดของ LinkedList
    if (isEmpty()){   //หาก head||tail ชี้  null
      System.out.println("ERROR");
      return new Node("Empty List!"); // sent error to Constructor
    } else { // หากมีข้อมูลอยู่ก่อนแล้ว
      return head;
    }
  }

  public Node topBack(){
    // แสดงโนดตัวหลังสุด
    if (isEmpty()){ //หาก head หรือ tail ชี้  null
      System.out.println("ERROR");
      return new Node("Empty List!"); // sent error to Constructor
    } else {
      return tail;
    }
  }

  public void pushFront(Node node){
    // นำโนดแทรกหน้าสุด
    if (isEmpty()){ // หาก head||tail ชี้  null
      head = node;
      tail = node;

    }else{    // หากมีข้อมูลอยู่ก่อนแล้ว
      node.next = head;    // ชี้ .next ของข้อมูลใหม่ ไปที่  node ตัวแรก (head)
      head = node;   // head ชี้ไปที่ node ใหม่ (ต่อสาย)
      head.next.previous = node;  // ตัวก่อนของ nodeเก่า ชี้ไป node ที่ถูกเอามาแทรก
      node.previous = null ; // ตัวก่อนของ node ที่ถูกเอามาแทรก ชี้ไป null เพราะเป็นตัวแรกสุด
    }
  }

  public void pushBack(Node node) {
    if (isEmpty()) { // หาก head||tail ชี้  null
      head = node;
      tail = node;
      node.next = null;
      node.previous  = null;
    }
    else{      // head <==> node# <==> node <==>  tail
      node.previous = tail;
      tail.next = node;
      node.next = null;
      tail = node;
    }


  }

  public Node findNode(int id){
    // หา node ที่มีมี student_id = id
    if (isEmpty()){ // หาก head||tail ชี้  null
      return new Node("Empty List!"); // sent error to Constructor
    } else { // หากมีข้อมูลอยู่ก่อนแล้ว
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
    if (isEmpty()){ // หาก head||tail ชี้  null
      System.out.println("ERROR");
      return new Node("Empty List!"); // sent error to Constructor
    } else { // หากมีข้อมูลอยู่ก่อนแล้ว
      Node current = head;  // สร้าง node current เพื่อเทียบค่าในแต่ละโนด
      Node temp; // สร้าง node current เพื่อเก็บค่าตัวที่ลบ
      if(current.student_id == id){ //หากเจอในโนด แรก
        temp = current;
        head = head.next;
        head.previous = null;
        return temp;
      }

      while (current != null) {    // ไล่ทุก node ใน LinkedList
        if(current.student_id == id)   {
          temp = current;
          if(current.next == null && current.previous == null)// โนดที่หามีตัวเดียว
          {
            head = null;
            tail = null;
          }
          else if(current.next == null){ // เจอในโนดตัวสุดท้าย
            tail.previous.next = null;
            tail = tail.previous;
          }
          else {   // เจอในสักที่
            current.next.previous = current.previous;
            current.previous.next = current.next;
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
      tail = node2;   //  ชี้ หางไปที่  node2 <= tail
      node2.previous = node1; // ตัวก่อนหน้า  node2 คือ node1
      node1.next = node2; //  ตัวหลังจาก node1 คือ node2
      node2.next = null; // ตัวหลังจาก node2 คือ null
      //    node1 <== node2 <== tail   (previous)
      //    node1 ==> node2 ==> null   (next)
    }
    else{
      node2.next = node1.next;    // ตัวถัดไป  node2 คือตัวถัดไปของ node1
      //        node2
      //          V
      //   node1     node#
      node1.next.previous = node2; // ตัวก่อนหน้า ของตัวถัดไปของ node1 คือ node2
      node1.next = node2;   // ตัวถัดไปของ node1 คือ node2
      node2.previous = node1; // ตัวก่อนหน้าของ node2 คือ node1
    }
  }

  public void addNodeBefore(Node node1, Node node2){
    // เอา node2 ไปแทรกก่อน node1
    if(node1.previous == null)  // หาก node1 อยู่หน้าสุด
    {
      node2.next = head;
      head = node2;
      node2.next.previous = node2;
      node2.previous = null;
    }
    else{
      node2.next = node1;    // ตัวถัดไป  node2 คือ  node1
      //        node2
      //          V
      //   node#     node1
      node1.previous.next = node2;  // ตัวถัดไปของตัวก่อนหน้า node1 คือ node2
      node2.previous = node1.previous; // ตัวก่อนหน้า node2 คือ ตัวก่อนหน้า node1
      node1.previous = node2; // ตัวก่อนหน้า node1 คือ node2
    }

  }

  public boolean isEmpty(){
    if(head == null || tail == null)  //หาก head หรือ tail ชี้ null แสดงว่าเป็น LinkedList ว่าง
    {return true;    }
    else
    {return false;   }
  }
  public void merge(DoublyLinkedList list){
    // [this list]  + [list]
    this.tail.next = list.head;
    list.head = this.tail;


  }

  public void printStructure(){
    Node current=head;
    System.out.print(listName + ": head <-> ");
    while(current!=null){
      System.out.print("{" + current.student_id + "} <-> ");
      current = current.next;
    }
    System.out.println("tail");
  }

  // This may be useful for you for implementing printStructure()
  public void printStructureBackward(){
    Node current=tail;
    System.out.print(listName + ": tail <-> ");
    while(current!=null){
      System.out.print("{" + current.student_id + "} <-> ");
      current = current.previous;
    }
    System.out.println("head");
  }

  public Node whoGotHighestGPA(){
    //หาว่า node ไหนมี GPA สูงสุด

    if (isEmpty()) { // หาก head||tail ชี้  null
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
