import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {
    static Scanner sc;
    static int N, x, y;
    static Vector<Integer> v;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] arr = new int[50002];

        for(int i=0; i<N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            arr[i] = y;
        }

        Stack<Integer> S = new Stack<Integer>();
        for(int i=0; i<=N; i++) {
            while (!S.empty() && S.peek() > arr[i]) {
                answer += 1;
                S.pop();
            }

            if(!S.empty() && S.peek() == arr[i]) continue;
            S.push(arr[i]);
        }

        System.out.println(answer);
    }
}