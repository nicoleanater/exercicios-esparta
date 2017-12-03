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
public class UsaSolution {
    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 2}; // 1
        int[] B = {1, 3, 2, 3, 1, 7}; // 4
        int[] C = {1, 3, 5, 5, 2, 15, 19, 3}; //6
        Solution s = new Solution();
        System.out.println(s.solution(A));
        System.out.println(s.solution(B));
        System.out.println(s.solution(C));
    }
}
