# A = 65
# Z = 90

def solution(name):
    answer = 0
    nameSize = len(name)
    maxShift = nameSize-1 #좌우 이동 횟수 초기 값

    for i in range(nameSize):
        alpha = name[i]
        answer += min(ord(alpha) - ord("A"), ord("Z") - ord(alpha) + 1)

        nextIdx = i+1
        while nextIdx < nameSize and name[nextIdx] == "A":
            nextIdx += 1 # 연속된 A 지나가기

                    # 1.이전 최소 값 or
                    # 2.연속된 A 왼쪽부터 시작 > 연속된 A 오른쪽 끝
                    # 3.연속된 A 오른쪽부터 시작 > 연속된 A 왼쪽에서 끝
        maxShift = min(maxShift, 
                       i + i + (nameSize - nextIdx),
                       (nameSize-nextIdx)*2 + i)

    return answer + maxShift