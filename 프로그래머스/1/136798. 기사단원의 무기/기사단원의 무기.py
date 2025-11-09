def solution(number, limit, power):
    result = 0
    for i in range(1, number+1):
        sum = 0
        for j in range(1, int(i **(1/2))+1):
            if i % j == 0:
                sum += 1
                if(j**2) != i:
                    sum += 1
        if sum <= limit:
           result += sum
        else:
            result += power
        
    return result
    