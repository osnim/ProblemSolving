N = int(input())
cards =  [0] + list(map(int, input().split()))
dp = cards[:]

for i in range(1, N+1):
    for j in range(1, i):
        dp[i] = max(dp[i], (dp[i-j]+cards[j]))

print(dp)