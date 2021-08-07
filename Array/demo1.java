


import Array.DynamicArray;


public class demo1{


  public static void main(String[] args) {


    // int[] Myarray;   //  ชีสร้าง [] ้ไปที่ null
    // Myarray = new int[10];   // new สร้าง [] ขนาด 10 ช่อง set ค่าเป็น 0
    //
    // for (int i = 0 ; i < 10 ; i++){
    //   Myarray[i] = i;
    // }
    // for (int i = 0 ; i < 10 ; i++){
    //   System.out.println(Myarray[i]);
    // }



    // int[] Myarray= new int[10];    // สร้างตัวแปล Myarray [0,0,...]
    // System.out.println(Myarray[0]);
    // Myarray[0]= 1;                   // Myarray [1,0,...]
    // System.out.println(Myarray[0]);
    // Myarray = new int[10];            // Myarray ชี้ไปที่ตัวใหม่
    // System.out.println(Myarray[0]);
    // // output =  0 1 0     [1 Myarray]   [2 object = ]


    DynamicArray array = new DynamicArray(2);
    array.pushBack(1);
    array.pushBack(2);

    array.pushBack(3); // new array

    array.pushBack(4);
    array.pushBack(5);
    array.pushBack(6);
    array.pushBack(7);
    array.printAll();
  }






}
