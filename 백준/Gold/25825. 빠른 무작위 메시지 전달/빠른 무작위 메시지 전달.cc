#include <bits/stdc++.h>

using namespace std;

int board[13][13];
bool vis[13];

int ans = 0x7fffffff;
void backtrack(int t, int mint, int c) {
    
    if(c == 12) {
        ans = min(ans, mint);
        return;
    }
    
    for(int i=1; i<=12; i++) {
        if(!vis[i]) {
            mint += board[t][i];
            vis[i] = true;
            if(i % 2 == 0) {
                mint += board[i][i-1];
                vis[i-1] = true;
                backtrack(i-1, mint, c+2);
            }
            else {
                mint += board[i][i+1];
                vis[i+1] = true;
                backtrack(i+1, mint, c+2);
            }
            
            mint -= board[t][i];
            if(i % 2 == 0) {
                mint -= board[i][i-1];
                vis[i-1] = false;
            }
            else {
                mint -= board[i][i+1];
                vis[i+1] = false;
            }
        }
        
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    for(int i=1; i<=12; i++){
        for(int j=1; j<=12; j++){
            cin >> board[i][j];
        }
    }
    for(int i=1; i<=12; i++) {
        fill(vis, vis+13, false);
        if(i % 2 == 0){
            vis[i] = true;
            vis[i-1] = true;
            backtrack(i-1, board[i][i-1], 2);
        }
        else {
            vis[i] = true;
            vis[i+1] = true;
            backtrack(i+1, board[i][i+1],2);
        }
    }
    
    cout << ans;
    
}