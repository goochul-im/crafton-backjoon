import sys

prob = sys.stdin.read().splitlines()[1:]

for line in prob:
    n = int(line.split()[0])
    message = ""
    for char in line.split()[1]:
        message += char * n
    print(message)

