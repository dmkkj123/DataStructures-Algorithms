import java.util.*;

/**
 * @author 王一安adw
 * @date 2025/11/26 18:56
 */
public class Kahn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> g = new ArrayList(n+1); // 邻接表
        for(int i = 0; i <= n; ++i){
            g.add(new ArrayList<>());
        }
        int[] indeg = new int[n+1]; // 入度表
        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; ++i){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> order = new ArrayList(n);
        while(!q.isEmpty()){
            int u = q.poll();
            order.add(u);
            for(int x : g.get(u)){
                indeg[x]--;
                if(indeg[x] == 0){
                    q.offer(x);
                }
            }
        }
        if(order.size() != n){
            System.out.println("has cycle.");
        }else{
            for(int i = 0; i < n; ++i){
                System.out.print(order.get(i)+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
