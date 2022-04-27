def solve():
    n = int(input())
    dp = [0] * (30+1)
    dp[1] = 0
    dp[2] = 3
    for i in range(4, n+1):
        if i%2 == 1:
            continue
        dp[i] = dp[i-2]*3
        for j in range(0, i-2, 2):
            dp[i] += dp[j]*2
        dp[i] += 2

    print(dp[n])
    return

if __name__ == "__main__":
    solve()

