package MyStructs;

/**
 * GENERIC QUEUE CLASS (OBJECT MANAGEMENT)
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyQueue<Type> {
    private MyNode<Type> first, last;
    private int size;
    
    /**
    * CONSTRUCTOR
    */
    public MyQueue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
    * RETURN IF QUEUE IS EMPTY
    * @return Boolean
    */
    public boolean isEmpty(){
        return this.first == null;
    }
    
    /**
    * RETURN QUEUE SIZE
    * @return int
    */
    public int size(){
        return this.size;
    }
    
    /**
    * RETURN FIRST VALUE
    * @return Type
    */
    public Type first(){
        if( this.isEmpty() ){
            return null;
        }else{
            return this.first.value;
        }
    }
    
    /**
    * RETURN FIRST VALUE, DELETE NODE
    * @return Type
    */
    public Type dequeue(){
        if( this.isEmpty() ){
            return null;
        }else{
            Type value = this.first.value;
            MyNode<Type> aux = this.first.next;
            this.first = null;
            this.first = aux;
            this.size--;
            if( this.isEmpty() ){
                this.last = null;
            }
            return value;
        }
    }
    
    /**
    * ADD NEW NODE
     * @param value
    */
    public void enqueue(Type value){
        MyNode<Type> aux = new MyNode<>(value, null);
        if( this.isEmpty() ){
            this.first = aux;
            this.last = aux;
        }else{
            if(this.size() == 1){
                this.first.next = aux;
            }else{
                this.last.next = aux;
            }
            this.last = aux;
        }
        this.size++;
    }
    
    /**
    * RETURN STRING OF VALUES
    * @return String
    */
    @Override
    public String toString(){
        if( this.isEmpty() ){
            return "";
        }else{
            String str = "";
            MyNode<Type> aux = this.first;
            while(null != aux){
                str += "[" + aux.toString() + "] ";
                aux = aux.next;
            }
            return str;
        }
    }
}
