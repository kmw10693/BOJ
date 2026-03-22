import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        Queue<Document> q = new ArrayDeque<>();

        while(T-- > 0) {
            int N, M;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Document(i, priority));
            }

            int ans = 1;
            while (!q.isEmpty()) {
                Document cur = q.poll();

                boolean isprint = true;
                for(Document d : q) {
                    if(cur.priority < d.priority) {
                        isprint = false;
                        break;
                    }
                }

                if(isprint) {
                    if(cur.idx == M) {
                        System.out.println(ans);
                        break;
                    } else {
                        ans++;
                    }
                } else {
                    q.add(cur);
                }
            }
            q.clear();
        }
    }

    public static class Document {
        int idx, priority;
        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}