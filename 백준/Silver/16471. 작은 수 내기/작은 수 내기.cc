#include <bits/stdc++.h>

using namespace std;

// 이분 탐색 문제

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    vector<int> v; // 주언
    vector<int> v2; // 사장
    
    for(int i=0; i<n; i++) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }
    
    for(int i=0; i<n; i++){
        int tmp;
        cin >> tmp;
        v2.push_back(tmp);
    }

    sort(v.begin(), v.end(), greater<>());
    sort(v2.begin(), v2.end(), greater<>());
    
    int ans = 0;
    for(int i=0; i<v2.size(); i++) {
        // 같은 경우
        int index = upper_bound(v.begin(), v.end(), v2[i], greater<>()) - v.begin();
        if(index >= v.size()) continue;
        v.erase(v.begin() + index);
        ans++;
    }
    if(ans >= (n+1)/2) cout << "YES";
    else cout << "NO";
    
}