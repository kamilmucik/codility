package pl.es.sample;

public class Codility2 {
}

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 */
public class BinaryGap {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);

        int longestBinaryGap = 0;
        List onesList = new ArrayList();

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') continue;
            onesList.add(i);
        }

        for (int i = 0; i < onesList.size() - 1; i++) {
            //subtract 1 so that don't count 1's next to each other as having any gap
            int indicesDiff = onesList.get(i + 1) - onesList.get(i) - 1;

            longestBinaryGap = Math.max(longestBinaryGap, indicesDiff);
        }
        return longestBinaryGap;
    }
}


/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * <p>
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * <p>
 * For another example, given
 * A = [0, 0, 0]
 * K = 1
 * <p>
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * A = [1, 2, 3, 4]
 * K = 4
 * <p>
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] rotatedA = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            //rotated index needs to "wrap" around end of array
            int rotatedIndex = (i + K) % A.length;

            rotatedA[rotatedIndex] = A[i];
        }
        return rotatedA;
    }
}

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * <p>
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * <p>
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashMap<Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (occurrencesMap.containsKey(A[i])) {
                int occurrences = occurrencesMap.get(A[i]);
                occurrences++;
                occurrencesMap.put(A[i], occurrences); //increment occurrence counter and store it
            } else {
                occurrencesMap.put(A[i], 1); //1st occurrences of this value
            }
        }

        Set keySet = occurrencesMap.keySet();

        for (int currentKey : keySet) {
            int occurrences = occurrencesMap.get(currentKey);

            //if occurs odd number of times, we found the unpaired value - no need to continue checking
            if (occurrences % 2 != 0) return currentKey;
        }
        //should never get to here
        throw new RuntimeException("shouldn't get to here - should've return unpaired value by now");
    }
}

/**
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
 * <p>
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int Y, int D); }
 * <p>
 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 * <p>
 * For example, given:
 * X = 10
 * Y = 85
 * D = 30
 * <p>
 * the function should return 3, because the frog will be positioned as follows:
 * <p>
 * after the first jump, at position 10 + 30 = 40
 * after the second jump, at position 10 + 30 + 30 = 70
 * after the third jump, at position 10 + 30 + 30 + 30 = 100
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * X, Y and D are integers within the range [1..1,000,000,000];
 * X ≤ Y.
 */
class FrogJump {
    public int solution(int X, int Y, int D) {
        int distanceToJump = Y - X;
        int jumpsRequired = distanceToJump / D;
        if (distanceToJump % D != 0) {
            jumpsRequired++; //only add extra jump if remainder exists
        }
        return jumpsRequired;
    }
}

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * <p>
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
class PermutationMissingElement {
    public int solution(int[] A) {
        int max = A.length + 1;

        //load array elements into array so would be quick to check if elements exist
        Set incompleteSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            incompleteSet.add(A[i]);
        }

        for (int i = 1; i < max + 1; i++) {
            if (!incompleteSet.contains(i)) {
                return (i);
            }
        }
        throw new RuntimeException("shouldn't reach here");
    }
}

/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * <p>
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * For example, given:
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * <p>
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
class TapeEquilibrium {
    public int solution(int[] A) {
        long sumAllElements = 0;
        for (int i = 0; i < A.length; i++) {
            sumAllElements += A[i];
        }

        int minDifference = Integer.MAX_VALUE;
        int currentDifference = Integer.MAX_VALUE;
        long sumFirstPart = 0;
        long sumSecondPart = 0;

        for (int p = 0; p < A.length - 1; p++) {
            sumFirstPart += A[p];
            sumSecondPart = sumAllElements - sumFirstPart;
            currentDifference = (int) Math.abs(sumFirstPart - sumSecondPart);
            minDifference = Math.min(currentDifference, minDifference);
        }
        return minDifference;
    }
}

/**
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 * <p>
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * <p>
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
 * <p>
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * <p>
 * For example, given X = 5 and array A such that:
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * <p>
 * the function should return 6, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 */
class FrogRiverOne {
    public int solution(int X, int[] A) {
        SetrequiredLeavesSet = new HashSet();
        for (int i = 1; i <= X; i++) {
            requiredLeavesSet.add(i);
        }

        SetcurrentLeavesSet = new HashSet();

        for (int p = 0; p < A.length; p++) {
            currentLeavesSet.add(A[p]);
            //keep adding to current leaves set until it's at least the same size as required leaves set
            if (currentLeavesSet.size() < requiredLeavesSet.size()) continue;

            if (currentLeavesSet.containsAll(requiredLeavesSet)) {
                return p;
            }
        }
        return -1;
    }
}

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class MissingInteger {
    public int solution(int[] A) {
        Set testedSet = new TreeSet();
        Set perfectSet = new TreeSet();

        for (int i = 0; i < A.length; i++) {
            testedSet.add(A[i]);   //convert array to set to get rid of duplicates, order int's
            perfectSet.add(i + 1);  //create perfect set so can find missing int
        }

        for (int current : perfectSet) {
            if (!testedSet.contains(current)) {
                return current;
            }
        }

        if (perfectSet.size() == testedSet.size()) {
            return perfectSet.size() + 1;  //e.g. {1, 2, 3} should return 4
        }

        return 1; //default - e.g. if A array has negative values or just a single positive value like 10
    }
}


