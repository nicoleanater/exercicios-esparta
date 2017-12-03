/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

/**
 *
 * @author Nicole
 */
public class Solution {

    public Solution() {
    }

    public int solution(int[] A) {
        int unpaired = -1;
        for (int i = 0; i < A.length; i++) { //for que troca o primeiro elemento da comparação
            if (A[i] == -2) {
                continue;
            }
            unpaired = A[i];
            for (int j = 0; j < A.length; j++) { //for que seleciona o segundo elemento para ser comparado, exceto ele mesmo
                if (i == j || A[j] == -2) {
                    continue;
                }
                if (A[i] == A[j]) {
                    unpaired = -1; //ainda não encontrou
                    A[i] = -2;
                    A[j] = -2;
                    break;
                }

            }
            if (unpaired != -1) {
                return unpaired;
            }
        }
        return unpaired;
    }
}
