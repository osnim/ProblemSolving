import sys
input = sys.stdin.readline
def DFS(i, stack):
    if len(stack) == 6:
        for i in range(6):
            print(stack[i], end = ' ')
        print()
        return
    for j in range(i, n):
        stack.append(nums[j])
        DFS(j+1, stack)
        stack.pop()

while True:
    nums = list(map(int, input().split()))
    if nums[0] == 0:
        exit()
    n = int(nums[0])
    nums = nums[1:]
    DFS(0, [])
    print()