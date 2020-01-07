





















































































Frog-Jmp

        A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

        Count the minimal number of jumps that the small frog must perform to reach its target.

        Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

        For example, given:
        X = 10

        Y = 85

        D = 30

        the function should return 3, because the frog will be positioned as follows:

        after the first jump, at position 10 + 30 = 40
        after the second jump, at position 10 + 30 + 30 = 70
        after the third jump, at position 10 + 30 + 30 + 30 = 100


        Write an efficient algorithm for the following assumptions:

        X, Y and D are integers within the range [1..1,000,000,000];
        X ≤ Y.





// you can also use imports, for example:

        import java.math.*;



// you can use System.out.println for debugging purposes, e.g.

// System.out.println("this is a debug message");



class Solution {

    public int solution(int X, int Y, int D) {

        long distance = Math.abs(Y) - Math.abs(X);

        return  (int) Math.ceil(distance/(double) D);

    }

}


Perm-Missing-Elem

        An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

        Your goal is to find that missing element.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

        For example, given array A such that:
        A[0] = 2

        A[1] = 3

        A[2] = 1

        A[3] = 5

        the function should return 4, as it is the missing element.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        the elements of A are all distinct;
        each element of array A is an integer within the range [1..(N + 1)].



        import java.util.*;
class Solution {
    public int solution(int[] A) {
        Arrays.sort( A );
        for(int i=0;i if (A[i]!=i+1) return i+1;
    }
return A.length+1;
}
}
        Tape-Equilibrium

        A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

        Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

        The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

        In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

        For example, consider array A such that:
        A[0] = 3

        A[1] = 1

        A[2] = 2

        A[3] = 4

        A[4] = 3

        We can split this tape in four places:

        P = 1, difference = |3 − 10| = 7

        P = 2, difference = |4 − 9| = 5

        P = 3, difference = |6 − 7| = 1

        P = 4, difference = |10 − 3| = 7



        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

        For example, given:
        A[0] = 3

        A[1] = 1

        A[2] = 2

        A[3] = 4

        A[4] = 3

        the function should return 1, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−1,000..1,000].


class Solution {
    public int solution(int[] A) {
        int minimum = A.length*1000;
        int head = 0;
        int tail = 0;
        for (int i = 0; i for(int i = 0; i head+= A[i];
        tail-= A[i];
        if (minimum>Math.abs(head-tail)) minimum = Math.abs(head-tail);
    }
return minimum;
}
}
        Perm-Check

        A non-empty array A consisting of N integers is given.

        A permutation is a sequence containing each element from 1 to N once, and only once.

        For example, array A such that:
        A[0] = 4

        A[1] = 1

        A[2] = 3

        A[3] = 2

        is a permutation, but array A such that:
        A[0] = 4

        A[1] = 1

        A[2] = 3

        is not a permutation, because value 2 is missing.

        The goal is to check whether array A is a permutation.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

        For example, given array A such that:
        A[0] = 4

        A[1] = 1

        A[2] = 3

        A[3] = 2

        the function should return 1.

        Given array A such that:
        A[0] = 4

        A[1] = 1

        A[2] = 3

        the function should return 0.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [1..1,000,000,000].


class Solution {
    public static int solution(int[] A) {
        int[] counter = new int [A.length];
        for(int i= 0; i< A.length; i++){
            if (A[i] < 1 || A[i] > A.length) {
// Out of range
                return 0;
            }
            else if(counter[A[i]-1] == 1) {
// met before
                return 0;
            }
            else {
// first time meet
                counter[A[i]-1] = 1;
            }
        }
        return 1;
    }
}

/**
 * https://codility.com/demo/results/demoYEU94K-8FU/ 100
 */
public class PermCheck {
    public static final int NOT_PERMUTATION = 0;
    public static final int PERMUTATION = 1;
    // (4,1,3,2) = 1
// (4,1,3) = 0
// (1) = 1
// () = 1
// (2) = 0
    public int solution(int[] A) {
// write your code in Java SE 8
        int[] mark = new int[A.length + 1];
        int counter = 0;
        for (int i = 0; i < A.length; ++i) {
            int value = A[i];
            if(value >= mark.length) {
                return NOT_PERMUTATION;
            }
            if(mark[value] == 0) {
                mark[value]=1;
                ++counter;
            } else {
                return NOT_PERMUTATION;
            }
        }
        return counter == A.length ? PERMUTATION : NOT_PERMUTATION;
    }
}

Frog-River-One

        A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

        You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

        The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

        For example, you are given integer X = 5 and array A such that:
        A[0] = 1

        A[1] = 3

        A[2] = 1

        A[3] = 4

        A[4] = 2

        A[5] = 3

        A[6] = 5

        A[7] = 4

        In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

        Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

        If the frog is never able to jump to the other side of the river, the function should return −1.

        For example, given X = 5 and array A such that:
        A[0] = 1

        A[1] = 3

        A[2] = 1

        A[3] = 4

        A[4] = 2

        A[5] = 3

        A[6] = 5

        A[7] = 4

        the function should return 6, as explained above.

        Write an efficient algorithm for the following assumptions:

        N and X are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..X].



        import java.util.*;
class Solution {
    public int solution(int X, int[] A) {
        HashSet container = new HashSet();
        for (int i = 0; i < A.length; i++){
            if (A[i] >= 1 && A[i] <= X){
                container.add(A[i]);
            }
            if (container.size() == X)
                return i;
        }
        return -1;
    }
}

Max-Counters

        You are given N counters, initially set to 0, and you have two possible operations on them:

        increase(X) − counter X is increased by 1,
        max counter − all counters are set to the maximum value of any counter.


        A non-empty array A of M integers is given. This array represents consecutive operations:

        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        if A[K] = N + 1 then operation K is max counter.


        For example, given integer N = 5 and array A such that:
        A[0] = 3

        A[1] = 4

        A[2] = 4

        A[3] = 6

        A[4] = 1

        A[5] = 4

        A[6] = 4

        the values of the counters after each consecutive operation will be:
        (0, 0, 1, 0, 0)

        (0, 0, 1, 1, 0)

        (0, 0, 1, 2, 0)

        (2, 2, 2, 2, 2)

        (3, 2, 2, 2, 2)

        (3, 2, 2, 3, 2)

        (3, 2, 2, 4, 2)

        The goal is to calculate the value of every counter after all operations.

        Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

        Result array should be returned as an array of integers.

        For example, given:
        A[0] = 3

        A[1] = 4

        A[2] = 4

        A[3] = 6

        A[4] = 1

        A[5] = 4

        A[6] = 4

        the function should return [3, 2, 2, 4, 2], as explained above.

        Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..N + 1].


class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int absMax = 0;
        for (int i=0; i if (A[i] == N+1) {
            if ((i < A.length-1 && A[i+1] != N+1) || (i==A.length-1)) {
                absMax += max;
                max = 0;
                counters = new int[N];
            }
        } else {
            counters[A[i]-1]++;
            if (max < counters[A[i]-1])
                max = counters[A[i]-1];
        }
    }
for (int i=0; i counters[i] += absMax;
return counters;
}
}
        Missing-Integer

        This is a demo task.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].




public int solution(int[] A) {
        HashSet positives = new HashSet<>(); // to add just positives
        int max = 1, length = A.length;
        for (int i =0; i < length; ++i) {
        int current = A[i];
        if (current < 0 ) {
        continue;
        } else {
        positives.add(current);
        if( max <= current) {
        max = current;
        }
        }
        }
        max = Math.max(max, length); // taking into account arrays with random elements
        for(int i = 1; i <= max ; ++i) {
        if(!positives.contains(i)) {
        return i;
        }
        }
        return length + 1; // array is complete
        }


class Solution {
    public int solution(int[] A) {
// write your code in Java SE 8
        boolean[] B = new boolean[A.length];
        int i =0;
        for(i=0; i if((A[i]>0) && (A[i]<=A.length) && (B[A[i]-1] == false))
            B[A[i]-1] = true;
    }
for(i=0; i< B.length;i++){
        if(B[i]==false)
            return i+1;
    }
if(i==B.length)
            return i+1;
else
        return 1;
}
}

        Passing-Cars

        A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

        Array A contains only 0s and/or 1s:

        0 represents a car traveling east,
        1 represents a car traveling west.


        The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

        For example, consider array A such that:
        A[0] = 0

        A[1] = 1

        A[2] = 0

        A[3] = 1

        A[4] = 1

        We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

        The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

        For example, given:
        A[0] = 0

        A[1] = 1

        A[2] = 0

        A[3] = 1

        A[4] = 1

        the function should return 5, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer that can have one of the following values: 0, 1.


public int solution(int[] A) {
        int total = 0;
        int unoCounter = 0;
        for (int i = A.length - 1; i >= 0; i--) {
        if (A[i] == 1) {
        unoCounter++;
        } else {
        total += unoCounter;
        if (total > 1000000000) {
        return -1;
        }
        }
        }
        return total;
        }

        Genomic-Range-Query

        A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

        The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

        For example, consider string S = CAGCCTA and arrays P, Q such that:
        P[0] = 2    Q[0] = 4

        P[1] = 5    Q[1] = 5

        P[2] = 0    Q[2] = 6

        The answers to these M = 3 queries are as follows:

        The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
        The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
        The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.


        Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

        Result array should be returned as an array of integers.

        For example, given the string S = CAGCCTA and arrays P, Q such that:
        P[0] = 2    Q[0] = 4

        P[1] = 5    Q[1] = 5

        P[2] = 0    Q[2] = 6

        the function should return the values [2, 4, 1], as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        M is an integer within the range [1..50,000];
        each element of arrays P, Q is an integer within the range [0..N − 1];
        P[K] ≤ Q[K], where 0 ≤ K < M;
        string S consists only of upper-case English letters A, C, G, T.



class Solution {
    private ImpactFactorHolder[] mHolder;
    private static final int A=0,C=1,G=2,T=3;
    public int[] solution(String S, int[] P, int[] Q) {
        mHolder = createImpactHolderArray(S);
        int queriesLength = P.length;
        int[] result = new int[queriesLength];
        for (int i = 0; i < queriesLength; ++i ) {
            int value = 0;
            if( P[i] == Q[i]) {
                value = lookupValueForIndex(S.charAt(P[i])) + 1;
            } else {
                value = calculateMinImpactFactor(P[i], Q[i]);
            }
            result[i] = value;
        }
        return result;
    }
    public int calculateMinImpactFactor(int P, int Q) {
        int minImpactFactor = 3;
        for (int nucleotide = A; nucleotide <= T; ++nucleotide ) {
            int qValue = mHolder[nucleotide].mOcurrencesSum[Q];
            int pValue = mHolder[nucleotide].mOcurrencesSum[P];
// handling special cases when the less value is assigned on the P index
            if( P-1 >= 0 ) {
                pValue = mHolder[nucleotide].mOcurrencesSum[P-1] == 0 ? 0 : pValue;
            } else if ( P == 0 ) {
                pValue = mHolder[nucleotide].mOcurrencesSum[P] == 1 ? 0 : pValue;
            }
            if ( qValue - pValue > 0) {
                minImpactFactor = nucleotide;
                break;
            }
        }
        return minImpactFactor + 1;
    }
    public int lookupValueForIndex(char nucleotide) {
        int value = 0;
        switch (nucleotide) {
            case 'A' :
                value = A;
                break;
            case 'C' :
                value = C;
                break;
            case 'G':
                value = G;
                break;
            case 'T':
                value = T;
                break;
            default:
                break;
        }
        return value;
    }
    public ImpactFactorHolder[] createImpactHolderArray(String S) {
        int length = S.length();
        ImpactFactorHolder[] holder = new ImpactFactorHolder[4];
        holder[A] = new ImpactFactorHolder(1,'A', length);
        holder[C] = new ImpactFactorHolder(2,'C', length);
        holder[G] = new ImpactFactorHolder(3,'G', length);
        holder[T] = new ImpactFactorHolder(4,'T', length);
        int i =0;
        for(char c : S.toCharArray()) {
            int nucleotide = lookupValueForIndex(c);
            ++holder[nucleotide].mAcum;
            holder[nucleotide].mOcurrencesSum[i] = holder[nucleotide].mAcum;
            holder[A].mOcurrencesSum[i] = holder[A].mAcum;
            holder[C].mOcurrencesSum[i] = holder[C].mAcum;
            holder[G].mOcurrencesSum[i] = holder[G].mAcum;
            holder[T].mOcurrencesSum[i] = holder[T].mAcum;
            ++i;
        }
        return holder;
    }
    private static class ImpactFactorHolder {
        public ImpactFactorHolder(int impactFactor, char nucleotide, int length) {
            mImpactFactor = impactFactor;
            mNucleotide = nucleotide;
            mOcurrencesSum = new int[length];
            mAcum = 0;
        }
        int mImpactFactor;
        char mNucleotide;
        int[] mOcurrencesSum;
        int mAcum;
    }
}



class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int len = S.length();
        int[] Acount = new int[len];
        int [] Ccount = new int[len];
        int [] Gcount = new int[len];
        int [] Tcount = new int[len];
        if (S.charAt(0) == 'A')
            Acount[0]++;
        else if (S.charAt(0) == 'C')
            Ccount[0]++;
        else if (S.charAt(0) == 'G')
            Gcount[0]++;
        else if (S.charAt(0) == 'T')
            Tcount[0]++;
        for (int i=1;i Acount[i] = Acount[i-1];
        Ccount[i] = Ccount[i-1];
        Gcount[i] = Gcount[i-1];
        Tcount[i] = Tcount[i-1];
        if (S.charAt(i) == 'A')
            Acount[i] ++;
        else if (S.charAt(i) == 'C')
            Ccount[i] ++;
        else if (S.charAt(i) == 'G')
            Gcount[i] ++;
        else if (S.charAt(i) == 'T')
            Tcount[i] ++;
    }
    int [] sol = new int[P.length];
for (int i=0;i int start = P[i];
    int end = Q[i];
    char c = S.charAt(start);
if ( ((Acount[end] - Acount[start]) > 0) || c == 'A' )
    sol[i] = 1;
else if ( (Ccount[end] - Ccount[start]) > 0 || c == 'C')
    sol[i] = 2;
else if ( (Gcount[end] - Gcount[start]) > 0 || c == 'G')
    sol[i] = 3;
else
    sol[i] = 4;
}
return sol;
        }
        }
        Min-Avg-Two-Slice

        A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

        For example, array A such that:
        A[0] = 4

        A[1] = 2

        A[2] = 2

        A[3] = 5

        A[4] = 1

        A[5] = 5

        A[6] = 8

        contains the following example slices:

        slice (1, 2), whose average is (2 + 2) / 2 = 2;
        slice (3, 4), whose average is (5 + 1) / 2 = 3;
        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.


        The goal is to find the starting position of a slice whose average is minimal.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

        For example, given array A such that:
        A[0] = 4

        A[1] = 2

        A[2] = 2

        A[3] = 5

        A[4] = 1

        A[5] = 5

        A[6] = 8

        the function should return 1, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−10,000..10,000].





public int solution(int[] A) {
        int len = A.length, result = len - 1, sum = 0;
        int[] prefixSums = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
        prefixSums[i] = prefixSums[i-1] + A[i-1];
        }
        double min = Double.MAX_VALUE, average = 0d;
        for (int P = 0, Q = 1; Q + 1 < prefixSums.length; ++P, ++Q ) {
        sum = prefixSums[Q + 1] - prefixSums[P];
        average = (sum)/(double) 2;
        if (average < min) {
        min = average;
        result = P;
        }
        if ( Q + 2 < prefixSums.length ) {
        sum = prefixSums[Q + 2] - prefixSums[P];
        average = (sum)/(double) 3;
        if (average < min) {
        min = average;
        result = P;
        }
        }
        }
        return result;
        }
class Solution {
    public int solution(int[] A) {
        int[] sum = new int[A.length + 1];
// We store the prefix sums here, please note prefix sum arrays start with 0 so their size is A.length + 1;
        sum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        int result = 0;
        double best = 10000;
        for (int i = 0; i < A.length - 2; i++) {
// Try pair
            double average = 1.0d * (sum[i + 2] - sum[i]) / 2;
            if (average < best) {
                best = average;
                result = i;
            }
// Try triade
            average = 1.0d * (sum[i + 3] - sum[i]) / 3;
            if (average < best) {
                best = average;
                result = i;
            }
        }
// Last pair
        double average = 1.0d * (sum[A.length] - sum[A.length - 2]) / 2;
        if (average < best) {
            result = A.length - 2;
        }
        return result;
    }
}
Count-Div

        Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

        { i : A ≤ i ≤ B, i mod K = 0 }

        For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

        Write an efficient algorithm for the following assumptions:

        A and B are integers within the range [0..2,000,000,000];
        K is an integer within the range [1..2,000,000,000];
        A ≤ B.