/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * <p>
 * is a permutation, but array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * <p>
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * <p>
 * the function should return 1.
 * <p>
 * Given array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * <p>
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
class PermutationCheck {
    public int solution(int[] A) {
        Set testedSet = new HashSet();
        Set perfectSet = new HashSet();

        for (int i = 0; i < A.length; i++) {
            testedSet.add(A[i]);
            perfectSet.add(i + 1);
        }

        for (int current : perfectSet) {
            //as soon as find 1 element missing return false
            if (!testedSet.contains(current)) return 0;
        }
        return 1;
    }
}

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * <p>
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * <p>
 * For example, given integer N = 5 and array A such that:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * <p>
 * the values of the counters after each consecutive operation will be:
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * <p>
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * <p>
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];

        int maxCounter = 0; //for the next re-set will know what high score to set all values
        int lastResetCounter = 0; //for setting values that were never explicitly set - at the end

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                if (counters[A[i] - 1] < lastResetCounter) {
                    counters[A[i] - 1] = lastResetCounter; //bring it up to last reset value } counters[A[i]-1]++; //store max counter in case need to set all counters to this value on next reset if(counters[A[i]-1] > maxCounter) {
                    maxCounter = counters[A[i] - 1];
                }

            } else {
                //keep track of last reset counter
                lastResetCounter = maxCounter;
            }
        }
        //set all values to last reset value that was never explicitly changed after last reset
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastResetCounter) {
                counters[i] = lastResetCounter;
            }
        }

        return counters;
    }
}

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
class CountDiv {
    public int solution(int A, int B, int K) {
        int divisors = 0;

        //nothing to do when K > B
        if (K > B) {
            if (A == 0 || B == 0) {
                return 1; //K mod 0 == 0 so count a single divisor
            }
            return 0; //no divisors when A, B both != 0
        }

        if (A == 0) {
            divisors++;  //K mod 0 == 0
        }

        int updatedA = A;
        if (K > A) {
            updatedA = K; //skip checking all values < K
        }

        int firstNonZeroDivisor = 0;
        int lastNonZeroDivisor = 0;

        for (int i = updatedA; i <= B; i++) {
            if (i % K == 0) {
                firstNonZeroDivisor = i;
                break;
            }
        }
        for (int i = B; i >= updatedA; i--) {
            if (i % K == 0) {
                lastNonZeroDivisor = i;
                break;
            }
        }
        if (firstNonZeroDivisor == 0 && lastNonZeroDivisor == 0) {
            divisors = 0;
        } else {
            divisors += ((lastNonZeroDivisor - firstNonZeroDivisor) / K) + 1;
        }

        return divisors;
    }
}

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * <p>
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * <p>
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * <p>
 * the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
class PassingCars {
    public int solution(int[] A) {
        int zeros = 0;
        int carPasses = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeros++;
            } else if (A[i] == 1) { //for every 1 - there will be an extra car pass for ALL the 0's that came before it carPasses += zeros; if(carPasses > 1000000000) {
                return -1;
            } else throw new RuntimeException("shouldn't reach here");
        }
        return carPasses;
    }
}


