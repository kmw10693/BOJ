#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int dp[1000005];
int dp2[1000005];

int solution(vector<int> money) {
    dp[0] = money[0];
    dp[1] = dp[0];
    
    dp2[0] = 0;
    dp2[1] = money[1];
    
    for(int i=2; i<money.size(); i++) {
        if(i == money.size() - 1) {
            dp[i] = dp[i-1];
            break;
        }
        
        dp[i] = max(dp[i-2] + money[i], dp[i-1]);
    }
    
    for(int i=2; i<money.size(); i++) {
        dp2[i] = max(dp2[i-2] + money[i] , dp2[i-1]);
    }
    return max(dp[money.size()-1], dp2[money.size()-1]);
}