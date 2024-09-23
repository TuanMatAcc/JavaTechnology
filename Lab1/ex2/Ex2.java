import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;

class Ex2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,4,3,9};
        int[] b = new int[]{6,7,2,8};
        ArrayOutput.print(a);
        ArrayOutput.print(b);
        int[] c = ArrayHandler.merge(a, b);
        ArrayOutput.print(c);

        ArrayHandler.sort(c);
        ArrayOutput.print(c);

        ArrayOutput.write(c, "output.txt");
    }
}
