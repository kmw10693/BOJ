def solution(k, score):
    answer = []
    arr = []
    for s in score:
        arr.append(s)
        if(len(arr) > k):
            arr.remove(min(arr))
        answer.append(min(arr))
        
    return answer