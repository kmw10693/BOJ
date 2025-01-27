#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int board[505][505];
int vis[505][505];

#define X first
#define Y second

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

void init(vector<vector<int>> rectangle) {
    for(int i=0; i<rectangle.size(); i++) {
        for(int j=0; j<4; j++) {
            rectangle[i][j] *= 2;
        }
        
        int x1 = rectangle[i][0];
        int y1 = rectangle[i][1];
        
        int x2 = rectangle[i][2];
        int y2 = rectangle[i][3];
        
        for(int i=x1; i<=x2; i++) {
            board[y1][i] = 1;
            board[y2][i] = 1;
        }
        
        for(int i=y1; i<=y2; i++) {
            board[i][x1] = 1;
            board[i][x2] = 1;
        }
        
    }
    
    for(int i=0; i<rectangle.size(); i++){
        int x1 = rectangle[i][0];
        int y1 = rectangle[i][1];
        
        int x2 = rectangle[i][2];
        int y2 = rectangle[i][3]; 
        
        for(int j=x1+1; j<x2; j++) {
            for(int k=y1+1; k<y2; k++) {
                board[k][j] = 0;
            }
        }
    }
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    init(rectangle);
    
    vis[characterY*2][characterX*2] = 1;
    queue<pair<int,int>> q;
    q.push({characterX*2, characterY*2});
    
    while(!q.empty()) {
        auto t = q.front(); q.pop();
        int curX = t.X;
        int curY = t.Y;
        
        if(curX == itemX*2 && curY == itemY*2) {
            return board[curY][curX] / 2;
        }
        for(int i=0; i<4; i++) {
            int nxtX = curX + dx[i];
            int nxtY = curY + dy[i];
            if(nxtX < 0 || nxtX >= 500 || nxtY < 0 || nxtY >= 500) continue;
            if(vis[nxtY][nxtX] || !board[nxtY][nxtX]) continue;
            vis[nxtY][nxtX] = 1;
            board[nxtY][nxtX] = board[curY][curX] + 1;
            q.push({nxtX, nxtY});
        }
    }
    
}