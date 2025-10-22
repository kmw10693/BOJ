import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int answer = Integer.MAX_VALUE;
        // 1 ~ 18
        for(int i=min; i<=max-17; i++) {
            answer = Math.min(answer, solve(i, i+17, arr));
        }
        // i, i+17, i
        System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    public static int solve(int min, int max, int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                sum += Math.pow(arr[i]-max, 2);
            } else if(arr[i] < min) {
                sum += Math.pow(min-arr[i], 2);
            }
        }
        return sum;
    }
}