package hw2;



public class DynamicArray {
  private int[] arr;
  private int capacity;
  private int size; // Last element can be indexed at size-1

  public DynamicArray(int cap){ // Class Constructor
    arr = new int[cap];
    capacity = cap;
  }

  public void pushBack(int data){
    // FIXED THIS  นำข้อมูลใส่ข้างหลัง
    // ถ้าเต็ม ขยาย 2 เท่า แล้ว coppy

    if(size<capacity){
      arr[size] = data; //pushBack recive data
      size++;  // next index
    }
    else{

      int[] temp = new int[capacity*2]; //make new array 2*capacity
      for(int i = 0; i<size;i++){ // Move old data to new 2time Array
        temp[i] = arr[i]; //coppy per index to index
      }

      arr = temp; // switch pointer to new
      capacity = capacity*2;

      arr[size] = data;//pushBack recive data
      size++;  // next index

    }
  }
  public int popBack(){
    // FIXED THIS  ลบข้อมูลตัวหลัง
    // return ค่า ที่่ถูที่่ถูกลบ
    // หากว่าง console ERROR  return 0
    if(size!=0){
      int temp = arr[size-1]; // backup value remove
      size--; // remove index = ลบค่า
        // System.out.println("temp" + temp);
      return temp;
    }
    else{
      System.out.println("ERROR");
    }
    return 0;
  }

  public int get(int i){
    // FIXED THIS return ค่าที่ตำแหน่ง index ของ DynamicArray
    // i ถ้าไม่ถูกต้อง console ERROR
    if(0<=i && i<size){
      return arr[i];
    }
    else{
      System.out.println("ERROR");
    }
    return 0;
  }
  public void set(int i, int value){
    // FIXED THIS set ค่า  ในตำแหน่ง index if () {
    // i ถ้าไม่ถูกต้อง console ERROR
    if(0<=i && i<size){
      arr[i] = value;
    }else{
      System.out.println("ERROR");
    }

  }


  public void remove(int i){
    // FIXED THIS ลบข้อมูลตำแหน่ง index
    // ลบแล้ว  ขยับข้อมูล
    // i ถ้าไม่ถูกต้อง console ERROR

    if(0<=i && i<size){
      for(int j = i ; j < size-1;j++){ // shif array mean delete it
        arr[j]= arr[j+1];

      }
      size--;
    }else{
      System.out.println("ERROR");
    }
  }

  public boolean isEmpty(){
    // FIXED THIS return ว่า data sture ว่างหรือไม่
    if(size==0){  // array ว่าง return true
      return true;
    }
    return false;
  }

  public int getSize(){
    // FIXED THIS  return จำนวยนข้อมูล (size)
    return size;
  }

  public void printStructure(){
    // FIXED THIS
    System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
    if(size!=0){
      for (int i = 0 ; i < size ; i++){
        System.out.print(arr[i]);
        if(i+1!=size){System.out.print(", ");}
        else{System.out.println(" ] ");}
      }
    }else{System.out.println("] ");}
  }
}
