#include <bits/stdc++.h>
using namespace std;

vector<int> p(303, -1);

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
    
    cin >> v;
    for(int i=1; i<=v; i++) {
        int cost;
        cin >> cost;
        edge[e++] = {cost, i, v+1};
    }
    
    for(int i=1; i<=v; i++) {
        for(int j=1; j<=v; j++) {
            int cost;
            cin >> cost;
            if(i>=j) continue;
            edge[e++] = {cost, i, j};
        }
    }
    
    v++;
    sort(edge, edge+e);
    int cnt = 0;
    int ans = 0;
    for(int i=0; i<e; i++) {
        int a, b, cost;
        tie(cost, a, b) = edge[i];
        if(find(a) == find(b)) continue;
        unionParent(a,b);
        ans += cost;
        cnt++;
        if(cnt == v-1) break;
    }
    cout << ans;
    
}