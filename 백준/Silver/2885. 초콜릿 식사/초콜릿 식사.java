import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int start = 1;
        while(true) {
            if(start >= K) {
                break;
            }
            start *= 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        int ans = 0;
        while(K > 0) {
            if(K >= start) {
                K -= start;
            } else {
                start /= 2;
                ans++;
            }
        }
        sb.append(" ");
        sb.append(ans);
        System.out.println(sb);
    }
}