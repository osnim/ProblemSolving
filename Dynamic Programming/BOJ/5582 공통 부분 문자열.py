S1, S2 = input(), input()
l1, l2 = len(S1), len(S2)
S1, S2 = " " + S1, " " + S2
dp = [[0] * (l2+1) for _ in range(l1+1)]
ans = 0
for i in range(1, l1+1):
    for j in range(1, l2+1):
        if S1[i] == S2[j]:
            dp[i][j] = dp[i-1][j-1] + 1
            ans = max(dp[i][j], ans)
print(ans)