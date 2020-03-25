import java.math.BigInteger;
import java.util.Stack;

class deletable_prime_it {

    public static void main(String[] args) {
        String input = (String) Input.get(Input.STRING, "Geben Sie eine Zahl ein!");
        Input.close();
        System.out.println(calc(input));
    }

    private static int calc(String str) {
        int count = 0;
        Stack<BigInteger> st = new Stack<>();
        BigInteger big = new BigInteger(str);
        StringBuilder sb = new StringBuilder();
        st.push(big);
        while (!st.isEmpty()) {
            sb = new StringBuilder("" + st.pop());
            if (sb.length() == 1) {
                count++;
            } else {
                for (int i = 0; i < sb.length(); i++) {
                    StringBuilder sb2 = new StringBuilder(sb);
                    BigInteger temp = new BigInteger(sb2.deleteCharAt(i).toString());
                    if (temp.isProbablePrime(100)) {
                        st.push(temp);

                    }

                }
            }
        }
        return count;
    }
}
