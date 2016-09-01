Need to pay attention
_371_SumOfTwoIntegers
_260_SingleNumberIII:
    care about the negative integer. Use diff &= -diff to get the rightmost different bit

_287_
    double cycle linked list
_309_
_326_ (as long as the range is known, there is a tricky way to solve problem)
_44_ should use dp
335
32


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

_216_
    dizzy, basic dfs

208 trie

188 need to consider some accelerate case
Need optimization:
104
237
52 classical n queen. used bit operation, and need while - stack, reverse optimization
212
174