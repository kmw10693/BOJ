def solution(numbers):
    answer2 = 0
    answer = [0 for i in range(10)]
    for i in numbers:
        answer[int(i)] = 1
    for i in range(10):
        if answer[i] == 0: answer2 += int(i)
    
    return answer2