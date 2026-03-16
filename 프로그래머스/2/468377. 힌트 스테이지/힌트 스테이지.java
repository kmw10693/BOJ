class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int hintlength = n-1;
                
        int ans = Integer.MAX_VALUE;
                 
        for(int i=0; i < (1 << hintlength); i++) {
            
            int eachsum = 0;
            int[] hintcount = new int[n+1];
            for(int j=0; j<hintlength; j++) {
                
                if((i & (1 << j)) != 0) {
                    eachsum += hint[j][0];
                    for(int k=1; k<hint[j].length; k++) {
                        hintcount[hint[j][k]]++;
                    }
                }
            }
            
            for(int j=0; j<n; j++) {
                if(hintcount[j+1] > n-1) hintcount[j+1] = n-1;
                eachsum += cost[j][hintcount[j+1]];
            }
            ans = Math.min(ans, eachsum);
        }
        return ans;
    }
}