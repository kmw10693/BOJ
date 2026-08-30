import java.util.*;
import java.io.*;

class Solution {
    int tempjoin = Integer.MIN_VALUE;
    int temptotal = Integer.MIN_VALUE;
    
    class Node {
        int join;
        int amount;
        
        Node(int join, int amount) {
            this.join = join;
            this.amount = amount;
        }
    }
 
    
    List<Node> anslist = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
       dfs(users, emoticons, new boolean[emoticons.length], new ArrayList<>());
        
       return new int[]{tempjoin, temptotal};       
    }
    
    public void dfs(int[][] users, int[] emoticons, boolean[] isuse, List<Integer> emojis) {
        
        
        if(emojis.size() == emoticons.length) {
            int totaljoin = 0;
            int totalamount = 0;
            
            for(int[] user : users) {
                
                double eachtotal = 0;
                for(int i=0; i<emojis.size(); i++) {
                    if(emojis.get(i) >= user[0]) {
                        eachtotal += (double)emoticons[i] * (1-((double)emojis.get(i)/100));
                    }
                }
                
                if(eachtotal >= user[1]) {
                    totaljoin++;
                } else {
                    totalamount += eachtotal;
                }
            }
            if(tempjoin < totaljoin) {
                tempjoin = totaljoin;
                temptotal = totalamount;
            }
            else if(tempjoin == totaljoin && temptotal < totalamount) {
                temptotal = totalamount;
            }
            return;
        }
                
      
        for(int j=1; j<=4; j++) {
            emojis.add(j*10);
            dfs(users, emoticons, isuse, emojis);
            emojis.removeLast();
        }
    }
}