def solution(storey):
    global answer
    arr = list(map(int, str(storey)))
    answer = sum(arr)
    n = len(arr)
    def dfs(depth, tot, storey):
        global answer
        if n == depth:
            answer = min(answer, tot+storey)
            return

        remainder = storey % 10
        quotient = storey // 10

        dfs(depth + 1, tot + 10 - remainder, quotient + 1)  # 1. 먼저 증가한 경우
        dfs(depth + 1, tot + remainder, quotient)

    dfs(0, 0, storey)
    return answer
