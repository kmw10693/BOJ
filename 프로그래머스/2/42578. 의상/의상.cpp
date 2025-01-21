#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

map<string, int> mm;

int sum = 1;
int solution(vector<vector<string>> clothes) {
    for(int i=0; i<clothes.size(); i++) {
        mm[clothes[i][1]]++;
    }
    
    for(auto it = mm.begin(); it != mm.end(); it++) {
        sum *= ((it -> second) + 1);
    }
    return sum - 1;
}