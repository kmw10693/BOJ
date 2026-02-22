import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> main = new ArrayDeque<>();
        Stack<Integer> sub = new Stack<>();

        for(int i=1; i<=order.length; i++) {
            main.add(i);
        }

        for(int o : order) {
            boolean qcheck = false;
            while(!main.isEmpty()) {
                int top = main.peek();
                if(top < o) {
                    main.poll();
                    sub.push(top);
                }
                else if(top == o) {
                    main.poll();
                    answer++;
                    qcheck = true;
                    break;
                }
                else break;
            }

            if(qcheck) continue;

            boolean scheck = false;
            if(!sub.isEmpty()) {
                int top = sub.peek();
                if(top == o) {
                    answer++;
                    sub.pop();
                    scheck = true;
                }
            }

            if(!qcheck && !scheck) break;
        }
        return answer;
    }
}