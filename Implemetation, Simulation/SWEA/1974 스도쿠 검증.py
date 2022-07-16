for T in range(int(input())):
    arr = []
    for i in range(9):
        arr.append(list(map(int, input().split())))

    def sol():
        for i in range(9):
            check = [0] * 10
            for j in range(9):
                if check[arr[i][j]]:
                    print(f"#{T + 1} {0}")
                    return
                check[arr[i][j]] = 1

        for i in range(9):
            check = [0] * 10
            for j in range(9):
                if check[arr[j][i]]:
                    print(f"#{T + 1} {0}")
                    return
                check[arr[j][i]] = 1

        for i in range(0, 7, 3):
            for j in range(0, 7, 3):
                check = [0] * 10
                for x in range(3):
                    for y in range(3):
                        if check[arr[i + x][j + y]]:
                            print(f"#{T + 1} {0}")
                            return
                        check[arr[i + x][j + y]] = 1

        print(f"#{T + 1} {1}")
        return

    sol()
