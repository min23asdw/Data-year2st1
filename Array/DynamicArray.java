package Array;

public class DynamicArray{

  int[] arr;
  int size;  //defalt = 0
  int cap;




  public DynamicArray(int capacity){  // function ที่มีชื่อเดียวกับ class
    cap = capacity;
    arr = new int[cap];


  }

  public void pushBack(int value){
    if(size<cap){
      arr[size] = value;
      size++;
    }else{

      int[] temp = new int[cap*2]; // สร้าง array ใหม่ ใหญ่ 2 เท่า
      for (int i = 0;i<size;i++){
        temp[i] = arr[i];    // ย้ายข้อมูล
        System.out.println( "temp " + temp[i] + ", " + "i " + i + ", "+"arr " +  arr[i]);

      }

      arr = temp;
      cap = cap*2;
      arr[size] = value;
      size++;
    }

  }
  public void printAll(){
    for (int i=0;i<size;i++){
      System.out.println(arr[i]+ ", ");


    }

  }
}
