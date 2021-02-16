public class Matrices {
    public static void main(String[] args){
        int[][] matrix = new int[(int)(Math.random() * 50) + 10][(int)(Math.random() * 50) + 10];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){e
                matrix[i][j] = i + j + 1;
            }
        }

        printMatrix(matrix);
        getCoord(3,5,matrix);
        
        //Caitlin
        System.out.println(sumMatrix(matrix));
        //Rosie
        System.out.println(sumRow(matrix, 6));
        //Jagger
        System.out.println(sumCol(matrix, 9));

        //More Dimensions (70)!!!
        double[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][] dimesionalAnalysis;
        //      "Evil"
        //          -Mermaidman (Jagger)
    }

    public static void printMatrix(int[][] mat){
        for(int[] row : mat){
            for(int col : row){
                System.out.print("[" + col + "], " );
            }
            System.out.println();
        }
    }
    
    public static int getCoord(int row, int col, int[][] matrix){
        return matrix[row][col];
    }

    
    
    public static int sumMatrix(int[][] matrix){
        int sum = 0;

        // for(int i = 0; i < matrix.length; i++) {
        //     for(int jagger = 0; jagger < matrix[i].length; jagger++){
        //         sum += matrix[i][jagger];
        //     } 
        // }
        for(int[] row : matrix) {
            for(int col : row){
                sum += col;
            }
        }

        return sum;
    }

    public static int sumRow(int[][] mat, int row){
        int sum = 0;
        for(int i = 0; i < mat[row].length; i++) {
            sum += mat[row][i];
        }
        return sum;
    }

    public static int sumCol(int[][] mat, int column){
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][column];
        }
        return sum;
    }
}


/*
*          A Matrix is an Array of Arrays, Arrays are listed horizontally.
*          You must choose the Array you want to look at first, before 
*          choosing a value in that Array.
*
*          1st 2nd 3rd
* 1st      [ ] [ ] [ ]
* 2nd      [ ] [ ] [ ]
* 3rd      [ ] [ ] [ ]
*/