import copy

def checking(r,c,i,j):
    global stick
    for y in range(r):
        for x in range(c):
            if board[i+y][j+x] + stick[y][x] > 1:
                return False
    return True

def attach(r:int, c:int, i:int, j:int):
    global stick
    for y in range(r):
        for x in range(c):
            board[i+y][j+x] += stick[y][x]
    return 

def rotate(r:int, c:int):
    global stick
    result = [[0 for _ in range(r)] for _ in range(c)]
    for i in range(r):
        for j in range(c):
            result[j][r-i-1] = stick[i][j]
    return result

def solve(n,m,r,c):
    global stick
    check = False
    cnt = 0
    while cnt < 4:
        if check: break
        for i in range(n-r+1):
            if check: break
            for j in range(m-c+1):
                if checking(r,c,i,j):
                    attach(r,c,i,j)
                    check = True
                    break
        else:
            stick = rotate(r,c)
            r,c = c,r
            cnt+=1

if __name__=='__main__':
    n,m,k = map(int, input().split())
    board = [[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        r, c = map(int ,input().split())
        stick =[]
        for _ in range(r):
            stick.append(list(map(int, input().split())))
        solve(n, m, r, c)
    answer = 0
    for i in range(n):
        for j in range(m):
            answer += board[i][j]
    print(answer)