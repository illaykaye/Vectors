package Vectores;

public class Matrix {

    private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    //Add 2 matrices together
    public Matrix add(Matrix m) {
        if (this.matrix.length != m.matrix.length || this.matrix[0].length != m.matrix[0].length) return null;

        int[][] m1 = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m1[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return new Matrix(m1);
    }

    //Multiply a matrix by scalar
    public Matrix mul_s(int num) {
        int[][] m1 = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m1[i][j] = this.matrix[i][j] * num;
            }
        }
        return new Matrix(m1);
    }

    //Get a column as an array from a matrix
    public int[] get_column(int num) {
        int[] column = new int[this.matrix.length];

        for (int i = 0; i < this.matrix.length; i++) {
            column[i] = this.matrix[i][num];
        }

        return column;
    }

    //Multiply a row by a column
    public static int mul_row_col(int[] row, int[] col) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * col[i];
        }
        return sum;
    }

    //Multiply a matrix by a matrix
    public Matrix mul_m(Matrix m) {
        if (this.matrix.length != m.matrix[0].length) return null;

        int[][] m1 = new int[m.matrix.length][this.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < m.matrix[0].length; j++) {
                m1[i][j] = mul_row_col(this.matrix[i], m.get_column(j));
            }
        }

        return new Matrix(m1);
    }

    //Multiply a matrix by vector
    public Vector mul_m_v(Vector v) {
        if (this.matrix[0].length != v.get_v().length) return null;

        int[] v1 = new int[v.get_v().length];

        for (int i = 0; i < v.get_v().length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                v1[i] += v.get_v()[j] * this.matrix[i][j];
            }
        }
        return new Vector(v1);
    }

    //Return a string of the matrix
    public String toString() {
        StringBuilder m = new StringBuilder();

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                if (j != 0 || j != this.matrix[0].length-1) {
                    m.append(String.format(" %d ", this.matrix[i][j]));
                }
                else m.append(String.format("%d", this.matrix[i][j]));
            }
            m.append('\n');
        }
        return m.toString();
    }

}