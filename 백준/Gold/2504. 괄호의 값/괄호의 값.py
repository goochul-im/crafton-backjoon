# 2504 괄호의 값
import sys

prob = sys.stdin.readline().strip()

stack = []


def find():
    for char in prob:
        if char == '(' or char == '[':  # 얘들은 그냥 추가
            stack.append(char)
        elif char == ')':  # ')' 를 넣어야 할 때
            if not stack:
                print(0)
                return
            if isinstance(stack[-1], int):  # 숫자랑 만났을 때
                num = stack.pop()  # 숫자 먼저 꺼내고
                if not stack or stack.pop() != '(':  # 올바른 괄호가 아니면
                    print(0)
                    return
                stack.append(num * 2)
            else:  # 괄호랑 만나면
                if stack.pop() != '(':  # 올바른 괄호가 아니면
                    print(0)
                    return
                stack.append(2)
            if len(stack) > 1 and isinstance(stack[-2], int):
                stack.append(stack.pop() + stack.pop())
        else:  # ']' 를 넣어야 할 때
            if not stack:
                print(0)
                return
            if isinstance(stack[-1], int):  # 숫자랑 만났을 때
                num = stack.pop()  # 숫자 먼저 꺼내고
                if not stack or stack.pop() != '[':  # 올바른 괄호가 아니면
                    print(0)
                    return
                stack.append(num * 3)
            else:  # 괄호랑 만나면
                if stack.pop() != '[':  # 올바른 괄호가 아니면
                    print(0)
                    return
                stack.append(3)
            if len(stack) > 1 and isinstance(stack[-2], int):
                stack.append(stack.pop() + stack.pop())
    if len(stack) == 1 and isinstance(stack[0], int):  # 정상적인 경우
        print(stack[0])
    else:
        print(0)  # 🚨 스택에 괄호가 남아있으면 0 출력


find()
