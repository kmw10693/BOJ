#include <bits/stdc++.h>

using namespace std;

int board[105];

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n;
    cin >> n;
    
    for(int i=1; i<=n; i++){
        int t;
        cin >> t;
        board[i] = t;
    }
    
    int c;
    cin >> c;
    for(int i=0; i<c; i++){
        int a,b;
        cin >> a >> b;
        
        if(a == 1) {
            int t = b;
            while(true) {
                if(t > n) break;
                board[t] = (board[t] == 1) ? 0 : 1;
                t += b;
            }
            
        }
        
        else if (a == 2) {
            int left = b;
            int right = b;
            
            while(true) {
                left = left-1;
                right = right+1;
                if(left < 1 || right > n) {
                    left += 1;
                    right -= 1;
                    break;
                }
                if(board[left] != board[right]) {
                    left += 1;
                    right -= 1;
                    break;
                }
            }
            
            for(int i=left; i<=right; i++) {
                board[i] = (board[i] == 1) ? 0 : 1;
            }
        }
    }
    
    for(int i=1; i<=n; i++) {
        cout << board[i] << ' ';
        if(i % 20 == 0) cout << '\n';
    }
}