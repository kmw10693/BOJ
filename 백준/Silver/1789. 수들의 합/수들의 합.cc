#include <bits/stdc++.h>
using namespace std;

// 이분 탐색 nlogn으로 불가함
// logn으로 풀어야 한다.
long long s;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> s;
    cout << (long long)((-1 + sqrt(1 + 8*s)) / 2);
}