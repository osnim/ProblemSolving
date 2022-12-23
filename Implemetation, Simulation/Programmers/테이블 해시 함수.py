def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key=lambda x: (x[col - 1], -x[0]))
    flag = False

    for r in range(row_begin - 1, row_end):
        temp = 0
        for c in data[r]:
            temp += c % (r + 1)

        if not flag:  # 처음 answer가 변하지 않은 경우
            answer = temp
            flag = True
            continue
        else:
            answer ^= temp

    return answer