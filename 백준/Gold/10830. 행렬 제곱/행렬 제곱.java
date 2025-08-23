import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.MarshalledObject;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Long B;
    static int[][] arr;
    static int mod = 1000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
            }
        }

        int [][] ans;
        ans = divide(arr, B);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] divide(int [][] A, Long exp) {
        if(exp == 1L) return arr;

        A = divide(A, exp/2);// 2로 분할
        A = gop(A, A);// 서로 곱함
        if(exp % 2 == 1L) {
            A = gop(A, arr);
        }
        return A;
        // 홀수면 하나 곱함
    }

    private static int[][] gop(int [][]o1, int[][]o2) {
        int [][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    arr[i][j] += o1[i][k] * o2[k][j];
                }
                arr[i][j] = arr[i][j] % mod;
            }
        }
        return arr;
    }
}