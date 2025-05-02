#include <bits/stdc++.h>
using namespace std;

int h,w,n,m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> h >> w >> n >> m;
    
    cout << ((h-1)/(n+1) + 1) * ((w-1)/(m+1) + 1); 
}