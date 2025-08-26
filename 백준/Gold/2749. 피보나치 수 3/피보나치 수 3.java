import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // (x*15)/10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        int fibo = (1000000*15)/10;

        long []fiboarr = new long[fibo+1];

        fiboarr[0] = 0;
        fiboarr[1] = 1;

        for(int i=2; i<fibo; i++) {
            fiboarr[i] = (fiboarr[i-1] + fiboarr[i-2]) % 1000000;
        }

        int index = (int)(N % fibo);

        System.out.println(fiboarr[index] % 1000000);
    }
}