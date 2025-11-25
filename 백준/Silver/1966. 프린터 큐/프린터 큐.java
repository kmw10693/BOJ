import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            Queue<Node> q = new LinkedList<>();
            Queue<Node> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N, M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int pr = Integer.parseInt(st.nextToken());
                q.add(new Node(pr, j));
                pq.add(new Node(pr, j));
            }

            int cnt = 1;
            while (!q.isEmpty() && !pq.isEmpty()) {
                Node pqcur = pq.poll();
                Node k = q.peek();
                while (k.pr != pqcur.pr) {
                    q.poll();
                    q.add(k);
                    k = q.peek();
                }
                if(q.poll().idx == M) System.out.println(cnt);
                cnt++;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int pr, idx;
        Node(int pr, int idx) {
            this.pr = pr;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node n) {
            return n.pr - this.pr;
        }
    }
}