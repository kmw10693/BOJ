#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    vector<int> v;
    for(int i=0; i<n; i++) {
        int t; cin >> t;
        v.push_back(t);
    }
    int s; cin >> s;
    int cnt = 0;
    for(int i=0; i<n; i++) {
        if(v[i] == s) cnt++;
    }
    cout << cnt;
}