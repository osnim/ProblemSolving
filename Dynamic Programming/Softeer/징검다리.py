import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
heights = list(map(int, input().split()))
dp = [1]*N # i+1번째까지 밟은 최대 돌 개수 누적
for i in range(N-1):
    h1 = heights[i] # 기준 돌의 높이
    for j in range(i+1, N):
        h2 = heights[j] # 비교 돌의 높이
        if h1 >= h2:
            continue
        else: # 기준 돌 보다 높은 돌 중 가장 처음 만나는 돌
            dp[j] = max(dp[j], dp[i]+1)

print(f"{max(dp)}")
