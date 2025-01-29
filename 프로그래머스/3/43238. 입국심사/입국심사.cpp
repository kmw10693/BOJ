#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

bool check(vector<int> times, int n, ll v) {
    ll cnt = 0;
    for(int i=0; i<times.size(); i++) {
        cnt += (v / times[i]);
    }
    return cnt >= n;
}

long long solution(int n, vector<int> times) {
    ll st = 1;
    sort(times.begin(), times.end());
    ll end = (n) * (ll) times.back();
    
    while(st < end) {
        ll mid = (st+end)/2;
        if(check(times, n, mid)) end = mid;
        else st = mid + 1;
    }
    
    return st;
}