public int solution(int A, int B, int K) {
        int offsetForLeftRange = 0;
        if ( A % K == 0) { ++offsetForLeftRange; }
        return (B/K) - (A /K) + offsetForLeftRange;
        }

// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Solution {
    public int solution(int A, int B, int K) {
// write your code in Java SE 8
        int count = 0;
        int counter=A;
        while(counter<=B){
            if(counter % K==0){
                count = Math.abs(((B - counter) /K)+1);
                break;
            }
            else if(counter/K == 0){
                counter = K;
            }
            else{
                counter = counter + (counter %K);
            }
        }
        return count;
    }
}

Distinct

        Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

        For example, given array A consisting of six elements such that:
        A[0] = 2    A[1] = 1    A[2] = 1

        A[3] = 2    A[4] = 3    A[5] = 1

        the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].




        import java.util.Set;
        import java.util.HashSet;
// https://codility.com/demo/results/demoVS545C-F36/ 100%
public class Distinct {
    // testcases
// (1) = 1
// (1,2) = 2
// (2,1,1,2,3,1) = 3
    public int solution(int[] A) {
        Set sparseArray = new HashSet<>();
        int distinctCount= 0;
        for(int element : A ) {
            if (!sparseArray.contains(element) ) {
                sparseArray.add(element);
                ++distinctCount;
            }
        }
        return distinctCount;
    }
}

import java.util.BitSet;
public class Distinct {
    public int solution(int[] A) {
// first part for negatives, second part for positives and adding 1
// to count the zero as part of the positives section
        int offset = 1_000_000;
        BitSet bitSet = new BitSet( (offset * 2) + 1 );
        for (int element : A ) {
            int index = element >= 0 ? offset + element : (element * -1);
            bitSet.set(index);
        }
        return bitSet.cardinality();
    }
}

import java.util.Arrays;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;
// you can also use imports, for example:
// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Solution {
    public int solution(int[] A) {
        Set aSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            aSet.add(A[i]);
        }
        return aSet.size();
    }
}
Max-Product-Of-Three

        A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

        For example, array A such that:
        A[0] = -3

        A[1] = 1

        A[2] = 2

        A[3] = -2

        A[4] = 5

        A[5] = 6

        contains the following example triplets:

        (0, 1, 2), product is −3 * 1 * 2 = −6
        (1, 2, 4), product is 1 * 2 * 5 = 10
        (2, 4, 5), product is 2 * 5 * 6 = 60


        Your goal is to find the maximal product of any triplet.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

        For example, given array A such that:
        A[0] = -3

        A[1] = 1

        A[2] = 2

        A[3] = -2

        A[4] = 5

        A[5] = 6

        the function should return 60, as the product of triplet (2, 4, 5) is maximal.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [3..100,000];
        each element of array A is an integer within the range [−1,000..1,000].




// you can also use imports, for example:
        import java.util.Arrays;
// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Solution {
    public int solution(int[] A) {
        int[] maxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
// Invariant: maxes[0] <= maxes[1] <= maxes[2]
        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
// Invariant: mins[0] <= mins[1]
// O(n)
        for( int a : A )
        {
            updateMaxes( a, maxes );
            updateMins( a, mins );
        }
        System.out.println(Arrays.toString(maxes));
        System.out.println(Arrays.toString(mins));
        int obvious = maxes[0] * maxes[1] * maxes[2];
        int twoBigNegs = mins[0] * mins[1] * maxes[2];
        return Math.max( obvious, twoBigNegs );
    }
    private static void updateMaxes( int a, int[] maxes )
    {
        if( a >= maxes[2] ) {
// Found new max, shift down
            maxes[0] = maxes[1];
            maxes[1] = maxes[2];
            maxes[2] = a;
        } else if( a >= maxes[1] ) {
            maxes[0] = maxes[1];
            maxes[1] = a;
        } else if( a > maxes[0] ) {
            maxes[0] = a;
        }
    }
    private static void updateMins( int a, int[] mins )
    {
        if( a <= mins[0] ) {
// Found new min, shift down
            mins[1] = mins[0];
            mins[0] = a;
        } else if( a < mins[1] ) {
            mins[1] = a;
        }
    }
}

    public int solution(int[] A) {
        Arrays.sort(A);
        int posCount = 0 ;
        int negCount = 0 ;
        int max = 0 ;
        int lastNegIndex = 0;
        for(int i=0 ; i < A.length ; i++){
            if(A[i] = 3 && negCount = 3 && negCount >1){
                max = A[A.length-1] * A[A.length-2] * A[A.length-3] ;
                if(A[A.length-1] * A[0] * A[1] > max){
                    max = A[A.length-1] * A[0] * A[1] ;
                }
            }
            else if((posCount==1 || posCount==2 ) && negCount>=2 ){
                max = A[A.length-1] * A[0] * A[1] ;
            }
            else if(posCount==2 && negCount==1){
                max = A[0] * A[1] * A[2] ;
            }
            else if(posCount==0 && negCount>=3){
                max = A[A.length-1] * A[A.length-2] * A[A.length-3] ;
            }
            return max;
        }


        public int solution(int[] A) {
            if(A == null || A.length < 3) {
                return 0;
            }
            Arrays.sort(A);
            int lastIndex = A.length - 1;
            int bigestElements = A[lastIndext] * A[lastIndext - 1] * A[lastIndext - 2];
            int twoBigestNegs = A[0] * A[1] * A[lastIndext];
            int maxProduct = Math.max(bigestElements, twoBigestNegs);
            return maxProduct;
        }

        Triangle

        An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

        A[P] + A[Q] > A[R],
                A[Q] + A[R] > A[P],
                A[R] + A[P] > A[Q].


                        For example, consider array A such that:
        A[0] = 10    A[1] = 2    A[2] = 5

        A[3] = 1     A[4] = 8    A[5] = 20

        Triplet (0, 2, 4) is triangular.

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

                For example, given array A such that:
        A[0] = 10    A[1] = 2    A[2] = 5

        A[3] = 1     A[4] = 8    A[5] = 20

        the function should return 1, as explained above. Given array A such that:
        A[0] = 10    A[1] = 50    A[2] = 5

        A[3] = 1

        the function should return 0.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].



// you can also use imports, for example:
// import java.math.*;
import java.util.Arrays;
        class Solution {
            /**
             * Check whether there is a triangular
             * @param A The array for length of lines
             * @return 0: no triangular found
             * 1: triangular is found
             */
            public int solution(int[] A) {
// Handle with the special cases
                if(null == A || A.length < 3) return 0;
// Sort the input, and then try to find the triangular
                Arrays.sort(A);
                for(int i = 0; i < A.length-2; i++) {
// Beware of overflow
                    if (A[i] >= 0 && A[i] > A[i+2] - A[i+1]) {
                        return 1;
                    }
                    /*
                     * We already know A[i+1] <= A[i+2]. If A[i] < 0,
                     * A[i] + A[i+1] < A[i+2]
                     */
                }
                return 0;
            }
        }


import java.util.Arrays;
// https://codility.com/demo/results/demoXVA6HQ-555/ 100
        public class Solution {
            public static final int NOT_TRIANGULAR = 0;
            public static final int TRIANGULAR = 1;
            // testcases
// (10,2,5,1,8,20) = 1
// (10,50,5,1) = 0
// (2147483647, 2147483647, 2147483647) = 1 for overflow
// (1,2) = 0 two elements
// (-1,-1,-1) = 0 negatives
            public int solution(int[] A) {
                Arrays.sort(A);
                int length = A.length;
                for (int p = 0, q = 1, r = 2; p < (length - 2); ++p, ++q, ++r) {
                    if (A[p] >= 0 && A[p] > A[r] - A[q]) {
                        if (isTriangular(A[p], A[q], A[r])) {
                            return TRIANGULAR;
                        }
                    }
                }
                return NOT_TRIANGULAR;
            }
            public static boolean isTriangular(int P, int Q, int R) {
                return (P > R - Q) && (Q > P - R) && (P > Q - R);
            }
        }
        beta2010 (Number-Of-Disc-Intersections)

        We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

                We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

                The figure below shows discs drawn for N = 6 and A as follows:
        A[0] = 1

        A[1] = 5

        A[2] = 2

        A[3] = 1

        A[4] = 4

        A[5] = 0

        There are eleven (unordered) pairs of discs that intersect, namely:

        discs 1 and 4 intersect, and both intersect with all the other discs;
        disc 2 also intersects with discs 0 and 3.


        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

        Given array A shown above, the function should return 11, as explained above.

                Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [0..2,147,483,647].





// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
        /* for each disc J in A w/ radius A[J], J *must* intersect with the previous A[J] discs
         * for disc J and K s.t. J < K, J intersects K iff J + A[J] >= K - A[K]
         * problem is when J + A[J] < K
         * need a way to know the number of discs prior to a position I that intersect w/ I
         * for I = K-A[K] s.t. K-A[K] > 0, I is the remaining number of discs that intersect w/ K
         * already know the number of discs prior to position I (which is simply I)
         * can calculate the number of discs prior to position I that *don't* intersect w/ I
         * if a disc doesn't intersect w/ I, it won't intersect w/ any position after I
         *
         * set count to zero
         * create array num_no_intersect of length N+1 (tracks number of discs before each position
         * that don't intersect that position)
         * for each disc J in A
         * if J - A[J] <= 0
         * count += J b/c disc J *must* intersect w/ the previous J discs
         * else
         * count += A[J] b/c disc J *must* intersect w/ the previous A[J] discs
         * count += J - A[J] - num_no_intersect[J-A[J]] b/c there are J-A[J] discs before disc J
         * w/ num_no_intersect[J-A[J]] that don't intersect position J-A[J]
         * which is *also* the left border of disc J
         * num_no_intersect[J+1] += num_no_intersect[J]
         * b/c discs that don't intersect position J also won't intersect position J+1
         * if J + A[J] + 1 < N (just after disc J's right border)
         * increment num_no_intersect[J+A[J]+1] b/c disc J doesn't intersect any discs on or after that
         * return count
         */
        class Solution {
            private static final int TEN_MILLION = 10000000;
            public int solution(int[] A) {
// write your code in Java SE 8
                int N = A.length, count = 0;
                int[] num_no_intersect = new int[N+1]; // tracks the number of discs prior to each position that doesn't intersect that position
                for (int J = 0; J < N; J++) {
                    if (J <= A[J]) {
                        count += J; // b/c disc J must intersect with the previous J discs
                    }
                    else {
                        count += A[J]; // b/c disc J must intersect with the previous A[J] discs
                        count += J-A[J] - num_no_intersect[J-A[J]]; // add number of discs before J's left border that intersect it
                    }
                    if (count > TEN_MILLION)
                        return -1; // check for exceptional case
                    num_no_intersect[J+1] += num_no_intersect[J]; // discs b/f position J also won't intersect position J+1
                    if (A[J] < N && J+A[J]+1 < N) { // check bounds on A[J] to avoid arithmetic overflow
                        num_no_intersect[J+A[J]+1]++; // disc J will not intersect positions on or after position J+A[J]+1
                    }
                }
                return count;
            }
        }


        Brackets

        A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.


        For example, the string "{[()()]}" is properly nested but "([)()]" is not.

        Write a function:

        class Solution { public int solution(String S); }

        that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

                For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

                Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..200,000];
        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".




import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
        class Solution {
            public static final int BALANCED = 1;
            public static final int UNBALANCED = 0;
            public int solution(String S) {
                if (S.isEmpty()) return BALANCED;
                Stack stack = new Stack<>(S.length());
                NestedValidatorUtil util = new NestedValidatorUtil();
                for (char c: S.toCharArray()) {
                    if (stack.isEmpty()){
                        if (util.isOpener(c)) {
                            stack.push(c);
                        } else {
                            return UNBALANCED;
                        }
                    } else {
                        if(util.isOpener(c)) {
                            stack.push(c);
                        } else if(util.getOpenerForGivenCloser(c) == stack.peek()){
                            stack.pop();
                        } else {
                            return UNBALANCED;
                        }
                    }
                }
                return stack.isEmpty() ? BALANCED : UNBALANCED;
            }
            public static class NestedValidatorUtil {
                private Map language = new HashMap(){{
                    put(')','(');
                    put(']','[');
                    put('}','{');
                }};
                public boolean isOpener(Character c) {
                    return language.values().contains(c);
                }
                public Character getOpenerForGivenCloser(Character closer) {
                    return language.get(closer);
                }
            }
            public static class Stack {
                public List stack;
                public Stack(int capacity) {
                    stack = new ArrayList<>(capacity);
                }
                public void push(T item) {
                    stack.add(item);
                }
                public T pop() {
                    T item = peek();
                    stack.remove(stack.size() - 1);
                    return item;
                }
                public T peek() {
                    int position = stack.size();
                    T item = stack.get(position - 1);
                    return item;
                }
                public boolean isEmpty() {
                    return stack.isEmpty();
                }
            }
        }
        Nesting

        A string S consisting of N characters is called properly nested if:

        S is empty;
        S has the form "(U)" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.


        For example, string "(()(())())" is properly nested but string "())" isn't.

        Write a function:

        class Solution { public int solution(String S); }

        that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

                For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

                Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..1,000,000];
        string S consists only of the characters "(" and/or ")".




        public static final int BALANCED = 1;
        public static final int UNBALANCED = 0;
        public int solution(String S) {
            if (S.length() % 2 != 0) {
                return UNBALANCED;
            }
            int counter = 0, increment = 1;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    increment = increment > 0 ? increment : increment * -1;
                } else if (c == ')') {
                    increment = increment < 0 ? increment : increment * -1;
                }
                counter += increment;
                if (counter < 0) {
                    return UNBALANCED;
                }
            }
            return counter == 0 ? BALANCED : UNBALANCED;
        }
        sigma2012 (Stone-Wall)

        You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

                The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

                Write a function:

        class Solution { public int solution(int[] H); }

        that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

                For example, given array H containing N = 9 integers:
        H[0] = 8    H[1] = 8    H[2] = 5

        H[3] = 7    H[4] = 9    H[5] = 8

        H[6] = 7    H[7] = 4    H[8] = 8

        the function should return 7. The figure shows one possible arrangement of seven blocks.

                Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array H is an integer within the range [1..1,000,000,000].




import java.util.ArrayList;
import java.util.List;
        public class StoneWall {
            public int solution(int[] H) {
                int len = H.length;
                Stack stack = new Stack<>(len);
                int blockCounter = 0;
                for (int i = 0; i < len; ++i) {
                    int element = H[i];
                    if (stack.isEmpty()) {
                        stack.push(element);
                        ++blockCounter;
                    } else {
                        while (!stack.isEmpty() && stack.peek() > element) {
                            stack.pop();
                        }
                        if (!stack.isEmpty() && stack.peek() == element) {
                            continue;
                        } else {
                            stack.push(element);
                            ++blockCounter;
                        }
                    }
                }
                return blockCounter;
            }
            public static class Stack {
                public List stack;
                public Stack(int capacity) {
                    stack = new ArrayList<>(capacity);
                }
                public void push(T item) {
                    stack.add(item);
                }
                public T pop() {
                    T item = peek();
                    stack.remove(stack.size() - 1);
                    return item;
                }
                public T peek() {
                    int position = stack.size();
                    T item = stack.get(position - 1);
                    return item;
                }
                public boolean isEmpty() {
                    return stack.isEmpty();
                }
            }
        }
        Fish

        You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.

                The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

                Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:

        0 represents a fish flowing upstream,
                1 represents a fish flowing downstream.


                If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:

        If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
        If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.


        We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

                For example, consider arrays A and B such that:
        A[0] = 4    B[0] = 0

        A[1] = 3    B[1] = 1

        A[2] = 2    B[2] = 0

        A[3] = 1    B[3] = 0

        A[4] = 5    B[4] = 0

        Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and therefore stay alive.

                Write a function:

        class Solution { public int solution(int[] A, int[] B); }

        that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.

        For example, given the arrays shown above, the function should return 2, as explained above.

                Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [0..1,000,000,000];
        each element of array B is an integer that can have one of the following values: 0, 1;
        the elements of A are all distinct.




