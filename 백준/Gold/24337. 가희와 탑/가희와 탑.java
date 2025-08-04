import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int N, a, b;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a+b-1 > N) {
            System.out.println(-1);
            return;
        }

        for(int i=1; i<=a-1; i++)
            list.add(i);

        list.add(Math.max(a, b));

        for(int i=b-1; i>=1; i--) {
            list.add(i);
        }

        for(int i=0; i<N-(a+b-1); i++)
            list.add(1,1);

        for(int n: list)
            sb.append(n).append(' ');


        System.out.println(sb);
    }
}