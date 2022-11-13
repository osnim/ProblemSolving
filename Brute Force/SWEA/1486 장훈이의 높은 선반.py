T = int(input())
def dfs(cnt, tot):
    global N, B, arr, minHeight, visitied
    if tot >= B: #B 이상인 탑 중에서 높이가 가장 낮은 탑
        minHeight = min(minHeight, tot)

    if cnt == N:
        return

    visitied[cnt] = True
    dfs(cnt+1, tot + arr[cnt])

    visitied[cnt] = False
    dfs(cnt+1, tot)

for t in range(1, T+1):
    global N, B, arr, minHeight, visitied
    N, B = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()
    visitied = [False] * N
    minHeight = sum(arr) + 1

    dfs(0, 0)

    print(f'#{t} {abs(minHeight-B)}')