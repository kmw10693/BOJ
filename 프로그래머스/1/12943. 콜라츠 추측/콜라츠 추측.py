def solution(num):
    result = 1
    while(result <= 500):
        if(num == 1):
            result = 0
            break
        if num % 2 == 0:
            num /= 2
        else:
            num = (num * 3) + 1
        
        if(num == 1):
            break
            
        if(result >= 500 and num != 1):
            result = -1
            break
            
        result += 1
    return result