n,k = map(int, input().split())
a = []

for i in range(n):
    m = int(input())
    a.append(m)
    
a.sort(reverse = True)

ans = 0


for i in a:
    ans += k // i
    k = k%i

print(ans)