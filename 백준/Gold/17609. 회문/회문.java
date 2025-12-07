import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int T;
    static String[] s;

    public static boolean isP(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String s = br.readLine();
            // 투포인터 풀이
            int start = 0, end = s.length() - 1;
            if(isP(s, 0, end)) {
                System.out.println(0);
                continue;
            }
            int ans = 2;
            while (start < end) {
                if(s.charAt(start) != s.charAt(end)) {
                     if(isP(s, start+1, end)) ans = 1;
                     if(isP(s, start, end-1)) ans = 1;
                     break;
                }
                start++;
                end--;
            }
            System.out.println(ans);
        }
    }
}