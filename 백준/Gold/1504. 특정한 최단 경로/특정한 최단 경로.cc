#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int INF = 0x3f3f3f3f;
ll n,m,st,en;
ll d[805];

vector<pair<int,int>> adj[805];
ll solve(int st, int en) {
    fill(d, d+n+1, INF);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    d[st] = 0;
    pq.push({d[st], st});
    while(!pq.empty()) {
        int u,v,w,dw;
        tie(w, u) = pq.top(); pq.pop();
        if(d[u] != w) continue;
        for(auto nxt : adj[u]) {
            tie(dw, v) = nxt;
            dw += w;
            if(dw >= d[v]) continue;
            d[v] = dw;
            pq.push({d[v], v});
        }
    }
    return d[en];
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    int u,v,w;
    
    while(m--) {
        cin >> u >> v >> w;
        adj[u].push_back({w, v});
        adj[v].push_back({w, u});
    }
    cin >> st >> en;
    
    ll t1 = solve(1, st) + solve(st, en) + solve(en, n);
    ll t2 = solve(1, en) + solve(en, st) + solve(st, n);
    
    ll ans = min(t1, t2);
    if(ans >= INF) cout << -1;
    else cout << ans;
}