/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * <p>
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * <p>
 * the function should return the values [2, 4, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
class GenomicRangeQuery {
    //main idea: keep running occurrence count of each nucleotide (A/C/G/T) at every position in S
    public int[] solution(String S, int[] P, int[] Q) {
        int[] answers = new int[P.length];
        int stringLength = S.length();

        int[][] occurrences = new int[stringLength][4];

        //step 1 - for each row, count occurrences of each nucleotide (can only have 1 occurrence / row)
        //e.g. if S=CAGCCTA array will be
        //{
        //  {0,1,0,0}  C
        //  {1,0,0,0}  A
        //  {0,0,1,0}  G
        //  {0,1,0,0}  C
        //  {0,1,0,0}  C
        //  {0,0,0,1}  T
        //  {1,0,0,0}  A
        // }
        for (int i = 0; i < occurrences.length; i++) {
            char c = S.charAt(i);
            if (c == 'A') occurrences[i][0] = 1;
            else if (c == 'C') occurrences[i][1] = 1;
            else if (c == 'G') occurrences[i][2] = 1;
            else if (c == 'T') occurrences[i][3] = 1;
        }

        //step 2 - for each row (starting from 2nd row), add up occurrences of each nucleotide by adding
        //occurrences from previous row to current row
        //now have running sum of each nucleotide for any row
        //e.g. if S=CAGCCTA array will be
        //{
        //  {0,1,0,0}  C
        //  {1,1,0,0}  A
        //  {1,1,1,0}  G
        //  {1,2,1,0}  C
        //  {1,3,1,0}  C
        //  {1,3,1,1}  T
        //  {2,3,1,1}  A
        // }
        for (int i = 1; i < stringLength; i++) {
            for (int j = 0; j < 4; j++) {
                occurrences[i][j] += occurrences[i - 1][j];
            }
        }

        //check each slice for min by simple subtraction
        for (int i = 0; i < P.length; i++) {
            int index1 = P[i];
            int index2 = Q[i];

            for (int j = 0; j < 4; j++) {
                int lowerIndexCount = 0; //when index1 not at beginning of String - need to get occurrences from just before //beginning of slice - to see if that nucleotide occurred within slice //e.g. if slice is (2, 4), need to check for occurrences of A, C, G, T from index 1 to 4 if(index1-1 >= 0) {
                lowerIndexCount = occurrences[index1 - 1][j];
            }

            if (occurrences[index2][j] - lowerIndexCount > 0) {
                answers[i] = j + 1; //nucleotide value is 1 more than loop value (A=1, C=2, G=3, T=4)
                //no need to keep checking since always checking from smallest impact factor
                //as soon as find occurrence, that has to be minimum, cause subsequent nucleotides have
                //larger impact factor
                break;
            }
        }
    }
    return answers;
}
}

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * <p>
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * <p>
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * <p>
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
class MinAverageTwoSlice {
    public int solution(int[] A) {

        //main idea: will find min average by checking only 2 and 3 contiguous elements at a time
        int sum1, sum2 = 0;
        double minAverage = Double.MAX_VALUE;
        double currentAverage1 = Double.MAX_VALUE;
        double currentAverage2 = Double.MAX_VALUE;
        int minAverageSliceIndex = 0; //for size 2 arrays, this will always be true

        //if array is > 2 elements
        for (int i = 0; i < A.length - 2; i++) {
            sum1 = A[i] + A[i + 1];
            currentAverage1 = sum1 / 2.0d;
            if (currentAverage1 < minAverage) {
                minAverage = currentAverage1;
                minAverageSliceIndex = i;
            }

            sum2 = sum1 + A[i + 2];
            currentAverage2 = sum2 / 3.0d;
            if (currentAverage2 < minAverage) {
                minAverage = currentAverage2;
                minAverageSliceIndex = i;
            }
        }

        //check last 2 contiguous elements from the end - they won't otherwise be checked because
        //when checking 2 and 3 contiguous elements at a time, will stop checking 3 elements from the end
        currentAverage1 = (A[A.length - 2] + A[A.length - 1]) / 2.0d;
        if (currentAverage1 < minAverage) {
            minAverage = currentAverage1;
            minAverageSliceIndex = A.length - 2;
        }

        return minAverageSliceIndex;
    }
}

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * <p>
 * contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * <p>
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 * <p>
 * For example, given array A such that:
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * <p>
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
class MaxProductOfThree {
    public int solution(int[] A) {
        List aList = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            aList.add(A[i]);
        }
        Collections.sort(aList);

        int product1, product2, product3, product4 = 0;

        product1 = aList.get(0) * aList.get(1) * aList.get(2); //first 3 elements
        product2 = aList.get(aList.size() - 3) * aList.get(aList.size() - 2) * aList.get(aList.size() - 1); //last 3 elements
        product3 = aList.get(0) * aList.get(1) * aList.get(aList.size() - 1); //first 2 and last element
        product4 = aList.get(0) * aList.get(aList.size() - 2) * aList.get(aList.size() - 1); //first and last 2 elements

        int max1 = Math.max(product1, product2);
        int max2 = Math.max(product3, product4);

        return Math.max(max1, max2);
    }
}

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * <p>
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class Distinct {
    public int solution(int[] A) {
        if (A.length == 0) return 0;

        Set aSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            aSet.add(A[i]);
        }
        return aSet.size();
    }
}

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * <p>
 * For example, consider array A such that:
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * <p>
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * <p>
 * the function should return 1, as explained above. Given array A such that:
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * <p>
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class Triangle {
    public int solution(int[] A) {
        if (A.length < 3) return 0;

        List aList = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            aList.add(A[i]);
        }
        Collections.sort(aList); //made long array because each int element can be as high as Integer.MAX_VALUE so when add them //can overflow int long [] aOrdered = new long[A.length]; int index = 0; for(Integer i : aList) { aOrdered[index++] = i; } //start from the end (largest) //if previous 2 elements have sum > current element, found a triangle
        for (int i = aOrdered.length - 1; i >= 2; i--) {
            if (aOrdered[i - 1] + aOrdered[i - 2] > aOrdered[i]) {
                return 1;
            }
        }
        return 0;
    }
}

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p>
 * https://codility-frontend-prod.s3.amazonaws.com/media/task_static/number_of_disc_intersections/static/images/auto/0eed8918b13a735f4e396c9a87182a38.png
 * <p>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 */
