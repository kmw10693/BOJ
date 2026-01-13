import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sum = 0;

        List<Integer> tmp = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int p, l;
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[p];
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<p; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());

            if(p >= l) {
               tmp.add(arr[l-1]);
            } else {
                tmp.add(1);
            }
        }
        Collections.sort(tmp);
        for(int i=0; i<tmp.size(); i++) {
            if(m >= tmp.get(i)) {
                sum++;
                m -= tmp.get(i);
            }
        }
        System.out.println(sum);

    }
}
