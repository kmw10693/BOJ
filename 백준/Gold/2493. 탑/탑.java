import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int num;
    int height;

    Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int N;
        N = Integer.parseInt(br.readLine());
        Stack<Top> s = new Stack<>();
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if(s.empty()) {
                ans.append("0 ");
                s.push(new Top(i, height));
            } else {
                while(true) {
                    if(s.empty()) {
                        ans.append("0 ");
                        s.push(new Top(i, height));
                        break;
                    } else {
                        if(s.peek().height > height) {
                            ans.append(s.peek().num + " ");
                            s.push(new Top(i, height));
                            break;
                        } else {
                            s.pop();
                        }
                    }
                }
            }
        }
        bw.write(ans.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}