def solution(numbers, target):
    global answer
    answer = 0
    n = len(numbers)
    cnt = 0
    def dfs(i, num):
        if i < n:
            dfs(i+1, num+numbers[i])
            dfs(i+1, num-numbers[i])
        else:
            if num == target:
                global answer
                answer += 1
            return
    dfs(0,0)
    return answer

from collections import deque

def solution(numbers, target):
    answer = 0
    n = len(numbers)
    q = deque([])
    q.append([numbers[0],0])
    q.append([-numbers[0],0])
    while q:
        num, idx = q.popleft()
        idx += 1
        if idx < n:
            q.append([num+numbers[idx],idx])
            q.append([num-numbers[idx],idx])
        else:
            if num == target:
                answer += 1
    return answer