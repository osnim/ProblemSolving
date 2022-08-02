import sys

def solve(dp):
    dp[1] = 1
    SUM = dp[1]
    i = 1
    while SUM < n:
        i += 1
        dp[i] = 1 + dp[i - dp[dp[i - 1]]]
        SUM += dp[i]

    print(i)
    return

if __name__=="__main__":
    n = int(sys.stdin.readline())
    dp = [0] * (1000001)
    solve(dp)