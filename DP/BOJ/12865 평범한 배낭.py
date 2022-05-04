import sys
def knapsack(N, capacity):
    for i in range(1, N+1):
        W = weight[i-1]
        V = value[i-1]
        for j in range(1, capacity+1):
            if W > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(V+dp[i-1][j-W], dp[i-1][j])
    return dp[N][capacity]

if __name__=="__main__":
    input = sys.stdin.readline
    N, K = map(int, input().split())
    #행은 아이템의 개수
    #열은 가방의 최대 무대
    #dp[i][j] : i개의 아이템을 골랐을 때 j 무게에서의 최대의 가치
    dp = [[0] * (K + 1) for _ in range(N+1)]
    weight = []
    value = []
    for i in range(N):
        W, V = map(int, input().split())
        weight.append(W)
        value.append(V)

    print(knapsack(N, K))
