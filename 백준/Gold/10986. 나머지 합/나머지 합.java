import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Main {
    static int N, M;
    static long[] s;
    static long[] div;
    static long ans;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        s = new long[N];
        div = new long[N];

        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        div[0] = s[0] % M;

        for (int i = 1; i < N; i++) {
            s[i] += s[i - 1] + Integer.parseInt(st.nextToken());
            div[i] = s[i] % M;
        }

        for (int i = 0; i < N; i++) {
            if (div[i] == 0) ans++;
            map.put(div[i], map.getOrDefault(div[i], 0L) + 1);
        }
        for (Long key : map.keySet()) {
            long count = map.get(key);
            ans += comb(count);
        }
        System.out.println(ans);
    }
    static long comb(long count) {
        return (long) count *(count-1)/2;
    }
}