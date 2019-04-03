public class BST<T> {
    BSTNode root;
    /*
    * BST()
    * constructor, creates a BST
     */
    public BST(){
        root = null;
    }

    public boolean find(Comparable v){
        return find(root,v);
    }
    /*
    * find()
    * recursively looks to the left or right of the current node
    * to find the element in the BST
     */
    private boolean find(BSTNode node, Comparable v){
        if(node == null)
            return false;
        if(node.getData().compareTo(v) == 0)
            return true;
        else if(node.getData().compareTo(v) < 0)
            return find(node.getRight(),v);
        else
            return find(node.getLeft(),v);
    }

    public void insert(Comparable v){
        root = insert(root,v);
    }
    /*
    * insert()
    * recursively calls itself to create a node checking if it
    * is to the left or right of the current node
     */
    private BSTNode insert(BSTNode node, Comparable v){ //O()
        if(node == null){
            BSTNode n = new BSTNode(v);
            return n;
        }
        else if(node.getData().compareTo(v) < 0){
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

    /*
     print()
     prints the node starting from the left then to the right
     this is in order printing
     */
    private void print(BSTNode node){
        if(!(node==null)){ // for any in order traversal
            print(node.getLeft());
            System.out.println(node.getData());  // example node data += node data*0.15
            print(node.getRight());
        }
        return;
    }

    public void delete(Comparable v){
        root = delete(root,v);
    }
    /*
    * delete()
    * find the successor of the node to delete by going one to the right
    * then all the way to the left to input that value in the spot being
    * deleted
     */
    private BSTNode delete(BSTNode node, Comparable v){
        if(node==null)
            return null;
        if(node.getData().compareTo(v) == 0){
            if(node.getLeft()==null){
                return node.getRight();
            }
            else if(node.getRight()==null){
                return node.getLeft();
            }
            else{
                if(node.getRight().getLeft() == null){
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                    return node;
                }
                else{
                    node.setData(removeSmallest(node.getRight()));
                    return node;
                }
            }
        }
        else if(node.getData().compareTo(v) > 0){
            node.setRight(delete(node.getRight(),v));
        }
        else{
            node.setLeft(delete(node.getLeft(),v));
        }
        return node;
    }

    /*
    * removeSmallest()
    * gets the node all the way to the left of the input node
    * and returns it to the delete function
     */

    private Comparable removeSmallest(BSTNode node){
        if(node.getLeft().getLeft() == null){
            Comparable smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        else{
            return removeSmallest(node.getLeft());
        }
    }

}
