import sys 
sys.setrecursionlimit(1000000)
graph = []

def check(x,y,n):
    init = graph[x][y]
    for i in range(n):
        for j in range(n):
            if init != graph[x+i][y+j]: return False
    
    return True
    
ansM = 0
ansZ = 0
ansO = 0


def graph2(x,y,n):
    global ansM, ansZ, ansO
    
    if check(x,y,n):
        if graph[x][y] == -1 : ansM += 1
        elif graph[x][y] == 0 : 
            ansZ += 1
        elif graph[x][y] == 1: 
            ansO += 1
        return;
 
    for i in range(3):
        for j in range(3):
            graph2(x + i*(n//3), y + j*(n//3), n//3)
    
    
k = int(sys.stdin.readline())
for i in range(k):
        graph.append(list(map(int, input().split())))

t = k//3
graph2(0, 0, k)
print(ansM)
print(ansZ)
print(ansO)
        
    