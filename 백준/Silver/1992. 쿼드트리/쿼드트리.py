def check(n, x, y):
    a = list1[x][y]
    for i in range(n):
        for j in range(n):
            if a != list1[x+i][y+j]: return False
    return True

def recur(n, x, y):
    if check(n, x, y) == True:
        print(list1[x][y], end='')
        return;
    else:
        print('(', end='')
        recur(n//2, x, y)
        recur(n//2, x, y+n//2)
        recur(n//2, x+n//2, y)
        recur(n//2, x+n//2, y+n//2)
    print(')', end='')

n = int(input())
list1 = []
for i in range(n):
    list1.append(list(map(int, input().strip())))
recur(n, 0, 0)
