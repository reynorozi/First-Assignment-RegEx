import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collection;


public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = "^[^.][\\S]+[^.]@+[^_]+[\\S]\\.(com|org|co\\.uk|)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     hello my name is reyhane today is 2025/3/6
     */
    public String findDate(String string) {

        String regex1 = "\\b(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|1[0-9]|2[0-9]|3[0-1])\\b";//yyyy/mm/dd
        String regex2 =  "\\b(0[1-9]|1[0-9]|2[0-9]|3[0-1])[-/](0[1-9]|1[0-2])[-/](\\d{4})\\b";//dd/mm/yyyy
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(string);
        if (matcher1.find()) {
            return matcher1.group();
        }
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(string);
        if (matcher2.find()) {
            return matcher2.group();
        }
        return null;
    }


    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        -✅ at least 8 characters
        -✅has to include at least one uppercase letter, and at least a lowercase
        -✅at least one number and at least a special char "!@#$%^&*"  ^ !
        -✅has no white-space in it
     */
    public static int findValidPasswords(String string) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[\\S]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        String[] words = string.split("\\s+");

        int validCount = 0;

        for (String word : words) {
            matcher = pattern.matcher(word);
            if (matcher.matches()) {
                validCount++;

            }
        }

        return validCount;
    }


    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String regex = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean isPalindrome(String word) {
        String lower = word.toLowerCase();
        int left = 0, right = lower.length() - 1;
        while (left < right) {
            if (lower.charAt(left) != lower.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // you can test your code here
    }

}