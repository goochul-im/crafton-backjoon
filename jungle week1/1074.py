import sys

N, r, c = map(int, sys.stdin.readline().split())

count = 0


def find(x, y, size):
    global count

    if size == 0:
        print(count)
        return

    size //= 2

    if x + size > c and y + size > r:
        # 좌상단
        find(x, y, size)
    elif x + size <= c and y + size > r:
        # 우상단
        count += (size ** 2)
        find(x + size, y, size)
    elif x + size > c and y + size <= r:
        # 좌하단
        count += ((size ** 2) * 2)
        find(x, y + size, size)
    else:
        # 우하단
        count += ((size ** 2) * 3)
        find(x + size, y + size, size)


find(0, 0, 2 ** N)
