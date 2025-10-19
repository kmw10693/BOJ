import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        double[] arr = new double[N];

        for(int i=0; i<N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> st = new Stack<>();

        double ans = 0;

        for(int i=0; i<s.length(); i++) {
            // 피연산자인 경우, 스택에 넣음
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                st.push(arr[s.charAt(i)-'A']);
            }
            else {
                double s1 = st.pop();
                double s2 = st.pop();
                double s3 = 0.0;
                switch (s.charAt(i)) {
                    case '+':
                        s3 = s1 + s2;
                        break;
                    case '-':
                        s3 = s2 - s1;
                        break;
                    case '/':
                        s3 = s2 / s1;
                        break;
                    case '*':
                        s3 = s2 * s1;
                        break;
                }
                st.push(s3);
            }
        }
        System.out.printf("%.2f", st.pop());
    }
}