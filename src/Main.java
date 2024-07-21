import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("res.txt", false);
        int[] ch = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            ch[i] = rand.nextInt(100);
            writer.append(ch[i] + ",");

            writer.flush();
        }
        writer.append("\n");

        writer.append("---------------------------------------------"
                + "------------------------------------------------"
                + "---------------------------------------------------"
                + "----------------------------------------------------"
                + "---------------------------");
        writer.append("\n");
        writer.flush();
        shellsort(ch);
        for (int i = 0; i < 100; i++) {
            writer.append(ch[i] + ",");

            writer.flush();

        }
        writer.append("\n");
        System.out.println("ok");

        try (FileReader reader = new FileReader("res.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        }
    }

    public static void shellsort(int[] mass) {
        int i, j, step;
        int tmp;
        for (step = 100 / 2; step > 0; step /= 2)
            for (i = step; i < 100; i++) {
                tmp = mass[i];
                for (j = i; j >= step; j -= step) {
                    if (tmp < mass[j - step])
                        mass[j] = mass[j - step];
                    else
                        break;
                }
                mass[j] = tmp;
            }
    }

}