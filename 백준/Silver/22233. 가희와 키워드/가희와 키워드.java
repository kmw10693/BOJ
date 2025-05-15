import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(br.readLine(), true);
        }

        int cnt = n;
        for(int i=0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
            while (st2.hasMoreTokens()) {
                String s = st2.nextToken();
                if(map.containsKey(s)) {
                    cnt--;
                    map.remove(s);
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}