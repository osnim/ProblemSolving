from collections import deque
def solution(progresses, speeds):
    answer = []
    proQ = deque(progresses)
    spdQ = deque(speeds)
    while proQ:
        per = proQ.popleft()
        speed = spdQ.popleft()
        #day = speed * (100 - per)
        day = 0
        while per < 100:
            per += speed
            day += 1

        cnt = 0  # 큐 첫번째 이후
        #모두 더하고
        for i in range(len(proQ)):
            proQ[i] += (day * spdQ[i])
        # 그 다음 앞에서 부터 100 넘은거 연속적인 뺴기
        for i in range(len(proQ)):
            if proQ[i] >= 100:
                cnt += 1
            else:
                break

        for i in range(cnt):
            proQ.popleft()
            spdQ.popleft()
        answer.append(cnt + 1)

    #print(answer)
    return answer

if __name__ == "__main__":
    arr = [[[99,97,95,93], [1,2,3,4]], [[95,95,95,95], [4,3,2,1]], [[55,60,65], [5, 10, 7]],[[95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]], [[93, 30, 55], [1, 30, 5]], [[10, 10, 10, 10, 10, 10, 10, 10, 10, 10], [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]]]
    for progresses, speeds in arr:
        solution(progresses, speeds)


