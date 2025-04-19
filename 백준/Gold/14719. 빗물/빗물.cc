#include <bits/stdc++.h>
using namespace std;


// 구현
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int h,w;
    cin >> h >> w;
    // 빗물 저장
    vector<int> v;
    for(int i=0; i<w; i++) {
        int t; cin >> t;
        v.push_back(t);
    }
    
    // 양끝에는 빗물이 고일수 없음
    int ans = 0;
    for(int i=1; i<w-1; i++) {
        int leftMax = v[i], rightMax = v[i];
        for(int j=0; j<i; j++) {
            leftMax = max(leftMax, v[j]);
        }
        for(int j=i+1; j<w; j++) {
            rightMax = max(rightMax, v[j]);
        }
        ans += min(leftMax, rightMax) - v[i];
    }
    cout << ans;
}