package hw4;

public class Stock { // cal หุ้น
  private List list;
  private int totalShares;

  public Stock(String costBasis){   // conducter
    switch (costBasis) {
      case "FIFO":
      list = new Queue();
      break;
      case "LIFO":
      list = new Stack();
      break;
      default:
      System.out.println("Invalid cost basis. Choose FIFO or LIFO");
      break;
    }
  }

  public void buy(int boughtShares, double boughtPrice){ // push node (จำนวนหุ้น ราคาหุ้นตอนซื้อ)  => costBasis
    // Complete this code
    list.push(new Node(boughtShares,boughtPrice));    // push node (จำนวนหุ้น ราคาหุ้นตอนซื้อ)  => list จาก costBasis
    totalShares += boughtShares;
  }

  public void sell(int soldShares, double soldPrice){ //คำนวนกำไร ขาดทุน  จาก datastuce
    if (soldShares <= totalShares){   // ยังมีหุ้นที่ถืออยู่

      double realizedGain = 0.0;
      double unrealizedGain = 0.0;
      // Realized cal
      while (list.top() != null && soldShares >0) { // list = Queue หรือ list = Stack อย่างใดอย่างนึงตาม costBasis
        if (soldShares >= list.top().shares) //หากจำนวนที่จะขาย  เกิน หุ้นโนดนึง ที่มีอยู๋
        {

          realizedGain += (soldPrice-list.top().price)*list.top().shares;   // สูตรคำนวนกำไร
          soldShares -= list.top().shares;
          list.pop();

        }
        else {                         //จำนวนขายน้อยกว่าทีมีอยู๋
          realizedGain += (soldPrice-list.top().price)*soldShares;
          list.top().shares -= soldShares;
          soldShares = 0;   // ขายหมดและหยุดลูป

        }

      }
      // Unrealized cal
      Node current = list.top();    // เอา list ที่เหลือมาคิด  Unrealized
      while(current != null){ // ลูปจนไปถึงก่อนตัวสดท้าย
        unrealizedGain += (soldPrice-current.price)*current.shares;
        current = current.next;
      }





      totalShares -= soldShares;
      System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
    }else{
      System.out.println("Sell command rejected");
    }
  }

  public void showList(){
    Node currentNode = list.top();
    System.out.print("head -> ");
    while (currentNode!=null){
      System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
      currentNode = currentNode.next;
    }
    System.out.println("tail");
  }
}
