import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N,M,L;
    static  List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr.add(0);
        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.add(L);

        int left = 1;
        int right = L;
        int ans = L;

        Collections.sort(arr);
        while (left <= right) {
            int mid = (left+right)/2;
            int count = 0;
            for(int i=1; i<arr.size(); i++) {
                int dist = arr.get(i) - arr.get(i-1);
                if(dist-1 >= mid) count += (dist-1)/mid;
            }
            if(count <= M) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);

    }
}