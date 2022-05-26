def solution(records):
    answer = []
    dic = {}
    temp = []
    for record in records:
        if record.split()[0] == "Enter":
            op, ID, name = map(str, record.split())
            dic[ID] = name
            temp.append([ID, "IN"])
        elif record.split()[0] == "Change":
            op, ID, name = map(str, record.split())
            dic[ID] = name
        else:
            op, ID = map(str, record.split())
            temp.append([ID, "OUT"])

    for [name, IO] in temp:
        if IO == "IN":
            answer.append(f"{dic[name]}님이 들어왔습니다.")
        else:
            answer.append(f"{dic[name]}님이 나갔습니다.")
    return answer