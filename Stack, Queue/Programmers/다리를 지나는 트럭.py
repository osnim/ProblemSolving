from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    trucks = deque(truck_weights)
    onBrigde = deque([])
    total = 0
    w = 0
    while trucks or onBrigde:
        if onBrigde:
            if onBrigde[0][1] >= bridge_length:
                tempw, temps = onBrigde.popleft()
                total -= tempw
            for i in range(len(onBrigde)):
                onBrigde[i][1] += 1

        if trucks:
            if total + trucks[0] <= weight:
                w = trucks.popleft()
                onBrigde.append([w, 1])
                total += w

        answer += 1
        print(onBrigde, answer)

if __name__ == "__main__":
    arr = [[2, 10, [7, 4, 5, 6]], [100, 100, [10]], [100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]]]
    for b, w, truck in arr:
        solution(b, w, truck)