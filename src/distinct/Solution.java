/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distinct;

/**
 *
 * @author Nicole
 */
public class Solution {

    public Solution() {
    }

    public int solution(int[] A) {
        int[] B = new int[A.length];
        B[0] = A[0];
        int tamanho = 1;
        for (int i = 1; i < A.length; i++) {
            boolean achou = false;
            for (int j = 0; j < B.length; j++){
                if (B[j] == A[i]){
                    achou = true;
                    break;
                }
            }
            if (!achou){
                B[tamanho] = A[i];
                tamanho++;
            }
        }
        return tamanho;
    }
}
