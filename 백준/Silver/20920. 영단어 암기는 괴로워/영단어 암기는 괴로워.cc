#include <bits/stdc++.h>
using namespace std;

int n,m;
unordered_map<string, int> um;

bool compare(pair<string, int> p1, pair<string, int> p2) {
    if(p1.second == p2.second) {
        if(p1.first.length() == p2.first.length()) {
            return p1.first < p2.first;
        }
        return p1.first.length() > p2.first.length();
    }
    return p1.second > p2.second;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        string s; cin >> s;
        if(s.length() >= m) um[s]++;
    }
    
    vector<pair<string, int>> v(um.begin(), um.end());
    
    sort(v.begin(), v.end(), compare);
    
    for(int i=0; i<v.size(); i++) {
        cout << v[i].first << '\n';
    }
}