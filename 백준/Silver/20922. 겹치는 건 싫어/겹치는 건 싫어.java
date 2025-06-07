import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[200005];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visit = new int[200005];
    static StringTokenizer st;

    public static void main(String [] args) throws Exception {
        int N,K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visit[i] = 0;
        }

        int start =0, end = 0;
        int answer = -1;
        while(start < N && end < N) {
            // 만약 작다면
            if(visit[arr[end]] < K) {
                visit[arr[end]]++;
                end++;
                answer = Math.max(answer, end-start);
            }
            else {
                visit[arr[start]]--;
                start++;
            }
        }
        System.out.print(answer);
    }
}