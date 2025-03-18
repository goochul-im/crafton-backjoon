import sys

N = int(sys.stdin.readline())
task = []
task.extend([None] * 10001)

for i in range(N):
    line = int(sys.stdin.readline())
    if task[line] is None:
        task[line] = 1
    else:
        task[line] += 1

task = [[index, val] for index, val in enumerate(task) if val is not None]

for index, val in task:
    for e in range(val):
        sys.stdout.write(f"{index}\n")

