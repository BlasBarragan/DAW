package ud02bEjercicios;

public class U02bEjercicio3 {

	public static void main(String[] args) {
		
		int a = 8;
		int b = 3;
		double res = (double) a/b;		
		
		//2,6666666666666667
		System.out.printf("%.15f %n", res);
		//2,67
		System.out.printf("%.2f %n", res);
		
		// 2,67		
		System.out.printf("%5.2f %n", res);
		
		//  2,67
		System.out.printf("%7.3f %n", res);
		
		//002,67
		System.out.printf("%07.3f %n", res);
		
		//    2,6667
		System.out.printf("%10.4f %n", res);
			
		//2,6667
		System.out.printf("%5.3f %n", res);
		
		//   2,66667
		System.out.printf("%10.5f %n", res);
		
		//0000000003
		System.out.printf("%010.0f %n", res);
	}

}
