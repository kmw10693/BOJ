import java.util.*;
import java.io.*;

class Solution {
    List<Node> pos = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        int cnt = 0;
        pos.add(new Node(0,k));
        
        while(k > 1) {
            cnt++;
            if(k % 2 == 0) k /= 2;
            else k = k*3 + 1;
            pos.add(new Node(cnt, k));
        }
        
        List<Double> anslist = new ArrayList<>(); 
        for(int[] range : ranges) {
            int a = range[0];
            int b = range[1];
            
            anslist.add(getArea(a,b,cnt));
        }
        
        double[] ans = new double[anslist.size()];
        
        for(int i=0; i<ans.length; i++) {
            ans[i] = anslist.get(i);
        }
        
        return ans;
    }
    
    public double getArea(int a, int b, int cnt) {
        b += cnt;
        if(a > b) return -1.0;
        
        double area = 0.0;
        
        for(int i=a; i<b; i++) {
            Node cur = pos.get(i);
            Node next = pos.get(i+1);
            
            area += (cur.y + next.y) / 2.0;
        }
        return area;
    }
    
    class Node {
        int x, y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}