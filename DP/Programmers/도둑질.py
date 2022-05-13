def solution(money):
    answer = 0
    n = len(money)
    dp = [0] * (n + 1)
    dp[1] = money[0]
    dp[2] = max(money[0], money[1])
    if n == 3:
        return max(money)

    # 첫번째 무조건 털기 = 맨뒤를 고려 안함
    for i in range(3, n):
        dp[i] = max(dp[i - 2] + money[i - 1], dp[i - 1])
    MAX1 = dp[n - 1]

    # 마지막 무조건 털기 = 처음을 고려 X
    dp = [0] * (n + 1)
    dp[2] = money[1]
    dp[3] = max(money[1], money[2])
    for i in range(4, n + 1):
        dp[i] = max(dp[i - 2] + money[i - 1], dp[i - 1])
    MAX2 = dp[n]

    return max(MAX1, MAX2)