import java.util.Stack;
        class Solution {
            private static final int UPSTREAM = 0;
            private static final int DOWNSTREAM = 1;
            // Sample input
// ([2,3],[1,0]) = 1
// ([4, 3, 2, 1, 5], [0, 1, 0, 0, 0]) = 2
            public int solution(int[] A, int[] B) {
                Stack stack = new Stack<>();
                for(int f = 0; f < A.length; ++f) {
                    Fish currentFish = new Fish(A[f],B[f]);
                    if (stack.isEmpty()) {
                        stack.push(currentFish);
                    } else {
                        Fish previousFish = stack.peek();
                        if(previousFish.direction == DOWNSTREAM && currentFish.direction == UPSTREAM) {
                            boolean currentFishAlive = true;
                            while (!stack.isEmpty() && stack.peek().direction != currentFish.direction) {
                                if (stack.peek().size < currentFish.size) {
                                    stack.pop(); // previous fish eaten
                                } else {
                                    currentFishAlive = false;
                                    break;
                                }
                            }
                            if (currentFishAlive) { stack.push(currentFish); }
                        } else { // same direction or don't meet P < Q, but no B[P] = 1, B[Q] = 0
                            stack.push(currentFish);
                        }
                    }
                }
                return stack.size();
            }
            public static class Fish {
                public int direction;
                public int size;
                public Fish(int size, int direction) {
                    this.size = size;
                    this.direction = direction;
                }
            }
        }

        Stack prevfishes = new Stack();
        int nooffish = 0;
        for(int i=0;i int currentflow = B[i];
// considering going up as natural order
        if(currentflow == 0) {
// no one in between increase count
            if(prevfishes.isEmpty()) {
                nooffish ++;
            } else {
// if something already in between sort it out
                while(!prevfishes.isEmpty() && prevfishes.peek() < A[i])
                    prevfishes.pop();
// no one in between increase the count
                if(prevfishes.isEmpty())
                    nooffish ++;
            }
        } else {
// noting down whose are not with going up
            prevfishes.push(A[i]);
        }
    }
return prevfishes.size() + nooffish;


public int solution(int[] A, int[] B) {
        Stack downStreamSize = new Stack();
        int surview = 0 ; public int solution(int[] A, int[] B) {
        Stack downStreamSize = new Stack();
        int surview = 0 ;
        for(int i=0 ; i if(B[i] == 1){
        downStreamSize.push(A[i]);
        }
        else if(B[i] == 0 && downStreamSize.isEmpty()){
        surview++;
        }
        else{
        while(!downStreamSize.isEmpty() && downStreamSize.peek() < A[i] ){
        downStreamSize.pop();
        }
        if(downStreamSize.size() ==0){
        surview ++ ; public int solution(int[] A, int[] B) {
        Stack downStreamSize = new Stack();
        int surview = 0 ;
        for(int i=0 ; i if(B[i] == 1){
        downStreamSize.push(A[i]);
        }
        else if(B[i] == 0 && downStreamSize.isEmpty()){
        surview++;
        }
        else{
        while(!downStreamSize.isEmpty() && downStreamSize.peek() < A[i] ){
        downStreamSize.pop();
        }
        if(downStreamSize.size() ==0){
        surview ++ ;
        }
        }
        }
        return surview + downStreamSize.size();
        }
        }
        }
        }
        return surview + downStreamSize.size();
        }
        for(int i=0 ; i if(B[i] == 1){
        downStreamSize.push(A[i]);
        }
        else if(B[i] == 0 && downStreamSize.isEmpty()){
        surview++;
        }
        else{
        while(!downStreamSize.isEmpty() && downStreamSize.peek() < A[i] ){
        downStreamSize.pop();
        }
        if(downStreamSize.size() ==0){
        surview ++ ;
        }
        }
        }
        return surview + downStreamSize.size();
        }
        Dominator

        An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

        For example, consider array A such that
        A[0] = 3    A[1] = 4    A[2] =  3

        A[3] = 2    A[4] = 3    A[5] = -1

        A[6] = 3    A[7] = 3

        The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

        Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

        For example, given array A such that
        A[0] = 3    A[1] = 4    A[2] =  3

        A[3] = 2    A[4] = 3    A[5] = -1

        A[6] = 3    A[7] = 3

        the function may return 0, 2, 4, 6 or 7, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].




        import java.util.*;
class Solution {
    public int solution(int[] A) {
        HashMap hashMap = new HashMap();
        int half = A.length/2;
        int dominatorNumOccurs = 0;
        int dominatorIdx = -1;
        for(int i = 0;i int num = A[i];
        int occurs = 1;
        if(hashMap.containsKey(num))
            occurs = hashMap.get(num)+1;
        hashMap.put(num, occurs);
        if(occurs > half && occurs > dominatorNumOccurs){
            dominatorIdx = i;
            dominatorNumOccurs = occurs;
        }
    }
return dominatorIdx;
}
}

public int solution(int[] A) {
        int indexOfCandidate = -1;
        int stackCounter = 0, candidate=-1, value=-1, i =0;
        for(int element: A ) {
        if (stackCounter == 0) {
        value = element;
        ++stackCounter;
        indexOfCandidate = i;
        } else {
        if (value == element) {
        ++stackCounter;
        } else {
        --stackCounter;
        }
        }
        ++i;
        }
        if (stackCounter > 0 ) {
        candidate = value;
        } else {
        return -1;
        }
        int countRepetitions = 0;
        for (int element: A) {
        if( element == candidate) {
        ++countRepetitions;
        }
        if(countRepetitions > (A.length / 2)) {
        return indexOfCandidate;
        }
        }
        return -1;
        }
        Equi-Leader

        A non-empty array A consisting of N integers is given.

        The leader of this array is the value that occurs in more than half of the elements of A.

        An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

        For example, given array A such that:
        A[0] = 4

        A[1] = 3

        A[2] = 4

        A[3] = 4

        A[4] = 4

        A[5] = 2

        we can find two equi leaders:

        0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
        2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.


        The goal is to count the number of equi leaders.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

        For example, given:
        A[0] = 4

        A[1] = 3

        A[2] = 4

        A[3] = 4

        A[4] = 4

        A[5] = 2

        the function should return 2, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].




class Solution {
    public int solution(int[] A) {
        Leader leader = getLeader(A);
        if ( leader == null ) { return 0; }
        int equileaders = 0, leaderCounter =0, len = A.length;
        for(int i=0; i < len ; ++i) {
            if(A[i] == leader.value) {
                ++leaderCounter;
            }
            if ((leaderCounter > (i+1)/2 && (leader.ocurrences - leaderCounter)>(len-1-i)/2) ) {
                ++equileaders;
            }
        }
        return equileaders;
    }
    public static class Leader {
        int ocurrences;
        int value;
        public Leader(int value, int ocurrences) {
            this.value = value;
            this.ocurrences = ocurrences;
        }
    }
    public Leader getLeader(int[] A) {
        int stackCounter = 0, candidate=-1, value=-1;
        for(int element: A ) {
            if (stackCounter == 0) {
                value = element;
                ++stackCounter;
            } else {
                if (value == element) {
                    ++stackCounter;
                } else {
                    --stackCounter;
                }
            }
        }
        if (stackCounter > 0 ) {
            candidate = value;
        } else {
            return null;
        }
        int countRepetitions = 0;
        for (int element: A) {
            if( element == candidate) {
                ++countRepetitions;
            }
        }
        if(countRepetitions > (A.length / 2)) {
            return new Leader(candidate, countRepetitions);
        }
        return null;
    }
}


// you can also use imports, for example:

import java.util.*;



// you can use System.out.println for debugging purposes, e.g.

// System.out.println("this is a debug message");



class Solution {

    public int solution(int[] A) {



        int size = 0;

        int value = 0;

        for (int i=0; i<A.length; i++) {

            if (size == 0) {

                size++;

                value = A[i];

            } else {

                if (A[i] == value)

                    size++;

                else

                    size--;

            }

        }





        int count = 0;



        for (int j=0; j<A.length; j++) {

            if (A[j] == value) {

                count++;

            }

        }



        if (count <= (A.length/2)) {

            return 0;

        } else {

            int indices = 0;

            size = 0;

            for (int k=0; k<A.length-1; k++) {

                if (A[k] == value){

                    count--;

                    size++;

                }

                if ((size > ((k+1)/2)) && (count > (A.length-(k+1))/2 )) {

                    indices++;

                }

            }

            return indices;

        }

    }

}


Max-Double-Slice-Sum

        A non-empty array A consisting of N integers is given.

        A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

        The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

        For example, array A such that:
        A[0] = 3

        A[1] = 2

        A[2] = 6

        A[3] = -1

        A[4] = 4

        A[5] = 5

        A[6] = -1

        A[7] = 2

        contains the following example double slices:

        double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
        double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
        double slice (3, 4, 5), sum is 0.


        The goal is to find the maximal sum of any double slice.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

        For example, given:
        A[0] = 3

        A[1] = 2

        A[2] = 6

        A[3] = -1

        A[4] = 4

        A[5] = 5

        A[6] = -1

        A[7] = 2

        the function should return 17, because no double slice of array A has a sum of greater than 17.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [3..100,000];
        each element of array A is an integer within the range [−10,000..10,000].




public int solution(int[] A) {
        int[] maxStartingHere = new int[A.length];
        int[] maxEndingHere = new int[A.length];
        int maxSum = 0, len = A.length;
        for(int i = len - 2; i > 0; --i ) {
        maxSum = Math.max(0, A[i] + maxSum);
        maxStartingHere[i] = maxSum;
        }
        maxSum = 0;
        for(int i = 1; i < len - 1; ++i ) {
        maxSum = Math.max(0, A[i] + maxSum);
        maxEndingHere[i] = maxSum;
        }
        int maxDoubleSlice = 0;
        for(int i = 0; i < len - 2; ++i) {
        maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i+2]);
        }
        return maxDoubleSlice;
        }
        Max-Profit

        An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].

        For example, consider the following array A consisting of six elements such that:
        A[0] = 23171

        A[1] = 21011

        A[2] = 21123

        A[3] = 21366

        A[4] = 21013

        A[5] = 21367

        If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

        Write a function,

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.

        For example, given array A consisting of six elements such that:
        A[0] = 23171

        A[1] = 21011

        A[2] = 21123

        A[3] = 21366

        A[4] = 21013

        A[5] = 21367

        the function should return 356, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..400,000];
        each element of array A is an integer within the range [0..200,000].




class Solution {
    public int solution(int[] A) {
        if(A.length == 0) return 0 ;
        int min = A[0]; //mainin the previous min price
        int profit = 0; //current max profit
        for(int i=1 ; i < A.length ;i++){
            min = Math.min(min,A[i]); //update minimum
            profit = Math.max(profit, A[i] - min); //calculate current profit
        }
        return profit > 0 ? profit : 0 ;
    }
}
Max-Slice-Sum

        A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

        For example, given array A such that:
        A[0] = 3  A[1] = 2  A[2] = -6

        A[3] = 4  A[4] = 0

        the function should return 5 because:

        (3, 4) is a slice of A that has sum 4,
        (2, 2) is a slice of A that has sum −6,
        (0, 1) is a slice of A that has sum 5,
        no other slice of A has sum greater than (0, 1).


        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..1,000,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000];
        the result will be an integer within the range [−2,147,483,648..2,147,483,647].




        def solution(A):
        max_ending = max_slice = 0
        max_A = max(A)
        if max_A > 0:
        for i in xrange(len(A)):
        max_ending = max(0, max_ending + A[i])
        max_slice = max(max_slice, max_ending)
        else:
        max_slice = max_A
        return max_slice


        using System;
        using System.Collections.Generic;
        using System.Collections;
// you can also use other imports, for example:
// using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
    public int solution(int[] A) {
// write your code in C# 6.0 with .NET 4.5 (Mono)
        int len = A.Length;
        int greatSum = A[0];
        int tempSum = 0;
//int[,] SliceArray = new int[1,1];

        if(len==1)
            return A[0];
        if(len==0)
            return -1;
        if(len>=1000000)
            return -1;
        for(int i = 0; i {
            if(A[i]>greatSum)
                greatSum = A[i];

            for(int j=i;j {
                tempSum = tempSum+A[j];
                if(tempSum>greatSum)
                    greatSum=tempSum;
            }
            tempSum = 0;


        }
        return greatSum;
    }
}


Min-Perimeter-Rectangle

        An integer N is given, representing the area of some rectangle.

        The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

        The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

        For example, given integer N = 30, rectangles of area 30 are:

        (1, 30), with a perimeter of 62,
        (2, 15), with a perimeter of 34,
        (3, 10), with a perimeter of 26,
        (5, 6), with a perimeter of 22.


        Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

        For example, given an integer N = 30, the function should return 22, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..1,000,000,000].



public int solution(int N) {
        Integer x = ((Double)Math.sqrt(N)).intValue();
        int y = 0 ;
        for(int i = x ; x>0 ; x--){
        if(N%x == 0){
        y = N/x;
        break;
        }
        }
        return 2*(x+y) ;
        }


        Count-Factors


        A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

        For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

        Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

        For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647].





class CountFactors {
    public static int solution(int N) {
// write your code in Java SE 8
        int numFactors = 0;
        for (int i = 1; i <= (double) Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (i * i != N)
                    numFactors = numFactors + 2;
                else
                    numFactors = numFactors + 1;
            }
        }
        return numFactors;
    }
    public static void main(String args[]) {
        System.out.println(solution(24));
    }
}

class Solution {
    public int solution(int N) {
        int r = 0;
        if(N>1){
            if(N%2 != 0){ // odd numbers
                for(int i = 1; i <= N/i; i+=2){
                    if(N%i == 0){
                        if(N/i != i){
                            r += 2;
                        } else {
                            r +=1;
                        }
                    }
                }
            }
            else { // even numbers
                for(int i = 1; i <= N/i; i++){
                    if( N%i == 0){
                        if(N/i != i){
                            r += 2;
                        } else {
                            r +=1;
                        }
                    }
                }
            }
        } else {
            r = 1;
        }
        return r;
    }
}
Peaks

        A non-empty array A consisting of N integers is given.

        A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

        For example, the following array A:
        A[0] = 1

        A[1] = 2

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        has exactly three peaks: 3, 5, 10.

        We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:

        A[0], A[1], ..., A[K − 1],
        A[K], A[K + 1], ..., A[2K − 1],

        ...
        A[N − K], A[N − K + 1], ..., A[N − 1].


        What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

        The goal is to find the maximum number of blocks into which the array A can be divided.

        Array A can be divided into blocks as follows:

        one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
        two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
        three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.


        However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

        The maximum number of blocks that array A can be divided into is three.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

        If A cannot be divided into some number of blocks, the function should return 0.

        For example, given:
        A[0] = 1

        A[1] = 2

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [0..1,000,000,000].






        import java.util.*;
class Solution {
    public int solution(int[] A) {
        int N = A.length;

// Find all the peaks
        ArrayList peaks = new ArrayList();
        for(int i = 1; i < N-1; i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
        }

        for(int size = 1; size <= N; size++){
            if(N % size != 0) continue; // skip if non-divisible
            int find = 0;
            int groups = N/size;
            boolean ok = true;
// Find whether every group has a peak
            for(int peakIdx : peaks){
                if(peakIdx/size > find){
                    ok = false;
                    break;
                }
                if(peakIdx/size == find) find++;
            }
            if(find != groups) ok = false;
            if(ok) return groups;
        }
        return 0;
    }
}


C++
        int solution(vector &A) {
// write your code in C++14 (g++ 6.2.0)
        int N = A.size();
        if (N < 3) return 0;

//find peaks
//max number of peaks (N+1)/2
        int peaks[(N+1)/2];
        int p = 0;
        peaks[p] = -1; //mark end

        for (int i = 1; i < N-1; i++) {
        if (A[i] > A[i-1] && A[i] > A[i+1]) {
        peaks[p] = i;
        ++p;
        peaks[p] = -1;//mark end
        ++i; // next number cannot be a peak
        }
        }
        if (peaks[0] == -1) {
        return 0; // no peaks
        }
        if (peaks[0] != -1 && peaks[1] == -1) {
        return 1; // only one peak
        }

        for (int k = 2 ; k <=N/2; k++ ) { //k is number of element in each block
        if (N%k != 0) {
        continue;
        }

        int peaks_in_block = -1; //find peak in each N/k block
        for(p = 0; peaks[p] > -1; p++) {
        if ((peaks[p])/k > peaks_in_block + 1) {
        break;// peak missing in next block
        } else if (peaks[p]/k == peaks_in_block + 1) {
        ++peaks_in_block; //found at least a peak in next block.
        }
        }
        if (peaks_in_block + 1 == N/k) { // all blocks has at least one peak
        return N/k;
        }
        }
        return 1; // if we are here array at least has one peak.
        }
        boron2013 (Flags)

        A non-empty array A consisting of N integers is given.

        A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        has exactly four peaks: elements 1, 3, 5 and 10.

        You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

        Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

        For example, given the mountain range represented by array A, above, with N = 12, if you take:

        two flags, you can set them on peaks 1 and 5;
        three flags, you can set them on peaks 1, 5 and 10;
        four flags, you can set only three flags, on peaks 1, 5 and 10.


        You can therefore set a maximum of three flags in this case.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..400,000];
        each element of array A is an integer within the range [0..1,000,000,000].




        import java.util.*;
