import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static long k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n;
        while (left <= right) {
            long row = (left + right) / 2;
            long col = (n - row);

            if(check(row, col) == k) {
                System.out.println("YES");
                return;
            }
            else if(check(row, col) > k) right = row - 1;
            else if(check(row, col) < k) left = row + 1;
        }
        System.out.println("NO");
    }
    private static long check(long row, long col) {
        return (row + 1) * (col + 1);
    }
}