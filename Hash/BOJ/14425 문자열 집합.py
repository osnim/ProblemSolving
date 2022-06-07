from collections import defaultdict
N, M = map(int, input().split())
dic = defaultdict(int)
temp = []
for _ in range(N):
    dic[input()] += 1
cnt = 0
for i in range(M):
    if input() in dic:
        cnt += 1

print(cnt)