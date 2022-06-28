def solution(triangle):
    h = len(triangle)
    dp = []
    for i in range(h):
        dp.append([0] * (h+1))
        print(dp[i])
    dp[0][1] = triangle[0][0]
    for i in range(1, h):
        w = len(triangle[i])
        for j in range(1, w+1):
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j-1]
    return max(dp[-1])
