import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Double> write_in() {
        ArrayList<Double> yList = new ArrayList<>();
        for (int a = 1; a <= 1000; a++) {
            yList.add(Math.random());
        }
        return yList;
    }

    static ArrayList<Double> getting_x(ArrayList<Double> arg, Double a) {
        ArrayList<Double> xList = new ArrayList<>();
        for (Double aDouble : arg) {
            if (aDouble == 0.0)
                xList.add(0.0);
            else { double tmp = Math.log(1 - aDouble);
            xList.add(Math.sqrt((-2) * a * tmp)); }
        }
        return xList;
    }

    static ArrayList<Integer> interval_x(ArrayList<Double> arg) {
        Double min = Collections.min(arg);
        Double max = Collections.max(arg);
        ArrayList<Integer> gistogram = new ArrayList<>();
        Double a = (max - min)/12;
        Double tmp = min + a;
        int count = 0, allCount = 0;
        for (double x : arg) {
             if (x <= tmp) count++;
             else if (allCount == 11) {
                 count++;
             }
             else {
                 gistogram.add(count);
                 count = 1;
                 allCount++;
                 if (allCount < 11) tmp += a;
             }
        }
        gistogram.add(count);
        return gistogram;
    }



    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("#.##########");
        Scanner sc = new Scanner(System.in);
        double a = 0.0;
        switch (sc.nextInt()) {
            case 1 -> a = 0.5;
            case 2 -> a = 1.0;
            case 3 -> a = 2.0;
            case 4 -> a = 3.0;
            case 5 -> a = 4.0;
            default -> System.out.println("Введите значение от 1 до 5");
        }
        ArrayList<Double> values_y = write_in();
        ArrayList<Double> values_x = getting_x(values_y, a);
        Collections.sort(values_x);
        //for(Double num : values_x){
        //    System.out.println(dF.format(num));
        //}
        //System.out.println("\n\n" + Collections.max(values_x));
        //System.out.println(Collections.min(values_x));
        int z = 0;
        for (int x: interval_x(values_x)) {
            System.out.println("Число элементов интервале = " + x);
            z += x;
        }
        System.out.println("Число элементов в сумме = " + z);
    }
}
