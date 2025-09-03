import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        int N, K;
        int ans = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[][] dfs = new boolean[1000001][K+1];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(N, 0));
        dfs[N][0] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.cnt == K) {
                ans = Math.max(ans, n.num);
                continue;
            }

            int length = String.valueOf(n.num).length();

            for(int i=0; i<length-1; i++) {
                for(int j=i+1; j<length; j++) {
                    int k = swap(n.num, i, j);
                    if (k != -1 && !dfs[k][n.cnt + 1]) {
                        q.add(new Node( k ,n.cnt+1));
                        dfs[k][n.cnt+1] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int swap(int n, int i, int j) {
        char[] charArray = String.valueOf(n).toCharArray();

        if(i == 0 && charArray[j] == '0') {
            return -1;
        }

        char c = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = c;

        return Integer.parseInt(new String(charArray));
    }
}