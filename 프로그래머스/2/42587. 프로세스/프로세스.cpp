#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

queue<pair<int,int>> q;
priority_queue<int> pq;

#define X first
#define Y second

int solution(vector<int> priorities, int location) {
    for(int i=0; i<priorities.size(); i++){
        q.push({priorities[i], i});
        pq.push(priorities[i]);
    }
    
    int cnt = 1;
    while(!q.empty()){
        int top = q.front().X;
        int Y = q.front().Y;
        
        if(top < pq.top()) {
            q.push({top,Y});
            q.pop();
        }
        else {
            if(q.front().Y == location) {
                break;
            }
            q.pop();
            pq.pop();
            cnt++;
        }   
    }
    return cnt;
}