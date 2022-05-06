from collections import deque
def solution(progresses, speeds):
    answer = []
    proQ = deque(progresses)
    spdQ = deque(speeds)
    while proQ:
        while proQ[0] < 100:
            for i in range(len(proQ)):
                proQ[i] = proQ[i] + spdQ[i]
        cnt = 0
        while proQ:
            if proQ[0] >= 100:
                cnt += 1
                proQ.popleft()
                spdQ.popleft()
            else:
                break
        answer.append(cnt)
    print(answer)
    return answer

if __name__ == "__main__":
    arr = [[[99,97,95,93], [1,2,3,4]], [[95,95,95,95], [4,3,2,1]], [[55,60,65], [5, 10, 7]],[[95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]], [[93, 30, 55], [1, 30, 5]], [[10, 10, 10, 10, 10, 10, 10, 10, 10, 10], [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]]]
    for progresses, speeds in arr:
        solution(progresses, speeds)


