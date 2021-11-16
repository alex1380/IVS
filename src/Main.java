import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Double> write_in() {
        ArrayList<Double> ar = new ArrayList<>();
        for (int a = 1; a <= 1000; a++) {
            ar.add(Math.random());
        }
        return ar;
    }

    static ArrayList<Double> getting_x(ArrayList<Double> arg) {
        ArrayList<Double> x = new ArrayList<>();
        for (Double aDouble : arg) {
            double tmp = Math.log(1 - aDouble);
            x.add(Math.sqrt((-2) * tmp));
        }
        return x;
    }




    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("#.##########");
        ArrayList<Double> values_y = write_in();
        ArrayList<Double> values_x = getting_x(values_y);
        Collections.sort(values_x);
        for(Double num : values_x){
            System.out.println(dF.format(num));
        }
        System.out.println("\n\n" + Collections.max(values_x));
        System.out.println(Collections.min(values_x));
    }
}
