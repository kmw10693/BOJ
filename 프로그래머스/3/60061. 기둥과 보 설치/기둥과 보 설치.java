import java.util.*;

class Solution {
    boolean[][] pillar;
    boolean[][] beam;
    int n;
    
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        pillar = new boolean[n+2][n+2];
        beam = new boolean[n+2][n+2];
        
        for(int[] cmd : build_frame) {
            int x = cmd[0];
            int y = cmd[1];
            int type = cmd[2];
            int action = cmd[3];
            
            if(action == 1) {
                if(type == 0) {
                    pillar[x][y] = true;
                }
                else {
                    beam[x][y] = true;
                }
                
                if(!isValid()) {
                    if(type == 0) {
                        pillar[x][y] = false;
                    } else {
                        beam[x][y] = false;
                    }
                }
            }
            
            else {
                if(type == 0) {
                    pillar[x][y] = false;
                } else {
                    beam[x][y] = false;
                }
                
                if(!isValid()) {
                    if(type == 0) {
                        pillar[x][y] = true;
                    }
                    else {
                        beam[x][y] = true;
                    }
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        
        for(int x=0; x<=n; x++) {
            for(int y=0; y<=n; y++) {
                if(pillar[x][y]) {
                    result.add(new int[]{x,y,0});
                }
                if(beam[x][y]) {
                    result.add(new int[]{x,y,1});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    
    boolean canPillar(int x, int y) {
        if(y == 0) return true;
        
        if(pillar[x][y-1]) return true;
        
        if(beam[x][y]) return true;
        
        if(x >0 && beam[x-1][y]) return true;
        
        return false;
    }
    
    boolean canBeam(int x, int y) {
        if(y >0 && pillar[x][y-1]) return true;
        
        if(y>0 && pillar[x+1][y-1]) return true;
        
        if(x>0 && beam[x-1][y] && beam[x+1][y]) return true;
        return false;
    }
    
    boolean isValid() {
        for(int x=0; x<=n; x++) {
            for(int y=0; y<=n; y++) {
                if(pillar[x][y] && !canPillar(x,y)) return false;
                
                if(beam[x][y] && !canBeam(x,y)) return false;
             }
        }
        return true;
    }
}