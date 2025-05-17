import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder();

    public static void main(String []args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n-1];
            long sum = 0L;
            for(int j=n-2; j>=0; j--) {
                if(max > arr[j]) {
                    sum += max - arr[j];
                }
                else {
                    max = arr[j];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

}