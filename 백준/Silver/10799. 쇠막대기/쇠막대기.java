
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sticks = br.readLine();
        Stack<Character> stack = new Stack<>();

        int ans = 0;
        for(int i=0; i<sticks.length(); i++) {
            if(sticks.charAt(i) == '(') {
                stack.add(sticks.charAt(i));
            } else if (sticks.charAt(i) == ')'){
                if(sticks.charAt(i-1) == '(') {
                    stack.pop();
                    ans += stack.size();
                } else if(sticks.charAt(i-1) == ')') {
                    ans += 1;
                    stack.pop();
                }
            }
        }

        System.out.print(ans);
    }
}