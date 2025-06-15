import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static int[] subin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        br.close();

        subin = new int[100001];
        Arrays.fill(subin, -1);

        Queue<Integer> q = new LinkedList<Integer>();
        subin[n] = 0;
        q.offer(n);

        while (!q.isEmpty()) {
            int bfn = q.poll();

            if (bfn == k) {
                System.out.println(subin[bfn]);
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    if ((bfn + 1) <= 100000 && subin[bfn + 1] == -1) {
                        q.offer(bfn + 1);
                        subin[bfn + 1] = subin[bfn] + 1;
                    }
                } else if (i == 1) {
                    if ((bfn-1) >= 0 && subin[bfn-1] == -1) {
                        q.offer(bfn-1);
                        subin[bfn-1] = subin[bfn] + 1;
                    }
                } else {
                    if(bfn*2 <= 100000 && subin[bfn*2] == -1) {
                        q.offer(bfn*2);
                        subin[bfn*2] = subin[bfn] + 1;
                    }
                }
            }
        }
    }
}