def solution(word):
    global answer
    global cnt
    cnt = 0
    answer = 0

    def dfs(s):
        global cnt
        global answer

        if word == s:
            answer = cnt
            return

        if len(s) == 6:
            return

        cnt += 1
        dfs(s + "A")
        dfs(s + "E")
        dfs(s + "I")
        dfs(s + "O")
        dfs(s + "U")

    dfs("")
    return answer