class Solution {
    public int solution(int[] A) {
        if(A.length==1) return 0;
        ArrayList al=new ArrayList();
        for(int i=1;i {
            if(A[i]>A[i-1] && A[i]>A[i+1])
            {
                al.add(i);
            }
        }
        int s=al.size();
        if(s==1) return 1;
        if(s==0)return 0;
        s=(int) Math.ceil(Math.sqrt(A.length));
        while(s>=0) {
            int lp=al.get(0);
            int c=1;
            for(int i=1;i {
                int d=Math.abs(al.get(i)-lp);
                if(d>=s)
                {
                    lp=al.get(i);
                    c++;
                    if(c==s)
                        return c;
                }
            }
            s--;}
        return 0;}
}
Count-Non-Divisible

        You are given an array A consisting of N integers.

        For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

        For example, consider integer N = 5 and array A such that:
        A[0] = 3

        A[1] = 1

        A[2] = 2

        A[3] = 3

        A[4] = 6

        For the following elements:

        A[0] = 3, the non-divisors are: 2, 6,
        A[1] = 1, the non-divisors are: 3, 2, 3, 6,
        A[2] = 2, the non-divisors are: 3, 3, 6,
        A[3] = 3, the non-divisors are: 2, 6,
        A[4] = 6, there aren't any non-divisors.


        Write a function:

class Solution { public int[] solution(int[] A); }

that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

        Result array should be returned as an array of integers.

        For example, given:
        A[0] = 3

        A[1] = 1

        A[2] = 2

        A[3] = 3

        A[4] = 6

        the function should return [2, 4, 3, 2, 0], as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..50,000];
        each element of array A is an integer within the range [1..2 * N].




        C++

        A non-empty array A consisting of N integers is given.

        A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        has exactly four peaks: elements 1, 3, 5 and 10.

        You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

        Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

        For example, given the mountain range represented by array A, above, with N = 12, if you take:

        two flags, you can set them on peaks 1 and 5;
        three flags, you can set them on peaks 1, 5 and 10;
        four flags, you can set only three flags, on peaks 1, 5 and 10.


        You can therefore set a maximum of three flags in this case.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..400,000];
        each element of array A is an integer within the range [0..1,000,000,000].




        Count-Semiprimes

        A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

        A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

        You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

        Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

        For example, consider an integer N = 26 and arrays P, Q such that:
        P[0] = 1    Q[0] = 26

        P[1] = 4    Q[1] = 10

        P[2] = 16   Q[2] = 20

        The number of semiprimes within each of these ranges is as follows:

        (1, 26) is 10,
        (4, 10) is 4,
        (16, 20) is 0.


        Write a function:

class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

        For example, given an integer N = 26 and arrays P, Q such that:
        P[0] = 1    Q[0] = 26

        P[1] = 4    Q[1] = 10

        P[2] = 16   Q[2] = 20

        the function should return the values [10, 4, 0], as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..50,000];
        M is an integer within the range [1..30,000];
        each element of arrays P, Q is an integer within the range [1..N];
        P[i] ≤ Q[i].




public int[] getSeive(int N) {
        int[] seive = new int[N + 1];
        int i = 2;
        while (i * i <= N) {
        if (seive[i] == 0) {
        int k = i * i;
        while (k <= N) {
        if (seive[k] == 0) {
        seive[k] = i;
        } else {
        }
        k += i;
        }
        }
        i++;
        }
        int[] indexes = new int[seive.length];
        for (int j = 2; j < seive.length; j++) {
        if (seive[j] == 0) {
        indexes[j] = j;
        } else {
        indexes[j] = seive[j];
        }
        }
        return indexes;
        }
public int[] solution(int N, int[] P, int[] Q) {
        int[] numbers = new int[N + 1];
        int[] seive = getSeive(N);
        for (int i = 4; i < numbers.length; i++) {
        if (seive[i] * seive[i / seive[i]] == i) {
        numbers[i] = 1;
        }
        }
        int[] preSum = new int[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
        preSum[i] = preSum[i - 1] + numbers[i];
        }
//System.out.println(Arrays.toString(numbers));
//System.out.println(Arrays.toString(preSum));
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
        result[i] = preSum[Q[i]] - preSum[P[i] - 1];
        }
        return result;
        }

        Chocolates-By-Numbers

        Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

        You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

        You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

        More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

        You stop eating when you encounter an empty wrapper.

        For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

        The goal is to count the number of chocolates that you will eat, following the above rules.

        Write a function:

class Solution { public int solution(int N, int M); }

that, given two positive integers N and M, returns the number of chocolates that you will eat.

        For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

        Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..1,000,000,000].




class Solution {
    public int solution(int N, int M) {
// write your code in Java SE 8

        int oneRoundMaxChocolate =N/M+1;
        int num =0;
        int round =1;
        while( round<= (N/oneRoundMaxChocolate) +1 ){
            if( ((round*(long)N))%M==0)
                return (int)(((round*(long)N))/M);
            else round++;
        }
        return N;
    }
}
Common-Prime-Divisors

        A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

        A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

        You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

        For example, given:

        N = 15 and M = 75, the prime divisors are the same: {3, 5};
        N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
        N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.


        Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

        For example, given:
        A[0] = 15   B[0] = 75

        A[1] = 10   B[1] = 30

        A[2] = 3    B[2] = 5

        the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

        Write an efficient algorithm for the following assumptions:

        Z is an integer within the range [1..6,000];
        each element of arrays A, B is an integer within the range [1..2,147,483,647].





        #include
        #include
        using namespace std;
static int gcd(int a, int b)
        {
        if (a%b == 0)return b;
        else return gcd(b, a%b);
        }
        int solution(vector &A, vector &B) {
        int len = A.size();
        assert(len >= 1 && len < 60001 && B.size() == len);
        int a, b, c, d = 0, cnt = 0;
        for (int i = 0; i < len; ++i)
        {
        a = A[i];
        b = B[i];
        d = gcd(a, b);
        while ((c = gcd(a, d)) != 1)
        a /= c;
        while ((c = gcd(b, d)) != 1)
        b /= c;
        if (1 == a && 1 == b)
        ++cnt;
        }
        return cnt;
        }



        def gcd(x, y):
        ''' Compute the greatest common divisor.
        '''
        if x%y == 0:
        return y;
        else:
        return gcd(y, x%y)
        def removeCommonPrimeDivisors(x, y):
        ''' Remove all prime divisors of x, which also exist in y. And
        return the remaining part of x.
        '''
        while x != 1:
        gcd_value = gcd(x, y)
        if gcd_value == 1:
        # x does not contain any more
        # common prime divisors
        break
        x /= gcd_value
        return x
        def hasSamePrimeDivisors(x, y):
        gcd_value = gcd(x, y) # The gcd contains all
        # the common prime divisors
        x = removeCommonPrimeDivisors(x, gcd_value)
        if x != 1:
        # If x and y have exactly the same common
        # prime divisors, x must be composed by
        # the prime divisors in gcd_value. So
        # after previous loop, x must be one.
        return False
        y = removeCommonPrimeDivisors(y, gcd_value)
        return y == 1
        def solution(A, B):
        count = 0
        for x,y in zip(A,B):
        if hasSamePrimeDivisors(x,y):
        count += 1
        return count
        Fib-Frog

        The Fibonacci sequence is defined using the following recursive formula:
        F(0) = 0

        F(1) = 1

        F(M) = F(M - 1) + F(M - 2) if M >= 2

        A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

        The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

        0 represents a position without a leaf;
        1 represents a position containing a leaf.


        The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

        For example, consider array A such that:
        A[0] = 0

        A[1] = 0

        A[2] = 0

        A[3] = 1

        A[4] = 1

        A[5] = 0

        A[6] = 1

        A[7] = 0

        A[8] = 0

        A[9] = 0

        A[10] = 0

        The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

        For example, given:
        A[0] = 0

        A[1] = 0

        A[2] = 0

        A[3] = 1

        A[4] = 1

        A[5] = 0

        A[6] = 1

        A[7] = 0

        A[8] = 0

        A[9] = 0

        A[10] = 0

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer that can have one of the following values: 0, 1.




class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int[] dp = new int[A.length + 2];
        dp[0] = 1;
        dp[A.length + 1] = -1;
        for (int i = 1; i < A.length + 2; i++) {
            int step = 1;
            int previous = 1;
            int min = Integer.MAX_VALUE;
            while (step <= i) {
// System.out.format("step: %d\n", step);
                if ((i == A.length + 1 || A[i - 1] == 1) && (i - step - 1 == -1 || A[i - step - 1] == 1) && dp[i - step] > 0) {
                    min = Math.min(min, dp[i - step] + 1);
// System.out.format("new min: %d\n", min);
                }
                int tmp = step;
                step = step + previous;
                previous = tmp;
            }
            if (min < Integer.MAX_VALUE) {
                dp[i] = min;
            }
// System.out.format("i: %d, dp: %s\n", i, java.util.Arrays.toString(dp));
        }
// System.out.format("dp: %s\n", java.util.Arrays.toString(dp));
        return dp[A.length + 1] == -1 ? -1 : dp[A.length + 1] - 1;
    }
}

Ladder

        You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:

        with your first step you can stand on rung 1 or 2,
        if you are on rung K, you can move to rungs K + 1 or K + 2,
        finally you have to stand on rung N.


        Your task is to count the number of different ways of climbing to the top of the ladder.

        For example, given N = 4, you have five different ways of climbing, ascending by:

        1, 1, 1 and 1 rung,
        1, 1 and 2 rungs,
        1, 2 and 1 rung,
        2, 1 and 1 rungs, and
        2 and 2 rungs.


        Given N = 5, you have eight different ways of climbing, ascending by:

        1, 1, 1, 1 and 1 rung,
        1, 1, 1 and 2 rungs,
        1, 1, 2 and 1 rung,
        1, 2, 1 and 1 rung,
        1, 2 and 2 rungs,
        2, 1, 1 and 1 rungs,
        2, 1 and 2 rungs, and
        2, 2 and 1 rung.


        The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.

        Write a function:

class Solution { public int[] solution(int[] A, int[] B); }

that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].

        For example, given L = 5 and:
        A[0] = 4   B[0] = 3

        A[1] = 4   B[1] = 2

        A[2] = 5   B[2] = 4

        A[3] = 5   B[3] = 3

        A[4] = 1   B[4] = 1

        the function should return the sequence [5, 1, 8, 0, 1], as explained above.

        Write an efficient algorithm for the following assumptions:

        L is an integer within the range [1..50,000];
        each element of array A is an integer within the range [1..L];
        each element of array B is an integer within the range [1..30].





        import java.util.LinkedList;
        import java.lang.Math;

class Solution {
    public int[] solution(int[] A, int[] B) {
        int[] fib = new int[A.length];
        int a = 0;
        int b = 1;
        int maxModulo = (int) Math.pow(2, 30);
        for (int i = 0; i < A.length; i++) {
            int x = (a + b) % maxModulo;
            fib[i] = x;
            a = b;
            b = x;
        }

        int[] result = new int[A.length];
        int[] modulo = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            modulo[i] = (int) Math.pow(2, B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = fib[A[i] - 1] % modulo[i];
        }

        return result;
    }
}

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import static java.lang.Math.pow;

class Solution {
    public void fib_update (int start, int end,int[]fib)
    {
        for (int i=start;i<=end;i++)
        {
            fib[i]=fib[i-1]+fib[i-2];
        }
    }
    int [] pows;
    public int[] solution(int[] A, int[] B) {
// write your code in Java SE 8
        int []fib= new int[30001];
        int []result=new int [A.length];
        fib[0]=1;
        fib[1]=1;
        fib[2]=2;
        int fibsize=2;
        pows = new int[B.length];
        for (int i=0;i<A.length;i++)
        {
            pows[i] = (1 << B[i]) -1;
            if (A[i]>fibsize)
            {
// calculate fibonacci numbers between fibsize until A[i]
                fib_update(fibsize,A[i],fib);
                fibsize=A[i];
            }
            result[i]= fib[A[i]] & pows[i];
        }
        return result;
    }
}

