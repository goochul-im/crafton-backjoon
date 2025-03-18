import sys

N = int(sys.stdin.readline())

count = 0
cols = set()
di_1 = set()  # 첫번째 대각선
di_2 = set()  # 두번째 대각선


def N_QUEEN(row):
    global count
    if row == N:
        count += 1
        return

    for col in range(N):
        if col in cols or (row - col) in di_1 or (row + col) in di_2:  # 같은 행에 있거나 같은 대각선에 있거나
            continue  # 스킵

        cols.add(col)
        di_1.add(row - col)
        di_2.add(row + col)

        N_QUEEN(row + 1)

        cols.remove(col)
        di_1.remove(row - col)
        di_2.remove(row + col)


N_QUEEN(0)

print(count)
