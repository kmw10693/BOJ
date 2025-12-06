import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String N;
    static int M;
    static List<Integer> bans = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        M = Integer.parseInt(br.readLine());
        ans = Math.abs(Integer.parseInt(N)-100);

        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                bans.add(Integer.parseInt(st.nextToken()));
            }
        }
        check();
        System.out.println(ans);
    }
    public static void check() {
        int init = Integer.parseInt(N);

        for (int i =9999999; i >= 0; i--) {
            String cur = String.valueOf(i);
            int check = 1;
            for(int j=0; j<cur.length(); j++) {
                for(int b : bans) {
                    if(b == cur.charAt(j) - '0') {
                        check = 0;
                        break;
                    }
                }
            }
            if(check == 1) {
                ans = Math.min(ans, Math.abs(init - i) + cur.length());
            }
        }
    }
}