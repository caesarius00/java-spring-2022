import java.util.ArrayList;


public class Program {

    public static boolean isArmstrong(int n){
        int size, check=0;

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i=n; i>0; i/=10)
            numbers.add(i % 10);

        size = numbers.size();
        for(int i=0; i<size; i++){
            int power=1, m=numbers.get(i);
            for(int j=0;j<size; j++)
                power*=m;

            check+=power;
        }
        return check==n;
    }

    public static void main(String[] args) {
        //int n = 39;         //nie
        int n = 17;         //nie
        //int n = 153;        //tak
        //int n = 9926315;    //tak
        System.out.println(isArmstrong(n));
    }
}
