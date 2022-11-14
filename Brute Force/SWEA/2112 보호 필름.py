# SWEA 보호필름
def checkCol(col):
    global D, K
    pre = col[0]  # 가장 처음 것
    k = 1  # k가 연속적으로 K개 있는지 세는 것
    for i in range(1, D):
        if col[i] == pre:
            k += 1
            if k >= K:
                return True
        else:
            pre = col[i]
            k = 1
    return False

def check(arr): # 성능검사 체크
    for j in range(W):
        col = []
        for i in range(D):
            col.append(arr[i][j])
        if not checkCol(col):
            return False
    return True

def dfs(depth, cntA, cntB):
    global D, W, K, arr, answer, visited, count
    #count += 1
    if depth == D:
        if check(arr):
            answer = min(cntA + cntB, answer)
             #print(depth, cntA, cntB, answer, visited, "<<<후보")
        return

    #print(depth, cntA, cntB, answer, visited)

    #if cntA > K or cntB > K: # K번 이상 칠하는 건 불필요
        #return

    if check(arr):
        answer = min(cntA + cntB, answer)
        #print(depth, cntA, cntB, answer, visited, "<<<후보")
        return
    #    if check(arr):
    #         answer = min(cnt, answer)
    #         return

    # 원래의 행
    memoRow = arr[depth][:]

    arr[depth] = ([0]*W)[:]
    #print(arr[depth])
    visited[depth] = 'A' #A 칠하는 경우
    dfs(depth + 1, cntA+1, cntB)

    arr[depth] = ([1]*W)[:]
    #print(arr[depth])
    visited[depth] = 'B' #B 칠하는 경우
    dfs(depth + 1, cntA, cntB+1)

    arr[depth] = memoRow[:]
    #print(arr[depth])
    visited[depth] = 'X'  # 안 칠하는 경우
    dfs(depth + 1, cntA, cntB)
    visited[depth] = ''

T = int(input())
for t in range(1, T+1):
    global D, W, K, arr, answer, visited, count
    D, W, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(D)]
    answer = D # 모든 두께에 약품 처리하는 경우
    visited = [''] * D
    #count = -1

    if K == 1:
        print(f'#{t} {0}')
        continue
    dfs(0, 0, 0)
    print(f'#{t} {answer}')
   # print(count)