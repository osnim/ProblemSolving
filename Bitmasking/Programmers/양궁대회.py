def solution(n, info):
    answer = [0] * 11
    arr = [0] * 11  # 라이언이 쏜 화살의 개수
    maxDiff = 0
    # 10개의 원소를 가진 부분 집합의 개수
    # 0은 공집합이라서 필요없음
    for subset in range(1, 1 << 10):
        ryan = 0  # 부분집합에서 점수 계산
        peach = 0
        cnt = 0  # 화살을 과녁에 쏜 수

        for i in range(10):
            if subset & (1 << i):  # subset에 i번째 인덱스에 1이 존재하는지
                ryan += 10 - i
                arr[i] = info[i] + 1
                cnt += arr[i]
            else:
                arr[i] = 0
                if info[i]:  # 어피치만 화살을 맞춘 경우
                    peach += 10 - i

        if cnt > n: continue  # 화살을 많이 날린 경우

        # 남은 화살 0점에 모두 넣기
        arr[10] = n - cnt

        if ryan - peach == maxDiff:
            # 가장 낮은 점수를 많이 맞춘 경우인지 확인
            for j in reversed(range(11)):
                if arr[j] > answer[j]:
                    maxDiff = ryan - peach
                    answer = arr[:]
                    break
                elif arr[j] < answer[j]:
                    break

        elif ryan - peach > maxDiff:
            maxDiff = ryan - peach
            answer = arr[:]

    # 라이언이 이기는 경우가 없는 경우
    if maxDiff == 0:
        answer = [-1]
    return answer