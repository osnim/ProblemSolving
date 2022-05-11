def solution(n, lost, reserve):
    answer = 0
    reserve.sort()
    temp = reserve[:]

    for i in reserve:
        if i in lost:
            lost.remove(i)
            temp.remove(i)
    reserve = temp[:]
    for i in reserve:
        if lost:
            if i - 1 in lost:
                lost.remove(i - 1)
            elif i + 1 in lost:
                lost.remove(i + 1)
        else:
            break
    answer = n - len(lost)
    return answer