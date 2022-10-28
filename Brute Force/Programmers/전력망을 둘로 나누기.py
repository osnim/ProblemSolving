from collections import deque
def solution(n, wires):
    def BFS(start):
        cnt = 0 # start와 연결된 송전탑의 개수
        q = deque([])
        q.append(start)
        while q:
            s = q.popleft()
            cnt += 1
            for i in range(1, n+1):
                if arr[s][i] == 0: continue
                if visited[i]: continue
                q.append(i)
                visited[i] = True
        #print(cnt)
        return cnt

    answer = n
    arr = [[0]*(n+1) for _ in range(n+1)]

    for wire in wires: # 인접배열
        start = wire[0]
        end = wire[1]
        arr[start][end] = 1
        arr[end][start] = 1

    #1개씩 모두 끊으면서 BFS, DFS 돌리기
    for i in range(1, n+1):
        for j in range(i+1, n+1):
            if arr[i][j] == 0: continue # 연결 된 것만 BFS, DFS 돌리기
            arr[i][j] = 0 #연결 끊기
            arr[j][i] = 0
            visited = [False] * (n + 1)
            for start in range(1, n+1):
                if visited[start]: continue #방문한 경우
                visited[start] = True
                connect = BFS(start)
                unconnect = n - connect# 연결되지 않은 것들
                answer = min(abs(connect-unconnect), answer)
            arr[i][j] = 1  #원상복귀
            arr[j][i] = 1
    return answer