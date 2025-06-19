import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] belt;
    private static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) robot[i] = false;

        int cnt = 0;
        while (check()) {
            cnt++;
            // 첫 번째
            int temp = belt[2*N-1];
            for (int i = 2*N-1; i >0 ; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;

            for (int i = N-1; i >0 ; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 두번째
            for (int i = N-1; i > 0; i--) {
                if(belt[i] > 0 && !robot[i] && robot[i-1]) {
                    robot[i] = robot[i-1];
                    robot[i-1] = false;
                    belt[i]--;
                }
            }
            // 세번째
            if(belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }
        }
        System.out.println(cnt);
    }

    public static boolean check() {
        int checkv = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (belt[i] == 0) checkv++;
        }
        if (checkv >= K) return false;
        return true;
    }

}