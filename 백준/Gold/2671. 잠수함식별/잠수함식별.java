import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        Pattern c = Pattern.compile("(100+1+|01)+");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(c.matcher(br.readLine()).matches()) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }
}