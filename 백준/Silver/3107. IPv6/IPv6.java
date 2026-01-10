import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, ":");
        int zeroCount = 8-st.countTokens();
        StringBuilder tmp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<str.length()-1; i++) {

            if(str.charAt(i) == ':' && str.charAt(i+1) == ':') {
                if(tmp.length() > 0) {
                    int count = 4 - tmp.length();
                    while (count-- > 0) {
                        ans.append('0');
                    }
                    ans.append(tmp);
                    ans.append(':');
                    tmp = new StringBuilder();
                }

                for(int j=0; j<zeroCount; j++) {
                    ans.append("0000");
                    ans.append(':');
                }
                i++;
            }
            else if(str.charAt(i) == ':') {
                int count = 4 - tmp.length();
                while (count-- > 0) {
                    ans.append('0');
                }
                ans.append(tmp);
                ans.append(':');
                tmp = new StringBuilder();
            } else {
                tmp.append(str.charAt(i));
            }
        }
        String lasttmp = "";
        for(int j=str.length()-1; j>=0; j--) {
            if(str.charAt(j) == ':') break;
            lasttmp += str.charAt(j);
        }
        if(lasttmp.length() > 0) {
            int count = 4 - lasttmp.length();
            while (count-- > 0) {
                ans.append('0');
            }
            ans.append(new StringBuilder(lasttmp).reverse().toString());
        }
        if(ans.charAt(ans.length() - 1) == ':') ans.deleteCharAt(ans.length()-1);
        System.out.println(ans);
    }
}