class NumberOfDiscIntersections {
    public int solution(int[] A) {
        List aList = new ArrayList();

        for (int i = 0; i < A.length; i++) {
            //need explicit cast to long on right side for case when A[i] is Integer.MAX_VALUE and adding would cause overflow
            long leftMost = i - (long) A[i];
            long rightMost = i + (long) A[i];

            aList.add(new Circle(leftMost, rightMost));
        }

        Collections.sort(aList, new CircleComparator());

        Circle[] aOrderedCircles = new Circle[A.length];
        int index = 0;

        for (Circle circle : aList) {
            aOrderedCircles[index++] = circle;
        }

        int intersections = 0;

        for (int i = 0; i < aOrderedCircles.length - 1; i++) {
            for (int j = i + 1; j < aOrderedCircles.length; j++) { //check intersection by comparing rightmost x with leftmost x of next element if(aOrderedCircles[i].rightMostX >= aOrderedCircles[j].leftMostX) {
                intersections++;

                if (intersections > 10000000) return -1;
            }
            //as soon as don't find intersection, stop counting cause circles are ordered so all subsequent circles won't intersect
        else break;
        }
    }
    return intersections;
}

class Circle {
    long leftMostX;
    long rightMostX;

    Circle(long pLeftMostX, long pRightMostX) {
        leftMostX = pLeftMostX;
        rightMostX = pRightMostX;
    }
}

//reference: https://stackoverflow.com/questions/2839137/how-to-use-comparator-in-java-to-sort
class CircleComparator implements Comparator {

    @Override
    public int compare(Circle pCircle1, Circle pCircle2) {
        if (pCircle1.leftMostX < pCircle2.leftMostX) return -1; //e.g. circle1 (-4, 6) < circle2 (-2, 9)
        if (pCircle2.leftMostX < pCircle1.leftMostX) return 1;  //e.g. circle2 (-4, 6) < circle1 (-3, 1)
        if (pCircle1.rightMostX < pCircle2.rightMostX) return -1; //e.g. circle1 (-4, 3) < circle2 (-4, 6)
        if (pCircle2.rightMostX < pCircle1.rightMostX) return 1;  //e.g. circle2 (-4, 3) < circle1 (-4, 1)

        return 0;  //e.g. circle1 (-2, 2), circle2 (-2, 2)
    }
}
}


/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * <p>
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * https://codility-frontend-prod.s3.amazonaws.com/media/task_static/stone_wall/static/images/auto/4f1cef49cc46d451e88109d449ab7975.png
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 */
class StoneWall {
    public int solution(int[] H) {

        //e.g. H[0] = 2 would be a block of size (0, 2)
        Block currentBlock = new Block(0, H[0]);
        Stack blockStack = new Stack();

        blockStack.add(currentBlock);
        int blocksRequired = 1;

        for (int i = 1; i < H.length; i++) {
            Block topStackBlock = blockStack.peek(); //remove any stack blocks that are taller than current block while(topStackBlock.upperHeight > H[i] ) {
            blockStack.pop();
            if (!blockStack.isEmpty()) {
                topStackBlock = blockStack.peek();
            } else break;
        }

        if (blockStack.isEmpty()) {
            blockStack.push(new Block(0, H[i]));
            blocksRequired++;
        }
        //block already exists in stack
        else if (blockStack.peek().upperHeight - H[i] == 0) {
            continue;
        }
        //put in a new block - need to calculate delta between tallest stack block and current block
        else {
            topStackBlock = blockStack.peek();
            blockStack.push(new Block(blockStack.peek().upperHeight, H[i]));
            blocksRequired++;
        }
    }

    return blocksRequired;
}

class Block {
    int lowerHeight;
    int upperHeight;

    Block(int pLowerHeight, int pUpperHeight) {
        lowerHeight = pLowerHeight;
        upperHeight = pUpperHeight;
    }
}
}

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
class Brackets {
    public int solution(String S) {
        if (S.length() % 2 != 0) return 0; //all odd numbered strings can't be properly nested

        Stack charStack = new Stack();

        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (isOpeningBracket(currentChar)) {
                charStack.push(currentChar);
            } else {
                //adding closing bracket to empty stack will never become properly nested
                if (charStack.size() == 0) {
                    return 0;
                }
                char poppedChar = charStack.pop();
                if (isBracketMatch(poppedChar, currentChar)) {
                    continue;
                } else return 0;
            }
        }
        if (charStack.isEmpty()) return 1;

