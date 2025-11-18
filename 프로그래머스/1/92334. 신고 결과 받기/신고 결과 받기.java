import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 누적
        Map<String, Set<String>> reports = new HashMap<>();
        // 인덱스
        Map<String, Integer> index = new HashMap<>();
        // 각 신고당한 횟수
        Map<String, Integer> ban = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            index.put(id_list[i], i);
            ban.put(id_list[i], 0);
        }
        
        for(int j=0; j<report.length; j++) {
            String[] arr = report[j].split(" ");
            reports.putIfAbsent(arr[0], new HashSet<>());
            reports.get(arr[0]).add(arr[1]); 
        }
        
        int[] ans = new int[id_list.length];
        for(String key : reports.keySet()) {
            for(String keys : reports.get(key)) {
                ban.put(keys, ban.get(keys) + 1);
            }
        }
        
        for(String key : reports.keySet()) {
            for (String keys : reports.get(key)) {
                if(ban.get(keys) >= k) {
                    ans[index.get(key)]++;
                }
            }
        }
        return ans;
        
    }
}