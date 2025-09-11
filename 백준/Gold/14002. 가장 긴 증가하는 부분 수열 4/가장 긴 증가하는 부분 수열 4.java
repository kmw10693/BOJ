import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int maxSize = 1;
        for(int i=1; i<N; i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxSize = Math.max(maxSize, dp[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxSize + "\n");
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--) {
            if(dp[i] == maxSize) {
                stack.add(arr[i]);
                maxSize--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.print(sb.toString());


    }
}