class Solution {
    public int solution(int a, int b) {
        String stra = Integer.toString(a);
        String strb = Integer.toString(b);
        
        int appendnum = Integer.parseInt(stra+strb);
        
        if(appendnum < 2*a*b) return 2*a*b;
        return appendnum;
    }
}