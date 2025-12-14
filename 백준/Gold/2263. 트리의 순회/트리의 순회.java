import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inorder = new int[n+1];
        postorder = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int num = Integer.parseInt(st.nextToken());
            inorder[num] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        recur(1, n, 1, n);
        System.out.println(sb);
    }
    static void recur(int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return;
        int root = postorder[pe];
        int rIdx = inorder[root];
        sb.append(root);
        sb.append(" ");
        int len = rIdx - is;

        recur(is, rIdx-1, ps, ps+len-1);
        recur(rIdx+1, ie, ps+len, pe-1);
    }
}