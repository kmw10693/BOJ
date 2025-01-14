#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n;
    cin >> n;
    vector<int> v;
    
    for(int i=0; i<n; i++) {
        int t;
        cin >> t;
        v.push_back(t);
    }
    sort(v.begin(), v.end());
    
    for(int i=0; i<n; i++) {
        cout << v[i] << '\n';
    }
}