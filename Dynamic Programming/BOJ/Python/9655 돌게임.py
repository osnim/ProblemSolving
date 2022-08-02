n = int(input())
dp = [0] * (1001)
dp[1] = 1
dp[2] = 0
dp[3] = 1
for i in range(4, n+1):
    if dp[i-1] or dp[i-3]: #i번째에서 1개나 3개가 남는 경우
        dp[i] = 0 # 창영이가 이김
    else:
        dp[i] = 1 # 상근이가 이김

if dp[n]:
    print("SK")
else:
    print("CY")
