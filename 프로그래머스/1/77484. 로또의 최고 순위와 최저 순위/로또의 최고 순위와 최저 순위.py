def rank(number):
    if number == 6: return 1
    if number == 5: return 2
    if number == 4: return 3
    if number == 3: return 4
    if number == 2: return 5
    else: return 6

def solution(lottos, win_nums):
    arr = [0 for i in range(45)]
    answer = []
    count = 0
    
    for i in lottos:
        if(int(i) != 0):
            arr[int(i) - 1] = 1
        if(int(i) == 0): count += 1
    for j in win_nums:
        arr[int(j) - 1]+=1
    
    minA = 0
    maxA = 0
    for i in range(45):
        if arr[i] >= 2: minA += 1
    maxA = minA + count
    
    answer.append(rank(maxA))
    answer.append(rank(minA))
    return answer
    
            