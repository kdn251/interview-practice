public class Main {

	public static void main(String args[]) {
		
		//create matrices
		Matrix a = new Matrix(5, 5);
		Matrix b = new Matrix(5, 5);
	
		//initialize matrices
		initializeMatrix(a);
		initializeMatrix(b);
		
		//print matrix a
		for(int i = 0; i < a.matrix.length; i++) {
			for(int j = 0; j < a.matrix[0].length; j++) {
			
				System.out.print(a.matrix[i][j] + " ");
			
			}
		
			System.out.println();

			
		}
		
		System.out.println();

		//print matrix b
		for(int i = 0; i < b.matrix.length; i++) {
			for(int j = 0; j < b.matrix[0].length; j++) {
			
				System.out.print(b.matrix[i][j] + " ");
			
			}
		
			System.out.println();

			
		}	
		
		System.out.println();

		//multiply matrices
		int[][] result = matrixMultiplication(a.matrix, b.matrix);
	
		
		//print the resulting matrix of the multiplication
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
			
				System.out.print(result[i][j] + " ");
			
			}
		
			System.out.println();

			
		}
	}

	//initialize elements of matrix
	public static void initializeMatrix(Matrix a) {

		int count = 1;

		for (int i = 0; i < a.matrix.length; i++) {
			for (int j = 0; j < a.matrix[i].length; j++) {

				a.matrix[i][j] = count;

			}

		}

	}

	public static int[][] matrixMultiplication(int[][] a, int[][] b) {
		
		//initialize the resulting matrix
		int[][] result = new int[a.length][b[0].length];

		//multiply matrices
		for (int i = 0; i < a.length; i++) {
			
			int n = 0;
			
			for (int j = 0; j < a[i].length; j++) {
				
				for(int k = 0; k < b.length; k++) {
					
					result[i][k] += a[i][j] * b[j][i];

				}

			}
			
			n++;

		}

		//return resulting matrix
		return result;

	}
	
}

//matrix class
class Matrix {
	
	//rows attribute
	int rows;
	
	//columns attribute
	int columns;
	
	//matrix attribute
	int[][] matrix;

	
	//constructor
	Matrix(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
		matrix = new int[rows][columns];

	}

}
