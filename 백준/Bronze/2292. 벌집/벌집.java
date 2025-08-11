import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int add = 0;
        int start = 2;

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.print(1);
            return;
        }

        for(; start<=N;) {
            add++;
            start += (add * 6);
        }
        // 0 -> 7 -> 19 -> 37
        System.out.print(add+1);
    }
}