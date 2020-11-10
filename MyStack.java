package MyStructs;

/**
 * GENERIC STACK CLASS (OBJECT MANAGEMENT)
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */
public class MyStack<Type> {
    private MyNode<Type> top;
    private int size;
    
    /**
    * CONSTRUCTOR
    */
    public MyStack(){
        this.top = null;
        this.size = 0;
    }
    
    /**
    * RETURN IF STACK IS EMPTY
    * @return Boolean
    */
    public boolean isEmpty(){
        return this.top == null;
    }
    
    /**
    * RETURN STACK SIZE
    * @return int
    */
    public int size(){
        return this.size;
    }
    
    /**
    * RETURN VALUE IN TOP OR NULL
    * @return Type
    */
    public Type top(){
        if( this.isEmpty() ) 
            return null;
        else
            return this.top.value;
    }
    
    /**
    * RETURN VALUE IN TOP OR NULL, DELTE NODE
    * @return Type
    */
    public Type pop(){
        if( this.isEmpty() ){
            return null;
        }else{
            Type value = this.top.value;
            MyNode<Type> aux = this.top.next;
            this.top = null;
            this.top = aux;
            this.size--;
            return value;
        }
    }
    
    /**
    * ADD NEW NODE
    * @param value
    */
    public void push(Type value){
        MyNode<Type> aux = new MyNode<>(value, this.top);
        this.top = aux;
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
            MyNode<Type> aux = this.top;
            while(null != aux){
                str += "[" + aux.toString() + "] ";
                aux = aux.next;
            }
            return str;
        }
    }
}
