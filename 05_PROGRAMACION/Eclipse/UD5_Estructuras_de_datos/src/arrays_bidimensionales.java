
public class arrays_bidimensionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//Declaracion de array bidimensional 
		int [][] matrix = new int[4][5];
		
		matrix [0][0]=1;
		matrix [0][1]=2;
		matrix [0][2]=3;
		matrix [0][3]=4;
		matrix [0][4]=5;
		
		matrix [1][0]=6;
		matrix [1][1]=7;
		matrix [1][2]=8;
		matrix [1][3]=9;
		matrix [1][4]=10;
		
		matrix [2][0]=11;
		matrix [2][1]=12;
		matrix [2][2]=13;
		matrix [2][3]=14;
		matrix [2][4]=15;
		
		matrix [3][0]=16;
		matrix [3][1]=17;
		matrix [3][2]=18;
		matrix [3][3]=19;
		matrix [3][4]=20;

		// for anidado para recorrer la matriz
		for (int i=0; i<4; i++) {
			System.out.println();			
			for (int j=0; j<5; j++) {
				
				System.out.print(matrix[i][j] + " ");
			}
		}
		*/
		/*
		// Declaracion y relleno de matriz en una sentencia
		int [][] matrix={
				{10,11,12,13,14},
				{15,16,17,18,19},
				{20,1,2,3,4},
				{5,6,7,8,9}
		};
		// Uso del bucle for mejorado (for: each)
		for(int []fila:matrix) {
			
			System.out.println();
			
			for(int z: fila) {
				
				System.out.print(z + " ");
			}
		}
		*/
		double acumulado;
		double interes = 0.10;
		
		double [][]saldo = new double [6][5];
		
		for (int i=0; i<6; i++) {
			
			saldo[i][0] = 10000;
			acumulado = 10000;
			
			for (int j=1; j<5; j++) { //Empieza en 1 por que el anterior bucle ya rellena la fila [0] del array
				
				acumulado = acumulado + (acumulado*interes);
				
				saldo[i][j]=acumulado;
			}
			
			interes = interes+0.01;
		}
		
		for (int z=0; z<6; z++) {
			System.out.println();
			for (int h=0;h<5; h++) {
				
				System.out.printf("%1.2f", saldo[z][h]);
				
				System.out.print(" ");
			}
		}
		
	}
}
