import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(new Node(br.readLine()));
        }

        for(int i=0; i<N; i++) {
            System.out.print(pq.poll().str.toString());
            System.out.println();
        }
    }
    static class Node implements Comparable<Node> {
        StringBuilder str = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();

        Node(String s) {
            StringBuilder tmp = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) {
                    tmp.append(s.charAt(i));
                    continue;
                } else if (tmp.length() > 0) {
                    arr.add(tmp.toString());
                    tmp = new StringBuilder();
                }
                arr.add(String.valueOf(s.charAt(i)));
            }

            if(tmp.length() > 0) {
                arr.add(tmp.toString());
            }
            for(int i=0; i<arr.size(); i++) {
                str.append(arr.get(i));
            }
        }

        @Override
        public int compareTo(Node o) {
            int curlen = arr.size();
            int strlen = o.arr.size();

            int minlen = Math.min(curlen, strlen);
            for(int i=0; i<minlen; i++) {
                // 첫번째 대상
                String curstr = arr.get(i);
                String sstr = o.arr.get(i);

                boolean curisDecimal = Character.isDigit(curstr.charAt(0));
                boolean sisDecimal = Character.isDigit(sstr.charAt(0));

                if(curisDecimal && sisDecimal) {
                    BigDecimal curd = new BigDecimal(curstr);
                    BigDecimal sstrd = new BigDecimal(sstr);
                    if(curd.equals(sstrd)) {
                        if(curstr.length() == sstr.length()) continue;
                        return curstr.length() - sstr.length();
                    }
                    return curd.compareTo(sstrd);
                }
                // 둘중 하나 숫자인 경우
                else if(curisDecimal || sisDecimal) {
                    return curisDecimal ? -1 : 1;
                }
                // 둘다 문자 인 경우
                else {
                    // 만약 대소문자 같을때
                    if(curstr.equals(sstr)) continue;
                    else if(curstr.equalsIgnoreCase(sstr)) {
                        if(curstr.toUpperCase().equals(curstr)) return -1;
                        return 1;
                    }
                    return curstr.compareToIgnoreCase(sstr);
                }
            }
            return curlen - strlen;
        }
    }
}