def solution(brown, yellow):
    answer = []
    # m : 노란 카펫의 가로
    # n : 노란 카펫의 세로
    for m in range(1, yellow+1):
        if yellow%m == 0:
            n = yellow//m
            if (m+2)*(n+2) == brown + yellow:
                answer.append(max((m+2), (n+2)))
                answer.append(min((m+2), (n+2)))
                break
    return answer