package Vectores;

public class Vector {

    private final int[] vector;

    public Vector(int[] vector) {
        this.vector = vector;
    }

    public int[] get_v() {
        return this.vector;
    }

    //Add 2 vectors together
    public Vector add_v_v(Vector v) {
        int[] v1 = new int[this.vector.length];

        for (int i = 0; i < this.vector.length; i++) {
            v1[i] = this.vector[i] + v.vector[i];
        }
        return new Vector(v1);
    }

    //Multiply a vector by scalar
    public Vector mul_s(int num) {
        int[] v1 = new int[this.vector.length];

        for (int i = 0; i < this.vector.length; i++) {
            v1[i] = this.vector[i] * num;
        }
        return new Vector(v1);
    }

    //Dot product of 2 vectors
    public int dot_product(Vector v) {
        int sum = 0;

        for (int i = 0; i < this.vector.length; i++) {
            sum += this.vector[i] * v.vector[i];
        }
        return sum;
    }

    //Cross product of 2 vectors
    public Vector cross_product(Vector v) {
        int[] v1 = new int[v.vector.length];

        return new Vector(v1);
    }

    public String toString() {
        StringBuilder v = new StringBuilder();

        for (int i : this.vector) {
            v.append(String.format("%d\n", i));
        }
        return v.toString();
    }

}
