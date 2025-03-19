#include <bits/stdc++.h>
using namespace std;

vector<int> p(10005, -1);

int find(int x) {
    if(p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unionParent(int a, int b){
    a = find(a);
    b = find(b);
    p[b] = a;
}

int v,e;
tuple<int,int,int> edge[100005];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> v >> e;
    for(int i=0; i<e; i++){
        int a,b,cost;
        cin >> a >> b >> cost;
        edge[i] = {cost, a, b};
    }
    sort(edge, edge+e);
    int cnt = 0;
    int ans = 0;
    for(int i=0; i<e; i++) {
        int a,b,cost;
        tie(cost,a,b) = edge[i];
        if(find(a) == find(b)) continue;
        unionParent(a,b);
        ans += cost;
        cnt++;
        if(cnt == v-1) break;
    }
    cout << ans;
    
}