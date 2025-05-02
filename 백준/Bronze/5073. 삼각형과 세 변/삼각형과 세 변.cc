#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    while(true) {
        int a,b,c;
        cin >> a >> b >> c;
        if(a == 0 && b == 0 && c == 0) break;
        
        int maxV = max(a,b);
        maxV = max(maxV, c);
        int sum = a + b + c;
        if(maxV >= sum - maxV) {
            cout << "Invalid" << "\n";
            continue;
        }
        
        if(a == b && a == c) {
            cout << "Equilateral" << "\n";
        }
        else if(a != b && a != c && b != c) {
            cout << "Scalene" << "\n";
        }
        else {
            cout << "Isosceles" << "\n";
        }
    }
}