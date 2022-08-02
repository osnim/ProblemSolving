def solve():
    code = list(map(int, input()))
    dp = [0] * (len(code)+1)
    dp[0] = 1
    dp[1] = 1
    if code[0] == 0:
        print(0)
        return
    N = len(code)
    code = [0] + code
    for i in range(2, N+1):
        one = code[i]
        if one > 0:
            dp[i] += dp[i-1]
        two = code[i-1]*10 + code[i]
        if 10 <= two <= 26:
            dp[i] += dp[i-2]

    print(dp[N]%1000000)
    #print(dp)

if __name__ == "__main__":
    solve()



