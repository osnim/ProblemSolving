def check(arr):
    l = len(arr)
    for i in range(l-1):
        if arr[i] == arr[i+1][:len(arr[i])]:
            print("NO")
            return
    print("YES")
    return

for _ in range(int(input())):
    arr = []
    for _ in range(int(input())):
        arr.append(input())
    arr.sort()
    check(arr)