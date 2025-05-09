#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    deque<int> dq;
    for(int i=1; i<=n; i++) {
        dq.push_back(i);
    }
    while(dq.size() > 1) {
        // 위에 원소 제거
        dq.pop_front();
        int t = dq.front();
        dq.pop_front();
        dq.push_back(t);
    }
    
    cout << dq.front();
}