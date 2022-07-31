import sys
def solve(k, l):
    minCnt = int(10e9)
    for c in range(2):
        if c == 0:
            cur = ["B", "W"] * 4
            next = ["W", "B"] * 4
        else:
            cur = ["W", "B"] * 4
            next = ["B", "W"] * 4

        cnt = 0
        for i in range(k, k + 8, 2):
            for j in range(l, l + 8):
                if data[i][j] != cur[j - l]:
                    cnt += 1
                if data[i + 1][j] != next[j - l]:
                    cnt += 1

        minCnt = min(cnt, minCnt)
    return minCnt


input = sys.stdin.readline
N, M = map(int, input().split())
data = []
for i in range(N):
    data.append(list(input().strip()))

answer = int(10e9)

for k in range(N-7):
    for l in range(M-7):
        answer = min(answer, solve(k, l))

print(answer)


