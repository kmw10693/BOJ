#include <bits/stdc++.h>
using namespace std;

int n,m;

vector<int> adj[505];
bool vis[505];

#define X first
#define Y second

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    while(m--) {
        int a,b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    int ans = 0;
    queue<pair<int,int>> q;
    q.push({1,0});
    vis[1] = true;
    while(!q.empty()) {
        auto t = q.front();
        q.pop();
        
        int cur = t.X;
        int count = t.Y;
        
        for(int nxt : adj[cur]) {
            if(vis[nxt] || count > 1) continue;
            vis[nxt] = true;
            ans++;
            q.push({nxt, count+1});
        }
    }
    cout << ans;
}