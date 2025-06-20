import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static HashMap<Integer, Integer> hash = new HashMap<>();
    private static boolean[] visited = new boolean[105];

    private static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            hash.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            hash.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        hash.put(1,1);
        bfs();

        System.out.println(cnt);
    }

    // bfs
    public static void bfs() {
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int end = 100;

        while(!q.isEmpty()) {
            cnt++;
            for(int i=0, size=q.size(); i<size; i++) {
                int init = q.poll();
                for(int j=1; j<=6; j++) {
                    if(init+j == end) return;
                    if(init+j > end) continue;
                    if(visited[init+j]) continue;
                    visited[init+j] = true;
                    // 사다리가 있는 경우
                    if(hash.containsKey(init+j)) {
                        q.add(hash.get(init+j));
                    }
                    else q.add(init+j);
                }
            }
        }
    }
}