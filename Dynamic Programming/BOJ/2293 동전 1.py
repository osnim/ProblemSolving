import sys
def solve():
    for coin in arr:
        for j in range(coin, K+1):
            #if j >= coin:
            dp[j] += dp[j-coin]

    print(dp[K])
    return

if __name__=="__main__":
    input = sys.stdin.readline
    N, K = map(int, input().split())
    arr = [int(input()) for i in range(N)]
    # dp[1]는 1개만 골랐을 때 경우의 수
    # dp[0]은 하나의 동전만으로 k원 만드는 경우의 수를 의미 = 1
    dp = [1] + [0]*K

    solve()