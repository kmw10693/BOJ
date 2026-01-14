import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<StringBuilder> list = new ArrayList<>();
        // 각 기차에 넣기
        for(int i=0; i<n; i++) {
            StringBuilder s = new StringBuilder("00000000000000000000");
            list.add(s);
        }

        // 마지막에 set의 개수를 세면 됨
        Set<String> set = new HashSet<>();
        for(int j=0; j<m; j++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            StringBuilder sb = list.get(i-1);

            if(num == 1) {
                int x = Integer.parseInt(st.nextToken());
                if(sb.charAt(x-1) == '0') {
                    sb.setCharAt(x-1,  '1');
                }
            } else if(num == 2){
                int x = Integer.parseInt(st.nextToken());
                if(sb.charAt(x-1) == '1') {
                    sb.setCharAt(x-1, '0');
                }
            } else if(num == 3){
                for(int t = 19; t >=1; t--) {
                    // 앞에 있는 것 가져오기
                    char tmp = sb.charAt(t-1);
                    sb.setCharAt(t, tmp);
                }
                // 0번째는 0으로 채움
                sb.setCharAt(0, '0');
            } else {
                for(int t = 0; t <=18; t++) {
                    // 앞에 있는 것 가져오기
                    char tmp = sb.charAt(t+1);
                    sb.setCharAt(t, tmp);
                }
                // 0번째는 0으로 채움
                sb.setCharAt(19, '0');
            }
            list.set(i-1, sb);
        }


        for(int i=0; i< list.size(); i++) {
            set.add(String.valueOf(list.get(i)));
        }
        System.out.println(set.size());
    }
}