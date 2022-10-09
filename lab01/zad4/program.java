public class program {
    public static void main(String[] args) {
        int n=5;
        for(int i=0; i<n; i++){
            for(int j=i; j>=0;j--)
                System.out.print("x");
            System.out.print("\n");
        }
        for(int i=n; i>0; i--){
            for(int j=i; j>0;j--)
                System.out.print("x");
            System.out.print("\n");
        }
        for(int i=n; i>0; i--){
            for(int j=i; j>0;j--)
                System.out.print("x");
            System.out.print("\n");
        }
        for(int i=0; i<n; i++){
            for(int j=i; j>=0;j--)
                System.out.print("x");
            System.out.print("\n");
        }
    }
}

/*
x
xx
xxx
xxx
xx
x
xxx
xx
x
x
xx
xxx




 */