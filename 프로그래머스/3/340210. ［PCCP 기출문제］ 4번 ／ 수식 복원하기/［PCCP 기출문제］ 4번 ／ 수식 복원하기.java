import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] expressions) {
        int[] jinbups = {2,3,4,5,6,7,8,9};
        boolean[] correctjinbups = new boolean[8];
        
        for(int i=0; i<8; i++) {
            correctjinbups[i] = true;
        }
            
        List<Expression> xlist = new ArrayList();
        
        for(String expression : expressions) {
            String[] splitlist = expression.split(" ");
            String a = splitlist[0];
            int op = (splitlist[1].equals("+")) ? 1 : -1;
            String b = splitlist[2];
            
            String result = splitlist[4];
            
            // a, b, result 돌면서 이하인거 모두 false로 만들기
            for(int i=0; i<a.length(); i++) {
                int eachnumber = a.charAt(i) - '0';
                
                for(int j=eachnumber-2; j>=0; j--) {
                    correctjinbups[j] = false;
                }
            }
            
            for(int i=0; i<b.length(); i++) {
                int eachnumber = b.charAt(i) - '0';
                
                for(int j=eachnumber-2; j>=0; j--) {
                    correctjinbups[j] = false;
                }
            }
            
            if(!result.equals("X")) {
                for(int i=0; i<result.length(); i++) {
                    int eachnumber = result.charAt(i) - '0';

                    for(int j=eachnumber-2; j>=0; j--) {
                        correctjinbups[j] = false;
                    }
                }
            }
            
            // X가 아니면, 각 수식마다 진법 계산을 모두 적용해보고, 지우기
            if(!result.equals("X")) {
                for(int i=0; i<8; i++) {
                    if(!correctjinbups[i]) continue;
                    int converta = Integer.parseInt(splitlist[0], jinbups[i]);
                    int convertb = Integer.parseInt(splitlist[2], jinbups[i]);
                    
                    int convertresult = Integer.parseInt(splitlist[4], jinbups[i]);
                    
                    if(converta + op*convertb != convertresult) correctjinbups[i] = false;
                }
            } 
            // X이면 X 리스트에 저장 하기
            else {
                xlist.add(new Expression(a, b, op));
            }
        }
        
        List<String> tmpresult = new ArrayList();
        
        for(int i=0; i<xlist.size(); i++) {
            Expression eachexp = xlist.get(i);
            
            int lastresult = -1;
            boolean alreadyinput = false;
            for(int j=0; j<8; j++) {
                if(!correctjinbups[j]) continue;
                
                String strcurresult = Integer.toString(Integer.parseInt(eachexp.a, jinbups[j]) + eachexp.op * Integer.parseInt(eachexp.b, jinbups[j]), jinbups[j]);
                int curresult = Integer.parseInt(strcurresult);
                
                if(lastresult != -1) {
                    if(lastresult != curresult) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(eachexp.a);
                        sb.append(" ");
                        if(eachexp.op == -1) sb.append("-");
                        else sb.append("+");
                        sb.append(" ");
                        sb.append(eachexp.b);
                        sb.append(" = ");
                        sb.append("?");
                        tmpresult.add(sb.toString());
                        alreadyinput = true;
                        break;
                    }
                } 
                lastresult = curresult;
            }
            
            if(alreadyinput) continue;
            
            if(lastresult != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(eachexp.a);
                sb.append(" ");
                if(eachexp.op == -1) sb.append("-");
                else sb.append("+");
                sb.append(" ");
                sb.append(eachexp.b);
                sb.append(" = ");
                sb.append(lastresult);
                tmpresult.add(sb.toString());
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(eachexp.a);
                sb.append(" ");
                if(eachexp.op == -1) sb.append("-");
                else sb.append("+");
                sb.append(" ");
                sb.append(eachexp.b);
                sb.append(" = ");
                sb.append("?");
                tmpresult.add(sb.toString());
            }
        }
        
        String[] result = new String[tmpresult.size()];
        for(int i=0; i<tmpresult.size(); i++) {
            result[i] = tmpresult.get(i);
        }
        return result;
    }
    
    public class Expression {
        String a, b;
        int op;
        
        Expression(String a, String b, int op) {
            this.a = a;
            this.b = b;
            this.op = op;
        }
    }
}