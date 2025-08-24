import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Long mod = 1000000007L;
    static Long N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        // nCk = n! / (k!)(n-k)!
        Long temp = factorial(K) * factorial(N-K) % mod;
        Long ans = factorial(N) * gop(temp, mod-2) % mod;
        System.out.print(ans);
    }
    private static Long factorial(Long n) {
        Long i = 1L;
        Long ans = 1L;

        while(i <= n) {
            ans = ans * i % mod;
            i++;
        }

        return ans;
    }

    // 거듭 제곱
    private static Long gop(Long n, Long e) {
        if(e == 1L) return n;

        Long tempGop = gop(n, e/2);

        tempGop = tempGop * tempGop % mod;
        if(e % 2 == 1L) {
            return tempGop * n % mod;
        }
        return tempGop % mod;
    }
}