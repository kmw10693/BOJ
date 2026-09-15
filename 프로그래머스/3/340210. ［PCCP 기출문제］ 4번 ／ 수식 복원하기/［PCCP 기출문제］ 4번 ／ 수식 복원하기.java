import java.util.*;

class Solution {
    
    private int toDecimal(String number, int base) {
        int result = 0;
        
        for(char c : number.toCharArray()) {
            int digit = c - '0';
            result = result * base + digit;
        }
        return result;
    }
    
    private String fromDecimal(int number, int base) {
        if(number == 0) return "0";
        
        StringBuilder sb = new StringBuilder();

        while(number > 0) {
            int digit = number % base;
            sb.append(digit);
            number /= base;
        }
        return sb.reverse().toString();
    }
    
    private boolean valid(String number, int base) {
        for(char c : number.toCharArray()) {
            
            int digit = c - '0';
            
            if(digit >= base) return false;
        }
        return true;
    }
    
    public String[] solution(String[] expressions) {
        List<Integer> bases = new ArrayList<>();
        
        for(int base = 2; base <= 9; base++) {
            
            boolean possible = true;
            
            for(String expression : expressions) {
                String[] split = expression.split(" ");
                String A = split[0];
                String op = split[1];
                String B = split[2];
                String C = split[4];
                
                if(!valid(A, base) || !valid(B, base)) {
                    possible = false;
                    break;
                }
                
                if(!C.equals("X")) {
                    if(!valid(C, base)) {
                        possible = false;
                        break;
                    }
                    
                    int a = toDecimal(A, base);
                    int b = toDecimal(B, base);
                    int c = toDecimal(C, base);
                    
                    int result;
                    
                    if(op.equals("+")) {
                        result = a + b;
                    } else {
                        result = a - b;
                    }
                    
                    if(result != c) {
                        possible = false;
                        break;
                    }
                }
            }
            
            if(possible) {
                bases.add(base);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for(String expression : expressions) {
            String[] split = expression.split(" ");
            
            String A = split[0];
            String op = split[1];
            String B = split[2];
            String C = split[4];
            
            if(!C.equals("X")) continue;
            
            String result = null;
            boolean same = true;
            
            for(int base : bases) {
                int a = toDecimal(A, base);
                int b = toDecimal(B, base);
                
                int value;
                
                if(op.equals("+")) {
                    value = a + b;
                } else {
                    value = a - b;
                }
                
                String current = fromDecimal(value, base);
                
                if(result == null) {
                    result = current;
                }
                else if(!result.equals(current)) {
                    same = false;
                    break;
                }
            }
            if(!same) {
                result = "?";
            }
            answer.add(A + " " + op + " " + B + " = " + result);
        }
        return answer.toArray(new String[0]);
    }
}