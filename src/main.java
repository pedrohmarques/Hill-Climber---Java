import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weightRelease[] = { 5, 10, 15, 20, 30, 30, 20, 50, 10, 20 };
		int pos = 0;
		FirstFound(weightRelease, pos);
		System.out.println("");
		System.out.println("");
		steepestAscent(weightRelease, pos);
	}
	
	public static void steepestAscent(int[] weightRelease, int pos) {
		int solucao = weightRelease[0];
		int[] foundedSolution = new int[]{};
		for(int i = pos; i < weightRelease.length; i++) {
			if (weightRelease[i] >= solucao) {
				solucao = weightRelease[i];
				foundedSolution = push(foundedSolution, solucao);
			}
		}
		
		System.out.println("Steepest Ascent - Solução encontrada:");
		for(int i = foundedSolution.length - 1; i > -1; i--) {
			System.out.print(foundedSolution[i] + ", ");
		}
	}
	
	public static void FirstFound(int[] weightRelease, int pos) {
		int solucao = weightRelease[0];
		int[] foundedSolution = new int[]{};
		
		for(int i = pos; i < weightRelease.length; i++) {
			if (weightRelease[i] >= solucao) {
				solucao = weightRelease[i];
				foundedSolution = push(foundedSolution, solucao);
			}
			else break;
		}
		
		System.out.println("First Found - Solução encontrada:");
		for(int i = foundedSolution.length - 1; i > -1; i--) {
			System.out.print(foundedSolution[i] + ", ");
		}
	}
	
	public static int[] push(int[] arr, int item) {
        int[] tmp = Arrays.copyOf(arr, arr.length + 1);
        tmp[tmp.length - 1] = item;
        return tmp;
    }
	
	public static int getMaiorValor(int[] weightRelease) {
		int maior = Integer.MIN_VALUE;
		int indiceMaior = -1;
		for (int i = 0; i < weightRelease.length; i++) {
		    if (weightRelease[i] > maior) {
		        maior = weightRelease[i];
		        indiceMaior = i;
		    }
		}
		System.out.printf("Maior número é %d, no índice %d", maior, indiceMaior);
		return maior;
	}
}
// 35