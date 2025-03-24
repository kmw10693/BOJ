#include <bits/stdc++.h>
using namespace std;

vector<int> adj[105];
vector<int> candi;

bool vis[105];

int n;

int bfs(int cnt) {
    queue<int> q;
    
    int dist[105];
    fill(dist+1, dist+n+1, -1);
    
    dist[cnt] = 0;
    q.push(cnt);
    
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        
        for(auto nxt: adj[cur]) {
            if(dist[nxt] != -1) continue;
            dist[nxt] = dist[cur] + 1;
            q.push(nxt);
        }
    }
    int maxCnt = *max_element(dist+1, dist+n+1);
    if(maxCnt == -1) return 100;
    return maxCnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    
    while(1) {
        int a, b;
        cin >> a >> b;
        if(a == -1 || b == -1) break;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    int minV = 0x3f3f3f3f;
    for(int i=1; i<=n; i++) {
        minV = min(minV, bfs(i));
    }
    
    for(int i=1; i<=n; i++){
        if(bfs(i) == minV) candi.push_back(i);
    }
    
    cout << minV << ' ' << candi.size() << '\n';
    
    sort(candi.begin(), candi.end());
    
    for(auto t : candi) {
        cout << t << ' ';
    }
    
    
    
}