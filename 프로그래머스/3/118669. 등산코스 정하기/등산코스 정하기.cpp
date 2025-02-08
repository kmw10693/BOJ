#include <string>
#include <vector>
#include <bits/stdc++.h>

#define ALL(X) X.begin(), X.end()
using namespace std;

vector<int> res;
vector<pair<int,int>> adj[50001];

int intensity[50001];
bool isSummit[50001];

void go(vector<int>& gates) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    vector<pair<int, int>> temp;
    memset(intensity, -1, sizeof(intensity));
    
    for(auto g : gates) {
        pq.push({0, g});
        intensity[g] = 0;
    }
    
    while(!pq.empty()) {
        int cost = pq.top().first;
        int nowV = pq.top().second;
        pq.pop();
    
        if(cost > intensity[nowV]) continue;
        
        if(isSummit[nowV]) {
            temp.push_back({cost, nowV});
            continue;
        }
    
        for(auto p : adj[nowV]) {
            int weight = p.first;
            int to = p.second;
            
            if(intensity[to] == -1 || max(cost, weight) < intensity[to]) {
                intensity[to] = max(cost, weight);
                pq.push({intensity[to], to});
            }
        }
    }
    
    sort(ALL(temp));
    res.push_back(temp[0].second);
    res.push_back(temp[0].first);
}

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    for (auto e : paths) {
        adj[e[0]].push_back({e[2], e[1]});
        adj[e[1]].push_back({e[2], e[0]});
    }
    
    for (auto s : summits) {
        isSummit[s] = true;
    }
    go(gates);
    return res;
}
