package MyStructs;

/**
 * GENERIC BINARY NODE CLASS WITH ONE VALUE AND TWO NODES, LEFT, RIGHT
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyBinNode<Type extends Comparable<Type>> {
    public Type value;
    MyBinNode left, right;
    
    /**
    * CONSTRUCTOR
    * @param value Type
    */
    public MyBinNode(Type value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    /**
    * RETURN STRING OF VALUE
    * @return String
    */
    @Override
    public String toString(){
        return this.value.toString();
    }
}
