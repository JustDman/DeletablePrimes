import java.math.BigInteger;

class deletable_prime {

    static int count = 0;

    public static void main(String[] args) {
        String input = (String) Input.get(Input.STRING, "Geben Sie eine Zahl ein!");
        Input.close();
        calc(input);
        System.out.println(count);
    }

    public static void calc(String str) {
        BigInteger big = new BigInteger(str);
        if (big.isProbablePrime(100)) {
            if (big.toString().length() == 1) {
                count++;
                return;
            }
            StringBuilder sb = new StringBuilder("" + big);
            for (int i = 0; i < sb.length(); i++) {
                StringBuilder sb2 = new StringBuilder("" + big);
                BigInteger temp = new BigInteger(sb2.deleteCharAt(i).toString());
                if (temp.isProbablePrime(100)) {
                    calc(temp + "");
                }

            }
        }
    }

}