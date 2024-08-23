def solution(s):
    a = 0
    
    for i in s:
        if i == 'p' or i == 'P':
            a += 1
        elif i == 'y' or i == 'Y':
            a-= 1
    return a == 0
