def solution(numbers):
    answer = ''
    arr = [str(x) * 3 for x in numbers]
    arr.sort(reverse=True)

    for num in arr:
        temp = num[:len(num) // 3]
        answer += temp

    answer = str(int(answer))
    return answer