import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            int n;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0) break;
            arr = new int[n];

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = Long.MIN_VALUE;

            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<n; i++) {

                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    int height = arr[stack.pop()];

                    if(stack.isEmpty()) {
                        ans = Math.max(ans, (long) height * i);
                    }
                    else {
                        ans = Math.max(ans, (long)height * (i-1 - stack.peek()));
                    }
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int height = arr[stack.pop()];

                if(stack.isEmpty()) {
                    ans = Math.max(ans, (long)height * n);
                }
                else {
                    ans = Math.max(ans, (long)height * (n-1 - stack.peek()));
                }
            }
            System.out.println(ans);
        }
    }
}