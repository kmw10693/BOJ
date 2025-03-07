#include <bits/stdc++.h>
using namespace std;

int n,m,st,en;
int d[1002];
const int INF = 0x3f3f3f3f;

vector<pair<int,int>> adj[1005];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    fill(d, d+n+1, INF);
    while(m--) {
        int u,v,w;
        cin >> u >> v >> w;
        adj[u].push_back({w,v});
    }
    cin >> st >> en;

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
            if(d[v] <= dw) continue;
            d[v] = dw;
            pq.push({dw, v});
        }
    }
    cout << d[en];
}