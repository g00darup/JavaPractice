package jHug;

public class BST {
    private int key;
    private BST left;
    private BST right;

    public BST(int key, BST left, BST Right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(int key) {
        this.key = key;
    }

    static BST find(BST T, int sk) {
        if (T == null)
            return null;
        if (sk==(T.key))
            return T;
        else if (sk < T.key)
        return find(T.left, sk);
        else
        return find(T.right, sk);
    }

    static BST insert(BST T, int ik) {
        if (T == null)
            return new BST(ik);
        if (ik < T.key)
            T.left = insert(T.left, ik);
        else if (ik >T.key)
            T.right = insert(T.right, ik);
        return T;
    }


    private void print(BST x) {
        if (x == null) return;
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }

//    public boolean contains(int key) {
//         return get(key) != null;
//    }
//    public Value get(int key) {
//        return get(root, key);
//    }
//
//    private Value get(Node x, Key key) {
//        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if      (cmp < 0) return get(x.left, key);
//        else if (cmp > 0) return get(x.right, key);
//        else              return x.val;
//    }

    static BST delete(BST T, int ik){

        return T;
    }

    public static void main(String[] args) {
        BST bst = new BST(17);
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key: keys) {
            bst = insert(bst,key);
        }
        //bst.print(bst);
        System.out.println( bst.find(bst,15).key);
        bst.print(bst);
    }
}

