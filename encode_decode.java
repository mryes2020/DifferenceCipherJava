package challenges;

import java.util.* ;

public class DifferenceCipher {
	
	public static void print(String string) {
		System.out.print(string);
	}
	
	public static void println(String string) {
		System.out.println(string);
	}
	
	public static void output(int[] array) {
		for (int x = 0; x < array.length; x++) {
			if (x == 0) {
				System.out.print("Encoded: " + array[x] + " ");
			}else {
				if (x == array.length-1) {
					System.out.println(array[x]);
				}else {
					System.out.print(array[x] + " ");
				}
			}
		}
	}
	
	
	public static void output_char_(char[] array) {
		for (int x = 0; x < array.length; x++) {
			if (x == 0) {
				System.out.print("Encoded: " + array[x]);
			}else {
				if (x == array.length-1) {
					System.out.println(array[x]);	
				}else {
					System.out.print(array[x]);
				}
			}
		}
	}
	
	
	public static int asciied(char char_) {
		
		int asciied_int = char_; 
		return asciied_int; 
	}
	
	public static int[] encode (String text_to_encode) {
		char[] text_to_encode_charred = text_to_encode.toCharArray(); 
		int[] result = new int[text_to_encode_charred.length]; 
		
		for (int x = 0; x < result.length; x++) {
			if (x == 0) {
				int ascii_char = asciied(text_to_encode_charred[x]); 
				result[x] = ascii_char; 
			}
			else {
				int ascii_char = asciied(text_to_encode_charred[x]); 
				int ascii_char_previous_one = asciied(text_to_encode_charred[x-1]); 
				int result_ = ascii_char - ascii_char_previous_one; 
				
				result[x] = result_;	
			}
		}
		
		
		
		return result; 
	}
	
	public static char toascii(int char_to_decode) {
		
		
		char result = (char) char_to_decode;
		
		return result; 
	}
	
	public static char[] decode(int[] text_to_decode) {
		char[] result = new char[text_to_decode.length]; 
		char previous = 0; 
		for (int x = 0; x < text_to_decode.length; x++) {
			if (x == 0) {
				char char_ = toascii(text_to_decode[x]); 
				previous = char_; 
				result[x] = char_; 
			}else {
				int encoded_char = text_to_decode[x]; 
				int encoded_prev_char = asciied(previous); 
				int result_2 = encoded_char + encoded_prev_char; 
				previous = toascii(result_2);
				result[x] = toascii(result_2);
				
			}
		}
		
		return result; 
	}
	
	
	public static void main(String[] args) {
		String text_to_encode = "Hello, this is a test";
		int[] text_to_decode = {72, 29, 7, 0, 3, -67, -12, 84, -12, 1, 10, -83, 73, 10, -83, 65, -65, 84, -15, 14, 1}; 
		

		int[] to_ascii = encode(text_to_encode); 
		char[] to_text = decode(text_to_decode); 
		output(to_ascii);  
		output_char_(to_text);  
	}

}
