import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int N,K;
    static Map<Integer, Integer> map = new HashMap<>();
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N];

        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        map.put(0, 1);
        for(int i=0; i<N; i++) {
            ans += map.getOrDefault(sum[i]-K, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0)+1);
        }
        System.out.println(ans);
    }
}