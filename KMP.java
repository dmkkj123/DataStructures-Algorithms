import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 王一安adw
 * @date 2025/11/25 21:16
 */
public class KMP {
    private static List buildLps(String t){
        int m = t.length();
        List<Integer> lps = new ArrayList(m);
        for(int i = 0; i < m; i++){lps.add(0);}
        int len = 0;
        for(int i = 1; i < m; ){
            if(t.charAt(i) == t.charAt(len)){
                lps.set(i++, ++len);
            }else{
                if(len > 0){
                    len = lps.get(len-1);
                }else{
                    i++;
                }
            }
        }
        return lps;
    }
    private static List kmpSearch(String s, String t) throws IndexOutOfBoundsException{
        int n = s.length(), m = t.length();
        List<Integer> lps = buildLps(t);
        List<Integer> ans = new ArrayList();
        int i = 0, j = 0;
        while(i < n){
            if(s.charAt(i) == t.charAt(j)){
                i++; j++;
            }
            if(j == m){
                ans.add(i-j);
                j = lps.get(j-1);
            }else if(i < n && s.charAt(i) != t.charAt(j)){
                if(j > 0) j = lps.get(j-1);
                else i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        List<Integer> ans = kmpSearch(s, t);
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
