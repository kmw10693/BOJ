from collections import deque
import sys, copy

input = sys.stdin.readline

n,m = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(n)]
tmp_space = copy.deepcopy(space)

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
def check(x, y):
    return 0 <= x < n and 0 <= y < m

def init():
    answer = 0
    cctv = deque()
    for i in range(n):
        for j in range(m):
           if space[i][j] != 0 and space[i][j] != 6:
               cctv.append((space[i][j], i, j))
           elif space[i][j] == 0:
               answer += 1
               
    return cctv, answer
    
cctv, answer = init()

def move(x, y, d):
    d %= 4
    while True:    
        x += dy[d]
        y += dx[d]
        
        if check(x, y) == False or tmp_space[x][y] == 6:
            break
        
        if tmp_space[x][y] != 0: continue
        
        tmp_space[x][y] = '#'
        
for i in range(4**len(cctv)):
    tmp = i
    tmp_space = copy.deepcopy(space)
    for j in range(len(cctv)):
        d = tmp % 4
        tmp //= 4
    
        num, x, y = cctv[j]
        
        if num == 1:
            move(x, y, d)
        elif num == 2:
            move(x, y, d); move(x, y, d+2)
        elif num == 3:
            move(x, y, d); move(x, y, d+1)
        elif num == 4:
            move(x, y, d); move(x, y, d+1); move(x, y, d+2)
        else:
            move(x, y, d); move(x, y, d+1); move(x, y, d+2); move(x,y,d+3)
    count = 0
    for i in tmp_space:
        count += i.count(0)
    
    answer = min(answer, count)
    
print(answer)
            