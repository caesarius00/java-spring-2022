public class Program {

    public static String pattern(int n){
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=i; j>=0;j--)
                ret.append("x");
            ret.append("\n");
        }
        for(int i=n; i>0; i--){
            for(int j=i; j>0;j--)
                ret.append("x");
            ret.append("\n");
        }
        for(int i=n; i>0; i--){
            for(int j=n-i; j>0;j--)
                ret.append(" ");
            for(int j=i; j>0;j--)
                ret.append("x");
            ret.append("\n");
        }
        for(int i=n; i>0; i--){
            for(int j=i-1; j>0;j--)
                ret.append(" ");
            for(int j=n-i+1; j>0;j--)
                ret.append("x");
            ret.append("\n");
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(pattern(n));
    }
}
