import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        while(L-- > 0) {
            String keystr = br.readLine();

            for(int i=0; i<keystr.length(); i++) {
                char key = keystr.charAt(i);
                if(key == '<') {
                    if(!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                } else if(key == '>') {
                    if(!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                } else if(key == '-') {
                    if(!left.isEmpty()) {
                        left.removeLast();
                    }
                } else {
                    left.addLast(key);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!left.isEmpty()) {
                sb.append(left.removeFirst());
            }

            while(!right.isEmpty()) {
                sb.append(right.removeFirst());
            }
            System.out.println(sb.toString());
            left.clear();
            right.clear();
        }
    }
}