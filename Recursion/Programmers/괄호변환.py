def solution(p):
    answer = ''
    if not p: return ""
    cnt = 0 # 괄호의 짝을 체크
    start = 0 #균형 잡힌 문자열 시작
    for i in range(len(p)):
        if p[i] == "(":
            cnt += 1
        else:
            cnt -= 1

        if cnt == 0: #균형 잡혔거나 올바른 문자열인 경우
            u = p[start:i + 1]
            v = ""
            if i - 1 < len(p):
                v = p[i + 1:]

            if u[0] == "(":  # 올바른 문자열
                u = p[start:i + 1]
                answer += u
                answer += solution(v) #v 넣기
                return answer

            # 균형잡힌 문자열을 올바른 문자열로 변경하는 과정
            else:
                answer += "("
                answer += solution(v)
                answer += ")"
                for j in range(1, len(u) - 1):
                    if u[j] == "(":
                        answer += ")"
                    else:
                        answer += "("
                return answer
    return answer