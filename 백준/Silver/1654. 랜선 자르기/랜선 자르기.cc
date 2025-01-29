#include <bits/stdc++.h>
using namespace std;

int k, n;
int arr[10005];
typedef long long ll;

bool check(ll x){
    
    ll sum = 0;
    for(int i=0; i<k; i++) sum += arr[i] / x;
    return sum >= n;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> k >> n;
    for(int i=0; i<k; i++) {
        cin >> arr[i];
    }
    
    ll st = 1;
    ll en = 0x7fffffff;
    while(st < en) {
        ll mid = (st+en+1)/2;
        if(check(mid)) st = mid;
        else en = mid-1;
    }
    cout << st;
    
}