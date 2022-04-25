def Spring_Summer():
    for i in range(N):
        for j in range(N):
            tlen = len(treeMap[i][j])
            for k in range(tlen):
                if treeMap[i][j][k] <= ground[i][j]:
                    ground[i][j] -= treeMap[i][j][k]
                    treeMap[i][j][k] += 1
                    if (treeMap[i][j][k]) % 5 == 0:
                        breeding.append([i, j, k])  # 겨울을 위해 미리 저장

                # 여름 한번에, 오름차순인데 앞에 나무가 죽으면 뒤에는 자동 사망
                else:
                    for l in range(k, tlen):
                        ground[i][j] += treeMap[i][j].pop()//2 # 뒤에서 부터 뺀다
                    break

def Fall():
    while breeding:
        x, y, idx = breeding.pop()
        for dx, dy in (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1):
            nx, ny = x+dx, y+dy
            if 0 <= nx < N and 0 <= ny < N:
                #trees.insert(0, [1, ny, ny])
                treeMap[nx][ny].insert(0, 1)
    return

def Winter():
    # 겨울
    for i in range(N):
        for j in range(N):
            ground[i][j] += Fertilizer[i][j]
    return

N, M, K = map(int, input().split())
ground = [[5]*N for i in range(N)]
trees = []
Fertilizer = []
breeding = []
treeMap = [[[] for _ in range(N)] for _ in range(N)]

# 겨울을 위해
for i in range(N):
    Fertilizer.append(list(map(int, input().split())))

for i in range(M):
    x, y, age = map(int, input().split())
    trees.append(list([age, x-1, y-1]))
    treeMap[x-1][y-1].append(age)

#trees.sort()

for i in range(K):
    Spring_Summer()
    if breeding:
        Fall()
    Winter()
    if not trees:
        break

ans = 0
for i in range(N):
    for j in range(N):
        ans += len(treeMap[i][j])
print(ans)