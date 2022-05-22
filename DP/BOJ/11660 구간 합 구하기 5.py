import sys
n, m = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0]*(n+1) for i in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == 1 or j == 1:
            dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i-1][j-1]
        else:
            dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i-1][j-1] - dp[i-1][j-1]

for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1])
