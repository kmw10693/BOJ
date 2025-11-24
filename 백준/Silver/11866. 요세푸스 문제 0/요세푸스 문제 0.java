import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            q.add(i);
        }

        Queue<Integer> ans = new LinkedList<>();
        while (!q.isEmpty()) {
            if(q.size() >= K) {
                for(int i=0; i<K-1; i++) {
                    int tmp = q.poll();
                    q.add(tmp);
                }
                ans.add(q.poll());
            }
            else {
                for(int i=0; i<K-1; i++) {
                    q.add(q.peek());
                    q.poll();
                }
                ans.add(q.poll());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!ans.isEmpty()) {
            if(ans.size() == 1) {
                sb.append(ans.poll());
            }
            else {
                sb.append(ans.poll());
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}