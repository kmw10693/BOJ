#include <bits/stdc++.h>
using namespace std;

int M,N;
int board[1005][1005];
bool vis[1005][1005];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

#define X first
#define Y second

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> M >> N;
    
    queue <pair<int,int>> Q;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin >> board[i][j];
            if(board[i][j] == 1) {
                Q.push({i,j});
                vis[i][j] = 1;
            }
        }
    }
    
    while(!Q.empty()) {
        auto t = Q.front();
        Q.pop();
        
        for(int i=0; i<4; i++){
            int nx = t.X + dx[i];
            int ny = t.Y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(board[nx][ny] != 0 || vis[nx][ny]) continue;
            
            board[nx][ny] = board[t.X][t.Y] + 1;
            vis[nx][ny] = 1;
            Q.push({nx,ny});
        }
    }
    
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++){
            if(board[i][j] == 0) {
                cout << -1 << "\n";
                return 0;
            }
        }
    }
    
    int ans = 0;
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++){
            ans = max(ans, board[i][j]);
        }
    }
    
    if(ans == 1) {
        cout << 0 << '\n';
    }
    
    else cout << ans - 1 << '\n';
}