public class BST<T> {
    BSTNode root;

    public boolean find(Comparable v){
        return find(root,v);
    }

    private boolean find(BSTNode node, Comparable v){
        if(node == null)
            return false;
        if(node.getData().compareTo(v) == 0)
            return true;
        else if(node.getData().compareTo(v) > 0)
            return find(node.getRight(),v);
        else
            return find(node.getLeft(),v);
    }

    public void insert(Comparable v){
        root = insert(root,v);
    }

    private BSTNode insert(BSTNode node, Comparable v){ //O()
        if(node == null){
            BSTNode n = new BSTNode(v);
            return n;
        }
        else if(node.getData().compareTo(v) > 0){
            BSTNode n = insert(node.getRight(),v);
            node.setRight(n);
        }
        else{
            BSTNode n = insert(node.getLeft(), v);
            node.setLeft(n);
        }
        return node;
    }

    public void print(){
        print(root);
    }
    //this is in order
    private void print(BSTNode node){
        if(!(node==null)){ // for any in order traversal
            print(node.getLeft());
            System.out.println(node.getData());  // example node data += node data*0.15
            print(node.getRight());
        }
        return;
    }
    public void delete(Comparable v){
        return;
    }

}