Min-Max-Division

        You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

        You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

        The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

        The large sum is the maximal sum of any block.

        For example, you are given integers K = 3, M = 5 and array A such that:
        A[0] = 2

        A[1] = 1

        A[2] = 5

        A[3] = 1

        A[4] = 2

        A[5] = 2

        A[6] = 2

        The array can be divided, for example, into the following blocks:

        [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
        [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
        [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
        [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.


        The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

        Write a function:

class Solution { public int solution(int K, int M, int[] A); }

that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

        For example, given K = 3, M = 5 and array A such that:
        A[0] = 2

        A[1] = 1

        A[2] = 5

        A[3] = 1

        A[4] = 2

        A[5] = 2

        A[6] = 2

        the function should return 6, as explained above.

        Write an efficient algorithm for the following assumptions:

        N and K are integers within the range [1..100,000];
        M is an integer within the range [0..10,000];
        each element of array A is an integer within the range [0..M].




class Solution {
    public int solution(int K, int M, int[] A) {
        int N = A.length;
        int max = M*N, min = 0, mid=-1;
        int total = 0;
        for(int i=0;i min){
            mid = (max + min) / 2;
            if(check(K, mid, A, total)){
                max = mid;
            } else {
                min = mid+1;
            }
        }
        if(check(K,min,A,total)) min--;
        return min;
    }
    boolean check(int K, int max, int[] A, int total){
        int cur = 0, i=0, rest = total;
        while(K > 0 && i < A.length){
            while(i < A.length && cur + A[i] < max )
                cur += A[i++];
            K--; cur = 0;
        }
        return i==A.length;
    }
}
Nailing-Planks

        You are given two non-empty arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.

        Next, you are given a non-empty array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.

        We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].

        The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

        For example, given arrays A, B such that:
        A[0] = 1    B[0] = 4

        A[1] = 4    B[1] = 5

        A[2] = 5    B[2] = 9

        A[3] = 8    B[3] = 10

        four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].

        Given array C such that:
        C[0] = 4

        C[1] = 6

        C[2] = 7

        C[3] = 10

        C[4] = 2

        if we use the following nails:

        0, then planks [1, 4] and [4, 5] will both be nailed.
        0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
        0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
        0, 1, 2, 3, then all the planks will be nailed.


        Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.

        Write a function:

class Solution { public int solution(int[] A, int[] B, int[] C); }

that, given two non-empty arrays A and B consisting of N integers and a non-empty array C consisting of M integers, returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.

        If it is not possible to nail all the planks, the function should return −1.

        For example, given arrays A, B, C such that:
        A[0] = 1    B[0] = 4

        A[1] = 4    B[1] = 5

        A[2] = 5    B[2] = 9

        A[3] = 8    B[3] = 10



        C[0] = 4

        C[1] = 6

        C[2] = 7

        C[3] = 10

        C[4] = 2

        the function should return 4, as explained above.

        Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..30,000];
        each element of arrays A, B, C is an integer within the range [1..2*M];
        A[K] ≤ B[K].





        C++
        #include
        #include
        #include
        int binsearch(vector< pair > &CP,int PlankB,int PlankE,int jmin)
        {
        int b,mid,e,value,resultpos,sjmin,j,CPsize;
        CPsize=CP.size();
        b=0;
        e=CP.size()-1;
        resultpos=-1;
// BinSearch for nail>=LeftPlankSide
        while (b<=e)
        {
        mid = ( b + e) / 2;
        value = CP[mid].first;
        if ( value >= PlankB )
        {
        e=mid-1;
        resultpos=mid;
        }
        else
        {
        b=mid+1;
        }
        }
        if (-1 == resultpos) return -1;
        value = CP[resultpos].first;
        if (value > PlankE) return -1;
// Linear Search for nail <= RightPlankSide
// with j sjmin=INT_MAX;
        while ( (value <= PlankE) && (resultpos < CPsize) )
        {
        j=CP[resultpos].second;
        if (j <= jmin ) return jmin;
        if (j < sjmin ) sjmin=j;
        resultpos++;
        if ( resultpos < CPsize ) value = CP[resultpos].first;
        }
        return sjmin;
        }
        int solution(vector &A, vector &B, vector &C)
        {
        int i,j,n,m,jmin;
        n = A.size();
        m = C.size();
        pair p(0,0);
        vector< pair > CP(m,p);
        for (j=0;j {
        CP[j].first =C[j];
        CP[j].second=j;
        }
        sort( CP.begin(), CP.end() );
        jmin=-1;
        for (i=0;i {
        jmin = binsearch(CP,A[i],B[i],jmin);
        if (-1==jmin) return -1;
        }
        return jmin+1;
        }
        Count-Triangles

        An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

        A[P] + A[Q] > A[R],
        A[Q] + A[R] > A[P],
        A[R] + A[P] > A[Q].


        For example, consider array A such that:
        A[0] = 10    A[1] = 2    A[2] = 5

        A[3] = 1     A[4] = 8    A[5] = 12

        There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

        For example, given array A such that:
        A[0] = 10    A[1] = 2    A[2] = 5

        A[3] = 1     A[4] = 8    A[5] = 12

        the function should return 4, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..1,000];
        each element of array A is an integer within the range [1..1,000,000,000].




        Python
        #include
        #include
        using namespace std;
        int solution(vector &A) {
        int len = A.size();
        std::sort(A.begin(), A.end());
        int s, ss, l, h, m;
        long long cnt = 0LL;
        for (int i = 0; i < len - 2; ++i)
        {
        ss = i + 2;
        for (int j = i + 1; j < len - 1; ++j)
        {
        l = ss;
        h = len - 1;
        s = -1;
        while (l <= h)
        {
        m = l + (h - l) / 2;
        if (A[m] >= A[i] + A[j])
        h = m - 1;
        else
        {
        s = m;
        l = m + 1;
        }
        }
        if (-1 != s)
        {
        ss = s;
        cnt += s - j;
        }
        }
        }
        return cnt;
        }

        C++
        #include
        #include
        using namespace std;
        int solution(vector &A) {
        int len = A.size();
        std::sort(A.begin(), A.end());
        int s, ss, l, h, m;
        long long cnt = 0LL;
        for (int i = 0; i < len - 2; ++i)
        {
        ss = i + 2;
        for (int j = i + 1; j < len - 1; ++j)
        {
        l = ss;
        h = len - 1;
        s = -1;
        while (l <= h)
        {
        m = l + (h - l) / 2;
        if (A[m] >= A[i] + A[j])
        h = m - 1;
        else
        {
        s = m;
        l = m + 1;
        }
        }
        if (-1 != s)
        {
        ss = s;
        cnt += s - j;
        }
        }
        }
        return cnt;
        }
        Abs-Distinct

        A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

        For example, consider array A such that:
        A[0] = -5

        A[1] = -3

        A[2] = -1

        A[3] =  0

        A[4] =  3

        A[5] =  6

        The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

        For example, given array A such that:
        A[0] = -5

        A[1] = -3

        A[2] = -1

        A[3] =  0

        A[4] =  3

        A[5] =  6

        the function should return 5, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
        array A is sorted in non-decreasing order.




        import java.util.Arrays;
public class AbsDistinct {
    public int solution(int[] A) {
// write your code in Java SE 8
        return (int)Arrays.stream(A).map(a->a<0?-a:a).distinct().count();
    }
}

C#
        using System;
        using System.Collections.Generic;
        using System.Collections;
        using System.Linq;

// you can also use other imports, for example:
// using System.Collections.Generic;

// you can write to stdout for debugging purposes, e.g.
// Console.WriteLine("this is a debug message");

class Solution {
    public int solution(int[] A) {
// write your code in C# 6.0 with .NET 4.5 (Mono)
        int len = A.Length;
//int[] B = A[len];

        if(len == 1) return 1;
        if(len == 0) return -1;

        for(int i=0;i {
            if(A[i]<0)
                A[i]=0-A[i];


        }

        int[] B = A.Distinct().ToArray();

        return B.Length;
    }
}
Count-Distinct-Slices

        An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.

        A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.

        For example, consider integer M = 6 and array A such that:
        A[0] = 3

        A[1] = 4

        A[2] = 5

        A[3] = 5

        A[4] = 2

        There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).

        The goal is to calculate the number of distinct slices.

        Write a function:

class Solution { public int solution(int M, int[] A); }

that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.

        If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.

        For example, given integer M = 6 and array A such that:
        A[0] = 3

        A[1] = 4

        A[2] = 5

        A[3] = 5

        A[4] = 2

        the function should return 9, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        M is an integer within the range [0..100,000];
        each element of array A is an integer within the range [0..M].





        int solution(int M, vector &A) {
        vector slice(M + 1, false);
        long long int res = 0;
        int front = 0, back = 0;
        while (front != A.size()) {
        if (back != A.size() && slice[A[back]] == false) {
        slice[A[back]] = true;
        ++back;
        }
        else {
        res += (back - front);
        if(res > 1000000000) {
        return 1000000000;
        }
        slice[A[front]] = false;
        ++front;
        }
        }

        return res;
        }

        Min-Abs-Sum-Of-Two

        Let A be a non-empty array consisting of N integers.

        The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

        For example, the following array A:
        A[0] =  1

        A[1] =  4

        A[2] = -3

        has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).

        The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.

        The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.

        The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.

        The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.

        The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.

        The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

        For example, given the following array A:
        A[0] =  1

        A[1] =  4

        A[2] = -3

        the function should return 1, as explained above.

        Given array A:
        A[0] = -8

        A[1] =  4

        A[2] =  5

        A[3] =-10

        A[4] =  3

        the function should return |(−8) + 5| = 3.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].




public int solution(int[] A) {
// write your code in Java SE 8
        int sum = 0;
        for(int i=0; i=0; i--) {
        if(rest == 0)
        break;
        if(A[i] > rest) {
        continue;
        }
        rest -= A[i];
        toSum += A[i];
        }
        int result1 = Math.abs(sum - 2*toSum);
        int sum2 = 0;
        for(int i=0; i if(i%2 == 0) {
        sum2 += A[i];
        }else {
        sum2 -=A[i];
        }
        }
        return Math.min(Math.abs(sum2),result1);
        }
        Tie-Ropes

        There are N ropes numbered from 0 to N − 1, whose lengths are given in an array A, lying on the floor in a line. For each I (0 ≤ I < N), the length of rope I on the line is A[I].

        We say that two ropes I and I + 1 are adjacent. Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the sum of lengths of both ropes. The resulting new rope can then be tied again.

        For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length is greater than or equal to K is maximal.

        For example, consider K = 4 and array A such that:
        A[0] = 1

        A[1] = 2

        A[2] = 3

        A[3] = 4

        A[4] = 1

        A[5] = 1

        A[6] = 3

        The ropes are shown in the figure below.

        We can tie:

        rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
        rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.


        After that, there will be three ropes whose lengths are greater than or equal to K = 4. It is not possible to produce four such ropes.

        Write a function:

class Solution { public int solution(int K, int[] A); }

that, given an integer K and a non-empty array A of N integers, returns the maximum number of ropes of length greater than or equal to K that can be created.

        For example, given K = 4 and array A such that:
        A[0] = 1

        A[1] = 2

        A[2] = 3

        A[3] = 4

        A[4] = 1

        A[5] = 1

        A[6] = 3

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        K is an integer within the range [1..1,000,000,000];
        each element of array A is an integer within the range [1..1,000,000,000].




        Python
        def solution(K, A):
        # The number of tied ropes, whose lengths
        # are greater than or equal to K.
        count = 0
        # The length of current rope (might be a tied one).
        length = 0
        for rope in A:
        length += rope # Tied with the previous one.
        # Find a qualified rope. Prepare to find the
        # next one.
        if length >= K: count += 1; length = 0
        return count
        Max-Nonoverlapping-Segments

        Located on a line are N segments, numbered from 0 to N − 1, whose positions are given in arrays A and B. For each I (0 ≤ I < N) the position of segment I is from A[I] to B[I] (inclusive). The segments are sorted by their ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.

        Two segments I and J, such that I ≠ J, are overlapping if they share at least one common point. In other words, A[I] ≤ A[J] ≤ B[I] or A[J] ≤ A[I] ≤ B[J].

        We say that the set of segments is non-overlapping if it contains no two overlapping segments. The goal is to find the size of a non-overlapping set containing the maximal number of segments.

        For example, consider arrays A, B such that:
        A[0] = 1    B[0] = 5

        A[1] = 3    B[1] = 6

        A[2] = 7    B[2] = 8

        A[3] = 9    B[3] = 9

        A[4] = 9    B[4] = 10

        The segments are shown in the figure below.

        The size of a non-overlapping set containing a maximal number of segments is 3. For example, possible sets are {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}. There is no non-overlapping set with four segments.

        Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two arrays A and B consisting of N integers, returns the size of a non-overlapping set containing a maximal number of segments.

        For example, given arrays A, B shown above, the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..30,000];
        each element of arrays A, B is an integer within the range [0..1,000,000,000];
        A[I] ≤ B[I], for each I (0 ≤ I < N);
        B[K] ≤ B[K + 1], for each K (0 ≤ K < N − 1).




class Solution {
    public int solution(int[] A, int[] B) {
        if(A.length==0 || B.length==0){
            return 0;
        }

        int ni=0;
        int c=1;
        for(int i=1;i if(A[i]>B[ni]){
            c++;
            ni=i;
        }
    }

return c;
}
}
        Binary-Gap

        A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

        For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

        Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

        For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647].



