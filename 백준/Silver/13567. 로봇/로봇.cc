#include <bits/stdc++.h>
using namespace std;

int dir = 0;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int m,n;
    cin >> m >> n;
    
    int curX = 0, curY = 0;
    
    for(int i=0; i<n; i++) {
        string co;
        int t;
        cin >> co >> t;
        if(co == "MOVE") {
            if(dir == 0) {
                if(curX + t > m) {
                    cout << -1;
                    return 0;
                }
                curX += t;
            }
            else if(dir == 1) {
                if(curY + t > m) {
                    cout << -1;
                    return 0;
                }
                curY += t;
            }
            else if(dir == 2) {
                if(curX - t < 0) {
                    cout << -1;
                    return 0;
                }
                curX -= t;
            }
            else {
                if(curY - t < 0) {
                    cout << -1;
                    return 0;
                }
                curY -= t;
            }
        }
        else if(co == "TURN") {
            if(t == 0) {
                dir = (dir + 1)%4;
            }
            else {
                dir--;
                if(dir < 0) dir = 3;
            }
        }
    }
    cout << curX << ' ' << curY;
}