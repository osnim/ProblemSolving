zero = [1, 0, 1]
one = [0, 1, 1]

for T in range(int(input())):
    N = int(input())
    temp = len(zero)
    if N < temp:
        print(zero[N], one[N])
        continue

    for i in range(temp, N+1):
        zero.append(zero[i-1]+zero[i-2])
        one.append(one[i-1]+one[i-2])
    print(zero[N], one[N])
