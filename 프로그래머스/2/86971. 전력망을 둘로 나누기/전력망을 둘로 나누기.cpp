#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> v[105];

int cnt;
int answer = 0x7fffffff;

void bfs(int x, int y) {
    bool vis[105];
    fill(vis, vis+105, false);
    
    queue<int> q;
    vis[x] = true;
    vis[y] = true;
    
    q.push(x);
    
    while(!q.empty()) {
        auto t = q.front(); q.pop();
        for(auto V : v[t]) {
            if(vis[V]) continue;
            q.push(V);
            vis[V] = true;
            cnt++;
        }
    }
    
}

int solution(int n, vector<vector<int>> wires) {
    for(auto w : wires) {
        v[w[0]].push_back(w[1]);
        v[w[1]].push_back(w[0]);
    }
    
    for(auto w : wires) {
        cnt = 1;
        bfs(w[0], w[1]);
        answer = min(answer, abs(2*cnt - n));
    }
    return answer;
    
}