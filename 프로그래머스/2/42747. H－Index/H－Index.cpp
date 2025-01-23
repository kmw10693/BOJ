#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
int answer = -1;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    int minV = citations.at(0);
    int maxV = citations.at(citations.size() - 1);
    
    for(int i=0; i<=maxV; i++) {
        int tmp = 0;
        for(int j=0; j<citations.size(); j++) {
            if(i <= citations[j]) tmp++;
        }        
        if(tmp >= i) answer = max(i, answer);
    }
    return answer;
}