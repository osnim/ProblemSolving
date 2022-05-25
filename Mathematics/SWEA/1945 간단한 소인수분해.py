T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
divider = [2, 3, 5, 7, 11]
for test_case in range(1, T + 1):
    n = int(input().strip())
    temp = [0, 0, 0, 0, 0]
    for i in range(5):
        cnt = 0
        while True:
            if n % divider[i] != 0:
                temp[i] = str(cnt)
                break
            n //= divider[i]
            cnt += 1
    print(f"#{test_case} {' '.join(temp)}")