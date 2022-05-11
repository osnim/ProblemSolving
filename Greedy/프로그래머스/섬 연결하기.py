def solution(n, costs):
    answer = 0
    visited = set([costs[0][0]])
    costs.sort(key=lambda x: (x[2], x[0], x[1]))

    while len(visited) < n:
        for start, end, cost in costs:
            if start in visited and end in visited:
                continue
            if start in visited or end in visited:
                answer += cost
                visited.update([start, end])
                break
    return answer