N = int(input())
a = [0]
ans = 0

# dp[i][j] = 현재까지 j개의 계단을 연속해서 밟고, i번째 계단까지 올라섰을 때, 점수합의 최댓값
# (단, i 번째 계단은 반드시 밟기)
dp = [[0]*3 for i in range(N+1)]
for i in range(N):
    a.append(int(input().strip()))

if N == 1:
    print(a[1])
    exit(0)
elif N == 2:
    print(a[1] + a[2])
    exit(0)

dp[1][1] = a[1]
dp[2][1], dp[2][2] = a[2], a[1] + a[2]

for i in range(3, N+1):
    dp[i][1] = max(dp[i-2][1], dp[i-2][2]) + a[i]
    dp[i][2] = dp[i-1][1]+a[i]

print(max(dp[N]))
