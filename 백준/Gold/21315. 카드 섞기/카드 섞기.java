import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] target;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        target = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) target[i] = Integer.parseInt(st.nextToken());

        for (int k1 = 1; (1 << k1) <= N; k1++) {
            for (int k2 = 1; (1 << k2) <= N; k2++) {

                dq = new ArrayDeque<>(N);
                for (int i = 1; i <= N; i++) dq.addLast(i);

                shuffle(k1);
                shuffle(k2);

                if (match()) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }
    }

    // (2, k) - 섞기
    static void shuffle(int k) {
        int t = 1 << k;

        // 1단계: 아래 t장을 위로 (전체 덱을 오른쪽으로 t 회전)
        for (int i = 0; i < t; i++) {
            dq.addFirst(dq.pollLast());
        }

        // 이후 단계: "맨 위 t장 중 아래 p장을 위로" 반복
        for (int step = 1; step <= k; step++) {
            int p = 1 << (k - step);
            rotatePrefixRight(t, p);
            t = p;
        }
    }

    // 덱의 맨 위 t장(prefix)만 대상으로, 그 중 아래 p장을 맨 위로 올린다.
    // == prefix(t)를 오른쪽으로 p만큼 회전
    static void rotatePrefixRight(int t, int p) {
        ArrayDeque<Integer> prefix = new ArrayDeque<>(t);

        // 1) 맨 위 t장을 분리
        for (int i = 0; i < t; i++) {
            prefix.addLast(dq.pollFirst());
        }

        // 2) prefix의 아래 p장을 moved에 (순서 유지)
        ArrayDeque<Integer> moved = new ArrayDeque<>(p);
        for (int i = 0; i < p; i++) {
            moved.addFirst(prefix.pollLast()); // pollLast 역순 추출 -> addFirst로 다시 순서 복구
        }

        // 3) 남은 prefix(위쪽 t-p장)를 먼저 덱 앞에 붙임 (순서 유지)
        while (!prefix.isEmpty()) {
            dq.addFirst(prefix.pollLast());
        }

        // 4) moved(아래 p장)를 덱 앞에 붙임 (순서 유지)
        while (!moved.isEmpty()) {
            dq.addFirst(moved.pollLast());
        }
    }

    static boolean match() {
        int idx = 0;
        for (int x : dq) {
            if (x != target[idx++]) return false;
        }
        return true;
    }
}
