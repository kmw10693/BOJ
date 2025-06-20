import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int T;
    private static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }

            // 문자열 횟수 초기화
            count = new int[29];
            for(int j=0; j<29; j++) count[j] = 0;

            for(int j=0; j<str.length(); j++) {
                count[str.charAt(j)-'a']++;
            }

            int minValue = Integer.MAX_VALUE;
            int maxValue = -1;

            for(int j=0; j<str.length(); j++) {
                int cnt = 1;
                if(count[str.charAt(j) - 'a'] < k) continue;
                for(int p=j+1; p<str.length(); p++) {
                    if(str.charAt(p) == str.charAt(j)) cnt++;
                    if(cnt == k) {
                            minValue = Math.min(minValue, p+1-j);
                            maxValue = Math.max(maxValue, p+1-j);
                            break;
                        }
                    }
                }

            if(maxValue == -1 || minValue == Integer.MAX_VALUE) {
                System.out.println(-1);
            }
            else {
                System.out.println(minValue + " " + maxValue);
            }
        }
    }
}