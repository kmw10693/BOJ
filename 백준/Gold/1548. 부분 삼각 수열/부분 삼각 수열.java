import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int ans = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0; i<N-1; i++) {
            for(int j=N-1; j>=0; j--) {
                if(i+1 == j) break;
                if(arr[i] + arr[i+1] > arr[j]) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        if(N == 1) System.out.println(1);
        else System.out.println(ans);
    }
}