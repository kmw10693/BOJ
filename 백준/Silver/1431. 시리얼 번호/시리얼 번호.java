import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> wordlist = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            wordlist.add(s);
        }

        Collections.sort(wordlist, (a,b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            else if(a.length() == b.length()) {
                int asum = 0;
                int bsum = 0;

                for(int i=0; i<a.length(); i++) {
                    if(a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                        asum += a.charAt(i) - '0';
                    }
                }

                for(int i=0; i<b.length(); i++) {
                    if(b.charAt(i) >= '0' && b.charAt(i) <= '9') {
                        bsum += b.charAt(i) - '0';
                    }
                }

                if(asum != bsum) {
                    return asum - bsum;
                }
            }
            return a.compareTo(b);
        });

        for(String word : wordlist) {
            System.out.println(word);
        }
    }
}