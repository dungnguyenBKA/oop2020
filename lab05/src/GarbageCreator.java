import java.util.Random;

public class GarbageCreator {
    public static void main(String[] args) {
        Random r= new Random(1000);
        long start = System.currentTimeMillis();
        String s ="";
        for(int i= 0; i<200000; i++)
            s+=r.nextInt(2);
        System.out.println(System.currentTimeMillis()-start);
    }
}
