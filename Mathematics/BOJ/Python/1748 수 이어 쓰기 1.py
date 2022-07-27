N = int(input())
cnt = 0
i = 9
l = 1
while True:
    if N < i:
        cnt += N * l
        break
    cnt += i * l
    N = N - i
    i *= 10
    l += 1

print(cnt)