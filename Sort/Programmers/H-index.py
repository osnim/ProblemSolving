def solution(citations):
    answer = 0
    MAX = max(citations)
    n = len(citations)
    citations.sort()
    for h in range(0, MAX+1):
        #i = 0
        for i in range(n):
            # h 이상의 인용 값 찾기
            if citations[i] < h:
                #i += 1
                continue

            # 찾았다면
            else:
                # h 이상의 인용 수가
                if h <= len(citations[i:]):
                #if h <= n-i:

                    if len(citations[:i]) <= h:
                    #if i+1 <= h:
                        answer = h
                        break
                else:
                    return answer
    return answer

if __name__ == "__main__":
    arr = [3, 0, 6, 1, 5]
    solution(arr)