package cn.edu.pku.unicorn.leetcode.p004;

public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || A.length == 0) {
            if (B.length % 2 == 0) {
                return (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
            }
            return B[B.length / 2];

        }
        if (B == null || B.length == 0) {
            if (A.length % 2 == 0) {
                return (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0;
            }
            return A[A.length / 2];
        }
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length & j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }
        while (i < A.length) {
            C[k++] = A[i++];
        }
        while (j < B.length) {
            C[k++] = B[j++];
        }

        if (C.length % 2 == 0) {
            return (C[C.length / 2] + C[C.length / 2 - 1]) / 2.0;
        }
        return C[C.length / 2];
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {2, 3, 4};
        System.out.println(findMedianSortedArrays(A, B));
    }

}
