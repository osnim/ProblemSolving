N = int(input())
temp = N
for i in range(2, N+1):
    while temp > 1:
        if temp % i == 0:
            temp = temp // i
            print(i)
        else:
            break
    if temp == 1:
        break
