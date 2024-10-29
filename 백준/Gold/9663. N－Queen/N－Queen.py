import sys
input = sys.stdin.readline

list1 = [False for _ in range(30)]
list2 = [False for _ in range(30)]
list3 = [False for _ in range(30)]

N = int(input())
ans = 0

def recur(k):
    global ans
    if k == N: 
        ans += 1
        return;
    for i in range(N):
        if list1[i] == False and list2[k+i] == False and list3[k-i+N-1] == False:
            list1[i] = True
            list2[k+i] = True
            list3[k-i+N-1] = True
            recur(k+1)
            list1[i] = False
            list2[k+i] = False
            list3[k-i+N-1] = False
        
recur(0)
print(ans)    