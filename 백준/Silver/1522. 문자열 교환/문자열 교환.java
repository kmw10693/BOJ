import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int min = Integer.MAX_VALUE;
        int alen = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a') alen++;
        }

        // 15
        for(int i=0; i<s.length(); i++) {
            int bcnt = 0;
            // alen = 3
            for(int j=i; j<alen+i; j++) {
                // 0 % 15 == b
                if(s.charAt(j % s.length()) == 'b') bcnt++;
            }
            // min이 0이야 0
            min = Math.min(min, bcnt);
        }
        System.out.println(min);
    }
}