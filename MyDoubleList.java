package MyStructs;

/**
 * GENERIC DOUBLE LINKED LIST CLASS (OBJECT MANAGEMENT)
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyDoubleList<Type> {
    private MyDoubleNode<Type> start, end;
    private int size;
    
    /**
    * CONSTRUCTOR
    */
    public MyDoubleList(){
        this.start = this.end = null;
        this.size = 0;
    }
    
    /**
    * RETURN IF LIST IS EMPTY
    * @return Boolean
    */
    public boolean isEmpty(){
        return this.start == null;
    }
    
    /**
    * RETURN LIST SIZE
    * @return int
    */
    public int size(){
        return this.size;
    }
    
    /**
    * ADD NODE TO END
    * @param value
    */
    public void addEnd(Type value){
        if( !this.isEmpty() ){
            this.end = new MyDoubleNode(value, this.end, null);
            this.end.prev.next = this.end;
        }else{
            this.start = this.end = new MyDoubleNode(value);
        }
        this.size++;
    }
    
    /**
    * ADD NODE TO START
    * @param value
    */
    public void addStart(Type value){
        if( !this.isEmpty() ){
            this.start = new MyDoubleNode(value, null, this.start);
            this.start.next.prev = this.start;
        }else{
            this.start = this.end = new MyDoubleNode(value);
        }
        this.size++;
    }
    
    /**
    * RETURNS A STRING OF VALUES ITERING FORWARD (SEPARATOR: SPACE)
    * @return String
    */
    public String getForward(){
        String str = "";
        if( !this.isEmpty() ){
            MyDoubleNode<Type> aux = this.start;
            while(aux != null){
                str += aux.value.toString() + " ";
                aux = aux.next;
            }
        }
        return str;
    }
    
    /**
    * RETURNS A STRING OF VALUES ITERING BACKWARD (SEPARATOR: SPACE)
    * @return String
    */
    public String getBack(){
        String str = "";
        if( !this.isEmpty() ){
            MyDoubleNode<Type> aux = this.end;
            while(aux != null){
                str += aux.value.toString() + " ";
                aux = aux.prev;
            }
        }
        return str;
    }
    
    /**
    * REMOVE THE FIRST NODE, RETURN VALUE
    * @return Type
    */
    public Type removeStart(){
        Type value = null;
        if( !this.isEmpty() ){
            value = this.start.value;
            if(this.start == this.end){
                this.start = this.end = null;
            }else{
                this.start = this.start.next;
                this.start.prev = null;
            }
        }
        this.size--;
        return value;
    }
    
    /**
    * REMOVE THE LAST NODE, RETURN VALUE
    * @return Type
    */
    public Type removeEnd(){
        Type value = null;
        if( !this.isEmpty() ){
            value = this.end.value;
            if(this.start == this.end){
                this.start = this.end = null;
            }else{
                this.end = this.end.prev;
                this.end.next = null;
            }
        }
        this.size--;
        return value;
    }
}