public int solution(int N) {
        int temp = 0;
        String bnry = Integer.toString(N, 2);
        String[] parts = bnry.split("1");
        int lenght = parts.length;
        if (N % 2 == 0) {
        lenght--;
        }
        for (int i = 0; i < lenght; i++) {
        if (parts[i].length() > temp) {
        temp = parts[i].length();
        }
        }
        return temp;
        }
        Number-Solitaire

        A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1. There is a number written on each square. A non-empty array A of N integers contains the numbers written on the squares. Moreover, some squares can be marked during the game.

        At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked. The goal of the game is to move the pebble to square number N − 1.

        During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces, and consider the number K, which shows on the upper face after the die comes to rest. Then we move the pebble standing on square number I to square number I + K, providing that square number I + K exists. If square number I + K does not exist, we throw the die again until we obtain a valid move. Finally, we mark square number I + K.

        After the game finishes (when the pebble is standing on square number N − 1), we calculate the result. The result of the game is the sum of the numbers written on all marked squares.

        For example, given the following array:
        A[0] = 1

        A[1] = -2

        A[2] = 0

        A[3] = 9

        A[4] = -1

        A[5] = -2

        one possible game could be as follows:

        the pebble is on square number 0, which is marked;
        we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
        we throw 5; the pebble does not move, since there is no square number 8 on the board;
        we throw 2; the pebble moves to square number 5; we mark this square and the game ends.


        The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. This is the maximal possible result that can be achieved on this board.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.

        For example, given the array
        A[0] = 1

        A[1] = -2

        A[2] = 0

        A[3] = 9

        A[4] = -1

        A[5] = -2

        the function should return 8, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−10,000..10,000].




        #include
        #include
        #include
        using namespace std;
        int solutionNumberSolitaire(const vector &A) {
        int len = A.size();
        vector memo(len, numeric_limits::min());
        memo[0] = A[0];
        for (int i = 1; i < len; ++i)
        {
        for (int j = 1; j <7; ++j)
        {
        if (i - j >= 0)
        memo[i] = std::max(memo[i], A[i] + memo[i - j]);
        }
        }
        return memo[len - 1];
        }
        Min-Abs-Sum

        For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

        val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

        (Assume that the sum of zero elements equals zero.)

        For a given array A, we are looking for such a sequence S that minimizes val(A,S).

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

        For example, given array:
        A[0] =  1

        A[1] =  5

        A[2] =  2

        A[3] = -2

        your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..20,000];
        each element of array A is an integer within the range [−100..100].




        1defgolden_min_abs_sum(A):2N = len(A)3M = 04foriinxrange(N):5A[i] = abs(A[i])6M = max(A[i], M)7S = sum(A)8count = [0]*(M + 1)9foriinxrange(N):10count[A[i]] += 111dp = [-1]*(S + 1)12dp[0] = 013forainxrange(1, M + 1):14ifcount[a] > 0:15forjinxrange(S):16ifdp[j] >= 0:17dp[j] = count[a]18elif(j >= aanddp[j - a] > 0):19dp[j] = dp[j - a] - 120result = S21foriinxrange(S // 2 + 1):22ifdp[i] >= 0:23result = min(result, S - 2*i)24returnresult
        Longest-Password

        You would like to set a password for a bank account. However, there are three restrictions on the format of the password:

        it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
        there should be an even number of letters;
        there should be an odd number of digits.


        You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and removing, the spaces. The goal is to choose the longest word that is a valid password. You can assume that if there are K spaces in string S then there are exactly K + 1 words.

        For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A" and "pass007". Thus the longest password is "pass007" and its length is 7. Note that neither "test" nor "?xy1" is a valid password, because "?" is not an alphanumerical character and "test" contains an even number of digits (zero).

        Write a function:

class Solution { public int solution(String S); }

that, given a non-empty string S consisting of N characters, returns the length of the longest word from the string that is a valid password. If there is no such word, your function should return −1.

        For example, given S = "test 5 a0A pass007 ?xy1", your function should return 7, as explained above.

        Assume that:

        N is an integer within the range [1..200];
        string S consists only of printable ASCII characters and spaces.


        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.



        C#
public static int LongestPassword(string value)
        {
        if (value == null || value.Length == 0) return -1;
        Regex r = new Regex(@"^[a-zA-Z0-9]+$");
        string[] passwords = value.Split(' ')
        .Where(x => x.Length % 2 != 0 && r.IsMatch(x) && x.Any(z => Char.IsDigit(z)))
        .ToArray();

        if(passwords.Length == 0)
        {
        return -1;
        }

        for (int i = 0; i < passwords.Length; i++)
        {
        string password = passwords[i];
        if(password.Length == 1)
        {
        continue;
        }


        int countLetter = 0;
        int countNumbers = 0;
        for (int j = 0; j < password.Length; j++)
        {
        char c = password[j];
        if (Char.IsLetter(c))
        {
        countLetter++;
        }

        if (Char.IsDigit(c))
        {
        countNumbers++;
        }

        if(j == password.Length - 1 && (countNumbers % 2 == 0 || countLetter % 2 != 0))
        {
        passwords[i] = null;
        }
        }
        }

        if(passwords.All(x => x == null))
        {
        return -1;
        }

        return passwords.Where(x => x != null).Max(x => x.Length);
        }

        Flood-Depth

        You are helping a geologist friend investigate an area with mountain lakes. A recent heavy rainfall has flooded these lakes and their water levels have reached the highest possible point. Your friend is interested to know the maximum depth in the deepest part of these lakes.

        We simplify the problem in 2-D dimensions. The whole landscape can be divided into small blocks and described by an array A of length N. Each element of A is the altitude of the rock floor of a block (i.e. the height of this block when there is no water at all). After the rainfall, all the low-lying areas (i.e. blocks that have higher blocks on both sides) are holding as much water as possible. You would like to know the maximum depth of water after this entire area is flooded. You can assume that the altitude outside this area is zero and the outside area can accommodate infinite amount of water.

        For example, consider array A such that:
        A[0] = 1

        A[1] = 3

        A[2] = 2

        A[3] = 1

        A[4] = 2

        A[5] = 1

        A[6] = 5

        A[7] = 3

        A[8] = 3

        A[9] = 4

        A[10] = 2

        The following picture illustrates the landscape after it has flooded:

        The gray area is the rock floor described by the array A above and the blue area with dashed lines represents the water filling the low-lying areas with maximum possible volume. Thus, blocks 3 and 5 have a water depth of 2 while blocks 2, 4, 7 and 8 have a water depth of 1. Therefore, the maximum water depth of this area is 2.

        Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximum depth of water.

        Given array A shown above, the function should return 2, as explained above.

        For the following array:
        A[0] = 5

        A[1] = 8

        the function should return 0, because this landscape cannot hold any water.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [1..100,000,000].




        def solution(A):
        maxH = 0
        minH = 0
        maxD = 0
        for a in A:
        if a > maxH:
        d = maxH - minH
        maxH = a
        minH = a
        elif a < minH:
        minH = a
        else:
        d = a - minH
        if d > maxD:
        maxD = d
        return maxD
        Slalom-Skiing

        You are a skier participating in a giant slalom. The slalom track is located on a ski slope, goes downhill and is fenced by barriers on both sides. The barriers are perpendicular to the starting line located at the top of the slope. There are N slalom gates on the track. Each gate is placed at a distinct distance from the starting line and from the barrier on the right-hand side (looking downhill).

        You start from any place on the starting line, ski down the track passing as many gates as possible, and finish the slalom at the bottom of the slope. Passing a gate means skiing through the position of the gate.

        You can ski downhill in either of two directions: to the left or to the right. When you ski to the left, you pass gates of increasing distances from the right barrier, and when you ski to the right, you pass gates of decreasing distances from the right barrier. You want to ski to the left at the beginning.

        Unfortunately, changing direction (left to right or vice versa) is exhausting, so you have decided to change direction at most two times during your ride. Because of this, you have allowed yourself to miss some of the gates on the way down the slope. You would like to know the maximum number of gates that you can pass with at most two changes of direction.

        The arrangement of the gates is given as an array A consisting of N integers, whose elements specify the positions of the gates: gate K (for 0 ≤ K < N) is at a distance of K+1 from the starting line, and at a distance of A[K] from the right barrier.

        For example, consider array A such that:
        A[0] = 15

        A[1] = 13

        A[2] = 5

        A[3] = 7

        A[4] = 4

        A[5] = 10

        A[6] = 12

        A[7] = 8

        A[8] = 2

        A[9] = 11

        A[10] = 6

        A[11] = 9

        A[12] = 3

        The picture above illustrates the example track with N = 13 gates and a course that passes eight gates. After starting, you ski to the left (from your own perspective). You pass gates 2, 3, 5, 6 and then change direction to the right. After that you pass gates 7, 8 and then change direction to the left. Finally, you pass gates 10, 11 and finish the slalom. There is no possible way of passing more gates using at most two changes of direction.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, describing the positions of the gates on the track, returns the maximum number of gates that you can pass during one ski run.

        For example, given the above data, the function should return 8, as explained above.

        For the following array A consisting of N = 2 elements:
        A[0] = 1

        A[1] = 5

        the function should return 2.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [1..1,000,000,000];
        the elements of A are all distinct.




        def LongestIncreasingSubsequence(seq):
        ''' The classic dynamic programming solution for longest increasing
        subsequence. More details could be found:
        https://en.wikipedia.org/wiki/Longest_increasing_subsequence
        http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
        http://stackoverflow.com/questions/3992697/longest-increasing-subsequence
        '''
        # smallest_end_value[i] = j means, for all i-length increasing
        # subsequence, the minmum value of their last elements is j.
        smallest_end_value = [None] * (len(seq) + 1)
        # The first element (with index 0) is a filler and never used.
        smallest_end_value[0] = -1
        # The length of the longest increasing subsequence.
        lic_length = 0
        for i in range(len(seq)):
        # Binary search: we want the index j such that:
        # smallest_end_value[j-1] < seq[i]
        # AND
        # ( smallest_end_value[j] > seq[i]
        # OR
        # smallest_end_value[j] == None
        # )
        # Here, the result "lower" is the index j.
        lower = 0
        upper = lic_length
        while lower <= upper:
        mid = (upper + lower) // 2
        if seq[i] < smallest_end_value[mid]:
        upper = mid - 1
        elif seq[i] > smallest_end_value[mid]:
        lower = mid + 1
        else:
        raise "Should never happen: " + \
        "the elements of A are all distinct"
        if smallest_end_value[lower] == None:
        smallest_end_value[lower] = seq[i]
        lic_length += 1
        else:
        smallest_end_value[lower] = \
        min(smallest_end_value[lower], seq[i])
        return lic_length
        def solution(A):
        # We are solving this question by creating two mirrors.
        bound = max(A) + 1
        multiverse = []
        for point in A:
        # The point in the double-mirror universe.
        multiverse.append(bound * 2 + point)
        # The point in the mirror universe.
        multiverse.append(bound * 2 - point)
        # The point in the original universe.
        multiverse.append(point)
        return LongestIncreasingSubsequence(multiverse)
        Dwarfs-Rafting

        A company of dwarfs is travelling across the New Zealand. On reaching the Clutha River the dwarfs need to get across, but recent storms have washed away the bridge. Luckily, a small ferry, in the form of a square raft, is operating.

        The raft is square and has N rows of seats, numbered from 1 to N. Each row contains N seats, labeled with consecutive letters (A, B, C, etc.). Each seat is identified by a string composed of its row number followed by its column number; for example, "9C" denotes the third seat in the 9th row.

        The raft has already been loaded with barrels in some seat positions, and other seats are already occupied by dwarfs. Our company of dwarfs may only take the remaining unoccupied seats. The ferryman wants to accommodate as many dwarfs as possible, but the raft needs to be stable when making the crossing. That is, the following conditions must be satisfied:

        the front and back halves of the raft (in terms of the rows of seats) must each contain the same number of dwarfs;
        similarly, the left and right sides of the raft (in terms of the columns of seats) must each contain the same number of dwarfs.


        You do not have to worry about balancing the barrels; you can assume that their weights are negligible.

        For example, a raft of size N = 4 is shown in the following illustration:

        Barrels are marked as brown squares, and seats that are already occupied by dwarfs are labeled d.

        The positions of the barrels are given in string S. The occupied seat numbers are given in string T. The contents of the strings are separated by single spaces and may appear in any order. For example, in the diagram above, S = "1B 1C 4B 1D 2A" and T = "3B 2D".

        In this example, the ferryman can accommodate at most six more dwarfs, as indicated by the green squares in the following diagram:

        The raft is then balanced: both left and right halves have the same number of dwarfs (four), and both front and back halves have the same number of dwarfs (also four).

        Write a function:

class Solution { public int solution(int N, String S, String T); }

that, given the size of the raft N and two strings S, T that describes the positions of barrels and occupied seats, respectively, returns the maximum number of dwarfs that can fit on the raft. If it is not possible to balance the raft with dwarfs, your function should return -1.

        For instance, given N = 4, S = "1B 1C 4B 1D 2A" and T = "3B 2D", your function should return 6, as explained above.

        Assume that:

        N is an even integer within the range [2..26];
        strings S, T consist of valid seat numbers, separated with spaces;
        each seat number can appear no more than once in the strings;
        no seat number can appear in both S and T simultaneously.


        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.



        def solution(A):
        # write your code in Python 3.6
        if len(A) < 3:
        return 0
        front = A[0]
        low = A[0]
        depth = 0
        for index in range(1, len(A)-1):
        if A[index] < A[index + 1]:
        if A[index + 1] > front:
        if A[index] < low:
        low = A[index]
        depth = max(front - low, depth)
        low = A[index]
        front = A[index +1]
        #print("First", index, depth)
        else:
        if A[index] < low:
        low = A[index]
        depth = max(A[index + 1] - low, depth)
        #print( "Second", index, depth
        elif A[index] >= front:
        front = A[index]
        low = A[index]
        elif A[index] < low:
        low = A[index]
        #print( index, front, low)
        return depth
        Tree-Height

        In this problem we consider binary trees, represented by pointer data structures.

        A binary tree is either an empty tree or a node (called the root) consisting of a single integer value and two further binary trees, called the left subtree and the right subtree.

        For example, the figure below shows a binary tree consisting of six nodes. Its root contains the value 5, and the roots of its left and right subtrees have the values 3 and 10, respectively. The right subtree of the node containing the value 10, as well as the left and right subtrees of the nodes containing the values 20, 21 and 1, are empty trees.

        A path in a binary tree is a non-empty sequence of nodes that one can traverse by following the pointers. The length of a path is the number of pointers it traverses. More formally, a path of length K is a sequence of nodes P[0], P[1], ..., P[K], such that node P[I + 1] is the root of the left or right subtree of P[I], for 0 ≤ I < K. For example, the sequence of nodes with values 5, 3, 21 is a path of length 2 in the tree from the above figure. The sequence of nodes with values 10, 1 is a path of length 1. The sequence of nodes with values 21, 3, 20 is not a valid path.

        The height of a binary tree is defined as the length of the longest possible path in the tree. In particular, a tree consisting of only one node has height 0 and, conventionally, an empty tree has height −1. For example, the tree shown in the above figure is of height 2.

        Problem

        Write a function:

class Solution { public int solution(Tree T); }

that, given a non-empty binary tree T consisting of N nodes, returns its height. For example, given tree T shown in the figure above, the function should return 2, as explained above. Note that the values contained in the nodes are not relevant in this task.

        Technical details

        A binary tree can be given using a pointer data structure. Assume that the following declarations are given:

class Tree {

    public int x;

    public Tree l;

    public Tree r;

}

    An empty tree is represented by an empty pointer (denoted by null). A non-empty tree is represented by a pointer to an object representing its root. The attribute x holds the integer contained in the root, whereas attributes l and r hold the left and right subtrees of the binary tree, respectively.

        For the purpose of entering your own test cases, you can denote a tree recursively in the following way. An empty binary tree is denoted by None. A non-empty tree is denoted as (X, L, R), where X is the value contained in the root and L and R denote the left and right subtrees, respectively. The tree from the above figure can be denoted as:
        (5, (3, (20, None, None), (21, None, None)), (10, (1, None, None), None))

        Assumptions

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..1,000];
        the height of tree T (number of edges on the longest path from root to leaf) is within the range [0..500].




class Solution {
    public int solution(Tree T) {
        if(T == null) return -1;
        int result = 0;
        result = Math.max(result, 1+solution(T.l));
        result = Math.max(result, 1+solution(T.r));
        return result;
    }
}
Str-Symmetry-Point

        Write a function:

class Solution { public int solution(String S); }

that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.

        Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.

        For example, given a string:

        "racecar"

        the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".

        Given a string:

        "x"

        the function should return 0, because both substrings are empty.

        Write an efficient algorithm for the following assumptions:

        the length of S is within the range [0..2,000,000].



        def solution(S):
        sLen = len(S)
        # Symmetry point is possible, when and only when the
        # string's length is odd.
        if sLen % 2 == 0: return -1
        # With a odd-length string, the only possible symmetry
        # point is the middle point.
        mid = sLen // 2
        begin, end = 0, sLen-1
        # The middle point of an odd-length string is symmetry
        # point, only when the string is symmetry.
        while begin < mid:
        if S[begin] != S[end]: return -1
        begin += 1
        end -= 1
        return mid
        Equi

        This is a demo task.

        An array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.

        A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].

        Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.

        For example, consider the following array A consisting of N = 8 elements:
        A[0] = -1

        A[1] =  3

        A[2] = -4

        A[3] =  5

        A[4] =  1

        A[5] = -6

        A[6] =  2

        A[7] =  1

        P = 1 is an equilibrium index of this array, because:

        A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]


        P = 3 is an equilibrium index of this array, because:

        A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]


        P = 7 is also an equilibrium index, because:

        A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0


        and there are no elements with indices greater than 7.

        P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.

        For example, given array A shown above, the function may return 1, 3 or 7, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].




        def solution(A):
        heading = 0 # The sum of A[0] + A[1] + ... + A[P-1]
        tailing = sum(A) # The sum of A[P] + A[P+1] + ... + A[N-2] + A[N-1]
        for index in xrange(len(A)):
        tailing -= A[index] # The sum of A[P+1] + ... + A[N-2] + A[N-1]
        if heading == tailing:
        # A[0] + A[1] + ... + A[P-1] == A[P+1] + ... + A[N-2] + A[N-1]
        return index
        heading += A[index]
        else:
        # No equilibrium is found.
        return -1
        Sql-Sum
        tresc	SELECT SUM(v) FROM elements
        Array-Inversion-Count

        An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].

        Write a function:

class Solution { public int solution(int[] A); }

    that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.

        For example, in the following array:
        A[0] = -1 A[1] = 6 A[2] = 3

        A[3] =  4 A[4] = 7 A[5] = 4

        there are four inversions:
        (1,2)  (1,3)  (1,5)  (4,5)

        so the function should return 4.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].



        def mergesort( aList, first, last ):
        ''' Modified merge sort algorithm.
        Record the inversion count during sort.
        '''
        mid = ( first + last ) / 2
        if first < last:
        # Recursive calling
        left_inver = mergesort( aList, first, mid )
        right_inver = mergesort( aList, mid + 1, last )
        else:
        # Terminate condition
        return 0
        first_index = first # The index for the left part
        second_index = mid + 1 # The index for the right part
        temp = [0] * (last-first+1) # To hold the sorted content
        temp_index = 0
        merge_inver = 0 # Number of inversion in merging
        while first_index <= mid and second_index <= last:
        if aList[first_index] <= aList[second_index]:
        # Less index indicates less value. No inversion.
        temp[temp_index] = aList[first_index]
        first_index += 1
        else:
        # Greater index has less value. Inversion exists.
        # For exampe:
        # [ 4, 5, 2, 3 ]
        # | Left part | |Right Part|
        # and first_index = 1, second_index = 3, mid = 2
        # We need the item "2" to be the position 0. So it
        # has to pass all the unwritten items in left part.
        # Here these unwritten items are "4" and "5". So
        # two more inversions are involved.
        # In general, the left part is sorted. So all the
        # elements, being and after first_index, are greater
        # than element in position second_index. AND all of
        # them have less indexes. As the result,
        # there are mid-first_index+1 new reversions.
        temp[temp_index] = aList[second_index]
        second_index += 1
        merge_inver += mid - first_index + 1
        temp_index += 1
        if first_index != mid+1:
        # Some element in the left part left. They have less
        # indexes, but greater values. Inversion involves.
        # BUT these inversions have already been counted.
        while first_index <= mid:
        temp[temp_index] = aList[first_index]
        first_index += 1
        temp_index += 1
        if second_index != last+1:
        # Some element in the right part left. They have both
        # greater indexes and values than all in the left part.
        # No inversion is involved.
        while second_index <= last:
        temp[temp_index] = aList[second_index]
        second_index += 1
        temp_index += 1
        # Rewrite the sorted content into the original array
        aList[first:last+1] = temp[:]
        return merge_inver + left_inver + right_inver
        def solution(A):
        return mergesort( A * 1, 0, len(A)-1)
        Odd-Occurrences-In-Array



        A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

        For example, in array A such that:
        A[0] = 9 A[1] = 3 A[2] = 9
        A[3] = 3 A[4] = 9 A[5] = 7
        A[6] = 9

        the elements at indexes 0 and 2 have value 9,
        the elements at indexes 1 and 3 have value 3,
        the elements at indexes 4 and 6 have value 9,
        the element at index 5 has value 7 and is unpaired.

        Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

        For example, given array A such that:
        A[0] = 9 A[1] = 3 A[2] = 9
        A[3] = 3 A[4] = 9 A[5] = 7
        A[6] = 9

        the function should return 7, as explained in the example above.

        Write an efficient algorithm for the following assumptions:

        N is an odd integer within the range [1..1,000,000];
        each element of array A is an integer within the range [1..1,000,000,000];
        all but one of the values in A occur an even number of times.



public int solution(int[] A) {
        Arrays.sort(A);
        int i, j, count = 0;
        for (i = 0; i < A.length; i++) {
        for (j = i + 1; j < A.length; j++) {
        if (A[i] == A[j])
        count++;
        else
        break;
        }
        if (count % 2 == 0)
        return A[i];
        else {
        count = 0;
        i = j - 1;
        }
        }
        return 0;
        }


