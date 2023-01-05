from math import gcd

def solution(arrayA, arrayB):
    answer = 0

    def getGCD(arr):
        g = arr[0]
        for num in arr:
            g = gcd(g, num)
        return g

    def checkOpponent(divisor, array):
        for num in array:
            if num % divisor == 0:
                return False
        return True

    # 배열의 최대공약수 찾기
    gcd_A, gcd_B = getGCD(arrayA), getGCD(arrayB)

    if checkOpponent(gcd_A, arrayB):  # 상대가 모두 안 나누어 지는지 체크
        answer = max(gcd_A, answer)
    if checkOpponent(gcd_B, arrayA):  # 상대가 모두 안 나누어 지는지 체크
        answer = max(gcd_B, answer)

    return answer