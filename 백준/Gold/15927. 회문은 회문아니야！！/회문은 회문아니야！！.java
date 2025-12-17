import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        boolean samesent = false;
        for(int i=0; i<len/2; i++) {
            if(s.charAt(i) != s.charAt(len-1-i)) {
                System.out.print(len);
                return;
            } else if (s.charAt(i) != s.charAt(i+1)) {
                samesent = true;
            }
        }
        if(samesent) {
            System.out.println(len - 1);
        } else {
            System.out.println(-1);
        }
    }
}