/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euclidean;

/**
 *
 * @author Nicole
 */
public class Solution {

    public Solution() {
    }

    public int solution(int N, int M) {
        Chocolate[] chocolates = new Chocolate[N];
        for (int i = 0; i < chocolates.length; i++){
            chocolates[i] = new Chocolate(); //inicializa cada objeto, para os chocolates serem setados 'não comidos'
        }
        
        int eaten = 0; //quantidade de chocolates comidos
        for (int i = 0; i < chocolates.length; i = (i+M)%N){
            if (!chocolates[i].isOnlyWrapper()){
                eaten++;
                chocolates[i].setOnlyWrapper(true);
            }else{
                break;
            }
        }
        return eaten;
    }
    
    
}
