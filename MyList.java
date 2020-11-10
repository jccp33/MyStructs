package MyStructs;

/**
 * GENERIC LIST CLASS (OBJECT MANAGEMENT)
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyList<Type> {
    private MyNode<Type> first, last;
    private int size;
    
    /**
    * CONSTRUCTOR
    */
    public MyList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
    * RETURN IF LIST IS EMPTY
    * @return Boolean
    */
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    /**
    * RETURN LIST SIZE
    * @return int
    */
    public int size(){
        return this.size;
    }
    
    /**
    * ADD LAST NODE
    * @param value Type
    */
    public void addLast(Type value) {
        MyNode<Type> aux;
        if (this.isEmpty()) {
            addFirst(value);
        } else {
            aux = new MyNode<>(value, null);
            this.last.next = aux;
            this.last = aux;

        }
        this.size++;
    }

    /**
    * ADD FIRST NODE
    * @param value
    */
    public void addFirst(Type value) {
        MyNode<Type> aux;
        if (isEmpty()) {
            aux = new MyNode<>(value, null);
            this.first = aux;
            this.last = aux;
        } else {
            MyNode<Type> first_curr = this.first;
            aux = new MyNode<>(value, first_curr);
            this.first = aux;
        }
        this.size++;
    }
    
    /**
    * ADD NODE IN INDEX POSITION
    * @param value
    * @param index
    */
    public void add(Type value, int index) {
        if (index == 0) {
            this.addFirst(value);
        } else if (index == size()) {
            this.addLast(value);
        } else if ((index < 0 || index >= size())) {
            return;
        } else {
            MyNode<Type> finded_prev = this.getNode(index-1);
            MyNode<Type> finded_curr = this.getNode(index);
            MyNode<Type> aux = new MyNode<>(value, finded_curr);
            finded_prev.next = aux;
            this.size++;
        }

    }
    
    /**
    * GET FIRST NODE
    * @return Type
    */
    public Type getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return this.first.value;
        }
    }
    
    /**
    * GET LAST NODE
    * @return Type
    */
    public Type getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return this.last.value;
        }
    }
    
    /**
    * GET NODE IN INDEX POSITION
    * @param index
    * @return MyNode<Type>
    */
    private MyNode<Type> getNode(int index) {
        if (this.isEmpty() || (index<0 || index>=this.size)) {
            return null;
        } else if (index == 0) {
            return this.first;
        } else if (index == this.size-1) {
            return this.last;
        } else {
            MyNode<Type> finded = this.first;
            //Busco el nodo deseado con un recorrido
            int cont = 0;
            while (cont < index) {
                cont++;
                finded = finded.next;
            }
            return finded;

        }

    }
    
    /**
    * GET VALUE IN INDEX POSITION
    * @param index
    * @return Type
    */
    public Type get(int index) {
        if (this.isEmpty() || (index<0 || index>=this.size)) {
            return null;
        } else if (index == 0) {
            return this.first.value;
        } else if (index == this.size-1) {
            return this.last.value;
        } else {
            MyNode<Type> finded = this.getNode(index);
            return finded.value;
        }
    }
    
    /**
    * RETURN IF LIST CONTAIN VALUE
    * @param value
    * @return Boolean
    */
    public boolean contain(Type value){
        if( this.isEmpty() ){
            return false;
        }else{
            MyNode<Type> aux = this.first;
            while(aux != null){
                if(value.equals(aux.value)){
                    return true;
                }
                aux = aux.next;
            }
            return false;
        }
    }
    
    /**
    * RETURN INDEX OF VALUE, -1 IF NO EXIST
    * @param value
    * @return int
    */
    public int indexOf(Type value){
        if( this.isEmpty() ){
            return -1;
        }else{
            MyNode<Type> aux = this.first;
            int posc = 0;
            while(aux != null){
                if(value.equals(aux.value)){
                    return posc;
                }
                posc++;
                aux = aux.next;
            }
            return -1;
        }
    }
    
    /**
    * REMOVE THE FIRST NODE, RETURN VALUE
    * @return Type
    */
    public Type removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            Type value = this.first.value;
            MyNode<Type> aux = this.first.next;
            this.first = null;
            this.first = aux;
            if (this.size == 1) {
                this.last = null;
            }
            this.size--;
            return value;
        }

    }
    
    /**
    * REMOVE THE LAST NODE, RETURN VALUE
    * @return Type
    */
    public Type removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            Type value = this.last.value;
            MyNode<Type> aux = this.getNode(this.size-2);
            if (aux == null) {
                this.last = null;
                if (this.size == 2) {
                    this.last = this.first;
                } else {
                    this.first = null;
                }
            } else {
                this.last = null;
                this.last = aux;
                this.last.next = null;
            }
            this.size--;
            return value;
        }
    }
    
    /**
    * REMOVE THE NODE IN INDEX, RETURN VALUE
    * @param index
    * @return Type
    */
    public Type remove(int index) {
        if (this.isEmpty() || (index<0 || index>=this.size)) {
            return null;
        } else if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size-1) {
            return this.removeLast();
        } else {
            MyNode<Type> node_prev = this.getNode(index - 1);
            MyNode<Type> node_curr = this.getNode(index);
            Type value = node_curr.value;
            MyNode<Type> node_next = node_curr.next;
            node_curr = null;
            node_prev.next = node_next;
            this.size--;
            return value;
        }
    }
    
    /**
    * MODIFY THE VALUE OF NODE IN INDEX
    * @param value
    * @param index
    */
    public void modify(Type value, int index) {
        if (this.isEmpty() || index<0 || index>=this.size) {
        } else {
            MyNode<Type> aux = this.getNode(index);
            aux.value = value;
        }
    }
    
    /**
    * RETURN STRING OF VALUES
    * @return String
    */
    @Override
    public String toString() {
        String str = "";
        if ( !this.isEmpty() ) {
            MyNode<Type> aux = this.first;
            while (aux != null) {
                str += "[" + aux.toString() + "] ";
                aux = aux.next;
            }
        }
        return str;
    }
}
