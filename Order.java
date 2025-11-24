import java.util.LinkedList;
import java.util.Queue;
/**
 * @author 王一安adw
 * @date 2025/11/24 18:58
 */
public class Order {
    static class Node{
        int v;
        Node left;
        Node right;
        public Node(int v){
            this.v = v;
        }
    }
    public static void preorder(Node root){
        if(root == null) return;
        System.out.println(root.v + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.v + " ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.v + " ");
    }
    public static void levelorder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            System.out.println(cur.v + " ");
            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);
        }
    }

}
