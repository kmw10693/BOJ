import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] arr = new int[52][52];
    public static int char2idx(String p) {
        if(p.charAt(0) >= 'a') {
            return p.charAt(0) - 'a' + 26;
        } else {
            return p.charAt(0) - 'A';
        }
    }
    public static char idx2char(int idx) {
        if(idx >= 26) return (char)(idx + 'a' - 26);
        return (char)(idx + 'A');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 플로이드

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String p = st.nextToken();
            String op = st.nextToken();
            String q = st.nextToken();
            arr[char2idx(p)][char2idx(q)] = 1;
        }

        for(int k=0; k<52; k++) {
            for(int i=0; i<52; i++) {
                for(int j=0; j<52; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for(int i=0; i<52; i++) {
            for(int j=0; j<52; j++) {
                if(i == j) continue;
                if(arr[i][j] == 1) {
                    ans++;
                    sb.append(idx2char(i));
                    sb.append(" ");
                    sb.append("=> ");
                    sb.append(idx2char(j));
                    sb.append("\n");
                }
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }
}