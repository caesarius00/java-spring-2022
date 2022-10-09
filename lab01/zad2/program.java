import java.util.ArrayList;

public class program {
    public static void main(String[] args) {
        int n = 9926315, size, check=0;

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i=n; i>1; i/=10)
            numbers.add(i % 10);

        size = numbers.size();
        for(int i=0; i<size; i++){
            int power=1, m=numbers.get(i);
            for(int j=0;j<size; j++)
                power*=m;

            check+=power;
        }
        System.out.println(check==n);
    }
}
