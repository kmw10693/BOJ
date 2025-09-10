import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int to, cost, d;

        public Node(int to, int cost, int d) {
            this.to = to;
            this.cost = cost;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if(this.d == o.d) return this.cost - o.cost;
            return this.d - o.d;
        }
    }

    private static int T;
    private static int N,M,K;
    private static int u,v,c,d;
    private static ArrayList<Node>[] map;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new ArrayList[N+1];
            for(int j=1; j<=N; j++) {
                map[j] = new ArrayList<>();
            }

            for(int j=1; j<=K; j++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                map[u].add(new Node(v,c,d));
            }
            dp = new int[M+1][N+1];

            int ans = Integer.MAX_VALUE;
            for(int j=1; j<=M; j++) {
                Arrays.fill(dp[j], Integer.MAX_VALUE);
            }

            dijkstra();

            for(int j=1; j<=M; j++) {
                ans = Math.min(ans, dp[j][N]);
            }

            sb.append(ans == Integer.MAX_VALUE ? "Poor KCM" : ans);
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra() {

        for(int i=1; i<=N; i++) {
            Collections.sort(map[i]);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));
        dp[0][1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.to == N) return;

            for(Node nxt : map[cur.to]) {
                 int cost = cur.cost + nxt.cost;
                 int d = cur.d + nxt.d;

                 if(cost > M) continue;

                 if(dp[cost][nxt.to] > d) {
                     for(int j=cost+1; j<=M; j++) {
                         if(dp[j][nxt.to] > d) dp[j][nxt.to] = d;
                         else break;
                     }
                     dp[cost][nxt.to] = d;
                     pq.add(new Node(nxt.to, cost, d));

                 }
            }
        }
    }
}