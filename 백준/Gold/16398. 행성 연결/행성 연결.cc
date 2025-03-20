#include <bits/stdc++.h>

using namespace std;

vector<int> p(10005, -1);

int find(int x) {
    if(p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unionParent(int u, int v) {
    u = find(u), v = find(v);
    p[v] = u;
}

vector<tuple<int,int,int>> e;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n; cin >> n;
    
    int c;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> c;
            if(i == j) continue;
            e.push_back({c, i, j});
        }
    }
    sort(e.begin(), e.end());
    
    int u,v;
    int cnt = 0;
    long long ans = 0;
    for(auto edge: e) {
        tie(c,u,v) = edge;
        if(find(u) == find(v)) continue;
        unionParent(u, v);
        ans += c;
        cnt++;
        if(cnt == n-1) break;
    }
    cout << ans;
}