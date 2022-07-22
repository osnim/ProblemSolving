N = int(input())
dist = list(map(int, input().split()))
costs= list(map(int, input().split()))
idx = 0 # costs의 인덱스
total = 0

total = costs[idx] * dist[0] #처음은 무조건 주유
for i in range(1, N-1):
    if costs[idx] > costs[i]:
        idx = i
    total += costs[idx] * dist[i]
print(total)