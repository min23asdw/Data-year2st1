//รับ input เป็นตัวเลขจำนวนเต็ม ( int )
//โปรแกรมนี้จะพิม  hello nlogn  เป็นจำนวนเท่ากับ N log2(N)

public class q18{


  static void LogLinear( int x ){

    for(int i = 0; i<x; i++){   //    loop แรกจะทำการ loop ตามจำนวน  N  จึงเป็น       O(N)
      for(int j = x; j > 0; j/=2){   //  loop แรกจะทำการ loop ตามจำนวน  X  และลดลงครึ่งนึงในแต่ละรอบแบบ log2()      จึงเป็น       O(log n)
        System.out.println("hello nlogn");
      }

    }
  }                    //              เมื่อรวมลู)นอกลูปใน O(N)  x  O(log n)  = N Log2(N) จึงกล่าวได้ว่า      fn LogLinear  is O(N log n)


  public static void main(String[] args) {

    LogLinear(10000);

  }



}
