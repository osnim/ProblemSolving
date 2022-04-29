def prime(num):
    temp = int((num) ** (0.5))
    for i in range(2, temp+1):
        if num % i == 0:
            return False
    return True

def solve():
    M = int(input())
    N = int(input())
    ans = []
    for i in range(M, N + 1):
        if i == 1:
            continue
        if prime(i):
            ans.append(i)

    if not ans:
        print(-1)
        return
    else:
        print(sum(ans))
        print(ans[0])
        return

if __name__ == "__main__":
    solve()