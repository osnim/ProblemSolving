X = int(input())
A = 64
cnt = 0
while A > 0 and X > 0:
    if A <= X:
        cnt += 1
        X -= A
    A //= 2
print(cnt)

# 한줄 코드
#print(bin(int(input())).count('1'))