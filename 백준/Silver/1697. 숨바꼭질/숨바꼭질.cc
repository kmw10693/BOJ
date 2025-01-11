#include <bits/stdc++.h>

using namespace std;

int board[100002];
int main() {
   ios::sync_with_stdio(0);
   cin.tie(0);
   
   queue <int> q;
   
   fill(board, board+100002, -1);
   int n, k;
   cin >> n >> k;
   board[n] = 0;
   q.push(n);
   
   while(board[k] == -1)
   {
       auto cur = q.front(); q.pop();
       for(int nxt : {cur-1, cur+1, 2*cur})
       {
           if(nxt <0 || nxt > 100000)
            continue;
           if(board[nxt] >= 0)
            continue;
           board[nxt] = board[cur] + 1;
           q.push(nxt);
       }
   }
   cout << board[k];
   
}