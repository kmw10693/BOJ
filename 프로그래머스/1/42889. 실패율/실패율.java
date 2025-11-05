import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        int[] userFail = new int[N+2];
        int[] userTotal = new int[N+1];
        
        for(int stage : stages) {
            userFail[stage]++;
        }
        userTotal[N] = userFail[N] + userFail[N+1];
        for(int i=N-1; i>=1; i--) {
            userTotal[i] = userFail[i] + userTotal[i+1];
        }
        
        for(int i=1; i<userTotal.length; i++) {
            if(userFail[i] == 0 || userTotal[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double)userFail[i]/userTotal[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}