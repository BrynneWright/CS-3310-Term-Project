import java.util.*;

public class Main {
 public static String decToBin(int decNum) 
 {
     String binNum = "";
     while (decNum > 0) {
         int remainder = decNum % 2;
         binNum += Integer.toString(remainder);
         decNum = decNum / 2;
     }
     int j = 0;
     int i = 0;
     char[] binNumArray = binNum.toCharArray();
     for (j = binNumArray.length - 1, i = 0; i <= j; j--, i++) {
         char tmp = binNumArray[j];
         binNumArray[j] = binNumArray[i];
         binNumArray[i] = tmp;
     }
     return new String(binNumArray);
 }

 public static int binToDec(String binNum) 
 {
     int decVal = 0;
     int baseVal = 1;
     int length = binNum.length();
     for (int i = length - 1; i >= 0; i--) 
     {
         if (binNum.charAt(i) == '1')
             decVal += baseVal;
         baseVal = baseVal * 2;
     }
     return decVal;
 }

 public static String decToHex(int decVal) 
 {
     String hex = "";
     while (decVal != 0) 
     {
         int remainder = 0;
         char ch;
         remainder = decVal % 16;
         if (remainder < 10) 
         {
             ch = (char) (remainder + 48);
         } 
         else 
         {
             ch = (char) (remainder + 55);
         }
         hex += ch;
         decVal = decVal / 16;
     }
     int i = 0, j = hex.length() - 1;
     while (i <= j) 
     {
         char temp = hex.charAt(i);
         StringBuilder sb = new StringBuilder(hex);
         sb.setCharAt(i, hex.charAt(j));
         sb.setCharAt(j, temp);
         hex = sb.toString();
         i++;
         j--;
     }
     return hex;
 }

 public static int hexToDec(String hexVal) 
 {
     int length = hexVal.length();
     int baseVal = 1;
     int decVal = 0;
     for (int i = length - 1; i >= 0; i--) {
         if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
         {
             decVal += (int)(hexVal.charAt(i) - '0') * baseVal;
             baseVal = baseVal * 16;
         }
         else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
         {
             decVal += (int)(hexVal.charAt(i) - 'A' + 10) * baseVal;
             baseVal = baseVal * 16;
         }
     }
     return decVal;
 }

 public static String hexToBin(String hexNum) 
 {
     int decimalEquivalent = hexToDec(hexNum);
     String binNum = decToBin(decimalEquivalent);
     return binNum;
 }

 public static String binToHex(String binNum) 
 {
     int decEquivalent = binToDec(binNum);
     String hexNum = decToHex(decEquivalent);
     return hexNum;
 }

 public static void main(String[] args) 
 {
     System.out.println("42 in binary form is: " + decToBin(42));
     System.out.println("101010 in decimal form is: " + binToDec("101010"));
     System.out.println("255 in hexadecimal form is: " + decToHex(255));
     System.out.println("1FF in decimal form is: " + hexToDec("1FF"));
     System.out.println("1A in binary form is: " + hexToBin("1A"));
     System.out.println("1101 in hexadecimal form is: " + binToHex("1101"));
 }
}

