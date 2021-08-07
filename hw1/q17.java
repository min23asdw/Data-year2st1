//รับ input เป็นตัวเลขจำนวนเต็ม ( int )
//โปรแกรมนี้จะพิม  hello n  เป็นจำนวนเท่ากับ N

public class q17{

  static void HowMuchYouWantToPrint(int N){
    if(N>0)
    for(int i=0;i<N;i++){
      System.out.println("hello n");
    }
    else {
      System.out.println("Enter a value greater than 0.");
    }
  }


  public static void main(String[] args) {

    HowMuchYouWantToPrint(3);

  }
}
