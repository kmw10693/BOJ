class Solution {
    public int solution(String s) {
        int result = 0;
        char first = s.charAt(0);
        int o = 1;
        int x = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != first) {
                x++;
            } 
            else if(s.charAt(i) == first) {
                o++;
            }
            
            if(o == x) {
                result++;
                if(i+1 < s.length()) {
                    first = s.charAt(i+1);
                    x = 0;
                    o = 1;
                    i++;
                } else {
                    return result;
                }
            } 
        }
        return result + 1;
    }
}