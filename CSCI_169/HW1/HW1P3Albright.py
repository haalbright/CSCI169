import math

INPUT_SIZE=10

def partition(input, p, r):
    pivot=input[r]
    while p<r:
        while input[p]<pivot:
            p+=1
        while input[r]>pivot:
            r-=1
        if input[p]==input[r]:
            p+=1
        elif p<r: #swap input[p] and input[r]
            tmp=input[p]
            input[p]=input[r]
            input[r]=tmp
    return r

def quicksort(input, p, r):
    if p<r:
        j=partition(input, p, r)
        quicksort(input, p, j-1)#"split" input list
        quicksort(input, j+1, r)

input=[500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]
print("Input:", input)
quicksort(input, 0, 9)
print(input)