public int solution(int[] A) {
        Arrays.sort(A);
        int i;
        for (i=0; i return A[i];
        }

        Cyclic-Rotation

        An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

        The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

        Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

        For example, given
        A = [3, 8, 9, 7, 6]

        K = 3

        the function should return [9, 7, 6, 3, 8]. Three rotations were made:
        [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]

        [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]

        [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

        For another example, given
        A = [0, 0, 0]

        K = 1

        the function should return [0, 0, 0]

        Given
        A = [1, 2, 3, 4]

        K = 4

        the function should return [1, 2, 3, 4]

        Assume that:

        N and K are integers within the range [0..100];
        each element of array A is an integer within the range [−1,000..1,000].


        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.



public int[] solution(int[] A, int K) {
        int[] shiftedArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        if (i + K >= A.length)
        shiftedArray[(i + K) % A.length] = A[i];
        else
        shiftedArray[i + K] = A[i];
        }
        return shiftedArray;
        }

class Solution
{
    public int[] solution(int[] a, int k) {
        if (a.length == 0){
            return a;
        }
        int modular = k % a.length;
        int index = a.length - modular;
        int newArray[] = new int[a.length];
        System.arraycopy( a, index, newArray, 0, a.length - index);
        if (index > 0){
            System.arraycopy( a, 0, newArray, a.length - index, index);
        }
        return newArray;
    }
}
Polygon-Concavity-Index

        An array A of points in a 2D plane is given. These points represent a polygon: every two consecutive points describe an edge of the polygon, and there is an edge connecting the last point and the first point in the array.

        A set of points in a 2D plane, whose boundary is a straight line, is called a semiplane. More precisely, any set of the form {(x, y) : ax + by ≥ c} is a semiplane. The semiplane contains its boundary.

        A polygon is convex if and only if, no line segment between two points on the boundary ever goes outside the polygon.

        For example, the polygon consisting of vertices whose Cartesian coordinates are consecutively:
        (-1, 3)   (3, 1)   (0, -1)   (-2, 1)

        is convex.

        The convex hull of a finite set of points in a 2D plane is the smallest convex polygon that contains all points in this set. For example, the convex hull of a set consisting of seven points whose Cartesian coordinates are:
        (-1, 3)   (1, 2)   (3, 1)   (1, 1)   (0, -1)   (-2, 1)  (-1, 2)

        is a polygon that has five vertices. When traversed clockwise, its vertices are:
        (-1, 3)   (1, 2)   (3, 1)   (0, -1)   (-2, 1)

        If a polygon is concave (that is, it is not convex), it has a vertex which does not lie on its convex hull border. Your assignment is to find such a vertex.

        Assume that the following declarations are given:

class Point2D {

    public int x;

    public int y;

}

    Write a function:

class Solution { public int solution(Point2D[] A); }

that, given a non-empty array A consisting of N elements describing a polygon, returns −1 if the polygon is convex. Otherwise, the function should return the index of any point that doesn't belong to the convex hull border. Note that consecutive edges of the polygon may be collinear (that is, the polygon might have 180−degrees angles).

        To access the coordinates of the K-th point (where 0 ≤ K < N), use the following syntax:

        A[K].x to access the x-coordinate,
        A[K].y to access the y-coordinate.


        For example, given array A such that:
        A[0].x = -1  A[0].y =  3

        A[1].x =  1  A[1].y =  2

        A[2].x =  3  A[2].y =  1

        A[3].x =  0  A[3].y = -1

        A[4].x = -2  A[4].y =  1

        the function should return −1, as explained in the example above.

        However, given array A such that:
        A[0].x = -1  A[0].y =  3

        A[1].x =  1  A[1].y =  2

        A[2].x =  1  A[2].y =  1

        A[3].x =  3  A[3].y =  1

        A[4].x =  0  A[4].y = -1

        A[5].x = -2  A[5].y =  1

        A[6].x = -1  A[6].y =  2

        the function should return either 2 or 6. These are the indices of the polygon lying strictly in its convex hull (that is, not on the convex hull border).

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [3..10,000];
        the coordinates of each point in array A are integers within the range [−1,000,000,000..1,000,000,000];
        no two edges of the polygon A intersect, other than meeting at their endpoints;
        array A does not contain duplicate points.




        def _IsClockwise(point_A, point_B, point_C):
        ''' Return the direction from points A -> B -> C.
        '''
        result = (point_B.x - point_A.x) * (point_C.y - point_A.y) -
        (point_B.y - point_A.y) * (point_C.x - point_A.x)
        # The direction of a->b->c is:
        if result > 0: return 1 # counter-clockwise
        elif result < 0: return -1 # clockwise
        else: return 0 # a staight line
        def solution(A):
        ''' The solution refers to:
        https://www.youtube.com/watch?v=0HZaRu5IupM
        '''
        # Find the lowest point(s) in y-axis.
        lowest_y = A[0].y
        lowest_y_index = []
        for i in xrange(len(A)):
        if A[i].y < lowest_y:
        lowest_y = A[i].y
        lowest_y_index = [i]
        elif A[i].y == lowest_y:
        lowest_y_index.append(i)
        else:
        continue
        # Find a point, which is not the lowest in y-axis and immediately
        # after a lowest-in-y-axis point.
        start_point = lowest_y_index[0]
        lowest_y_array = [False] * len(A)
        for i in lowest_y_index: lowest_y_array[i] = True
        while lowest_y_array[start_point] == True:
        start_point = (start_point + 1) % len(A)
        start_point = (start_point - 1 + len(A)) % len(A)
        # Re-organize the points so that, it is easier to check every three
        # consecutive points in one loop (without module operation %).
        rotated_A = A[start_point : ] + A[ : start_point]
        # We find the start point such that, the direction is non-zero.
        direction = _IsClockwise(rotated_A[-1], rotated_A[0], rotated_A[1])
        extened_A = rotated_A + rotated_A[:2]
        for i in xrange(len(A)):
        temp = _IsClockwise(extened_A[i], extened_A[i+1], extened_A[i+2])
        if temp * direction < 0:
        # Compute the original index and return
        return (i + 1 + start_point)%len(A)
        # Every point is on the convex hull.
        return -1
        alpha2010 (Prefix-Set)
        def solution(A):
        alphabet = set()
        for element in A:
        alphabet.add(element)
        for index in xrange(len(A)):
        alphabet.discard(A[index])
        if len(alphabet) == 0:
        return index 	odpowiedz
        beta2010 (Number-Of-Disc-Intersections)

        We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

        We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

        The figure below shows discs drawn for N = 6 and A as follows:
        A[0] = 1

        A[1] = 5

        A[2] = 2

        A[3] = 1

        A[4] = 4

        A[5] = 0

        There are eleven (unordered) pairs of discs that intersect, namely:

        discs 1 and 4 intersect, and both intersect with all the other discs;
        disc 2 also intersects with discs 0 and 3.


        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

        Given array A shown above, the function should return 11, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [0..2,147,483,647].




// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
        /* for each disc J in A w/ radius A[J], J *must* intersect with the previous A[J] discs
         * for disc J and K s.t. J < K, J intersects K iff J + A[J] >= K - A[K]
         * problem is when J + A[J] < K
         * need a way to know the number of discs prior to a position I that intersect w/ I
         * for I = K-A[K] s.t. K-A[K] > 0, I is the remaining number of discs that intersect w/ K
         * already know the number of discs prior to position I (which is simply I)
         * can calculate the number of discs prior to position I that *don't* intersect w/ I
         * if a disc doesn't intersect w/ I, it won't intersect w/ any position after I
         *
         * set count to zero
         * create array num_no_intersect of length N+1 (tracks number of discs before each position
         * that don't intersect that position)
         * for each disc J in A
         * if J - A[J] <= 0
         * count += J b/c disc J *must* intersect w/ the previous J discs
         * else
         * count += A[J] b/c disc J *must* intersect w/ the previous A[J] discs
         * count += J - A[J] - num_no_intersect[J-A[J]] b/c there are J-A[J] discs before disc J
         * w/ num_no_intersect[J-A[J]] that don't intersect position J-A[J]
         * which is *also* the left border of disc J
         * num_no_intersect[J+1] += num_no_intersect[J]
         * b/c discs that don't intersect position J also won't intersect position J+1
         * if J + A[J] + 1 < N (just after disc J's right border)
         * increment num_no_intersect[J+A[J]+1] b/c disc J doesn't intersect any discs on or after that
         * return count
         */
        class Solution {
        private static final int TEN_MILLION = 10000000;
        public int solution(int[] A) {
// write your code in Java SE 8
        int N = A.length, count = 0;
        int[] num_no_intersect = new int[N+1]; // tracks the number of discs prior to each position that doesn't intersect that position
        for (int J = 0; J < N; J++) {
        if (J <= A[J]) {
        count += J; // b/c disc J must intersect with the previous J discs
        }
        else {
        count += A[J]; // b/c disc J must intersect with the previous A[J] discs
        count += J-A[J] - num_no_intersect[J-A[J]]; // add number of discs before J's left border that intersect it
        }
        if (count > TEN_MILLION)
        return -1; // check for exceptional case
        num_no_intersect[J+1] += num_no_intersect[J]; // discs b/f position J also won't intersect position J+1
        if (A[J] < N && J+A[J]+1 < N) { // check bounds on A[J] to avoid arithmetic overflow
        num_no_intersect[J+A[J]+1]++; // disc J will not intersect positions on or after position J+A[J]+1
        }
        }
        return count;
        }
        }

        gamma2011 (Count-Palindromic-Slices)
        tresc
        def palindrome_substring(str):
        ''' Input: string
        Attention: the input string will be extended. For example,
        original string abc would be converted into #a#b#c#.
        Output: array, to say palindrome_len.
        palindrome_len[i] records the half width (include
        the element in position i) of palindrome substring,
        which centers in position i.
        Method: Manacher's algorithm
        Time complexity: O(n)
        '''
        str = "#" + "#".join(str) + "#" # Convert the original string so
        # that, every palindrome substring
        # in the new string has odd number
        # of elements.
        palindrome_len = [0] * len(str) # Store the half width (include the
        # center point) of the longest
        # palindrome substring with index
        # being the substring's center.
        # palindrome_len[i]-1 means the full
        # length of palindrome substring in
        # the original string.
        bound = 0 # Record the first positin, that the previous computed
        # palindrome substrings chould NOT achieve.
        center = 0 # Record the center position of the substring, which
        # is corresponding to "bound".
        for index in xrange(len(str)):
        if bound > index:
        # Part of current substring has already been compared.
        # For point "index", 2*center-index is the point
        # symmetrical to the points "center".
        palindrome_len[index] =
        min( palindrome_len[2*center-index], bound-index )
        else:
        # None of current substring has been compared.
        palindrome_len[index] = 1
        # Compare the uncompared elements one by one.
        while index-palindrome_len[index] >= 0 and
        index+palindrome_len[index] < len(str) and
        str[index-palindrome_len[index]] ==
        str[index+palindrome_len[index]]:
        palindrome_len[index] += 1
        if bound < palindrome_len[index] + index:
        # The bound has been extended.
        center = index
        bound = palindrome_len[index] + index
        return palindrome_len
        def solution(S):
        # With center point i, if the longest palindrome substring
        # has length of j, the number of palindrome substrings,
        # with the same center, is j//2.
        count = sum([
        (length-1)/2 for length in palindrome_substring(S) if length>2
        ])
        if count > 100000000:
        return -1
        else:
        return count
        Delta2011 (Min-Abs-Sum)

        For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

        val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

        (Assume that the sum of zero elements equals zero.)

        For a given array A, we are looking for such a sequence S that minimizes val(A,S).

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

        For example, given array:
        A[0] =  1

        A[1] =  5

        A[2] =  2

        A[3] = -2

        your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..20,000];
        each element of array A is an integer within the range [−100..100].




        def solution(A):
        # Since S could be 1 or -1, it does not matter that
        # each element in A is positive or negative.
        A = [abs(item) for item in A]
        sumOfA = sum(A)
        # Get the number distribution. So we do not need to try
        # each number for multiple times.
        numbers = {}
        for item in A: numbers[item] = numbers.get(item, 0) + 1
        # This is the KEY point.
        # Typically, we will use possible = [False] * len to track, which numbers
        # could be the result by summing up subsets of A.
        # For a number, appeared for many times, there will be multiple attempts
        # for it. But in this way, when we are trying number n,
        # possible[i] == -1 means it is impossible.
        # possible[i] == i >= 0 means it is possible and there are i n(s) left to use.
        # So for ALL number n(s), we only need ONE scan over the record.
        possible = [-1] * (sumOfA // 2 + 1)
        possible[0] = 0
        for number in numbers: # Try each distinct number
        for trying in xrange(sumOfA//2+1):
        if possible[trying] >= 0:
        # Can be reached with previous numbers
        possible[trying] = numbers[number]
        elif trying >= number and possible[trying-number] > 0:
        # Cannot be reached with only previous numbers.
        # But could be achieved with previous numbers AND current one.
        possible[trying] = possible[trying-number] - 1
        # Divide the A into two parts: P and Q, with restriction P <= Q.
        # So P <= sumOfA // 2 <= Q. We want the largest possible P, so that
        # Q-P is minimized.
        for halfSum in xrange(sumOfA//2, -1, -1):
        if possible[halfSum] >= 0:
        return sumOfA - halfSum - halfSum
        raise Exception("Should never be here!")
        return 0
        nu2011 (Double-Median)
        tresc
        import random
        def findTwoArrayMedian(A, B, AFrom, ATo, BFrom, BTo):
        # A classic question: find median in two sorted array
        # For more details, please Google it.
        result = 0
        while True:
        # AMid and BMid are current medians for A and B
        # sub-arrays respectively
        AMid = A[(AFrom+ATo)/2]
        BMid = B[(BFrom+BTo)/2]
        if AFrom == ATo:
        # Only one element in A's sub-array. No need
        # for further iteration
        if AMid < B[(BFrom+BTo)/2]:
        result = B[(BFrom+BTo)/2]
        elif AMid > B[(BFrom+BTo)/2+1]:
        result = B[(BFrom+BTo)/2+1]
        else:
        result = AMid
        break
        elif BFrom == BTo:
        # Only one element in B's sub-array. No need
        # for further iteration
        if BMid < A[(AFrom+ATo)/2]:
        result = A[(AFrom+ATo)/2]
        elif BMid > A[(AFrom+ATo)/2+1]:
        result = A[(AFrom+ATo)/2+1]
        else:
        result = BMid
        break
        elif AMid == BMid:
        # Median is found
        result = AMid
        break
        elif AMid > BMid:
        # Median must be in the left part of A's
        # sub-array OR the right part of B's sub-
        # array
        reduced = (min(ATo-AFrom, BTo-BFrom)+1)/2
        ATo -= reduced
        BFrom += reduced
        else:
        # Median must be in the right part of A's
        # sub-array OR the left part of B's sub-
        # array
        reduced = (min(ATo-AFrom, BTo-BFrom)+1)/2
        AFrom += reduced
        BTo -= reduced
        return result
        def findSingleArrayMedian(content):
        # Find the median in the unsorted array "content"
        # Methond: quick-select with shuffle
        begin = 0
        end = len(content)
        target = end/2
        random.shuffle(content)
        # Similar with 3-way quick-sort
        while True:
        current = content[begin]
        i, lt, gt = begin, begin, end - 1
        # After one while loop, all the elements, from (include)
        # begin to (exclude) lt, are less than chosen pivot
        # "current". All the elements, from (include) lt to
        # (include) gt, are same as the pivot. All the elements,
        # from (exclude) gt to end, are greater than pivot.
        while i <= gt:
        if content[i] < current:
        content[i], content[lt] = content[lt], content[i]
        i += 1
        lt += 1
        elif content[i] > current:
        content[i], content[gt] = content[gt], content[i]
        gt -= 1
        else:
        i += 1
        if target >= lt and target <= gt:
        # The median equals to the chosen pivot
        return content[target]
        elif target < lt:
        end = lt
        else:
        begin = gt + 1
        def solution(A, B, P, Q, R, S):
        questionCount = len(P)
        answer = [0] * questionCount
        for i in xrange(questionCount):
        # Find the median for each query
        answer[i] = findTwoArrayMedian(A, B, P[i], Q[i], R[i], S[i])
        # Find the median of the query results
        return findSingleArrayMedian(answer)

        sigma2012 (Stone-Wall)

        You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

        The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

        Write a function:

        class Solution { public int solution(int[] H); }

        that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

        For example, given array H containing N = 9 integers:
        H[0] = 8    H[1] = 8    H[2] = 5

        H[3] = 7    H[4] = 9    H[5] = 8

        H[6] = 7    H[7] = 4    H[8] = 8

        the function should return 7. The figure shows one possible arrangement of seven blocks.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array H is an integer within the range [1..1,000,000,000].



        import java.util.ArrayList;
        import java.util.List;
        public class StoneWall {
        public int solution(int[] H) {
        int len = H.length;
        Stack stack = new Stack<>(len);
        int blockCounter = 0;
        for (int i = 0; i < len; ++i) {
        int element = H[i];
        if (stack.isEmpty()) {
        stack.push(element);
        ++blockCounter;
        } else {
        while (!stack.isEmpty() && stack.peek() > element) {
        stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() == element) {
        continue;
        } else {
        stack.push(element);
        ++blockCounter;
        }
        }
        }
        return blockCounter;
        }
        public static class Stack {
        public List stack;
        public Stack(int capacity) {
        stack = new ArrayList<>(capacity);
        }
        public void push(T item) {
        stack.add(item);
        }
        public T pop() {
        T item = peek();
        stack.remove(stack.size() - 1);
        return item;
        }
        public T peek() {
        int position = stack.size();
        T item = stack.get(position - 1);
        return item;
        }
        public boolean isEmpty() {
        return stack.isEmpty();
        }
        }
        }

        upsilon2012 (Cartesian-Sequence)
        tresc 	class Cartesian_Tree():
        ''' The class to construct the Cartesian Tree
        '''
        class node(object):
        # __slots__ keyword is used to improve the performance
        __slots__ = ('key', 'value', 'right', 'left', 'parent', 'height')
        def __init__(self, key, value):
        self.key = key # Node's key
        self.value = value # Node's value
        self.right = None # Right Child
        self.left = None # Left Child
        self.parent = None # Parent Node
        self.height = 0 # The height of current sub-tree
        return
        def __init__(self, content):
        # Construction method:
        # http://en.wikipedia.org/wiki/Cartesian_tree#Efficient_construction
        self.nodes=[self.node(i, content[i]) for i in xrange(len(content))]
        self.root = self.nodes[0]
        for index in xrange(1, len(content)):
        prior = self.nodes[index-1]
        current = self.nodes[index]
        while prior.value <= current.value:
        # Finding a node with value greater than current node
        # Update the height information of nodes on the finding path
        # These nodes will NEVER be accessed again!
        # AND their height information is final.
        if prior.left != None:
        prior.height = max(prior.left.height+1, prior.height)
        if prior.right != None:
        prior.height = max(prior.right.height+1, prior.height)
        if prior.parent == None:
        # Cannot find the node with greater value
        # Current node will be the new root node
        current.left = prior
        current.height = prior.height + 1
        prior.parent = current
        self.root = current
        break
        prior = prior.parent
        else:
        # Find the node, to say x, with greater value
        # x.right will be current node's left son
        # And current node will be the x's new right son
        current.left = prior.right
        current.parent = prior
        if current.left != None:
        current.left.parent = current
        current.height = current.left.height + 1
        prior.right = current
        # Some nodes, on the path from last processed node to root,
        # might have out-of-date height information. Update them.
        prior = self.nodes[-1]
        while prior.parent != None:
        if prior.parent.height <= prior.height:
        prior.parent.height = prior.height + 1
        prior = prior.parent
        return
        def get_height(self):
        return self.root.height
        heigth = property(get_height)
        def solution(A):
        tree = Cartesian_Tree(A)
        return tree.heigth+1
        chi2012 (Cannonballs)

        A new kind of cannon is being tested. The cannon shoots cannonballs in a fixed direction. Each cannonball flies horizontally until it hits the ground, and then it rests there. Cannonballs are shot from different heights, so they hit the ground at different points.

        You are given two arrays, A and B, containing M and N integers respectively. Array A describes the landscape in the direction along which the cannon is shooting. Elements of array A represent the height of the ground, going from the cannon outwards. Array B contains levels from which consecutive cannonballs are shot.

        Assume that a cannonball is shot at level H.

        Let I be the smallest index, such that 0 < I < M and A[I] ≥ H. The cannonball falls at position I − 1 and increases the ground level A[I−1] by 1.
        If there is no such I, and H > A[I] for all 0 ≤ I < M, then the cannonball flies beyond the horizon and has no effect on the result.
        If H ≤ A[0], then the cannonball ricochets away and has no effect on the result either.


        Write a function:

        class Solution { public int[] solution(int[] A, int[] B); }

        that, given arrays A and B, simulates the flight of the cannonballs and returns the final contents of array A (denoted by A1) representing the final shape of the ground along the line of fire.

        For example, given the following arrays A and B, of size M = 9 and N = 11 respectively:
        A[0] = 1    A[1] = 2    A[2] = 0

        A[3] = 4    A[4] = 3    A[5] = 2

        A[6] = 1    A[7] = 5    A[8] = 7



        B[0] = 2    B[1] = 8    B[2] = 0

        B[3] = 7    B[4] = 6    B[5] = 5

        B[6] = 3    B[7] = 4    B[8] = 5

        B[9] = 6    B[10]= 5

        the function should return the following array A1 of M = 9 integers:
        A1[0] = 2    A1[1] = 2    A1[2] = 2

        A1[3] = 4    A1[4] = 3    A1[5] = 3

        A1[6] = 5    A1[7] = 6    A1[8] = 7

        Write an efficient algorithm for the following assumptions:

        M and N are integers within the range [0..30,000];
        each element of arrays A, B is an integer within the range [0..1,000,000].


        def solution(A, B):
        to_fall = [-1] * (max(B) + 1) # Store where the ball should
        # fall. to_fall[i] = j means,
        # the cannonball, which is shot
        # from heigth of i, will fall
        # at position j.
        # Scan and find the initial falling position for cannonballs
        # from each different shooting height.
        current_pos = 0 # Index for the landscape array A.
        # For all shooting heigthes <= A[0], the cannonballs do not
        # change the landscape. Keep the content being -1 and no need
        # to try them.
        for height in xrange( A[0]+1, max(B)+1 ):
        while current_pos < len(A) and height > A[current_pos]:
        current_pos += 1
        if current_pos == len(A):
        # No position could prevent the cannonball from flying
        # beyond the bound. These cannonballs do not change
        # the landscape. Keep the content being -1.
        break
        else:
        # The cannonball meets with a high enought position,
        # and falls at the previous position.
        to_fall[height] = current_pos - 1
        for cannonball in B:
        if to_fall[cannonball] == -1:
        # This cannonball would not change the landscape.
        continue
        else:
        fall_pos = to_fall[cannonball]
        A[ fall_pos ] += 1 # increases the ground by 1
        # For shooting height > A[fall_pos], the increase
        # is NOT enought to block/change their flying
        # path.
        # For shooting height < A[fall_pos] <= old A[fall_pos]
        # they cannot fly beyond this position both
        # before and after increase. NO change is
        # made for them.
        # ONLY for shooting height = A[fall_pos], its
        # flying path might be changed due to the
        # increase.
        to_fall[ A[ fall_pos ] ] = min(
        to_fall[ A[ fall_pos ] ], fall_pos-1)
        return A
        psi2012 (Wire-Burnouts)
        tresc 	class WeightedQuickUnion(object):
        ''' A class for weighted quick union data structure
        Details: https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
        '''
        ID = None # ID[i] = component identifier of i
        weight = None # weight[i] = number of nodes in the subtree(component)
        # with i being the root
        def __init__(self, size):
        assert size > 0
        # Each individual cell is a component
        self.ID = [i for i in xrange(size)]
        # Each component has only one item initially
        self.weight = [1 for i in xrange(size)]
        return
        def findRoot(self, cell):
        ''' Return the root of tree, to which cell belongs.
        That is, the component identifier of cell.
        '''
        assert 0 <= cell < len(self.ID)
        while cell != self.ID[cell]: cell = self.ID[cell]
        return cell
        def isConnected(self, p, q):
        ''' Check whether p and q belong to same component/tree.
        '''
        assert 0 <= p < len(self.ID) and 0 <= q < len(self.ID)
        return self.findRoot(p) == self.findRoot(q)
        def union(self, p, q):
        ''' Merge the components (trees), to which p and q belong
        '''
        assert 0 <= p < len(self.ID) and 0 <= q < len(self.ID)
        rootP = self.findRoot(p)
        rootQ = self.findRoot(q)
        # Already the same component
        if rootP == rootQ: return
        if self.weight[rootP] >= self.weight[rootQ]:
        self.ID[rootQ] = rootP
        self.weight[rootP] += self.weight[rootQ]
        else:
        self.ID[rootP] = rootQ
        self.weight[rootQ] += self.weight[rootP]
        return
        class Grid(object):
        ''' A wrapper class of WeightedQuickUnion for the current grid
        '''
        grid = None
        size = -1
        def __init__(self, size):
        self.grid = WeightedQuickUnion(size*size)
        # This is a size * size grid
        self.size = size
        return
        def isConnected(self, x1, y1, x2, y2):
        ''' Check whether the nodes (x1, y1) and (x2, y2) in the grid
        is connected or not.
        '''
        p = x1 * self.size + y1
        q = x2 * self.size + y2
        return self.grid.isConnected(p, q)
        def union(self, x1, y1, x2, y2):
        ''' Connect two nodes (x1, y1) and (x2, y2) in the grid
        '''
        p = x1 * self.size + y1
        q = x2 * self.size + y2
        self.grid.union(p, q)
        return
        def solution(N, A, B, C):
        # Not enough burn out wires to stop the current from flowing
        if len(A) < N + N - 2: return -1
        grid = Grid(N)
        # Get all the wires, which will burn out.
        removed = {}
        for index in xrange(len(A)):
        if C[index] == 0: removed[(A[index], B[index], A[index], B[index]+1)] = True
        else: removed[(A[index], B[index], A[index]+1, B[index])] = True
        # Add all the never-burn wires to the grid
        for x in xrange(N):
        for y in xrange(N):
        if y + 1 < N and not (x, y, x, y+1) in removed:
        grid.union(x, y, x, y+1)
        if x + 1 < N and not (x, y, x+1, y) in removed:
        grid.union(x, y, x+1, y)
        # Even if all the wires in A, B, and C burn out, the current is still flowing
        if grid.isConnected(0, 0, N-1, N-1): return -1
        for index in xrange(len(A)-1, -1, -1):
        # Recovery one burn-out wire
        if C[index] == 0:
        grid.union(A[index], B[index], A[index], B[index]+1)
        else:
        grid.union(A[index], B[index], A[index]+1, B[index])
        # After recovery, the current could flow.
        if grid.isConnected(0, 0, N-1, N-1): return index + 1
        # Would never be here.
        return -1
        omega2013 (Falling-Disks)
        tresc 	def solution(A, B):
        # Find the smallest diameter to achieve each position
        min_diameter_so_far = [A[0]] * len(A)
        for index in xrange(1, len(A)):
        min_diameter_so_far[index] = min(min_diameter_so_far[index-1], A[index])
        rings_index = len(A) - 1 # Travel the well from bottom to top
        fit_disks = 0 # The number of fitted disks
        for disks_index in xrange(len(B)):
        while min_diameter_so_far[rings_index] < B[disks_index]:
        rings_index -= 1
        if rings_index == -1:
        # No way to fit into the well for current disk, and
        # therefore the remaining disks.
        return fit_disks
        fit_disks += 1 # Current disk occupies this ring of well
        rings_index -= 1
        if rings_index == -1:
        # The toppest ring of well is used. No way to fit any
        # more disk.
        break
        return fit_disks
        helium2013 (Find-Three)
        tresc 	def solution(A, B):
        # Find the smallest diameter to achieve each position
        min_diameter_so_far = [A[0]] * len(A)
        for index in xrange(1, len(A)):
        min_diameter_so_far[index] = min(min_diameter_so_far[index-1], A[index])
        rings_index = len(A) - 1 # Travel the well from bottom to top
        fit_disks = 0 # The number of fitted disks
        for disks_index in xrange(len(B)):
        while min_diameter_so_far[rings_index] < B[disks_index]:
        rings_index -= 1
        if rings_index == -1:
        # No way to fit into the well for current disk, and
        # therefore the remaining disks.
        return fit_disks
        fit_disks += 1 # Current disk occupies this ring of well
        rings_index -= 1
        if rings_index == -1:
        # The toppest ring of well is used. No way to fit any
        # more disk.
        break
        return fit_disks
        lithium2013 (Clocks)
        tresc 	def lexicographically_min(A):
        ''' Return the given array in a Lexicographically Minimal
        Rotation (LMR)
        '''
        double_array = A + A
        array_len = len(A)
        start = 0 # The start point of the LMR so far
        testing = 1 # The start point of the next trying rotation
        offset = 0 # The offset in comparing two rotations
        while testing < array_len:
        if offset == array_len:
        # Pass all the test, the "start" begins the
        # lexicographically minimal array rotation
        break
        if double_array[start+offset] == double_array[testing+offset]:
        # So far, both rotations have the same lexicographically
        # value. So we move on to compare the next element.
        offset += 1
        elif double_array[start+offset] < double_array[testing+offset]:
        # The current trying rotation is lexicographically larger
        # The start point of LMR could not in the range
        # [testing, testing + offset]
        testing += offset + 1
        offset = 0
        else:
        # The current trying rotation is lexicographically smaller
        # The start point of LMR could not in the range
        # [start, start + offset]. AND
        # all the points in [start+1, testing-1] have been tested
        # not to be the start point of LRM
        start = max( start+offset+1, testing )
        testing = start + 1
        offset = 0
        return A[start:]+A[:start]
        def solution(A, P):
        columns = len(A[0])
        same_after_rotation = []
        # Compute the Lexicographically Minimal Rotation for the hands'
        # distance array. And use the LMR array as signature to identify
        # the same clocks
        for row_index in xrange(len(A)):
        A[row_index].sort() # Make the hands in order
        distance = [(A[row_index][column_index] -
        A[row_index][column_index-1]) % P
        for column_index in xrange(columns)]
        same_after_rotation.append( lexicographically_min(distance) )
        # Sort the LMR array for better counting the same clocks
        same_after_rotation.sort()
        # Count the same clocks. Notice that all the same clocks must
        # appear consecutively.
        current = same_after_rotation[0]
        current_count = 1
        same_pairs = 0
        for clock in same_after_rotation[1:]:
        if clock == current:
        current_count += 1
        else:
        same_pairs += current_count * ( current_count - 1 ) /2
        current_count = 1
        current = clock
        same_pairs += current_count * ( current_count - 1 ) /2
        return same_pairs
        boron2013 (Flags)

        A non-empty array A consisting of N integers is given.

        A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        has exactly four peaks: elements 1, 3, 5 and 10.

        You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

        Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

        For example, given the mountain range represented by array A, above, with N = 12, if you take:

        two flags, you can set them on peaks 1 and 5;
        three flags, you can set them on peaks 1, 5 and 10;
        four flags, you can set only three flags, on peaks 1, 5 and 10.


        You can therefore set a maximum of three flags in this case.

        Write a function:

        class Solution { public int solution(int[] A); }

        that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

        For example, the following array A:
        A[0] = 1

        A[1] = 5

        A[2] = 3

        A[3] = 4

        A[4] = 3

        A[5] = 4

        A[6] = 1

        A[7] = 2

        A[8] = 3

        A[9] = 4

        A[10] = 6

        A[11] = 2

        the function should return 3, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..400,000];
        each element of array A is an integer within the range [0..1,000,000,000].


        import java.util.*;
        class Solution {
        public int solution(int[] A) {
        if(A.length==1) return 0;
        ArrayList al=new ArrayList();
        for(int i=1;i {
        if(A[i]>A[i-1] && A[i]>A[i+1])
        {
        al.add(i);
        }
        }
        int s=al.size();
        if(s==1) return 1;
        if(s==0)return 0;
        s=(int) Math.ceil(Math.sqrt(A.length));
        while(s>=0) {
        int lp=al.get(0);
        int c=1;
        for(int i=1;i {
        int d=Math.abs(al.get(i)-lp);
        if(d>=s)
        {
        lp=al.get(i);
        c++;
        if(c==s)
        return c;
        }
        }
        s--;}
        return 0;}
        }
        oxygenium2014 (Count-Bounded-Slices)

        An integer K and a non-empty array A consisting of N integers are given.

        A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.

        A bounded slice is a slice in which the difference between the maximum and minimum values in the slice is less than or equal to K. More precisely it is a slice, such that max(A[P], A[P + 1], ..., A[Q]) − min(A[P], A[P + 1], ..., A[Q]) ≤ K.

        The goal is to calculate the number of bounded slices.

        For example, consider K = 2 and array A such that:
        A[0] = 3

        A[1] = 5

        A[2] = 7

        A[3] = 6

        A[4] = 3

        There are exactly nine bounded slices: (0, 0), (0, 1), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (4, 4).

        Write a function:

        class Solution { public int solution(int K, int[] A); }

        that, given an integer K and a non-empty array A of N integers, returns the number of bounded slices of array A.

        If the number of bounded slices is greater than 1,000,000,000, the function should return 1,000,000,000.

        For example, given:
        A[0] = 3

        A[1] = 5

        A[2] = 7

        A[3] = 6

        A[4] = 3

        the function should return 9, as explained above.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        K is an integer within the range [0..1,000,000,000];
        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].


        defboundedSlicesGolden(K, A):2N = len(A)34maxQ = [0]*(N + 1)5posmaxQ = [0]*(N + 1)6minQ = [0]*(N + 1)7posminQ = [0]*(N + 1)89firstMax, lastMax = 0, -110firstMin, lastMin = 0, -111j, result = 0, 01213foriinxrange(N):14while(j < N):15# added new maximum element16while(lastMax >= firstMaxandmaxQ[lastMax] <= A[j]):17lastMax -= 118lastMax += 119maxQ[lastMax] = A[j]20posmaxQ[lastMax] = j212
        22# added new minimum element23while(lastMin >= firstMinandminQ[lastMin] >= A[j]):24lastMin -= 125lastMin += 126minQ[lastMin] = A[j]27posminQ[lastMin] = j2829if(maxQ[firstMax] - minQ[firstMin] <= K):30j += 131else:32break33result += (j - i)34ifresult >= maxINT:35returnmaxINT36ifposminQ[firstMin] == i:37firstMin += 138ifposmaxQ[firstMax] == i:39firstMax += 140returnresul
