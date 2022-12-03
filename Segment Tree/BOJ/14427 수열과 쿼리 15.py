import sys
input = sys.stdin.readline
print = sys.stdout.write

class Node():
    def __init__(self, index, value):
        self.index = index
        self.value = value

def update(index, value):
    global base, N, arr, M, base, cnt, segmentTree
    p = base + index
    segmentTree[p] = Node(index, value)
    p //= 2
    while p >= 1:
        left, right = p * 2, p * 2 + 1
        # 최소값 우선 순위
        # 수열에서 크기가 가장 작은 값의 인덱스를 출력 그러한 값이 여러 개인 경우에는 인덱스가 작은 것을 출력한다.
        if segmentTree[left].value == segmentTree[right].value:
            if segmentTree[left].index < segmentTree[right].index:
                segmentTree[p] = segmentTree[left]
            else: segmentTree[p] = segmentTree[right]

        elif segmentTree[left].value < segmentTree[right].value:
            segmentTree[p] = segmentTree[left]

        else: segmentTree[p] = segmentTree[right]
        p //= 2

def insert(index, value):
    update(index, value)

def init():
    global base, N, arr, M, base, cnt, segmentTree
    # N이 6이면 base = 2^h-1 = 2^3-1 = 7
    while base < N:
        base *= 2
        cnt += base  # 세그멘트 트리의 노드 개수
    base -= 1

    for i in range(cnt+1):
        segmentTree.append(Node(i, MAX))

if __name__ == "__main__":
    global base, N, arr, M, base, cnt, segmentTree
    N = int(input())  # 수열의 크기
    arr = [0] + list(map(int, input().split()))
    M = int(input())  # 쿼리의 개수
    cnt = base = 1  # 부모 노드의 개수들
    segmentTree = []
    MAX = int(10e9)

    init()
    # 리프노드에 수열 넣기
    for i in range(1, N + 1):
        insert(i, arr[i])  # 세그멘트 트리 초기화, 배열로 구현

    for i in range(M):
        query = list(map(int, input().split()))
        if query[0] == 2:  # 수열에서 크기가 가장 작은 값의 인덱스를 출력 그러한 값이 여러개인 경우에는 인덱스가 작은 것을 출력한다.
            print(f'{segmentTree[1].index}\n')
        else:
            update(query[1], query[2])  # Ai를 v로 바꾼다
