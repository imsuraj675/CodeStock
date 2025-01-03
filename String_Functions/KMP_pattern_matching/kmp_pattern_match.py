def get_lps(pattern):
    len_lps = 0
    lps = [0] * len(pattern)

    i = 1
    while i < len(pattern):
        if pattern[i] == pattern[len_lps]:     #characters match, increase len 
            len_lps += 1
            lps[i] = len_lps
            i += 1
        else:
            if len_lps != 0:
                len_lps = lps[len_lps - 1]
            else:
                lps[i] = 0      #couldn't find a prefix that is also suffix, move forward
                i += 1
    return lps

def search(text, pattern):
    n = len(text)
    m = len(pattern)

    ans = []
    if m > n:           #pattern larger than text, no match can be found. return empty list.
        return ans

    lps = get_lps(pattern)

    i = 0
    j = 0

    while i < n:
        if text[i] == pattern[j]:
            i += 1
            j += 1
            if j == m:              #match found
                ans.append(i - m)   #add starting index to list
                j = lps[j - 1]      #adjust j to start finding next match
        else:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
    return ans

if __name__ == "__main__":
    
    text = "ababacabab"
    pattern = "aba"

    ans = search(text, pattern)
    for idx in ans:
        print(idx, end=" ")