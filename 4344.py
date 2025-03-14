import sys

prob = sys.stdin.read().splitlines()[1:]
for task in prob:
    student = list(map(int, task.split()[1:]))
    avg = sum(student)/len(student)
    number_of_better = sum(1 for x in student if x > avg)
    print(f"{number_of_better/len(student)*100:.3f}%")


