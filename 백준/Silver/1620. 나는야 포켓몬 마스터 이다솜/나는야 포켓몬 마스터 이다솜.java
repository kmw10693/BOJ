import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static Map<String, Integer> nameToInt = new HashMap<>();
    static Map<Integer, String> IntToName = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            nameToInt.put(s, i);
            IntToName.put(i, s);
        }

        for(int i=1; i<=M; i++) {
            String s = br.readLine();
            if(isNumeric(s)) {
                System.out.println(IntToName.get(Integer.parseInt(s)));
            }
            else System.out.println(nameToInt.get(s));
        }

    }
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}