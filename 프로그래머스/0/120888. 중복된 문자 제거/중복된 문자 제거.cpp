#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_map<char, int> m;

bool compare(pair<char, int> v1, pair<char, int> v2) {
    return v1.second < v2.second;
}
string solution(string my_string) {

    for(auto s: my_string) {
        m[s] = 1;
    }
    string answer = "";
    for(auto s : my_string) {
        if(m[s]) {
            answer += s;
            m[s] = 0;
        }
    }
    return answer;

}
