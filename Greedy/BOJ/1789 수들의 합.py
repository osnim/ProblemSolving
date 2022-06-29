import sys
S = int(sys.stdin.readline().strip())
i = 1
cnt = 0
while S > 0:
    S = S - i
    i += 1
    cnt += 1

if S != 0:
    cnt -= 1
print(cnt)