while True:
    string = input()
    if string == ".":
        break
    temp = []
    check = 0
    for s in string:
        if not temp:
            if s == ")" or s == "]":
                print("no")
                check = 1
                break
            elif s == "(" or s == "[":
                temp.append(s)
        else:
            if s == "(":
                if temp[-1] == ")":
                    temp.pop()
                else:
                    temp.append(s)
            elif s == "[":
                if temp[-1] == "]":
                    temp.pop()
                else:
                    temp.append(s)
            elif s == ")":
                if temp[-1] == "(":
                    temp.pop()
                else:
                    print("no")
                    check = 1
                    break
            elif s == "]":
                if temp[-1] == "[":
                    temp.pop()
                else:
                    print("no")
                    check = 1
                    break
    if not check:
        if temp:
            print("no")
        else:
            print("yes")
