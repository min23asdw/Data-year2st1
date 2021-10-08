// This node contains information about an investor (investorID) who submits an order (sell order = minHeap, buy order = maxHeap)
// at a certain time (timestamp) and a certain price (price)
public class Node {
    
    double price;
    int investorID;
    int amount;
    int timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }
    
    // This function will return true if Priority(thisNode) > Priority(rightNode)
    // minHeap: the lower the price, the higher the priority
    // maxHeap: the lower the price, the lower the priority
    // If same price, the smaller the timestamp is, the higher the priority will be
    public boolean compare(Node rightNode){
        if (this.price == rightNode.price) {   // ราคาเท่ากัน เวลาน้อยกว่ามี priority มากกว่า
            if(this.timestamp < rightNode.timestamp){
                return true;
            }else{
                return false; 
            }
        }else{  // ในกรณีราคาไม่เท่ากัน  ต้องเช็คก่อนว่า เป็นฝั่งซื้อ[maxheap]หรือฝั่งขาย[minheap]
            if (isMinHeap){ // if minheap = true  [sell side]   lower price have more  priority
                if(this.price < rightNode.price){
                    return true;
                }else{
                    return false;       
                }
              
            }else{ // if minheap = flase  [buy side]   higher price have more  priority
                if(this.price > rightNode.price){
                    return true;
                }else{
                    return false;  
                }
                
            }
        }
    }
    
    public Node(){} // Dummy constructor, no need to edit
}
