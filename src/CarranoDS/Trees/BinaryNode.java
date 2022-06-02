package CarranoDS.Trees;

import java.io.Serializable;

public class BinaryNode<T> implements BinaryNodeInterface<T>, Serializable {

    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T data) {
        this(data,null,null);
    }

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T newData) {
        data = newData;
    }

    @Override
    public BinaryNodeInterface getLeftChild() {
        return left;
    }

    @Override
    public BinaryNodeInterface getRightChild() {
        return right;
    }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {
            this.left = (BinaryNode)leftChild;
    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {
            this.right = (BinaryNode) rightChild;
    }

    @Override
    public boolean hasLeftChild() {
        return left!=null;
    }

    @Override
    public boolean hasRightChild() {
        return right!=null;
    }

    @Override
    public boolean isLeaf() {
        return (left!=null && right!=null);
    }

    @Override
    public int getNumberOfNodes() {
        int lnodes=0;
        int rNodes=0;

        if(left!=null)
            lnodes = left.getNumberOfNodes();
        if(right!=null)
            rNodes = right.getNumberOfNodes();

        return 1+lnodes+rNodes;
    }

    @Override
    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(BinaryNode<T> node) {
        return 1+Math.max(getHeight(node.left),getHeight((node.right)));
    }

    @Override
    public BinaryNodeInterface copy() {
        return null;
    }
}
