import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Main {
    static int N;
    static long M;
    static long[] arr;
    static long mid;
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long s = 0, en = M * arr[arr.length-1];
        while (s <= en) {
            mid = (s+en)/2;
            long count = 0;
            for(int i=0; i<N; i++) {
                count += mid/arr[i];
                if(count >= M) break;
            }
            if(count >= M) {
                en = mid - 1;
                ans = Math.min(mid, ans);
            }
            else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}