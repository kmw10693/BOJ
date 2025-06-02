import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] temp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {

            int tempIdx = 0;
            while(true) {
                if (arr[tempIdx] == 0 && temp[i] == 0) {
                    arr[tempIdx] = i+1;
                    break;
                } else if (arr[tempIdx] == 0) temp[i]--;
                tempIdx++;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}