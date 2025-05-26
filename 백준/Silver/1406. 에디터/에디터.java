import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main  {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        String str = br.readLine();

        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> it = list.listIterator();

        while(it.hasNext()){
            it.next();
        }

        for(int i=0; i<M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if(c == 'L'){
                if(it.hasPrevious()){
                    it.previous();
                }
            }
            else if(c == 'D'){
                if(it.hasNext()) it.next();
            }
            else if(c == 'B'){
                if(it.hasPrevious()) {
                    it.previous();
                    it.remove();

                }
            }
            else if(c == 'P') {
                char t = command.charAt(2);
                it.add(t);
            }
        }
        for(char c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}