#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

int N,K,L;
int board[105][105]; 
int second;

int nx[4] = {1,0,-1,0};
int ny[4] = {0,1,0,-1};

deque<pair<int,int>> snake;
deque<pair<int,char>> dir;

int main(){
    cin >> N >> K;
    while(K--) {
        int x,y;
        cin >> x >> y;
        board[x][y] = 2;
    }
    cin >> L;
    while(L--){
        int x;
        char d;
        cin >> x >> d;
        dir.push_back({x,d});
    }
    
    int d = 1;
    snake.push_front({1,1});
    while(1){
        auto t = snake.front();
        int x = t.X;
        int y = t.Y;
        board[x][y] = 1;
        second++;
        
        d %=4;
        
        int dx = x + nx[d];
        int dy = y + ny[d];
        
        if(dx < 1 || dx > N || dy < 1 || dy > N) break;
        if(board[dx][dy] == 1) break;
        
        if(board[dx][dy] != 2) {
            auto t = snake.back();
            board[t.X][t.Y] = 0;
            snake.pop_back();
        }
        
        if(!dir.empty() && second == dir.front().X) {
            if(dir.front().Y == 'D') {
                d+=3;
            }
            else {
                d+=1;
            }
            dir.pop_front();
        }
        snake.push_front({dx, dy});
    }
    cout << second;
}