#include <bits/stdc++.h>
using namespace std;

int n,m;
int board[10][10];
int dx[3] = {-1, 0, 1};

int recur(int x, int y, int dir) {
    if(x == n) return 0;
    
    int ans = 1000000000;
    for(int i=0; i<3; i++) {
        if(y+dx[i] >= 0 && y+dx[i] < m && dir != dx[i]) {
            ans = min(ans, recur(x+1, y+dx[i], dx[i]) + board[x][y]);
        }
    }
    return ans;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            int v; cin >> v;
            board[i][j] = v;
        }
    }   
    int real = 1000000000;
    for(int i=0; i<m; i++) {
        real = min(real, recur(0, i, 2));
    }
    cout << real;
}