        return 0;
    }

    boolean isOpeningBracket(char pC) {
        if (pC == '[' || pC == '(' || pC == '{') {
            return true;
        }
        return false;
    }

    boolean isBracketMatch(char pC1, char pC2) {
        if (pC1 == '[' && pC2 == ']') return true;
        if (pC1 == '(' && pC2 == ')') return true;
        if (pC1 == '{' && pC2 == '}') return true;

        return false;
    }
}


/**
 * You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.
 * <p>
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.
 * <p>
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
 * <p>
 * 0 represents a fish flowing upstream,
 * 1 represents a fish flowing downstream.
 * <p>
 * If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:
 * <p>
 * If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * <p>
 * We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.
 * <p>
 * For example, consider arrays A and B such that:
 * A[0] = 4    B[0] = 0
 * A[1] = 3    B[1] = 1
 * A[2] = 2    B[2] = 0
 * A[3] = 1    B[3] = 0
 * A[4] = 5    B[4] = 0
 * <p>
 * Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and therefore stay alive.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.
 * <p>
 * For example, given the arrays shown above, the function should return 2, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000];
 * each element of array B is an integer that can have one of the following values: 0, 1;
 * the elements of A are all distinct.
 */
class Fish {
    public int solution(int[] A, int[] B) {
        final int UPSTREAM = 0;

        Stack fishStack = new Stack();
        fishStack.push(new Fish1(A[0], B[0]));

        for (int i = 1; i < A.length; i++) {
            if (B[i] == fishStack.peek().direction) { //same direction, so put another fish on stack fishStack.push(new Fish1(A[i], B[i])); } //if top of stack fish is upstream, not right condition to see who's eating who else if(fishStack.peek().direction == UPSTREAM) { fishStack.push(new Fish1(A[i], B[i])); } else { //figure out who's eating who while(!fishStack.isEmpty()) { //current fish is swimming in same direction as top of stack fish - they can't eat other if(fishStack.peek().direction == B[i]) { fishStack.push(new Fish1(A[i], B[i])); break; } else { //existing fish that was on stack eats latest fish if(fishStack.peek().size > A[i]) {
                break; //eating finished
            } else {
                fishStack.pop();
                continue; //keep checking other elements on stack
            }
        }
    }
        if(fishStack.isEmpty())

    {
        fishStack.push(new Fish1(A[i], B[i])); //current fish ate all the fish in the stack
    }
}
    }
            return fishStack.size();
            }

class Fish1 {
    private int size;
    private int direction;

    Fish1(int pSize, int pDirection) {
        size = pSize;
        direction = pDirection;
    }
}
}


/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */
class Nesting {
    public int solution(String S) {
        if (S.length() % 2 != 0) return 0; //all odd numbered strings can't be properly nested

        Stack charStack = new Stack();

        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (isOpeningBracket(currentChar)) {
                charStack.push(currentChar);
            } else {
                //adding closing bracket to empty stack will never become properly nested
                if (charStack.size() == 0) {
                    return 0;
                }
                char poppedChar = charStack.pop();
                if (isBracketMatch(poppedChar, currentChar)) {
                    continue;
                } else return 0;
            }
        }
        if (charStack.isEmpty()) return 1;

        return 0;
    }

    boolean isOpeningBracket(char pC) {
        if (pC == '(') {
            return true;
        }
        return false;
    }

    boolean isBracketMatch(char pC1, char pC2) {
        if (pC1 == '(' && pC2 == ')') return true;

        return false;
    }
}


