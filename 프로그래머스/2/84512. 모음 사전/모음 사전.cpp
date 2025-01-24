#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
string answer;
int answer2;
int k = 0;

void backtrack(string word, int cnt) {
    if(word == answer) { 
        answer2 = k;
        return;
    }
    
    if(cnt == 5) {
        return;
    }
    
    k++;
    backtrack(word+"A", cnt+1);
    k++;
    backtrack(word+"E", cnt+1);
    k++;
    backtrack(word+"I", cnt+1);
    k++;
    backtrack(word+"O", cnt+1);
    k++;
    backtrack(word+"U", cnt+1);
}

int solution(string word) {
    answer = word;
    backtrack("", 0);
    return answer2;
}