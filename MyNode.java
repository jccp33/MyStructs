package MyStructs;

/**
 * GENERIC NODE CLASS WITH AN VALUE AND A NODE NEXT
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyNode<Type> {
    Type value;
    MyNode next;
    
    /**
    * CONSTRUCTOR
    * @param value
    * @param next node
    */
    public MyNode(Type value, MyNode<Type> next){
        this.value = value;
        this.next = next;
    }
    
    /**
    * RETURN STRING OF VALUE
    * @return String
    */
    @Override
    public String toString(){
        return this.value + "";
    }
}
