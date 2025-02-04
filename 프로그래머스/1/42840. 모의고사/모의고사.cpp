#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int first1[5] = {1,2,3,4,5};
int first2[8] = {2,1,2,3,2,4,2,5};
int first3[10] = {3,3,1,1,2,2,4,4,5,5};

int exam[10001];

vector<pair<int,int>> v;

bool cmp(pair<int,int> v1, pair<int,int> v2) {
    if(v1.first == v2.first) {
        return v1.second < v2.second; 
    }
    return v1.first > v2.first;
}

vector<int> solution(vector<int> answers) {
    for(int i=0; i<answers.size(); i++) {
        exam[i] = answers[i];
    }
    
    for(int i=1; i<=3; i++){
        v.push_back({0, i});
    }
    
    for(int i=0; i<answers.size(); i++){
        if(exam[i] == first1[i%5]) v[0].first++;
        if(exam[i] == first2[i%8]) v[1].first++;
        if(exam[i] == first3[i%10]) v[2].first++;
    }
    
    sort(v.begin(), v.end(), cmp);
    
    vector<int> ans;
    
    if(v[0].first > v[1].first) ans.push_back(v[0].second);
    
    else if(v[0].first == v[1].first && v[0].first != v[2].first) {
        ans.push_back(v[0].second);
        ans.push_back(v[1].second);
    }
    else {
        ans.push_back(v[0].second);
        ans.push_back(v[1].second);
        ans.push_back(v[2].second);
    }
    return ans;
}