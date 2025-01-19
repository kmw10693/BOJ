#include <bits/stdc++.h>

using namespace std;

int n,m;
int ans = 0;

int board[105][105];

#define X first
#define Y second

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

int vis[105][105];

void init() {
    for(int i=0; i<105; i++) {
        for(int j=0; j<105; j++) vis[i][j] = 0;
    }
}

void air() {
    
    init();
    
    queue<pair<int,int>> q;
    q.push({0,0});
    vis[0][0] = 1;
    board[0][0] = 2;
    
    while(!q.empty()) {
        auto t = q.front(); q.pop();
        int curX = t.X;
        int curY = t.Y;
        
        for(int i=0; i<4; i++){
            int nxtX = curX + dx[i];
            int nxtY = curY + dy[i];
            
            if(nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m) continue;
            if(vis[nxtX][nxtY] || board[nxtX][nxtY] == 1) continue;
            
            board[nxtX][nxtY] = 2;
            vis[nxtX][nxtY] = 1;
            q.push({nxtX, nxtY});
        }
    }
}

bool check(int x, int y) {
    int check = 0;
    for(int i=0; i<4; i++) {
        int nxtX = x + dx[i];
        int nxtY = y + dy[i];
        
        if(board[nxtX][nxtY] == 2) check++;
    }
    
    if(check >= 2) return true;
    else return false;
}

void printarr() {
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++){
            cout << board[i][j] << " ";
        }
        cout << '\n';
    }
}
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++){
            cin >> board[i][j];
        }
    }
    

    air();


    while(true) {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) {
                        if(check(i,j)) board[i][j] = 0;
                    }
            }
        }
        ans++;
        air();
        
        bool check = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) check = true; 
            }
        }
        
        if(!check) break;
    }
    cout << ans;
}
    
