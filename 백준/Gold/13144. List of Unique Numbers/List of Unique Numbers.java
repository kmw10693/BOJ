import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[N];

        boolean[] checker = new boolean[N+1];
        for(int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = 0;

        while(end < N) {
            if(checker[numArr[end]]) { // 존재한다.
                while (end > start) {
                    sum += (end - start);
                    checker[numArr[start]] = false;
                    if(numArr[end] == numArr[start]) {
                        start++;
                        break;
                    }
                    start++;
                }
            } else {
                checker[numArr[end++]] = true;
            }
        }
        for(int i=1; i<=(end-start); i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}