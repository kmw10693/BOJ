import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = 1000000000;
        long ans = 0;

        while (start <= end) {
            long mid = (start+end)/2;
            long cutheight = 0;
            for(int i=0; i<N; i++) {
                if(mid <= trees[i]) cutheight += (trees[i] - mid);
            }

            if(cutheight >= M) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);

    }
}