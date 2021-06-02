package Vectores;

public class Main {

    public static void main(String[] args) {
        Matrix m = new Matrix(new int[][]{{1,2,3},{4,5,6}, {7,8,9}});
        Matrix m1 = new Matrix(new int[][]{{9, 8, 7}, {6, 5, 4}, {3,2,1}});
        Vector v= new Vector(new int[]{1,2,3});
        System.out.println(m.mul_m_v(v));
    }

}
