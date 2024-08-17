from itertools import combinations

def solution(numbers):
    arr = []
    arr = list(combinations(numbers, 2))
    answer = []
    
    for x,y in arr:
        if x+y not in answer:
            answer.append(x+y)
    answer.sort()
    return answer