pad = {'1':(0,0), '2':(0,1), '3':(0,2),
           '4':(1,0), '5':(1,1), '6':(1,2),
           '7':(2,0), '8':(2,1), '9':(2,2),
           '*':(3,0), '0':(3,1), '#':(3,2)
}

def dist(point1, point2):
    y1, x1 = point1
    y2, x2 = point2
    return abs(y2-y1) + abs(x2-x1)

def solution(numbers, hand):
    t = 'R'
    if hand == 'left':
        t = 'L'
        
    a = {1: 'L', 4:'L', 7:'L'}
    b = {3: 'R', 6:'R', 9:'R'}
    
    result = ""
    
    prevL = '*'
    prevR = '#'
    
    for n in numbers:
        if n in a:
            result += a[n]
            prevL = str(n)
        elif n in b:
            result += b[n]
            prevR = str(n)
        else: 
            if dist(pad[str(prevL)], pad[str(n)]) > dist(pad[str(prevR)], pad[str(n)]):
                result += 'R'
                prevR = str(n)
            elif dist(pad[str(prevL)], pad[str(n)]) < dist(pad[str(prevR)], pad[str(n)]):
                result += 'L'
                prevL = str(n)
            else:
                result += t
                if t == 'R': prevR = str(n)
                else: prevL = str(n)
                
    return result
    