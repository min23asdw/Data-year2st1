//รับ input เป็นตัวเลขจำนวนเต็ม ( int )
//โปรแกรมนี้จะพิม  hello n^2  เป็นจำนวนเท่ากับ N^2

public class q19{


  static void Quadratic( int x ){

    for(int i = 0; i<x; i++){   //    loop แรกจะทำการ loop ตามจำนวน  N  จึงเป็น       O(N)
      for(int j = 0; j < x; j++){   //  loop แรกจะทำการ loop ตามจำนวน  N  จึงเป็น       O(N)
        System.out.println("hello n^2");
      }

    }
  }                    //              เมื่อรวมลู)นอกลูปใน O(N)  x  O(N)  = O(N^2) จึงกล่าวได้ว่า      fn Quadratic is O(N^2)


  public static void main(String[] args) {

    Quadratic(200);

  }



}
