def solution(number, k):
    answer = ''
    arr = list(number)
    cnt = len(number) - k
    # 최고 앞자리의 idx
    idx = 0
    # 앞자리부터 k번째 인덱스까지 중 최댓값
    MAX = 0
    start = 0
    while k > 0 and cnt > 0:
        for i in range(start, start + k + 1):
            if int(arr[i]) > int(MAX):
                idx = i
                MAX = arr[i]
                if MAX == "9":
                    break

        k -= (idx - start)
        answer += str(MAX)
        start = idx + 1
        MAX = 0
        cnt -= 1
    if cnt > 0:
        answer += "".join(arr[idx + 1:])

    return answer