#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool check[50005];
int answer;

bool compare(int a, int b) {
    return a > b;
}

int solution(vector<int> people, int limit) {
    fill(check, check+50005, false);
    sort(people.begin(), people.end(), compare);
    
    for(int i=0; i<people.size(); i++) {
        if(!check[i] && people[i] <= limit) {
            check[i] = true;
            int tmplimit = limit - people[i];
            for(int j=i+1; j<people.size(); j++) {
                if(tmplimit - people[j] >= 0) {
                    tmplimit -= people[j];
                    check[j] = true;
                }
            }
            answer++;
        }
    }
    return answer;
}