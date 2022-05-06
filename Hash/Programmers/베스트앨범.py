def solution(genres, plays):
    answer = []
    dic = {}
    #장르별로 플레이와 인덱스 추가
    for i in range(len(genres)):
        # 딕셔너리도 append 가능
        if genres[i] in dic:
            dic[genres[i]].append([plays[i], i])
        else:
            dic[genres[i]] = [[plays[i], i]]

    #장르의 총합
    genTotal = {genre: 0 for genre in genres}
    for i in range(len(genres)):
        genTotal[genres[i]] += plays[i]
    # 장르의 우선순위 정하기
    sgenTotal = sorted(genTotal.items(), key=lambda x: -x[1])

    #장르 안의 곡의 우선순위 정하기
    for k in dic.keys():
        dic[k].sort(key = lambda x : -x[0])

    #장르별 앞에서 2개 또는 1개 뽑기
    for gen, total in sgenTotal:
        if len(dic[gen]) == 1:
            answer.append(dic[gen][0][1])
        else:
            answer.append(dic[gen][0][1])
            answer.append(dic[gen][1][1])

    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays))