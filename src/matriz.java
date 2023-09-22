
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class matriz {
    private int[][] matrix;
    private int numVertices;

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public static int[][] readMatrixFromFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int numRows = 0;
            int numCols = -1;

            int numVertices = Integer.parseInt(br.readLine());

            // br.close();

            int[][] matrix = new int[numRows][numCols];

            // int numVertices = Integer.parseInt(br.readLine());

            // br = new BufferedReader(new FileReader(fileName));

            // Ler e preencher a matriz
            for (int row = 0; row < numVertices; row++) {
                line = br.readLine();
                String[] elements = line.split("\t");
                for (int col = 0; col < numVertices; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
            }

            br.close();

            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
