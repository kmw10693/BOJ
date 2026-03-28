import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int start, end;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, end});
        }

        Collections.sort(arr, (a, b) -> {
           if(a[1] == b[1]) return a[0] - b[0];
           return a[1] - b[1];
        });

        int start = 0;
        int ans = 0;
        for(int[] a : arr) {
            if(a[0] >= start) {
                start = a[1];
                ans++;
            }
        }
        System.out.print(ans);
    }
}