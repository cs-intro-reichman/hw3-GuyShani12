import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcessNoSpace(str1);
		str2 = preProcessNoSpace(str2);
		if (str1.length() != str2.length()){
			return false;
		}
		
		for (int i = 0; i < str1.length(); i++)
		{
			int count1 = 0;
			int count2 = 0;
			char c1 = str1.charAt(i);
			for (int j = 0; j < str1.length(); j++)
			{
				if (c1 == str1.charAt(j)){
					count1++; 
				}
			}

			char c2 = str2.charAt(i);
			for (int j = 0; j < str2.length(); j++)
			{
				if (c2 == str2.charAt(j))
				{
					count2++;
				}
				if (count1 != count2){
					return false;
				}
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				newStr = newStr + (char)(str.charAt(i + 32));
			}
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				newStr = newStr + str.charAt(i);
			}
			if (str.charAt(i) == ' '){
				newStr = newStr + str.charAt(i);
			}
		}
		return newStr;
	} 

	public static String preProcessNoSpace(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				newStr = newStr + (char)(str.charAt(i + 32));
			}
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				newStr = newStr + str.charAt(i);
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String strCopy = preProcess(str);
		String tempStr = strCopy;
		String newStr = "";
		
		while (newStr.length() > 0)
		{
			int x = (int)(Math.random() * strCopy.length() + 1);
			char c = strCopy.charAt(x);
			newStr = newStr + c;
			String updateStr = "";

			for (int i = 0; i < tempStr.length(); i++)
			{
				if (i != x){
					updateStr += tempStr.charAt(i);
				}
			}

			tempStr = updateStr;
		}
		return newStr;
	}
}
