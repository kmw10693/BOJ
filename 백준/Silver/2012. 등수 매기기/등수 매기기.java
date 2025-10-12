import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int t = Integer.parseInt(br.readLine());
            arr.add(t);
        }

        arr.sort(null);
        long ans = 0;
        int index = 1;
        for(Integer i : arr) {
            ans += Math.abs(index -i);
            index++;
        }
        System.out.println(ans);
        // 다 정렬하기
        // 1 2 5 4 4
        // 1 2 4 4 5
        // 1 2 3 4 5
        // 1
    }
}