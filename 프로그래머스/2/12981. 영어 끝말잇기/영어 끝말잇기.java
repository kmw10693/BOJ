import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 1;
        int num = 1;
        Set<String> wordlists = new HashSet<>();
        
        String prev = "";
        for(String word : words) {
            if(num > n) {
                num = 1;
                cnt++;
            }
            if(prev.isEmpty() || (prev.charAt(prev.length()-1) == word.charAt(0) && word.length() > 1))  {
                if(wordlists.contains(word)) {
                    answer = new int[]{num, cnt};
                    return answer;
                }
                wordlists.add(word);
                prev = word;
            }
            else {
                answer = new int[]{num, cnt};
                return answer;
            }
            num++;
        }
        return new int[]{0,0};
    }
}