/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * <p>
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * <p>
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class Dominator {

public int solution(int[] A) {
Stack stack = new Stack();

for (int i = 0; i < A.length; i++) {
if (stack.isEmpty()) {
    stack.push(A[i]);
} else {
    if (stack.peek().intValue() == A[i]) {
        stack.push(A[i]);
    } else {
        stack.pop();
    }
}
}
//no candidate if stack is empty
if (stack.isEmpty()) return -1;
int candidate = stack.peek().intValue();
int count = 0;
int candidateIndex = -1;
for (int i = 0; i < A.length; i++) {
if (A[i] == candidate) {
    count++;
    if (candidateIndex < 0) {
        candidateIndex = i; //only store index of first occurence of candidate } } } //works for even and odd number of A elements //e.g. if A.length = 4, count needs to be > 2
        //e.g. if A.length = 5, count needs to be > 2
        if (count > (A.length / 2)) return candidateIndex;

        return -1; //no dominator found
    }
}

/**
 *

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


 */
class EquiLeader {
    public int solution(int[] A) {
        Stack stack = new Stack();

        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
            } else {
                if (stack.peek().intValue() == A[i]) {
                    stack.push(A[i]);
                } else {
                    stack.pop();
                }
            }
        }
        //no equi leaders if stack is empty
        if (stack.isEmpty()) return 0;
        int candidate = stack.peek().intValue();
        int dominatorCount = 0;

        Map<Integer, Integer> dominatorMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                dominatorCount++;
                dominatorMap.put(i, dominatorCount);
            }
        } //works for even and odd number of A elements //e.g. if A.length = 4, count needs to be > 2
        //e.g. if A.length = 5, count needs to be > 2
        int equiLeaders = 0;
        if (dominatorCount > (A.length / 2)) {
            //find all equi leader sequences

            int lastCandidateOccurenceIndex = 0;
            int runningDominatorCount = 0;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] == candidate) {
                    lastCandidateOccurenceIndex = i;
                    runningDominatorCount = dominatorMap.get(i).intValue();
                } else if (dominatorMap.get(lastCandidateOccurenceIndex) != null) {
                    runningDominatorCount = dominatorMap.get(lastCandidateOccurenceIndex).intValue();
                }
                if (runningDominatorCount > (i + 1) / 2) {
                    if ((dominatorCount - runningDominatorCount) > (A.length - (i + 1)) / 2) {
                        equiLeaders++;
                    }
                }
            }
        }
        return equiLeaders;
    }
}

/**
 *

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


 */
    class MaxProfit {

        public int solution(int[] A) {
            if(A.length < 2) return 0; //for empty array or 1 element array, no profit can be realized

            //convert profit table to delta table so can use max slice technique
            int [] deltaA = new int[A.length];
            deltaA[0] = 0;
            for(int i=1; i<A.length; i++) {
                deltaA[i] = A[i] - A[i-1];
            }

            int absoluteMax = deltaA[0];
            int localMax = deltaA[0];
            int nextSum = 0;
            int currentElement = 0;

            for (int i = 1; i < deltaA.length; i++) { currentElement = deltaA[i]; nextSum = localMax + currentElement; localMax = Math.max(deltaA[i], nextSum); absoluteMax = Math.max(absoluteMax, localMax); } if(absoluteMax > 0) return absoluteMax;

            return 0;
        }
    }

    /**
     *

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


     */
    class MaxDoubleSlice {
        public int solution(int[] A) {
            int[] slice1LocalMax = new int[A.length];
            int[] slice2LocalMax = new int[A.length];

            //start from i=1 because slice can't start at index 0
            for(int i = 1; i < A.length-1; i++) { slice1LocalMax[i] = Math.max(slice1LocalMax[i-1] + A[i], 0); } //start from i=A.length-2 because slice can't end at index A.length-1 for(int i = A.length-2; i > 0; i--){
            slice2LocalMax[i] = Math.max(slice2LocalMax[i+1]+A[i], 0);
        }

        int maxDoubleSliceSum = 0;

        //compute sums of all slices to find absolute max
    for(int i = 1; i < A.length-1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, slice1LocalMax[i-1] + slice2LocalMax[i+1]);
        }

    return maxDoubleSliceSum;
    }
}
/**
 *

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


 */
    class MaxSliceSum {
        public int solution(int[] A) {
            int absoluteMax = A[0];
            int localMax = A[0];
            int nextSum = 0;
            int currentElement = 0;

            for (int i = 1; i < A.length; i++) {
                currentElement = A[i];
                nextSum = localMax + currentElement;
                localMax = Math.max(A[i], nextSum);
                absoluteMax = Math.max(absoluteMax, localMax);
            }
            return absoluteMax;
        }
    }

/**
 *

 A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

 For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

 Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the number of its factors.

 For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..2,147,483,647].


 */
    class CountFactors {
        public int solution(int N) {
            int factors = 0;
            int squareRootN = (int) Math.sqrt(N);
            if(Math.pow(squareRootN, 2) != N) {
                squareRootN++; //round up for any non-perfect squares
            }
            else { //perfect squares have an additional factor
                factors++;
            }

            for(int i=1; i<squareRootN; i++) {
                if(N % i == 0) {
                    factors += 2;
                }
            }

            return factors;
        }
    }
