package d220804.q858;

public class JavaSolution {
    static int mirrorReflection(int p, int q) {
        int count = 1;
        int floor = 1;

        while ((p * floor != q * count)) {
            if (q * count < p * floor) {
                count++;
            } else {
                floor++;
            }
        }

        if (count % 2 == 1 && floor % 2 == 0) {
            return 0;
        } else if (count % 2 == 0 && floor % 2 == 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
