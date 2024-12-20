def get_factors(n):
    ans=[]
    root = int(n**(1/2))
    for i in range(1,root+1):
        if n%i==0: 
            ans.append(i) #appending all factors <= root into a list
            if (i != (n//i)):
                ans.append(n//i) #appending the corresponding factors which are greater than root(n)
    return ans

if __name__ == "__main__":
    print(get_factors(4)) # sample input 1
    print(get_factors(20)) # sample input 2
