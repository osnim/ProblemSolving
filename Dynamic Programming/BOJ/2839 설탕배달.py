N = int(input())
dp = [2001] * (N+1)
temp = 1
if N <= 5:
    dp = [-1, -1, -1, 1, -1, 1]
    print(dp[N])
    exit()
dp[3] = 1
dp[5] = 1
for i in range(3, N+1, 3):
    dp[i] = temp
    temp += 1
for i in range(5, N+1):
    dp[i] = min(dp[i-5]+1, dp[i])
if dp[N] == 2001:
    print(-1)
else:
    print(dp[N])