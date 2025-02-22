#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n,k;
    cin >> n >> k;
    vector<int> v;
    
    while(n--) {
        int t;
        cin >> t;
        v.push_back(t);
    }
    sort(v.begin(), v.end(), greater<int>());
    cout << v[k-1];
}