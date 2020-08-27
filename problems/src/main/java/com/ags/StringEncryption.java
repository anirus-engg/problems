package com.ags;

public class StringEncryption {
  public static void main(String[] args) {
    String str = "aniruddha";
    System.out.println(encode(str));

    str = "Ê×ÎÍîçÔÝÂ";
    System.out.println(decode(str));
  }

  private static String decode(String encodedMessage) {
    StringBuilder b = new StringBuilder(encodedMessage);
    char[] messageChar = b.reverse().toString().toCharArray();

    b = new StringBuilder();

    for (int i = 0; i < encodedMessage.length(); i++) {
      char d = messageChar[i];
      char c = (char) ((d - i)/ 2);
      b.append(c);
    }

    return b.toString();
  }

  private static String encode(String text) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      b.append(c += c + i);
    }
    return b.reverse().toString();
  }
}
