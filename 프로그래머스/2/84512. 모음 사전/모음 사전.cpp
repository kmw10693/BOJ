#include <string>
#include <vector>

using namespace std;

int k = 0;
string answerWord;
int answer = 0;

void backtrack(string s, int cnt) {
    if(s == answerWord) {
        answer = k;
        return;
    }
    if(cnt >= 5) return;
    
    k++;
    backtrack(s+"A", cnt+1);
    k++;
    backtrack(s+"E", cnt+1);
    k++;
    backtrack(s+"I", cnt+1);
    k++;
    backtrack(s+"O", cnt+1);
    k++;
    backtrack(s+"U", cnt+1);
}

int solution(string word) {
    answerWord = word;
    backtrack("", 0);
    return answer;
}