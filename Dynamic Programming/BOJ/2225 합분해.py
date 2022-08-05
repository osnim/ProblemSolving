import sys
def solve():
    arr = [[0] *(N+1) for i in range(K+1)]
    for i in range(1, K+1):
        for j in range(1, N+1):
            if j == 1:
                arr[i][j] = i
            elif i == 1:
                arr[i][j] = 1
            else:
                arr[i][j] = arr[i-1][j] + arr[i][j-1]

    return arr[K][N]
if __name__ == "__main__":
    input = sys.stdin.readline
    N, K = map(int, input().split())

    print(solve()%1000000000)