import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }

        System.out.println(ans);
    }
}