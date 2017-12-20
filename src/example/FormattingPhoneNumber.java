package example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력한 전화 번호를 규칙에 맞게 변환
 *
 */
public class FormattingPhoneNumber {
    public String solution(String S) {
        String result = "";
        String cleaned = cleanString(S);
        int length = cleaned.length();
        int index;
        switch (length % 3) {
            case 0:
                for (index = 0; index < length; index += 3) {
                    result += cleaned.substring(index, index + 3) + "-";
                }
                break;
            case 1:
                for (index = 0; index < length - 4; index += 3) {
                    result += cleaned.substring(index, index + 3) + "-";
                }
                result += cleaned.substring(length - 4, length - 2)
                        + "-" + cleaned.substring(length - 2, length) + "-";
                break;
            case 2:
                for (index = 0; index < length - 2; index += 3) {
                    result += cleaned.substring(index, index + 3) + "-";
                }
                result += cleaned.substring(length - 2, length) + "-";
                break;
            default:
                result = "wrong input ";
                break;
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
        return result;
    }
    private String cleanString(String input) {
        String cleaned = "";
        Pattern p = Pattern.compile("(\\d)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            cleaned += m.group();
        }
        return cleaned;
    }

    public static void main(String[] args) {
        FormattingPhoneNumber t = new FormattingPhoneNumber();
        System.out.println(t.solution("00-44  48 5555 8361"));
        System.out.println(t.solution("00-44  48 5555 8361"));
        System.out.println( t.solution("0 - 22 1985--324"));
        System.out.println( t.solution("555372654"));
        System.out.println( t.solution("55  5/372-6-5/44"));
        System.out.println(t.solution("0000000000"));
        System.out.println( t.solution("0000000000000"));
        System.out.println( t.solution("0000000000000000"));
        System.out.println(t.solution("00000000000000"));
        System.out.println( t.solution("00000000000000000"));
        System.out.println( t.solution("00000000000000000000"));

    }
}
