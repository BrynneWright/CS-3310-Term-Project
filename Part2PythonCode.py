def dec_to_bin(dec_num):
    bin_num = ""
    while dec_num > 0:
        remainder = dec_num % 2
        bin_num = str(remainder) + bin_num
        dec_num = dec_num // 2
    return bin_num


def bin_to_dec(bin_num):
    dec_val = 0
    base_val = 1
    for digit in bin_num[::-1]:
        if digit == '1':
            dec_val += base_val
        base_val *= 2
    return dec_val


def dec_to_hex(dec_val):
    hex_val = ""
    while dec_val != 0:
        remainder = dec_val % 16
        if remainder < 10:
            hex_val = chr(remainder + 48) + hex_val
        else:
            hex_val = chr(remainder + 55) + hex_val
        dec_val = dec_val // 16
    return hex_val


def hex_to_dec(hex_val):
    dec_val = 0
    base_val = 1
    for char in hex_val[::-1]:
        if char.isdigit():
            dec_val += (ord(char) - 48) * base_val
        elif char.isalpha():
            dec_val += (ord(char.upper()) - 55) * base_val
        base_val *= 16
    return dec_val


def hex_to_bin(hex_num):
    dec_equivalent = hex_to_dec(hex_num)
    bin_num = dec_to_bin(dec_equivalent)
    return bin_num


def bin_to_hex(bin_num):
    dec_equivalent = bin_to_dec(bin_num)
    hex_num = dec_to_hex(dec_equivalent)
    return hex_num



'''
Function testing / examples 
'''

print("42 in binary form is:", dec_to_bin(42))
print("101010 in decimal form is:", bin_to_dec("101010"))
print("255 in hexadecimal form is:", dec_to_hex(255))
print("1FF in decimal form is:", hex_to_dec("1FF"))
print("1A in binary form is:", hex_to_bin("1A"))
print("1101 in hexadecimal form is:", bin_to_hex("1101"))


'''
Reasoning:

We choose for implementing these conversion functions due to its ease of use and functional programming support. 
Python’s syntax is simpler and more readable than C++ or Java, making it easier to write and understand the conversion logic. 
It also supports functional programming, allowing functions to be reused and passed around, which can make your conversion functions more flexible. 
Additionally, Python allows for rapid prototyping and has built-in functions for easy conversions

'''