def solution(t, p):
    answer = 0
    tSize = len(t)
    start, end = 0, len(p) - 1
    while end < tSize:
        temp = t[start:end + 1]
        if temp <= p:
            answer += 1

        start += 1
        end += 1

    return answer