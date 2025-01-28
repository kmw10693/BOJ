#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    priority_queue <int> pq;
    int min_delete = 0;
    for(int i=0; i<operations.size(); i++)
    {
        string op = operations[i];
        //1. 삽입
        if(op[0]=='I')
        {
            string numstr = op.substr(2);
            int num = stoi(numstr);
            pq.push(num);
        }
        //2.삭제
        else
        {
            //만약 큐가 비어있다면 연산 무시
            if(pq.size()==0) continue;
            else
            {
                //최솟값 삭제(lazy delete, 나중에 삭제횟수 모아서 한번에 삭제)
                if(op[2]=='-') min_delete++;
                //최댓값 삭제
                else pq.pop();
            }
        }
    }
    //lazy delete & 답 만들기
    int max = 0; int min = 0;
    //max 구하기
    if(pq.size()>0) max = pq.top();
    //min구하기
    //최솟값 삭제연산 호출 횟수가 남아있는 pq 사이즈로 감당되는 경우
    if(pq.size()>=min_delete+1)
        while(pq.size()>min_delete+1) pq.pop();
    //최솟값 삭제연산 호출횟수가 남은 pq의 숫자보다 넘칠경우
    else
        while(pq.size()>0) pq.pop();

    if(pq.empty()==true)
    {
        max = 0; 
        min = 0;
    }
    else
        min = pq.top();
    answer.emplace_back(max);
    answer.emplace_back(min);
    return answer;
}