#include <bits/stdc++.h>

using namespace std;

int dp[10005];

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n,k;
    cin >> n >> k;
    vector<int> v;
    dp[0] = 1;
    for(int i=0; i<n; i++){
        int t;
        cin >> t;
        v.push_back(t);
    }
    
    for(int i=0; i<n; i++) {
        for(int j=v[i]; j<=k; j++){
            dp[j] = dp[j] + dp[j-v[i]];  
        }
    }
    cout << dp[k];

}