#include<vector>
#include<bits/stdc++.h>

using namespace std;

#define X first
#define Y second

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

queue<pair<int,int>> q;
int vis[105][105];

int solution(vector<vector<int>> maps)
{
    q.push({0,0});
    vis[0][0] = 1;
    
    int boardY = maps[0].size() - 1;
    
    while(!q.empty()) {
        auto t = q.front(); q.pop();
        int curX = t.X;
        int curY = t.Y;
        
        if(curX == maps.size()-1 && curY == boardY) {
            return vis[curX][curY];
        }
        
        for(int i=0; i<4; i++) {
            int nxtX = curX + dx[i];
            int nxtY = curY + dy[i];
            
            if(nxtX < 0 || nxtX >= maps.size() || nxtY < 0 || nxtY >= boardY+1) continue;
            if(vis[nxtX][nxtY] || !maps[nxtX][nxtY]) continue;
            
            q.push({nxtX,nxtY});
            vis[nxtX][nxtY] = vis[curX][curY] + 1;
        }
    }
    return -1;
}