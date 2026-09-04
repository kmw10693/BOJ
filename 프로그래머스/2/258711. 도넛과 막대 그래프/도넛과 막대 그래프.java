import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] in = new int[1000005];
        int[] out = new int[1000005];
        
        int maxnode = -1;
        int graph = 0;
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            out[a]++;
            in[b]++;
            maxnode = Math.max(maxnode, Math.max(a,b));
        }
        
        int rootnode = -1;
        for(int i=1; i<=maxnode; i++) {
            if(in[i] == 0 && out[i] >= 2) {
                rootnode = i;
                graph = out[i];
                break;
            }
        }
        
        int stick = 0;
        int eight = 0;
        for(int i=1; i<=maxnode; i++) {
            if(i == rootnode) continue;
            if(out[i] == 0 && in[i] >= 1) stick++;
            else if(in[i] >= 2 && out[i] == 2) eight++;
        }
        return new int[]{rootnode, graph-stick-eight, stick, eight};
    }
}