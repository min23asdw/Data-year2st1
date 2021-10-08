public class Heap {
    
    int capacity;
    Node[] arr;
    int size;
    
    boolean isMinHeap;  // true if minHeap, false if maxHeap
    
    int timer;    // For each push, the timer will increase by 1
    
    public Heap(boolean isMinHeap, int cap){   
        // Initialize the heap here
        // Don't forget that we will build the binary heap using...
        // ... the concept of "Complete binary tree based on the array implementation"
        // ... The 0 index will not be used, The index starts from 1 (remember?)
        
        // constructor [max cap 20]

        this.isMinHeap = isMinHeap;
        this.capacity = cap + 1;
        size = 1;
        arr = new Node[capacity];


    }
    public Node top(){
        return arr[1]; 
    }
    
    public void push(Node node){
        // Increase timer each time you push something into the Queue
        timer++;
        node.timestamp = timer; // Stamp the time number to the node
        
        // To do:
        // 1. Push the new node at the end of the array (via back pointer)
        // 2. Sift (percolate) it up the heap
        //      * Check priority of the current node with its parent
        //      * Swap the current node if the priority is higher than the parent
        //      * Repeat the process until reaching the root or there is no swap (Pls use while loop)
        // 3. Increase the heap size

        arr[size] = node;
        int index = size;

        while(index >= 1){
            int parentindex = (int) Math.floor( index/2.00 );

            if(parentindex <= 1){break;}


            if(isMinHeap){
                if(arr[index].price <= arr[parentindex].price ){
                    swap(index, parentindex);
                }

            }else{
                if(arr[index].price >= arr[parentindex].price ){
                    swap(index, parentindex);
                }
                
            }

            index = parentindex;
            
        }

        size ++;
        

       
    }
    
    public Node pop(){
        
        // To do:
        // 1. Mark the root for return (Don't forget to return this node)
        // 2. Move the last node to the root (change pointer, set null)
        // 3. Decrease the heap size
        // 4. Sift (percolate) it down the heap
        //      * Check priority of the current node with both children
        //      * Swap the current node with the lower priority child
        //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)
        Node hightpriority  = arr[1];

        arr[1] = arr[size];
        arr[size] = null;

        
        int index =1;
        while(index <= size){
            int childindex =  index * 2 ;

            if(childindex > size){break;}

            if(isMinHeap){ // ตัวเบาควรอยู่บน
                if(arr[index].price >= arr[childindex].price){    // มีลูกเบากว่า

                    if(arr[childindex+1]!= null){

                        if(arr[childindex].price < arr[childindex+1].price){  // ลูกที่เบากว่า จะต้องขึ้นมา
                            swap(index, childindex); 
                        }else{
                            swap(index, childindex+1);
                        }

                    }else{
                        swap(index, childindex); 
                    }


                }

            }else{ // ตัวหนักควรอยู่บน
                if(arr[index].price <= arr[childindex].price || arr[index].price <= arr[childindex+1].price){    // มีลูกหนักกว่า

                    if(arr[childindex+1]!= null){

                        if(arr[childindex].price > arr[childindex+1].price){  // ลูกที่เบากว่า จะต้องขึ้นมา
                            swap(index, childindex); 
                        }else{
                            swap(index, childindex+1);
                        }

                    }else{
                        swap(index, childindex); 
                    }

                }
            }

            index = childindex;
           

            
        }
        size--;

        return hightpriority; // FIX THIS

    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
