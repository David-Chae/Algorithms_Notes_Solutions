#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countSwaps' function below.
#
# The function accepts INTEGER_ARRAY a as parameter.
#

def countSwaps(a):
    # Write your code here
    num_swap = 0
    i = 0
    while i < len(a):
        j = 0
        while j < len(a)-1:
            if(a[j] > a[j+1]):
                temp = a[j]
                a[j] = a[j+1]
                a[j+1] = temp
                num_swap+=1
            j+=1
        i+=1
    
    print("Array is sorted in " + str(num_swap) + " swaps.")
    print("First Element: " + str(a[0]))
    print("Last Element: " + str(a[len(a)-1]))
    

if __name__ == '__main__':
    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    countSwaps(a)
