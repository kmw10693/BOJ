#include <bits/stdc++.h>

using namespace std;

int n,k;

bool compare(const tuple<int,int,int,int>& t1, const tuple<int,int,int,int>& t2) {
    if(get<1>(t1) != get<1>(t2)) {
        return get<1>(t1) > get<1>(t2);
    }
    if(get<2>(t1) != get<2>(t2)) {
        return get<2>(t1) > get<2>(t2);
    }
    
    return get<3>(t1) > get<3>(t2);
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> k;
    vector<tuple<int,int,int,int>> v;
    for(int i=0; i<n; i++) {
        int cont, gold, silver, dong;
        cin >> cont >> gold >> silver >> dong;
        v.push_back(make_tuple(cont, gold, silver, dong));
    }
    sort(v.begin(), v.end(), compare);
    
    int rank = 1;
    vector<int> ans(100005, 0);
    int tmp = 1;
    // 첫번째는 1위
    ans[get<0>(v[0])] = 1;
    
    for(int i=1; i<n; i++) {
        // 뒤랑 앞이랑 같으면 rank유지하고, tmp 증가
        if(get<1>(v[i]) == get<1>(v[i-1]) && get<2>(v[i]) == get<2>(v[i-1]) && get<3>(v[i]) == get<3>(v[i-1])) {
            ans[get<0>(v[i])] = rank;
            tmp++;
            continue;
        }
        // 다르면 rank + tmp 만큼 더하기
        rank += tmp;
        tmp = 1;
        ans[get<0>(v[i])] = rank;
    }
    
    cout << ans[k];
}
