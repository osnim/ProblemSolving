import sys
def pseudoCheck(string, left, right):
    while left < right:
        if string[left] != string[right]:
            return 2
        else:
            left += 1
            right -= 1
    return 1

def solve():
    string = input().strip()
    left = 0
    right = len(string)-1
    # 만약 left > right : 이는 회문
    while left < right:
        if string[left] != string[right]:
            if pseudoCheck(string, left + 1, right) == 2:
                if pseudoCheck(string, left, right-1) == 2:
                    return 2
                else:
                    return 1
            else:
                return 1
        else:
            left += 1
            right -= 1
    return 0
if __name__ =="__main__":
    input = sys.stdin.readline
    N = int(input())
    for i in range(N):
        print(solve())
