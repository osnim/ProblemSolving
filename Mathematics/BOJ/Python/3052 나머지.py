arr = [0]*42
for i in range(10):
    arr[int(input()) % 42] = 1
print(sum(arr))