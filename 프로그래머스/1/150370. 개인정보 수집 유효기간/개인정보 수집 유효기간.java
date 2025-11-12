import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int checkDate = getDate(today);
        
        for(String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            
            if(getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= checkDate) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
 
    }
    
    public static int getDate(String date) {
        String[] arr = date.split("\\.");
        
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return (year * 12 * 28) + month*28 + day;
    }
}