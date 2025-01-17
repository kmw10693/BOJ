#include <bits/stdc++.h>

using namespace std;

int n,m;

bool vis[10];

void backtrack(int cnt, int prev) {
    if (cnt == m) {
        for(int i=1; i<=n; i++) {
            if(vis[i]) cout << i <<  ' ';
        }
        cout << '\n';
        return;
    }
    
    for(int i=1; i<=n; i++) {
        if(!vis[i] && prev < i) {
            vis[i] = true;
            backtrack(cnt+1, i);
            vis[i] = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    
    backtrack(0, 0);
}