package IOTool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aria Pahlavan on 1/22/17.
 */
class MatrixReaderTest {
    private MatrixReader matrixReader;
    private int[][] a;
    private int[][] b;
    
    @BeforeEach
    void setUp() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name of file: ");
        String filename = keyboard.next();

        try {
            matrixReader = new MatrixReader("matrix");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void readAndPrintMatrix() {
        try {
            a = matrixReader.readMatrix();
            b = matrixReader.readMatrix();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        MatrixReader.printMatrix(a);
        System.out.println();
        MatrixReader.printMatrix(b);
    }
}