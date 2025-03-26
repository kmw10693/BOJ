#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int a; cin >> a;
            pq.push(a);
            if(n < (int)pq.size()) pq.pop();
        }
    }
    cout << pq.top();
    
}