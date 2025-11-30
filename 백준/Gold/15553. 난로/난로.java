import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int ans = 0x7fffffff;
    static Node[] nodes;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 시작 시간, 종료 시간이 필요하니 Node 클래스를 선언하자.
        nodes = new Node[N];

        for(int i=0; i<N; i++) {
            int start = Integer.parseInt(br.readLine());
            nodes[i] = new Node(start, start+1);
        }
        // 처음 난로를 키고 끈 곳이 필요하겠음
        dfs(0, 1, 1, nodes[0].start,  0);
        System.out.println(ans);

    }
    static void dfs(int idx, int cnt, int islight, int start, int sum) {
        // 마지막 인덱스일떄
        if(idx == N-1) {
            // 불 킨 횟수가 K번 이하여야지..
            if(islight == 0) {
                if(cnt <= K-1) ans = Math.min(ans, sum + 1);
            }
            else if(islight == 1) {
                if(cnt <= K) ans = Math.min(ans, sum + (nodes[idx].end - start));
            }
            return;
        }
        // 1 2
        // 3 4
        // 6 7

        // 만약 불이 꺼져있는 경우
        if(islight == 0) {

            dfs(idx+1, cnt+1, 1, nodes[idx].start, sum);
            dfs(idx+1, cnt+1, 0, start, sum + (nodes[idx].end - nodes[idx].start));
        }
        else {
            // 0 + (4 - 1) dfs(1, 3)
            dfs(idx+1, cnt, 0, start, sum + (nodes[idx].end - start));
            //
            dfs(idx+1, cnt, 1, start, sum);
        }
    }

    static class Node {
        int start, end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
