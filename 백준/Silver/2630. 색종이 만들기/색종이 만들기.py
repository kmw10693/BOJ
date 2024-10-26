ans0 = 0
ans1 = 0
lists = []

def check(n, x, y):
    t = lists[x][y]
    for i in range(n):
        for j in range(n):
            if t != lists[x+i][y+j]: return False
    
    return True

def sol(x, y):
    global ans0, ans1
    if lists[x][y] == 1: ans1 += 1
    else: ans0 += 1

def recur(n, x, y):
    if check(n, x, y) == True:
        sol(x,y)
        return;
    else:
        recur(n//2, x, y)
        recur(n//2, x+n//2, y)
        recur(n//2, x, y+n//2)
        recur(n//2, x+n//2, y+n//2)


n = int(input())
lists = []
for i in range(n):
    list2 = list(map(int, input().split()))
    lists.append(list2)

recur(n, 0, 0)
print(ans0)
print(ans1)

