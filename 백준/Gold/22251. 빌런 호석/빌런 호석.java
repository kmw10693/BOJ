import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, P, X;
    static int ans;
    static int[][] map = {{1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] Xdigit = todigit(X);

        for(int i=1; i<=N; i++) {
            if(i == X) continue;
            if(comparenum(i, Xdigit)) ans++;
        }
        System.out.println(ans);
    }

    public static boolean comparenum(int i, int[] Xdigit) {
        int[] iarr = todigit(i);
        int tmpadd = 0;
        for(int j=0; j<K; j++) {
            for(int k=0; k<7; k++) {
                if(map[iarr[j]][k] != map[Xdigit[j]][k]) {
                    tmpadd++;
                }
                if(tmpadd > P) return false;
            }
        }
        return true;
    }
    public static int[] todigit(int num) {
        int[] arr = new int[K];
        int temp = num;
        for(int i=K-1; i>=0; i--) {
            arr[i] = temp%10;
            temp/=10;
        }
        return arr;
    }

}