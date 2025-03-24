#include <bits/stdc++.h>

using namespace std;

int k, v, e;

vector<int> adj[20005];
int gr[20005];

bool bipt() {
    fill(gr+1, gr+v+1, -1);
    
    for(int i=1; i<=v; i++) {
        if(gr[i] != -1) continue;
        
        queue<int> q;
        q.push(i);
        gr[i] = 0;
        
        while(!q.empty()) {
            int cur = q.front();
            q.pop();
            
            for(auto nxt: adj[cur]) {
                if(gr[nxt] != -1) {
                    if(gr[cur] == gr[nxt]) return false;
                    else continue;
                }
                gr[nxt] = (gr[cur] + 1) % 2;
                q.push(nxt);
            }
        }
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> k;
    while(k--) {
        cin >> v >> e;
        for(int i=1; i<=v; i++) 
            adj[i].clear();
        while(e--) {
            int a, b;
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        if(bipt() == true) cout << "YES\n";
        else cout << "NO\n";
    }
}