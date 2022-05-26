def solution(s):
    answer = len(s)
    temp = list(s)
    n = len(s)
    for i in range(1, n//2+1):
        start = 0
        end = start + i
        cnt = 1
        string = ""
        while start < n:
            if temp[start:end] == temp[end:end+i]:
                cnt += 1
            else:
                if cnt > 1:
                    string += str(cnt) + "".join(temp[start:end])
                    cnt = 1
                else: string += "".join(temp[start:end])
            start = end
            end = start + i
        answer = min(answer, len(string))
    return answer