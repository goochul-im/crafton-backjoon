import sys

n = int(sys.stdin.readline())


def is_hansu(number):
    if number < 100:
        return True

    task = str(number)

    mul = int(task[0]) - int(task[1])
    for i in range(1, len(task) - 1):
        if int(task[i]) - int(task[i + 1]) != mul:
            return False
    return True


print(sum(1 for i in range(1, n + 1) if is_hansu(i)))
