class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long r1 = x;
        long r2 = x;
        long c1 = y;
        long c2 = y;
        
        for(int i=queries.length-1; i>=0; i--) {
            int command = queries[i][0];
            long dx = queries[i][1];
            
            if(command == 0) {
                if(c1 != 0) {
                    c1 += dx;
                }
                c2 = Math.min(m-1L, c2 + dx);
            }
            else if(command == 1) {
                c1 = Math.max(0L, c1 - dx);
                
                if(c2 != m-1) {
                    c2 -= dx;
                }
            }
            else if(command == 2) {
                if(r1 != 0) {
                    r1 += dx;
                }
                r2 = Math.min(n-1L, r2 +dx);
            }
            else {
                r1 = Math.max(0L, r1-dx);
                if(r2 != n-1) {
                    r2 -= dx;
                }
            }
            if(r1 >r2 || c1 > c2) return 0;
        }
        return (r2-r1 +1) * (c2-c1 +1);
    }
}