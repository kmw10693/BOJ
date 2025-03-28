#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll n,m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    vector<ll> v;
    
    for(ll i=0; i<m; i++) {
        ll a;
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    
    ll minV = *min_element(v.begin(), v.end());
    ll maxV = *max_element(v.begin(), v.end());
    
    ll ans = 0;
    ll price = 0;
    for(ll i=minV; i<=maxV; i++) {
        ll tmp = 0;
        ll cnt = 0;
        for(auto V : v) {
            if(i <= V && cnt < n) {
                tmp += i;
                cnt++;
            }
        }
        if(ans < tmp) {
            price = i;
            ans = tmp;
        }
    }
    cout << price << ' ' << ans;
}