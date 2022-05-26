import sys
# N번 원판을 start에서 dst로 옮긴다
def move(N, start, dst):
    print(start, dst)
    return

# N번의 원판을 start에서 출발하여 via를 통해 dst로 옮긴다
def hanoi(N, start, via, dst):
    if N == 1:
        move(1, start, dst)
        return

    hanoi(N - 1, start, dst, via)
    move(N, start, dst)
    hanoi(N - 1, via, start, dst)
    return

N = int(sys.stdin.readline())
K = 2**N-1
print(K)
hanoi(N, 1, 2, 3)