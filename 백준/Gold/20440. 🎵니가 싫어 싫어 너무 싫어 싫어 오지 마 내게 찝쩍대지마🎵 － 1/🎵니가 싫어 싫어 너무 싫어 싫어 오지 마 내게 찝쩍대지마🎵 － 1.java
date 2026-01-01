import java.io.*;
import java.util.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        List<Integer> set = new ArrayList<>(map.keySet());
        set.sort(Comparator.comparingInt(a -> a));
        int ans = Integer.MIN_VALUE;
        int anst = 0, anen = 0;

        int sum = 0;
        boolean check = false;
        for(Integer a : set) {
            sum += map.get(a);

            if(sum > ans) {
                anst = a;
                check = true;
                ans = sum;
            } else if(sum < ans && check) {
                anen = a;
                check = false;
            }
        }
        System.out.println(ans);
        System.out.print(anst);
        System.out.print(" ");
        System.out.println(anen);
    }
}