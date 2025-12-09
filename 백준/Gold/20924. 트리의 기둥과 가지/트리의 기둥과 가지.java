import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N,R;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static long longbranch = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N+1; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b, d));
            arr.get(b).add(new Node(a, d));
        }
        // BFS
        boolean[] visited = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        long tree =0;
        q.add(new Node(R, 0));
        visited[R] = true;
        boolean isTree = false;

        while (!q.isEmpty()) {
            Node n = q.poll();
            visited[n.num] = true;
            ArrayList<Node> friends = arr.get(n.num);
            int count = 0;
            for(int i=0; i<friends.size(); i++) {
                Node friend = friends.get(i);
                if(visited[friend.num]) continue;
                q.add(new Node(friend.num, n.cost + friend.cost));
                count++;
            }
            if(count >= 2 && !isTree) {
                isTree = true;
                tree = n.cost;
            }
            else if(count < 2 && !isTree) {
                tree = n.cost;
            }
            else if(count == 0) {
                longbranch = Math.max(longbranch, n.cost - tree);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tree);
        sb.append(" ");
        sb.append(longbranch);
        System.out.print(sb);
    }
    static class Node {
        int num;
        long cost;
        Node(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}