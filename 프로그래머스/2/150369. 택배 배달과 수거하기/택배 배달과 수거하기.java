import java.util.*;
import java.io.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int have = 0;
        int curpos = -1;
        
        // 추가
        int deliveryIdx = n - 1;
        int pickupIdx = n - 1;
        
        while(true) {
            
             // 이미 끝난 위치 앞으로 이동
            while (deliveryIdx >= 0 && deliveries[deliveryIdx] == 0) {
                deliveryIdx--;
            }

            while (pickupIdx >= 0 && pickups[pickupIdx] == 0) {
                pickupIdx--;
            }
            
            if (deliveryIdx < 0 && pickupIdx < 0) {
                break;
            }
            
            
            for(int i=deliveryIdx; i>=0; i--) {
                while(have < cap && deliveries[i] > 0) {
                    if(curpos < i) {
                        answer += (i - curpos)*2;
                        curpos = i;
                    }
                    deliveries[i]--;
                    have++;
                }
                if (have == cap) break;
            }
            have = 0;
            
            for(int i=pickupIdx; i>=0; i--) {
                while(have < cap && pickups[i] > 0) {
                    if(curpos < i) {
                        answer += (i - curpos)*2;
                        curpos = i;
                    }
                    pickups[i]--;
                    have++;
                }
                if (have == cap) break;

            }
            have = 0;
            curpos = -1; 
        }
        
        return answer;
    }
}