public class Heap {

    int capacity;
    Node[] arr;
    int size;

    boolean isMinHeap; // true if minHeap, false if maxHeap

    int timer; // For each push, the timer will increase by 1

    public Heap(boolean isMinHeap, int cap) {
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

    public Node top() {
        return arr[1];
    }

    public void push(Node node) {
        // Increase timer each time you push something into the Queue
        timer++;
        node.timestamp = timer; // Stamp the time number to the node

        // To do:

        // 1. Push the new node at the end of the array (via back pointer)
        arr[size] = node;

        // 2. Sift (percolate) it up the heap
        // * Check priority of the current node with its parent
        // * Swap the current node if the priority is higher than the parent
        // * Repeat the process until reaching the root or there is no swap (Pls use
        // while loop)
        int index = size;
        int parentindex = (int) Math.floor(index / 2.00);
        while (true) {

            if (size + 1 < 3) {
                break;
            } // ถ้ามี node ตัวเดียวใน tree

            if (parentindex < 1) {
                break;
            } // ไล่มาจนถึง root

            if (arr[index].compare(arr[parentindex])) { // มีตัว index ซึ่งอยู่ท้ายของ array มี priority มากกว่า parent
                                                        // ของมัน จึงควรก่อน จึงต้อง swap
                swap(index, parentindex);
                index = parentindex;
                parentindex = index / 2;
            } else {
                break;
            }

        }

        // 3. Increase the heap size
        size++;

    }

    public Node pop() {

        // To do:

        // 1. Mark the root for return (Don't forget to return this node)
        Node hightpriority = arr[1];

        // 2. Move the last node to the root (change pointer, set null)
        arr[1] = arr[size - 1];
        arr[size - 1] = null;

        // 3. Decrease the heap size
        size--;

        int index = 1;
        int childindex = index * 2;

        // 4. Sift (percolate) it down the heap
        // * Check priority of the current node with both children
        // * Swap the current node with the lower priority child
        // * Repeat the process until the node has no child or there is no swap (Pls use
        // while loop)
        while (true) {

            if (size < 3) { // ถ้ามี node ตัวเดียวใน tree
                break;
            } 
            if (childindex >= size) { // ไล่จนเลยจากจำนวน node ใน tree
                break;
            }  

            if (childindex + 1 < size) { // มีลูกที่ 2k+1 ด้วย
                if (arr[childindex + 1].compare(arr[childindex])) { // ด้านซ้าย ซึ่งมี priority ที่ควรอจึงต้
                    childindex = childindex + 1;
                }
            }

            if (arr[childindex].compare(arr[index])) { // มีลูก ซึ่งมี priority ที่ควรออกก่อน จึงต้อง swap
                if (arr[childindex].compare(arr[index])) { // ลูก มี priority มากกว่า
                    swap(index, childindex); // สลับ k กับ 2k
                    index = childindex;
                    childindex = index * 2;
                } else {
                    break;
                }

            }else{
                break;
            }

        }

        return hightpriority; // FIX THIS

    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2) {
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
