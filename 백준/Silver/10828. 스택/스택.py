# 10828 스택
import sys

N = int(sys.stdin.readline())
command_list = []
for _ in range(N):
    command_list.append(sys.stdin.readline().strip())

stack = []


def execution_command(command: str):
    spl = command.split()
    if len(spl) == 2:
        stack.append(spl[1])
    else:
        if command == "top":
            if len(stack) == 0:
                print(-1)
            else:
                print(stack[len(stack) - 1])
        elif command == "pop":
            if len(stack) == 0:
                print(-1)
            else:
                print(stack.pop())
        elif command == "size":
            print(len(stack))
        else:
            if len(stack) == 0:
                print(1)
            else:
                print(0)


for com in command_list:
    execution_command(com)
