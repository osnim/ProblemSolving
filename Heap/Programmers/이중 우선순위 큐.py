import heapq as hq


def solution(operations):
    answer = []
    q = []
    while operations:
        cmd, data = operations.pop(0).split()
        if cmd == "I":
            hq.heappush(q, int(data))
        else:
            if q:
                if cmd == "D" and data == "1":
                    MAX = max(q)
                    q.remove(MAX)

                elif cmd == "D" and data == "-1":
                    hq.heappop(q)

    if q:
        answer.append(max(q))
        answer.append(hq.heappop(q))
    else:
        answer = [0,0]
    print(answer)
    return answer

#solution(["I 7","I 5","I -5","D -1"])
solution(["I 16","D 1"])