/**
 *

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


 */
    class MinPerimeterRectangle {
        public int solution(int N) {
            int squareRootN = (int) Math.sqrt(N);

            int factor2 = 0;
            int perimeter = 0;
            int minPerimeter = Integer.MAX_VALUE;

            if(Math.pow(squareRootN, 2) != N) {
                squareRootN++; //round up for any non-perfect squares
            }
            else { //perfect square root won't be reached inside loop so calculate and set min perimeter
                minPerimeter = 2 * (squareRootN + squareRootN);
            }

            for(int i=1; i<squareRootN; i++) {
                if(N % i == 0) {
                    //calculate 2nd factor by simple division since know 1st factor and N
                    factor2 = N / i;
                    perimeter = 2 * (factor2 + i);
                    minPerimeter = Math.min(perimeter, minPerimeter);
                }
            }
            return minPerimeter;
        }
    }

    /**
     * Sieve of EratosthenesThe Sieve of Eratosthenes is a very simple and popular technique for finding all the primenumbers in the range from2to a given numbern. The algorithm takes its name from theprocess of sieving—in a simple way we remove multiples of consecutive numbers.Initially, we have the set of all the numbers{2,3,...,n}. At each step we choose thesmallest number in the set and remove all its multiples. Notice that every composite numberhas a divisor of at mostÔn. In particular, it has a divisor which is a prime number. Itis su
     */
    class PrimesDemo {
        public int[] solution(int N) {
            //make size N+1 so will have direct mapping from array index
            boolean [] arePrimes = new boolean[N+1];

            arePrimes[0] = false; //0 is never prime
            arePrimes[1] = false; //1 is never prime
            for(int i=2; i<arePrimes.length; i++) {
                arePrimes[i] = true;
            }

            int nSquareRoot = (int) Math.sqrt(N);
            for(int i=2; i<=nSquareRoot; i++) {
                if(arePrimes[i]) {
                    //start checking from i^2 because lower numbers will have already been checked
                    //keep checking very multiple of i
                    for(int j=i*i; j<=N; j+=i) {
                        arePrimes[j] = false;
                    }
                }
            }

            List primesList = new ArrayList();

            for(int i=2; i<arePrimes.length; i++) {
                if(arePrimes[i]) {
                    primesList.add(i);
                }
            }
            //https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
            int[] primes = primesList.stream().mapToInt(i->i).toArray();
            return primes;
        }
    }

