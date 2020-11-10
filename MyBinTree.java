package MyStructs;

/**
 * GENERIC BINARY TREE CLASS (OBJECT MANAGEMENT)
 * @author JESUS CARLOS CARDENAS PINUELAS
 * @version 1.0
 * @param <Type>
 */

public class MyBinTree<Type extends Comparable<Type>> {
    private MyBinNode root;
    private int nodes;
    
    /**
    * CONSTRUCTOR
    */
    public MyBinTree(){
        this.root = null;
    }
    
    /**
    * RETURN THE ROOT NODE
    * @return MyBinNode
    */
    public MyBinNode<Type> getRoot(){
        return this.root;
    }
    
    /**
    * RETURN IF TREE IS EMPTY
    * @return Boolean
    */
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /**
    * RETURN TREE SIZE
    * @return int
    */
    public int size(){
        this.nodes = 0;
        counting(this.root);
        return this.nodes;
    }
    
    /**
    * COUNT ALL NODES IN TREE
    * @param MyBinNode root
    */
    private void counting(MyBinNode<Type> r){
        if(r != null){
            this.nodes++;
            this.counting(r.left);
            this.counting(r.right);
        }
    }
    
    /**
    * ADD NEW NODE
    * @param value Type
    */
    public void addNode(Type value){
        MyBinNode<Type> node = new MyBinNode(value);
        if(this.root == null){
            this.root = node;
        }else{
            MyBinNode<Type> aux = this.root;
            MyBinNode<Type> parent;
            while(true){
                parent = aux;
                if(value.compareTo(aux.value) < 0){
                    aux = aux.left;
                    if(aux == null){
                        parent.left = node;
                        return;
                    }
                }else{
                    aux = aux.right;
                    if(aux == null){
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }
    
    /**
    * PRINT NODES IN ORDER
    * @param r MyBinNode
    */
    public void inOrder(MyBinNode<Type> r){
        if(r != null){
            this.inOrder(r.left);
            System.out.print(r.value.toString() + " ");
            this.inOrder(r.right);
        }
    }
    
    /**
    * PRINT NODES IN PRE ORDER
    * @param r MyBinNode
    */
    public void preOrder(MyBinNode<Type> r){
        if(r != null){
            System.out.print(r.value.toString() + " ");
            this.preOrder(r.left);
            this.preOrder(r.right);
        }
    }
    
    /**
    * PRINT NODES IN POST ORDER
    * @param r MyBinNode
    */
    public void postOrder(MyBinNode<Type> r){
        if(r != null){
            this.postOrder(r.right);
            this.postOrder(r.left);
            System.out.print(r.value.toString() + " ");
        }
    }
    
    /**
    * FIND NODE BY VALUE
    * @param val Type
    * @return MyBinNode
    */
    public MyBinNode findNodeByValue(Type val){
        MyBinNode aux = this.root;
        while(aux.value.compareTo(val) != 0){
            if(aux.value.compareTo(val) > 0){
                aux = aux.left;
            }else{
                aux = aux.right;
            }
            if(aux == null){
                return null;
            }
        }
        return aux;
    }
    
    /**
    * DELETE NODE BY VALUE
    * @param val Type
    * @return Boolean
    */
    public boolean deleteNode(Type val){
        MyBinNode aux = this.root;
        MyBinNode parent = this.root;
        boolean left = true;
        
        while(aux.value.compareTo(val) != 0){
            parent = aux;
            if(aux.value.compareTo(val) > 0){
                left = true;
                aux = aux.left;
            }else{
                left = false;
                aux = aux.right;
            }
            if(aux == null){
                return false;
            }
        }
        
        if(aux.left==null && aux.right==null){
            if(aux == this.root){
                this.root = null;
            }else if(left){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }else if(aux.right == null){
            if(aux == this.root){
                this.root = aux.left;
            }else if(left){
                parent.left = aux.left;
            }else{
                parent.right = aux.left;
            }
        }else if(aux.left == null){
            if(aux == this.root){
                this.root = aux.right;
            }else if(left){
                parent.left = aux.right;
            }else{
                parent.right = aux.right;
            }
        }else{
            MyBinNode replace = getToReplace(aux);
            if(aux == this.root){
                this.root = replace;
            }else if(left){
                parent.left = replace;
            }else{
                parent.right = replace;
            }
            replace.left = aux.left;
        }
        return true;
    }
    
    /**
    * GET A NODE TO REPLACE
    * @param node TyMyBinNodepe
    * @return MyBinNode
    */
    private MyBinNode getToReplace(MyBinNode node){
        MyBinNode replc_p = node;
        MyBinNode replace = node;
        MyBinNode aux = node.right;
        while(aux != null){
            replc_p = replace;
            replace = aux;
            aux = aux.left;
        }
        if(replace != node.right){
            replc_p.left = replace.right;
            replace.right = node.right;
        }
        return replace;
    }
}
