public class BSTNode<T> {
    Comparable data;
    BSTNode left;
    BSTNode right;

    //Acessors(get)
    public BSTNode getLeft(){
        return this.left;
    }
    public BSTNode getRight(){
        return this.right;
    }
    public Comparable getData(){
        return this.data;
    }
    //mutators(set)
    public void setRight(BSTNode v){
        this.right = v;
    }
    public void setLeft(BSTNode v){
        this.left = v;
    }
    public void setData(Comparable v){
        this.data = v;
    }
    //constructor
    public BSTNode(Comparable v){
        this.data = v;
        left = null;
        right = null;
    }

}
