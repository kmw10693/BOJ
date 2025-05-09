#include <bits/stdc++.h>
using namespace std;

long long cost[100005];
long long d[100005];
int n;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n-1; i++) {
        long long d_tmp;
        cin >> d_tmp;
        d[i] = d_tmp;
    }
    
    for(int i=0; i<n; i++) {
        long long cost_tmp;
        cin >> cost_tmp;
        cost[i] = cost_tmp;
    }
    
    long long min = 1000000009;
    long long ans = 0;
    
    for(int i=0; i<n; i++) {
        if(cost[i] < min) {
            min = cost[i];
        }
        ans += (min*d[i]);
    }
    cout << ans;
}