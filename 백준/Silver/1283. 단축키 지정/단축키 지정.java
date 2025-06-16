import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            boolean isShortCut = false;
            String str = br.readLine();
            // 공백 기준으로 쪼개기
            String words[] = str.split(" ");

            // 각 단어의 길이 만큼
            for(int j=0; j<words.length; j++) {
                // 단어의 첫번째 검사
                String s = words[j].charAt(0) + "";
                int idx = 0;

                // 셋에 저장안된 경우
                if(!set.contains(s.toUpperCase()) && !set.contains(s.toLowerCase())) {
                    set.add(s.toUpperCase());
                    set.add(s.toLowerCase());
                    isShortCut = true;

                    for(int k =0; k<j; k++) {
                        idx += words[k].length();
                        if(idx !=0) idx+=1;
                    }
                    sb.append(str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx + 1) + "\n");
                    break;
                }
            }

            if(isShortCut) continue;

            for(int j=0; j<str.length(); j++) {
                String s = str.charAt(j) + "";

                if(!s.equals(" ") && !set.contains(s.toUpperCase()) && !set.contains(s.toLowerCase())) {
                    set.add(s.toUpperCase());
                    set.add(s.toLowerCase());
                    isShortCut = true;

                    sb.append(str.substring(0, j) + "[" + str.charAt(j) + "]" + str.substring(j + 1) + "\n");
                    break;
                }
            }

            if (isShortCut) continue;

            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}