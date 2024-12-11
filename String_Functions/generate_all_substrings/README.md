An algorithm to generate all the substrings of a given string
has been implemented in C++, Java & Python.

The Algorithm uses a two pointer approach to generate all the substrings in the following manner ->

1 2 3 4 5
a b c d e

pointers->
i loops over 1 to n
j loops over i to n

1 2 3 4 5  1 2 3 4 5  1 2 3 4 5  & so on...
a b c d e  a b c d e  a b c d e
i          i          i
j            j            j

giving the sequence as ->

a
ab
abc
abcd
abcde
b
bc
bcd
bcde
c
cd
cde
d
de
e