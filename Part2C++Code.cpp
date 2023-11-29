#include <bits/stdc++.h> 
using namespace std; 
  
string decToBin(int decNum) 
{
    string binNum = "";
    while(decNum >0)
    {
        int remainder = decNum % 2;
        binNum += to_string(remainder);
        decNum = decNum / 2;
    }
    
    
    int j = 0;
    int i = 0;
    for (j = binNum.size() - 1, i = 0; i <= j; j--, i++)
    {
        int tmp = binNum[j];
        binNum[j] = binNum[i];
        binNum[i] = tmp;
    }
   
    return binNum;
}

int binToDec(string binNum) 
{  
    int decVal = 0; 
  
    int baseVal = 1; 
  
    int length = binNum.length(); 
    for (int i = length - 1; i >= 0; i--) 
    { 
        if (binNum[i] == '1') 
            decVal += baseVal; 
        baseVal = baseVal * 2; 
    } 
  
    return decVal; 
} 

string decToHex(int decVal) 
{ 
    string hex = ""; 
    
    while (decVal != 0) {  
        int remainder = 0; 
          
        char ch; 
        remainder = decVal % 16; 
   
        if (remainder < 10) { 
            ch = remainder + 48; 
        } 
        else { 
            ch = remainder + 55; 
        } 
           
        hex += ch; 
        decVal = decVal / 16; 
    } 
       
    int i = 0, j = hex.length() - 1; 
    while(i <= j) 
    { 
      swap(hex[i], hex[j]); 
      i++; 
      j--; 
    } 
    return hex; 
} 

int hexToDec(string hexVal) 
{ 
    int length = hexVal.length(); 
    int baseVal = 1; 
    int decVal = 0; 
  
    for (int i = length - 1; i >= 0; i--) { 
        if (hexVal[i] >= '0' && hexVal[i] <= '9') { 
            decVal += (int(hexVal[i]) - 48) * baseVal; 
  
            baseVal = baseVal * 16; 
        } 

        else if (hexVal[i] >= 'A' && hexVal[i] <= 'F') { 
            decVal += (int(hexVal[i]) - 55) * baseVal; 

            baseVal = baseVal * 16; 
        } 
    } 
    return decVal; 
} 

string hexToBin(string hexNum)
{
    int decEquivalent = hexToDec(hexNum);
    string binNum = decToBin(decEquivalent);
    return binNum;
}

string binToHex(string binNum)
{
    int decEquivalent = binToDec(binNum);
    string hexNum = decToHex(decEquivalent);
    return hexNum;
}

int main() 
{ 
    cout << "42 in binary form is: " << decToBin(42) << endl;
    cout << "101010 in decimal form is: " << binToDec("101010") << endl;
    cout << "255 in hexadecimal form is: " << decToHex(255) << endl;
    cout << "1FF in decimal form is: " << hexToDec("1FF") << endl;
    cout << "1A in binary form is: " << hexToBin("1A") << endl;
    cout << "1101 in hexadecimal form is: " << binToHex("1101") << endl;
    return 0; 
}