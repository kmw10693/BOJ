#include <bits/stdc++.h>

using namespace std;

// 이분 탐색 nlogn
int n,m;
vector<int> v;

bool check(int t) {
    for(int i=0; i<v.size(); i++) {
        if(i == 0 && v[i] - t > 0) return false;
        if(i > 0 && v[i-1] + t < v[i] - t) return false;
        if(i == v.size()-1 && v[i] + t < n) return false;
    }
    return true;
    
}
int main() {
    ios::sync_with_stdio(0);
    
    cin >> n >> m;
    for(int i=0; i<m; i++) {
        int x; cin >> x;
        v.push_back(x);
    }
    // O(NlogN) 으로 풀어야함
    int st = 1;
    int en = 100000;
    while(st <= en) {
        int mid = (st+en)/2;
        if(check(mid)) en = mid-1;
        else st = mid+1;
    }
    cout << st;
    
}