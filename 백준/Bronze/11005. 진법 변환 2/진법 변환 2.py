a,b = map(int,input().split())

## 좀 어렵지만 이론적인 방법
## a가 0이 될떄까지 b로 나눠준다
## a/b로 나눴을때 나오는 나머지가 알파벳이다
## 진법계산을 반대로했으므로 마지막에 역순으로 출력해주는 작업이 필요하다.
num_list = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
s = ""
while a:
    s += str(num_list[a%b])
    a //= b
11
print(s[::-1])