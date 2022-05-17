def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    left, right = 0, distance
    while left <= right:
        mid = (left+right)//2
        cur = 0 #현재 왼쪽 바위의 위치
        removeCnt = 0
        for rock in rocks:
            dist = rock - cur # 현재 왼쪽 바위의 위치
            if dist < mid: #제거 되는 바위
                removeCnt += 1
                continue
            else:
                cur = rock
        #남겨야 하는 바위 수
        if removeCnt > n: # 제거 되는 바위가 많거나 같다, mid값을 늘려 최대 거리 간격을 늘려서 바위를 덜 제거하기
            right = mid - 1
        else: # 제거되는 바위가 딱 적절하거나 적다, mid값을 줄여 최대 거리 간격을 줄여서 바위 더 제거
            answer = mid
            left = mid + 1
    return answer