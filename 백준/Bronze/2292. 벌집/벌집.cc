#include <bits/stdc++.h>
using namespace std;

long long n;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    
    // 1 -> 1, 2 ~ 7 -> 2, 8 ~ 19 -> 3, 20 ~ 37 -> 4, 
    vector<pair<long long, long long>> v;
    
    // 채워 넣기
    v.push_back({1, 1});
    long long t = 2;
    long long cnt = 6;
    while(t <= 1000000000){
        v.push_back({t, t+cnt-1});
        t += cnt;
        cnt += 6;
    }
    
    for(int i=0; i<v.size(); i++) {
        long long x = v[i].first;
        long long y = v[i].second;
        
        if(x <= n && n <= y) {
            cout << i+1; 
            return 0;
        }
    }
}