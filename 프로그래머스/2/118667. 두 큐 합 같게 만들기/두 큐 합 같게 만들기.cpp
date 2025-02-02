#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
#define ll long long

int solution(vector<int> queue1, vector<int> queue2) {
    queue<ll> q1;
    queue<ll> q2;
    
    ll sum1 = 0;
    ll maximum = 2 * queue1.size() + 2;
    
    for(int i=0; i<queue1.size(); i++) {
        q1.push(queue1[i]);
        sum1 += queue1[i];
    }
    
    ll sum2 = 0;
    for(int i=0; i<queue2.size(); i++) {
        q2.push(queue2[i]);
        sum2 += queue2[i];
    }
    
    
    if((sum1 + sum2) % 2 != 0) return -1;
    
    ll half = (sum1 + sum2) / 2;
    int tmp = 0;
    
    while(true) {
        if(sum1 == half) break;
        if(tmp >= maximum) return -1;
        if(q1.empty() || q2.empty()) return -1;
        
        if(sum1 > half) {
            if(!q1.empty()) {
                int t = q1.front(); q1.pop();
                q2.push(t);
                sum1 -= t;
                sum2 += t;
            }
        }
        else if(sum1 < half) {
            if(!q2.empty()) {
                int t = q2.front(); q2.pop();
                q1.push(t);
                sum2 -= t;
                sum1 += t;
            }
        }
        tmp++;
    }
    return tmp;
}
