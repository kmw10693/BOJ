class Solution {
    int ans = 0;
    boolean check = false;
    
    public void dfs(String s, String word) {
        if(check) return;
        if(s.length() > 0 && s.length() <= 5) {
            ans++;
            if(s.equals(word)) {
                check = true;
                return;
            }
        }
        if(s.length() == 5) return;
        
        dfs(s+"A", word);
        dfs(s+"E", word);
        dfs(s+"I", word);
        dfs(s+"O", word);
        dfs(s+"U", word);
    }
    
    public int solution(String word) {
        dfs("", word);
        return ans;
    }
}