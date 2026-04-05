import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long start = 1;
        long end = 0;

        for (int i = 0; i < K; i++) {
            lans[i] = Long.parseLong(br.readLine());
            end = Math.max(end, lans[i]);
        }

        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(lans, mid, N)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean check(long[] lans, long mid, int N) {
        long count = 0;

        for (int i = 0; i < lans.length; i++) {
            count += lans[i] / mid;
        }

        return count >= N;
    }
}