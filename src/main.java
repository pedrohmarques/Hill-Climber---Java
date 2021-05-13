import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// POS1: 4,50,5,8,48,23,21,41,50, 1
		// POS2: 28,58,49,29,14,17,53,59,42, 2
		// POS3: 52,10,36,55,19,16,42,3,1, 0
		// TODO Auto-generated method stub
		int weightRelease[] = { 751,218,657,265,584,707,428,582,693,642,799,445,449,300,758,688,222,252,475,444,327,384,296,734,669,378,736,616,762,593,202,323,630,294,340,752,408,587,522,419,330,520,343,718,292,564,332,687,553,363,523,400,481,251,497,377,683,437,391,543 };
		int l_pos[] = { 52,10,36,55,19,16,42,3,1, 0};
		System.out.println("First Found:");
		FirstFound(weightRelease, l_pos);
		
		System.out.println("");
		System.out.println("Steepest Ascent:");
		steepestAscent(weightRelease, l_pos);
	}
	
	public static void steepestAscent(int[] weightRelease, int[] l_pos) {
		int solucao = weightRelease[0];
		int[] foundedSolution = new int[]{};
		int sum = 0;
		for(int i = 0; i < l_pos.length; i++){
			int pos = l_pos[i];
			for(int j = pos; j < weightRelease.length; j++) {
				if (weightRelease[j] >= solucao) {
					solucao = weightRelease[j];
					foundedSolution = push(foundedSolution, solucao);
				}
			}
			//System.out.println("NOVO First Found - Solução encontrada:" + solucao);
			sum = sum + solucao;
			solucao = weightRelease[0];
		}
		System.out.println("Soma: " + sum);
	}
	
	public static void FirstFound(int[] weightRelease, int[] l_pos) {
		int solucao = weightRelease[0];
		int[] foundedSolution = new int[]{};
		int sum = 0;
		for(int i = 0; i < l_pos.length; i++){
			int pos = l_pos[i];
			for(int j = pos; j < weightRelease.length; j++) {
				if (weightRelease[j] >= solucao) {
					solucao = weightRelease[j];
					foundedSolution = push(foundedSolution, solucao);
				}
				else break;
			}
			//System.out.println("NOVO First Found - Solução encontrada:" + solucao);
			sum = sum + solucao;
			solucao = weightRelease[0];
		}
		System.out.println("Soma: " + sum);
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