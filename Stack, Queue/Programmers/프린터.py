from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque(priorities)
    idx = deque([i for i in range(len(q))])
    cnt = 1

    while q:
        M = max(q)
        pri = q.popleft()
        i = idx.popleft()

        if pri != M:
            q.append(pri)
            idx.append(i)
        else:
            if i == location:
                answer = cnt
                break
            cnt += 1

        answer = cnt
    return answer