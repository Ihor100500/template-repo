public class Test {

  /*
    * Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise return the string unchanged.

  Examples:
  withoutX2('xHi') → Hi
  withoutX2('Hxi') → Hi
  withoutX2('Hi') → Hi
    * */

  public static void main(String[] args) {

    String source = "xHi";
    String source1 = "Hxi";
    String source2 = "Hi";
    String source3 = "xxxHiiii";

    System.out.println(withoutX2(source3));
  }

  public static String withoutX2(String str) {
    if (str.isEmpty()) {
      return str;
    }

    if (str.length() == 1) {
      if (str.charAt(0) == 'x') {
        return "";
      }
      return str;
    }

    String substring1 = str.substring(0, 2);
    String substring2 = str.substring(2);
    StringBuilder stringBuilder = new StringBuilder();
    char[] charArray1 = substring1.toCharArray();
    for (char c : charArray1) {
      if (c != 'x') {
        stringBuilder.append(c);
      }
    }

    return stringBuilder.append(substring2).toString();
  }
}
