// package hw2;
import hw2.DynamicArray;
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray var = new DynamicArray(2);
        var.printStructure();
        for (int i=0; i<10; i++){
     var.pushBack(i*i + 1);
}
var.printStructure();
var.remove(3);
var.printStructure();
    }

}
