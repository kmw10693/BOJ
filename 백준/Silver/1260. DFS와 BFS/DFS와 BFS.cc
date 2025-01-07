#include <bits/stdc++.h>
using namespace std;

int m,n,st;
vector<int> adj[1009];
bool vis[1009];


void dfs(int cur) {
    vis[cur] = true;
    cout << cur << ' ';
    for(auto nxt : adj[cur]){
        if(vis[nxt]) continue;
        dfs(nxt);
    }
}

void bfs(){
    queue<int> q;
    q.push(st);
    vis[st] = true;
    while(!q.empty()){
        int cur = q.front();
        cout << cur << ' ';
        q.pop();
        for(auto nxt : adj[cur]) {
            if(vis[nxt]) continue;
            q.push(nxt);
            vis[nxt] = true;
        }
    }
    
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m >> st;
    while(m--){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    for(int i=1; i<=n; i++){
        sort(adj[i].begin(), adj[i].end());
    }
    

    dfs(st);
    cout << '\n';
    fill(vis+1, vis+n+1, false);
    bfs();
}