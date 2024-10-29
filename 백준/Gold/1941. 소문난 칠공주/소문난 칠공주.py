from collections import deque
board = [list(input()) for _ in range(5)]
idx = [(i,j) for i in range(5) for j in range(5)]
s = []
n = []
ans = 0

def check(s):
    l = [i for i in s]
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    
    d = deque([l[0]])
    l.remove(l[0])
    while d:
        
        x, y = d.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (nx,ny) in l:
                d.append((nx,ny))
                l.remove((nx,ny))
    
    if len(l) == 0: return True
    else: return False
    
def dfs(depth):
    global ans
    if len(s) == 7:
        if check(s) == True and n.count('S') >= 4:
            ans +=1
        return
            
    for i in range(depth, 25):
        x, y = idx[i]
        s.append((x,y))
        n.append(board[x][y])
        dfs(i+1)
        s.pop()
        n.pop()
        
dfs(0)
print(ans)