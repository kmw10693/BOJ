import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int solution(int N, int d, int k, int c, int[] sushi) {
        int cnt = 1;
        int [] selected = new int[d+1];
        selected[c]++;
        for(int i=0; i<k; i++) {
            if(selected[sushi[i]] == 0) cnt++;
            selected[sushi[i]]++;
            sushi[N+i] = sushi[i];
        }
        int answer = cnt;
        
        for(int i=0; i<N; i++) {
            selected[sushi[i]]--;
            if(selected[sushi[i]] == 0) cnt--;
            if(selected[sushi[i+k]] == 0) cnt++;
            selected[sushi[i+k]]++;
            
            answer = Math.max(answer, cnt);
        }
        return answer;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N, d, k, c;
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int [] sushi = new int[N+k];
        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solution(N, d, k, c, sushi));
        br.close();
    }
}