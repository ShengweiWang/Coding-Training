Need to pay attention
_371_SumOfTwoIntegers
_260_SingleNumberIII:
    care about the negative integer. Use diff &= -diff to get the rightmost different bit
Hint used
_258_AddDigits

Debugging Hints
_167_TwoSumII_InputArrayIsSorted
    binary search
    shift precedence is lower than + : mid = l + ((r - l) >>1);
_238_
    int[] b = a.clone(); it will clone the content in the array. not suitable for high dimension, because in high dimension, each array will store a pointer
_347_
    List<Integer>[] bucket = new List[123];
    res.addAll(bucket[i]);

_217_
    set.add will avoid duplicate. And set.contains() will take a lot of time

_94_
    usually, even the result is empty, we should return an empty result rather than null

Need optimization:
104
237

