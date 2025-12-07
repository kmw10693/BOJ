import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N,C;
    static List<Long> nums;
    static Long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();

        for(int i=0; i<N; i++) {
            nums.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(nums);

        // 거리를 이분탐색하여, 거리가 임의의 K인 경우 C개를 설치할수 있는지 검증
        long s = 0;
        long en = 1000000000;

        while (s <= en) {
            long mid = (s+en)/2;
            if(check(mid)) {
                ans = mid;
                s = mid + 1;
            }
            else {
                en = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static boolean check(long mid) {
        // 1번을 설치
        long last = nums.get(0);
        long total = 1;

        for(int i=1; i<nums.size(); i++) {
            long dis = nums.get(i) - last;
            if(dis >= mid) {
                total++;
                last = nums.get(i);
            }
        }
        if(total >= C) return true;
        return false;
    }
}