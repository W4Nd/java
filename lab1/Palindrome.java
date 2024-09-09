public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) { 
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " palindrome");
            } else {
                System.out.println(s + " not a palindrome");
            }
        }
    } 
    public static String reverseString(String s) {
        String a = "";
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            a += s.charAt(i);
        }
        return a;
    }
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
    