#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool compare(string s1, string s2){
    return s1 + s2 > s2 + s1;
}

string solution(vector<int> numbers) {
    vector<string> v;
    
    for(auto n : numbers) v.push_back(to_string(n));
    
    sort(v.begin(), v.end(), compare);
    if(v.at(0) == "0") return "0";
    string s;
    for(auto V : v) s += V;
    return s;
}