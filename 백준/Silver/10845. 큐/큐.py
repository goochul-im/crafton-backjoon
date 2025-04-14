# 10845 큐

import sys
from collections import deque

N = int(sys.stdin.readline())
command_list = []
for _ in range(N):
    command_list.append(sys.stdin.readline().strip())

Q = deque()


def execution_command(command: str):
    global Q
    spl = command.split()
    if len(spl) == 2:
        Q.append(spl[1])
    else:
        if command == "front":
            if len(Q) == 0:
                print(-1)
            else:
                print(Q[0])
        elif command == "back":
            if len(Q) == 0:
                print(-1)
            else:
                print(Q[-1])
        elif command == "pop":
            if len(Q) == 0:
                print(-1)
            else:
                print(Q.popleft())
        elif command == "size":
            print(len(Q))
        else:
            if len(Q) == 0:
                print(1)
            else:
                print(0)


for com in command_list:
    execution_command(com)
