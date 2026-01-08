import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static boolean[] visited;
    static List<Node>[] arr;
    static int check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[100005];

        for(int i=1; i<100005; i++) {
            arr[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end, cost;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, cost));
            arr[end].add(new Node(start, cost));
            right = Math.max(right, cost);
        }
        int fs, fe;
        st = new StringTokenizer(br.readLine());
        fs = Integer.parseInt(st.nextToken());
        fe = Integer.parseInt(st.nextToken());
        while (left <= right) {
            int mid = (left+right) / 2;
            check = -1;
            visited = new boolean[100005];
            dfs(fs, fe, mid);
            if(check == 1) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.println(right);
    }
    public static void dfs(int cur, int dst, int cost) {
        if(cur == dst) {
            check = 1;
            return;
        }

        visited[cur] = true;
        for(Node f : arr[cur]) {
            if(cost <= f.cost && !visited[f.nxt]) {
                dfs(f.nxt, dst, cost);
            }
        }
    }
    static class Node {
        int nxt, cost;
        Node(int nxt, int cost) {
            this.nxt = nxt;
            this.cost = cost;
        }
    }
}