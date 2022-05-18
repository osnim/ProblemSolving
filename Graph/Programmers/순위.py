def solution(n, results):
    answer = 0
    arr = [[0] * (n) for i in range(n)]
    for [win, lose] in results:
        arr[win - 1][lose - 1] = 1
        arr[lose - 1][win - 1] = -1

    # 플로이드 워셜 알고리즘
    for k in range(n):  # k를 지나는 경로 모두 파악
        for i in range(n):
            for j in range(n):
                if arr[i][j] == 0:  # i, j보다 쎈지 아닌지
                    if arr[i][k] == 1 and arr[k][j] == 1:  # i가 k보다 쎄고, k가 j보다 쎄다면
                        arr[i][j] = 1  # i는 확실하게 j보다 쎔
                    if arr[i][k] == -1 and arr[k][j] == -1:  # 반대도 마찬가지
                        arr[i][j] = -1  # 확실히 약함

    for i in range(n):
        if arr[i].count(0) == 1:
            answer += 1

    return answer