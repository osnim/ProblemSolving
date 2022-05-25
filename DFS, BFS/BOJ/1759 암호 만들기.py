import sys

def dfs(i, stack):
    #print(alphas)
    if len(stack) == L:
        cnt = 0
        for j in range(L):
            if stack[j] in aeiou:
                cnt += 1
        #print(cnt)
        if cnt < 1 or L - cnt < 2:
            return
        print("".join(stack))
        return

    for j in range(i, C):
        stack.append(alphas[j])
        dfs(j+1, stack)
        stack.pop()
    return

input = sys.stdin.readline
L, C = map(int, input().split())
alphas = list(map(str, input().split()))
alphas.sort()
aeiou = ['a','e','i','o','u']
dfs(0, [])