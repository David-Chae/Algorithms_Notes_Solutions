#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'sherlockAndAnagrams' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

def sherlockAndAnagrams(s):
    # Write your code here
    freq = {}
    i = 0;
    while(i < len(s)):
        j = i+1
        while(j < len(s)+1):
            unsorted = s[i:j]
            sorted_list = sorted(unsorted)
            key = ''.join(sorted_list)
            if(key in freq):
                freq[key]+=1
            else:
                freq[key]=1
            j+=1
        i+=1
    
    res = 0
        
    for key, value in freq.items():
        if(value > 1):
           num = value
           while(num > 1):
                res += num-1
                num-=1 
    
    return res
           

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
