class Solution {
    public int solution(String s) {
        int result = 0;
        char first = s.charAt(0);
        int o = 1;
        int x = 0;
        for(int i=1; i<s.length()-1; i++) {
            if(s.charAt(i) != first) {
                x++;
            } 
            else if(s.charAt(i) == first) {
                o++;
            }
            if(o == x) {
                result++;
                x=0;
                o=0;
                first = s.charAt(i+1); 
            } 
        }
        if(s.charAt(s.length()-1) != first) {
            x++;
        } 
        else if(s.charAt(s.length()-1) == first) {
            o++;
        } 
        if(o == x) result++;
        else if(o == 1) result++;
        return result;
    }
}