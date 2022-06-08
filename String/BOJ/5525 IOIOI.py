N, M = int(input()), int(input())
S = input()
p = "I"+"OI" * N
i = 0
pattern = 0
cnt = 0
while i < M-2:
    if S[i:i+3] == "IOI":
        pattern += 1
        if pattern == N:
            pattern -= 1
            cnt += 1
        i += 1
    else:
        pattern = 0
    i += 1
print(cnt)