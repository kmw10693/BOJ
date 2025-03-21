#include <bits/stdc++.h>
using namespace std;

int n, m;
priority_queue<tuple<int,int,int>, vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> pq;

vector<pair<int,int>> adj[100002];
bool vis[100002];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    
    int a,b,c;
    while(m--) {
        cin >> a >> b >> c;
        adj[a].push_back({c,b});
        adj[b].push_back({c,a});
    }
    
    vis[1] = 1;
    for(auto nxt : adj[1])
        pq.push({nxt.first, 1, nxt.second});
        
    int cnt =0, ans=0, mc=0;
    while(cnt < n-1) {
        tie(c,a,b) = pq.top(); pq.pop();
        if(vis[b]) continue;
        
        vis[b] = 1;
        ans += c;
        mc = max(mc, c);
        cnt++;
        
        for(auto nxt : adj[b])
            if(!vis[nxt.second])
                pq.push({nxt.first, b, nxt.second});
    }
    cout << ans - mc;
}