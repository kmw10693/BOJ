import java.util.*;

class Solution {
    // 할인율
    int[] discountRate = {10, 20, 30, 40};
    int[] discounts;
        
    // 정답
    int join = 0;
    int sum = 0;
    
    // 할인율
    public int[] solution(int[][] users, int[] emoticons) {
        discounts = new int[emoticons.length];
        for(int i=0; i<discounts.length; i++) {
            discounts[i] = -1;
        }
        recur(users, 0, emoticons);
        return new int[]{join, sum};
    }
    // 완전 탐색
    public void recur(int[][] users, int cnt, int[] emoticons) {
        if(cnt >= emoticons.length) {
            sum(users, emoticons);
            return;
        }

        for(int i=0; i<4; i++) { 
            if(discounts[cnt] != -1) return;
            discounts[cnt] = i;
            recur(users, cnt+1, emoticons);
            discounts[cnt] = -1;
        }
    }
    
    public void sum(int[][] users, int[] emoticons) {
        int tmpjoin = 0;
        int tmptotal = 0;
        
        // 유저의 길이: 2
        for(int i=0; i<users.length; i++) {
            double tmpsum =0;
            // 할인 율: 
            for(int j=0; j<discounts.length; j++) {
                if(discountRate[discounts[j]] >= users[i][0]) {
                    tmpsum += (100-discountRate[discounts[j]])/100.0 * emoticons[j];
                }
            }
            if(tmpsum >= users[i][1]) tmpjoin++;
            else tmptotal += tmpsum;
             
        }
        if(tmpjoin > join) {
             join = tmpjoin;
             sum = tmptotal;
         }
         else if(tmpjoin == join && tmptotal > sum) {
             join = tmpjoin;
             sum = tmptotal;
         }
    }
}

