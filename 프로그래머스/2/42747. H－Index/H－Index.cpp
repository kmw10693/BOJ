#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    int minV = citations.at(0);
    int maxV = citations.at(citations.size() - 1);
    
    int answer = 0;
    for(int j=0; j<=maxV; j++) {
        int cnt = 0;
        int cnt2 = 0;
        for(int i=0; i<citations.size(); i++) {
            if(citations[i] >= j) cnt++;
        }
        if(cnt >= j) answer = j;
    }
    return answer;
}