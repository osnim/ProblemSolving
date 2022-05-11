def solution(routes):
    answer = 0
    routes.sort(key = lambda x : x[1])
    lastCameraPosition = -30001
    #cnt = 0
    for IN, OUT in routes:
        #print(lastCameraPosition)
        if lastCameraPosition >= IN:
            continue
        else:
            lastCameraPosition = OUT
            answer += 1
    #print(answer)
    return answer

solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]])