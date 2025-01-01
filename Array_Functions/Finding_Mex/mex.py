def mex(arr):

	arr.sort()

	mex = 0
	for idx in range(len(arr)):
		if arr[idx] == mex:

			mex += 1

	return mex


if __name__ == '__main__':

	arr = [1, 0, 2, 4]

	print(mex(arr))
