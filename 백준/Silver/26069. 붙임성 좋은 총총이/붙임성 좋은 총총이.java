import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs=new HashSet<>();
        hs.add("ChongChong");
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String me=st.nextToken();
            String met=st.nextToken();
            if(hs.contains(me)||hs.contains(met)){hs.add(met); hs.add(me);}
        }
        System.out.println(hs.size());
    }
}