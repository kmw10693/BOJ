import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int T;
    private static int n, m, t;
    private static int s, g, h;
    private static ArrayList<Node>[] arr;
    private static boolean[] visited;
    private static int[] mindist;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n+1];
            for(int j=1; j<n+1; j++) {
                arr[j] = new ArrayList<Node>();
            }
            visited = new boolean[n+1];

            for(int j=0; j<m; j++) {
                int a, b, d;
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken()) * 2;

                if((a == g && b == h) || (a == h && b == g)) {
                    d--;
                }
                arr[a].add(new Node(b, d));
                arr[b].add(new Node(a, d));
            }
            mindist = new int[n+1];

            ArrayList<Integer> ans = new ArrayList<>();
            for(int j=0; j<t; j++) {
                Arrays.fill(mindist, INF);
                Arrays.fill(visited, false);
                int end = Integer.parseInt(br.readLine());
                int dist = dijkstra(end);
                if (dist == -1) continue;

                if (dist % 2 == 1) ans.add(end);
            }
            Collections.sort(ans);
            for(int a : ans) {
               sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.d, n2.d));
        pq.add(new Node(s, 0));
        mindist[s] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(n.x == end) {
                return n.d;
            }
            if(visited[n.x]) continue;
            visited[n.x] = true;

            for(Node t: arr[n.x]) {
                if(!visited[t.x] && mindist[t.x] > mindist[n.x] + t.d) {
                    mindist[t.x] = mindist[n.x] + t.d;
                    pq.offer(new Node(t.x, mindist[t.x]));
                }
            }

        }
        return -1;
    }

    private static class Node {
        int x, d;
        public Node(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }
}