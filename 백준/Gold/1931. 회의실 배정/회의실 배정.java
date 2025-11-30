import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Node> q = new PriorityQueue<>();

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.add(new Node(start, end));
        }

        int end = 0;
        int ans = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if(end > n.start) continue;
            ans++;
            end = n.end;
        }
        System.out.println(ans);
    }
    static class Node implements Comparable<Node> {
        int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node n) {
            if (this.end == n.end) return this.start - n.start;
            return this.end - n.end;
        }
    }
}