/**
 *

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


 */
    class CountSemiprimes {
        public int[] solution(int N, int[] P, int[] Q) {
            //make size N+1 so will have direct mapping from array index
            boolean [] arePrimes = new boolean[N+1];

            arePrimes[0] = false; //0 is never prime
            arePrimes[1] = false; //1 is never prime
            for(int i=2; i<arePrimes.length; i++) {
                arePrimes[i] = true;
            }

            int nSquareRoot = (int) Math.sqrt(N);
            for(int i=2; i<=nSquareRoot; i++) {
                if(arePrimes[i]) {
                    //start checking from i^2 because lower numbers will have already been checked
                    //keep checking very multiple of i
                    for(int j=i*i; j<=N; j+=i) {
                        arePrimes[j] = false;
                    }
                }
            }

            List primesList = new ArrayList();
            for(int i=2; i<arePrimes.length; i++) { if(arePrimes[i]) { primesList.add(i); } } //https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java int[] primes = primesList.stream().mapToInt(i->i).toArray();

            int [] semiPrimes = new int[N + 1];

            //populate semi primes set in order
            //reference: https://codesays.com/2014/solution-to-count-semiprimes-by-codility/
            for(int i=0; i<primes.length-1; i++) { if(primes[i] * primes[i] > N) {
                continue;
            }
                semiPrimes[primes[i]*primes[i]] = 1;  //square of the prime
                for(int j=i+1; j<primes.length; j++) { if(primes[i] * primes[j] > N) {
                    break; //semi primes are larger than N so can stop calculating them
                }
                    semiPrimes[primes[i]*primes[j]] = 1;
                }
            }

            for(int i=1; i<semiPrimes.length; i++) {
                semiPrimes[i] += semiPrimes[i-1];
            }

            int [] results = new int[P.length];
            for(int i=0; i<P.length; i++) {
                results[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
            }
            return results;
        }
    }
/**
 * he Euclidean algorithm is one of the oldest numerical algorithms still to be in commonuse. It solves the problem of computing the greatest common divisor (gcd) of two positiveintegers.12.1. Euclidean algorithm by subtractionThe original version of Euclid’s algorithm is based on subtraction: we recursively subtractthe smaller number from the larger.12.1:Greatest common divisor by subtraction.1defgcd(a, b):2ifa == b:3returna4ifa > b:5gcd(a - b, b)6else:7gcd(a, b - a)Let’s estimate this algorithm’s time complexity (based onn=a+b). The number of steps canbe linear, for e.g.gcd(x,1), so the time complexity isO(n). This is the worst-case complexity,because the valuex+ydecreases with every step.12.2. Euclidean algorithm by divisionLet’s start by understanding the algorithm and then go on to prove its correctness. For twogiven numbersaandb, such thataˇb:•ifb|a,thengcd(a, b)=b,•otherwisegcd(a, b)=gcd(b, amodb).gcd(24,9)=gcd(9,6)=gcd(6,3)=324 mod 9 = 69mod6=36mod3=0c•Copyright 2015 by Codility Limited. All Rights Reserved. Unauthorized copying or publication pro-hibited.1
 * Let’s prove thatgcd(a, b)=gcd(b, r),wherer=amodbanda=b·t+r:•Firstly, letd=gcd(a, b). We getd|(b·t+r)andd|b,sod|r.Therefore we getgcd(a, b)|gcd(b, r).•Secondly, letc=gcd(b, r). We getc|bandc|r,soc|a.Therefore we getgcd(b, r)|gcd(a, b).Hencegcd(a, b)=gcd(b, r). Notice that we can recursively call a function whileais notdivisible byb.12.2:Greatest common divisor by dividing.1defgcd(a, b):2ifa % b == 0:3returnb4else:5returngcd(b, a % b)Denote by (ai,bi) pairs of valuesaandb, for which the above algorithm performsisteps.ThenbiˇFibi≠1(whereFibiis thei-th Fibonacci number). Inductive proof:1.for one step,b1=0,2.for two steps,bˇ1,3.for more steps,(ak+1,bk+1)æ(ak,bk)æ(ak≠1,bk≠1),thenak=bk+1,ak≠1=bk,bk≠1=akmodbk,soak=q·bk+bk≠1for someqˇ1,sobk+1ˇbk+bk≠1.Fibonacci numbers can be approximated by:Fibn¥(1+Ô52)nÔ5(12.1)Thus, the time complexity is logarithmic based on the sum ofaandb—O(log(a+b)).12.3. Binary Euclidean algorithmThis algorithm finds thegcdusing only subtraction, binary representation, shifting and paritytesting. We will use adivide and conquertechnique.The following function calculategcd(a, b, res)=gcd(a, b,1)·res. So to calculategcd(a, b)it su
 */
    class GreatestCommonDivisorDemo {

        //reference: https://codility.com/media/train/10-Gcd.pdf
        //find greatest common divisor between 2 integers using Euclidean algorithm with subtraction, division
        public int gcdBySubtraction(int A, int B) {
            if(A == B) return A;
            if(A > B)  return gcdBySubtraction(A-B, B);
            else       return gcdBySubtraction(A, B-A);
        }

        public int gcdByDivision(int A, int B) {
            if(A % B == 0) return B;
            else           return gcdByDivision(B, A % B);
        }
    }
/**
 *

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


 */
    class ChocolatesByNumbers {
        public int solve(int N, int M) {
            return N / gcdByDivision(N, M);
        }

        int gcdByDivision(int A, int B) {
            if(A % B == 0) return B;
            else           return gcdByDivision(B, A % B);
        }

    }


    /**
     * Fibonacci numbersThe Fibonacci numbers form a sequence of integers defined recursively in the following way.The first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent numberis the sum of the previous two.Fn=Y__]__[0forn=0,1forn=1,Fn≠1+Fn≠2forn>1.The first twelve Fibonacci numbers are:0112358132134558901234567891011Notice that recursive enumeration as described by the definition is very slow. The definitionofFnrepeatedly refers to the previous numbers from the Fibonacci sequence.13.1:Finding Fibonacci numbers recursively.1deffibonacci(n):2if(n <= 1):3returnn4returnfibonacci(n - 1) + fibonacci(n - 2)The above algorithm performsFnadditions of 1, and, as the sequence grows exponentially,we get an ine
     */
    class FibonacciDemo {
        public int[] getFibs(int pN) {
            if(pN == 1) { return new int [] { 0 }; }
            if(pN == 2) { return new int [] { 0, 1 }; }

            int [] fibs = new int [pN];
            fibs[0] = 0;
            fibs[1] = 1;
            generateFibs(fibs, 2, pN);

            return fibs;
        }

        //naive/slowest implementation: fib(n) = fib(n-1) + fib(n-2)
        private void generateFibs(int [] pFibs, int pCurrent, int pMax) {
            int currentFib = pFibs[pCurrent - 1] + pFibs[pCurrent - 2];
            pFibs[pCurrent] = currentFib;

            pCurrent++;
            if(pCurrent == pMax) return;
            else {
                generateFibs(pFibs, pCurrent, pMax);
            }
        }

        //faster implementation - non recursive, uses Fibs of previous 2 elements to calculate current Fib
        public int[] getFibsFast(int pN) {
            if(pN == 1) { return new int [] { 0 }; }
            if(pN == 2) { return new int [] { 0, 1 }; }

            int [] fibs = new int [pN];
            fibs[0] = 0;
            fibs[1] = 1;

            for(int i=2; i<fibs.length; i++) {
                fibs[i] = fibs[i-1] + fibs[i-2];
            }
            return fibs;
        }
    }