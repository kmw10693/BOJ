import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long x,y,w,s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        long ans = 0;

        // 만약 직선 거리가 대각선보다 작을 경우 무조건 직선거리
        if(2*w  < s) {
            ans = (long) (x + y) * w;
        }
        else if(w > s) {
            // 직선거리가 대각선보다 큰 경우
            // 무조건 대각선으로 가기
            if((x + y) % 2 == 0) {
                ans = (long)Math.max(x, y) * s;
            }
            else {
                ans = (long)(Math.max(x, y) - 1) * s + w;
            }
        }
        else {
            if(x == y) {
                ans = (long)x * s;
            }
            else {
                ans += Math.min(x*s, y*s);
                ans += (long) Math.abs(y - x) * w;
            }
        }
        System.out.println(ans);
    }
}