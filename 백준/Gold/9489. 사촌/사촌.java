import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n,k;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0) break;
            int[] parent = new int[n + 2];
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int target = -1;
            int idx = -1;
            // 0번 부모는 -1
            parent[0] = -1;
            if (arr[0] == k) target = 0;
            for (int i = 1; i < n; i++) {
                // 현재 노드
                int cur = arr[i];
                int prev = arr[i - 1];
                // 이전 노드
                if (arr[i] == k) target = i;
                if (prev + 1 != cur) idx++;
                parent[i] = idx;
            }
            ans = 0;
            for (int i = 1; i < n; i++) {
                if (parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) ans++;
            }

            System.out.println(ans);
        }
    }
}