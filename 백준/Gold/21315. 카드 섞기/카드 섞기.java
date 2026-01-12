import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayDeque<Integer> arr;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; (1 << i) < N; i++) {
            for(int j=1; (1 << j) < N; j++) {
                arr = new ArrayDeque<>();
                for(int p=1; p<=N; p++) arr.addLast(p);
                rotate(i);
                rotate(j);
                boolean check = true;
                for(int k=0; k<N; k++) {
                    if(ans[k] != arr.removeFirst()) check = false;
                }
                if(check) {
                    System.out.print(i);
                    System.out.print(" ");
                    System.out.print(j);
                    return;
                }
            }
        }
    }
    static void rotate(int k) {
        // 2^k 위로 올리자
        int t = (1 << k);
        for(int i=1; i<=t; i++) {
            arr.addFirst(arr.removeLast());
        }

        for(int i=2; i<=k+1; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            int move = (1 << (k-i+1));
            // 일단 후보 넣자
            // 2 3
            for(int j=0; j<t; j++) tmp.addLast(arr.removeFirst());
            ArrayDeque<Integer> tmp2 = new ArrayDeque<>();
            // 4 5
            for(int j=0; j<move; j++){
                tmp2.addFirst(tmp.removeLast());
            }
            // 2 3
            for(int j=0; j<t-move; j++) {
                arr.addFirst(tmp.removeLast());
            }
            for(int j=0; j<move; j++) {
                arr.addFirst(tmp2.removeLast());
            }
            t = move;
        }
    }
}