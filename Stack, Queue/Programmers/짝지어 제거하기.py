def solution(s):
    answer = -1
    stack = []
    for a in s:
        if not stack:
            stack.append(a)
            continue
        if stack[-1] == a:
            stack.pop()
        else:
            stack.append(a)
    if stack:
        return 0
    else:
        return 1