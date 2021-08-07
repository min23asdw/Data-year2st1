package hw3;

public class Node {
    public int student_id;
    public String name;
    public double gpa;

    Node next;
    Node previous;

    // Constructor 1
    public Node(int recieve_id, String recieve_name, double recieve_gpa){
      //กำหนดค่าเรื่ิมต้นสามตัวแปล   ที่ได้รับมา
  this.student_id = recieve_id; // setค่าของ id nodeนี้  เท่ากับ id ที่ได้รับมา
  this.name = recieve_name; // setค่าของ name nodeนี้  เท่ากับ id ที่ได้รับมา
  this.gpa = recieve_gpa; // setค่าของ gpa nodeนี้  เท่ากับ id ที่ได้รับมา

    }
    // Constructor 2
    public Node(String error_msg){ // หากเกิด error , มีแคาข้อความที่เข้ามา  (error massege) จะเข้าฟังชั่นนี้
      this.student_id = 0;
      this.name = error_msg;   // set this Name  = error_msg
      this.gpa = 0;

    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }

    public void printIDName(){
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}
