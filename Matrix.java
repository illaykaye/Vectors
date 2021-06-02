package Vectores;

public class Matrix {

    private final double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] get_matrix() {
        return this.matrix;
    }

    //Add 2 matrices together
    public Matrix add(Matrix m) {
        if (this.matrix.length != m.matrix.length || this.matrix[0].length != m.matrix[0].length) return null;

        double[][] m1 = new double[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m1[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return new Matrix(m1);
    }

    //Multiply a matrix by scalar
    public Matrix mul_s(int num) {
        double[][] m1 = new double[this.matrix.length][this.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m1[i][j] = this.matrix[i][j] * num;
            }
        }
        return new Matrix(m1);
    }

    //Get a column as an array from a matrix
    public double[] get_column(int num) {
        double[] column = new double[this.matrix.length];

        for (int i = 0; i < this.matrix.length; i++) {
            column[i] = this.matrix[i][num];
        }

        return column;
    }

    //Multiply a row by a column
    public static int mul_row_col(double[] row, double[] col) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * col[i];
        }
        return sum;
    }

    //Multiply a matrix by a matrix
    public Matrix mul_m(Matrix m) {
        if (this.matrix.length != m.matrix[0].length) return null;

        double[][] m1 = new double[m.matrix.length][this.matrix[0].length];

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

        double[] v1 = new double[v.get_v().length];

        for (int i = 0; i < v.get_v().length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                v1[i] += v.get_v()[j] * this.matrix[i][j];
            }
        }
        return new Vector(v1);
    }

    //Row operations

    //Multiply a row by scalar
    public static double[] mul_row(double[] row, double num) {
        double[] new_row = new double[row.length];

        for (int i = 0; i < row.length; i++) {
            new_row[i] = row[i] * num;
        }
        return new_row;
    }

    public Matrix add_mul_row(int row_2_add_2, int row, double scalar) {
        Matrix m = new Matrix(this.matrix);

        for (int i = 0; i < this.matrix[0].length; i++) {
            m.matrix[row_2_add_2][i] += scalar * m.matrix[row][i];
        }

        return m;
    }

    //Swap rows
    public Matrix swap_rows(int i, int j) {
        Matrix m = new Matrix(this.matrix);

        m.matrix[j] = this.matrix[i];
        m.matrix[i] = this.matrix[j];

        return m;
    }

    //


    //Gaussian elimination to row echelon form
    public Matrix gaussian_elim() {
        Matrix m = new Matrix(new double[this.matrix.length][this.matrix[0].length]);

        for (int row_1 = 0; row_1 < m.matrix.length; row_1++) {
            for (int col = 0; col < this.matrix[0].length; col++) {
                m.matrix[0] = mul_row(m.matrix[0], 1/m.matrix[0][0]);

                for (int row = 1; row < m.matrix.length; row++) {
                    m = m.add_mul_row(row, row_1, -m.matrix[row_1][0]);
                }
            }
        }
        return m;
    }

    //Return a string of the matrix
    public String toString() {
        StringBuilder m = new StringBuilder();

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                if (j != 0 || j != this.matrix[0].length-1) {
                    m.append(String.format(" %f ", this.matrix[i][j]));
                }
                else m.append(String.format("%f", this.matrix[i][j]));
            }
            m.append('\n');
        }
        return m.toString();
    }

}