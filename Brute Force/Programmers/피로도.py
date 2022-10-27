def solution(k, dungeons):
    global answer  
    answer = 0
    N = len(dungeons)
    visited = [False]*N

    def npn(cnt, clear, k):
        global answer
        if cnt == N:
            answer = max(answer, clear)
            return
        
        for i in range(N):
            if visited[i]: continue
            require = dungeons[i][0]
            consume = dungeons[i][1]
            visited[i] = True
            
            if k >= require: 
                npn(cnt+1, clear+1, k - consume)
            else:
                npn(cnt+1, clear, k)
            visited[i] = False
                
    npn(0, 0, k)
    return answer