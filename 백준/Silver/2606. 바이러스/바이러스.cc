#include <bits/stdc++.h>

using namespace std;

vector<int> adj[105];
bool vis[105];

int n, m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    
    while(m--){
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    queue<int> q;
    q.push(1);
    vis[1] = true;
    
    int ans = 0;
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        
        for(auto nxt: adj[cur]) {
            if(vis[nxt]) continue;
            ans++;
            vis[nxt] = true;
            q.push(nxt);
        }
    }
    cout << ans;
    
}