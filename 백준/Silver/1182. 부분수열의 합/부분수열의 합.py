N, S = map(int, input().split())
list1 = list(map(int, input().split()))

sum1 = 0
def cur(k, tot):
    global sum1
    if k == N:
        if tot == S:
            sum1 += 1
        return
    cur(k+1, tot)
    cur(k+1, tot+list1[k])

cur(0, 0)
if S == 0: sum1 -= 1
print(sum1)