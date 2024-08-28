from sys import stdin


n = int(stdin.readline())


def solution(row):
    global ans
    
    if row == n:
        ans += 1
        return 
    
    for i in range(n):
        if promising(row, i): # 현재 둘 행(row), 열(i)이 유망한지 확인
            arr[row] = i
            checked[i] = True
         #   print(row, i, arr)
            solution(row + 1)
            arr[row] = -1
            checked[i] = False
    
def promising(row, col): 
    if checked[col]:
        return False
        
    for i in range(row):
        #print("[", row, "]", i, col, arr[i]==col, abs(i-row), abs(col-arr[i]))
        if arr[i] == col:   # 이전 행에서 같은 세로줄에 있는지 확인
            return False
        if abs(i-row) == abs(col-arr[i]): # 이전 행의 퀸들에서 대각선에 위치하는지 확인
            return False
    return True
    
    
    
ans = 0
arr = [-1] * n
checked = [False] * n
solution(0)
    
print(ans)