#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

deque<pair<int, int>> dq;
queue<int> waitQ;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 1;
    int curWeight = weight;
    int curlength = 0;
    
    for(int i=0; i<truck_weights.size(); i++) waitQ.push(truck_weights[i]);

    while(true) {
        if(!dq.empty()) {
            if(answer == dq.front().second) {
                curWeight += dq.front().first;
                dq.pop_front(); 
                curlength--;
            }
        }
        
        if(!waitQ.empty()) {
            if(curWeight >= waitQ.front() && curlength < bridge_length) {
                dq.push_back({waitQ.front(), answer+bridge_length});
                curWeight -= waitQ.front();
                curlength++;
                waitQ.pop();
            }
        }
    

        if(dq.empty() && waitQ.empty()) break;
        
        answer++;
    }        
    return answer;
}