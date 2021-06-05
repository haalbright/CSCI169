import math
def report(xs):
    numSum=0
    count=0
    output=[]
    name=0
    for x in xs:
        if isinstance(x, int):
            output.pop() #pop last name
            if name==3: #if they had a middle name
                middle=output.pop()
                first=output.pop()
                first=first+" "+middle #combine the first and middle name
                output.append(first)
            numSum+=x #add the scores up
            count+=1
            name=0 #new student so name=0
        else:
            output.append(x)
            name+=1
    output.append(numSum/count)#add the average to the list
    return (output)
    

list1=report(["Jill", "Johnson", 87, "Billy", "Ray", "Cyrus", 78, "Rita", "Yeats", 94, "Bobbie", "Sue", "Palmer", 72])
average=list1.pop() #pop the average
for x in list1:
    print(x, end=", ")
print(" averaged ",  average, ".", sep="")
