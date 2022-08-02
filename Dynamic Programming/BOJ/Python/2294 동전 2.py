n, k = map(int, input().split())
arr = set()
dp = [10001]*(k+1)
dp[0] = 0
for _ in range(n):
    arr.add(int(input()))

arr = list(arr)
for i in range(len(arr)):
    for j in range(arr[i], k+1):
        if dp[j - arr[i]] != 10001:
            dp[j] = min(dp[j], dp[j - arr[i]]+1)

if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])
