#include <bits/stdc++.h>

using namespace std;

int n,m;

vector<int> p(100005, -1);
vector<tuple<int,int,int>> e;

int ans;

int find(int x) {
    if(p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unionf(int x, int y) {
    x = find(x);
    y = find(y);
    
    p[y] = x;
}

void solve(int t) {
    int sum =0, cnt = 0;
    fill(p.begin(), p.end(), -1);
    for(auto [cost, u,v] : e){
        if(find(u) == find(v)) continue;
        cnt++;
        sum += cost;
        unionf(u,v);
        if(cnt == n) break;
    }
    if(t) ans += sum*sum;
    else ans -= sum*sum;
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    m++;
    while(m--) {
        int u,v; bool cost;
        cin >> u >> v >> cost;
        e.push_back({!cost, u, v});
    }
    sort(e.begin(), e.end());
    solve(0);
    
    sort(e.rbegin(), e.rend());
    solve(1);
    
    cout << ans;
}