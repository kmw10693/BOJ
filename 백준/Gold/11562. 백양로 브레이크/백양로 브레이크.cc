#include <bits/stdc++.h>
using namespace std;

const int INF = 0x3f3f3f3f;

int n,m;
int d[255][255];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    for(int i=1; i<=n; i++) {
        fill(d[i], d[i]+n+1, INF);
        d[i][i] = 0;
    }
    
    
    while(m--) {
        int u,v,b;
        cin >> u >> v >> b;
        
        d[u][v] = 0;
        d[v][u] = !b;
    }
    
    for(int k=1; k<=n; k++)
        for(int i=1; i<=n; i++) 
            for(int j=1; j<=n; j++)
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
    
    int p;
    cin >> p;
    while(p--) {
        int s, e;
        cin >> s >> e;
        cout << d[s][e] << '\n';
    }
}