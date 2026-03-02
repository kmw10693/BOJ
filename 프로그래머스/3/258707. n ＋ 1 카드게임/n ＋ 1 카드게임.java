import java.util.*;
import java.io.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int life = 0;
        int templife = 0;
        int n = cards.length;
        
        int[] curcards = new int[cards.length + 1];
        // n/3 카드 말고 기록
        int[] nxtcards = new int[cards.length + 1];
        
        for(int i=0; i<cards.length/3; i++) {
            int cardnum = cards[i];
            curcards[cardnum]++;
        }
        
        for(int i=1; i<=cards.length/2; i++) {
            if(curcards[i] > 0 && curcards[n+1-i] > 0) life++;
        }
        
        int result = 1;
        for(int i=cards.length/3; i<cards.length+1; i+=2) {
            if(i == cards.length) return result;
            
            int curcardnum = cards[i];
            if(curcards[n+1-curcardnum] > 0 && coin > 0) {
                life++;
                coin--;
            }
            int curcardnum2 = cards[i+1];
            if(curcards[n+1-curcardnum2] > 0 && coin > 0) {
                life++;
                coin--;
            }
            
            if(nxtcards[n+1-curcardnum] > 0) templife++;
            else nxtcards[curcardnum]++;
            
            if(nxtcards[n+1-curcardnum2] > 0) templife++;
            else nxtcards[curcardnum2]++;
            
            if(life <= 0 && templife > 0 && coin >= 2) {
                life++;
                coin -= 2;
                templife--;
            }
            if(life <= 0) return result;
            life--;
            result++;
        }
        return result;
    }
}