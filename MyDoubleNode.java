package MyStructs;

/**
 * GENERIC NODE CLASS WITH ONE VALUE AND TWO NODES, PREVIOUS, NEXT
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyDoubleNode<Type> {
    Type value;
    MyDoubleNode prev, next;
    
    /**
    * CONSTRUCTOR
    * @param value
    * @param prev node
    * @param next node
    */
    public MyDoubleNode(Type value, MyDoubleNode<Type> prev, MyDoubleNode<Type> next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
    
    /**
    * CONSTRUCTOR
    * @param value
    */
    public MyDoubleNode(Type value){
        this(value, null, null);
    }
}
