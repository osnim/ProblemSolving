n, k = map(int, input().split())
arr = set()
dp = [10001]*(k+1)
dp[0] = 0
for _ in range(n):
    arr.add(int(input))

for i in range(1, k+1):
    for j in arr:
        dp[i - j] = ,

