class Solution {
    
    int ans = Integer.MAX_VALUE;
  
    public int solution(String begin, String target, String[] words) {
        for(int i=0; i<words.length; i++) {

            int diff = 0;
            for(int j=0; j<words[i].length(); j++) {
                if(words[i].charAt(j) != begin.charAt(j)) {
                    diff++;
                }
            }
            
            if(diff == 1) {
                boolean[] visited = new boolean[words.length];
                visited[i] = true;
                dfs(words[i], visited, 1, words, target);
             }
        }
        if(ans == Integer.MAX_VALUE) return 0;
        else return ans;
    }
    
    public void dfs(String cur, boolean[] visited, int cnt, String[] words, String target) {
        if(cur.equals(target)) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;

            int diff = 0;
            for(int j=0; j<words[i].length(); j++) {
                if(words[i].charAt(j) != cur.charAt(j)) {
                    diff++;
                }
            }
            
            if(diff == 1) {
                visited[i] = true;
                dfs(words[i], visited, cnt+1, words, target);
                visited[i] = false;
             }
        }
       
    }
    
}