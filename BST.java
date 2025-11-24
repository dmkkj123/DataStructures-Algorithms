/**
 * @author 王一安adw
 * @date 2025/11/24 16:49
 */
public class BST {
    private Node root;
    static class Node {
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
            left = null;
            right = null;
        }
    }
    // 插入
    public void insert(int x) {
        root = insert(root, x);
    }
    private Node insert(Node node, int x){
        if(node == null) return new Node(x);
        if(x < node.v) node.left = insert(node.left, x);
        else if(x > node.v) node.right = insert(node.right, x);
        return node;
    }
    // 查找
    public boolean contains(int x){
        return contains(root, x);
    }
    private boolean contains(Node node, int x){
        if(node == null) return false;
        if(x == node.v) return true;
        if(x < node.v) return contains(node.left, x);
        else return contains(node.right, x);
    }
    // 删除
    public void remove(int x) {
        root = remove(root, x);
    }
    private Node remove(Node node, int x){
        if(node == null) return null;
        if(x < node.v){
            node.left = remove(node.left, x);
        }else if(x > node.v){
            node.right = remove(node.right, x);
        }else{
            // 关键 如果找到了
            // 1.没有子节点
            if(node.left == null && node.right == null){
                return null;
            }
            // 2.有一个子节点
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }
            // 难点
            // 3.有两个子节点
            Node t = node.right;
            while(t.left != null){
                t = t.left;
            }
            node.v = t.v;
            node.right = remove(node.right, t.v);
        }
        return node;
    }
}
