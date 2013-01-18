package nio.regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Test the appendReplacement() and appendTail() methods of the
 * java.util.regex.Matcher class.
 * 
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class RegexAppend {

	public static void main(String[] argv) {
		String input = "Thanks, thanks very much";
		String regex = "([Tt])hanks";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		StringBuffer sb = new StringBuffer();
		// Loop while matches are encountered
		while (matcher.find()) {
			if (matcher.group(1).equals("T")) {
				matcher.appendReplacement(sb, "Thank you");
			} else {
				matcher.appendReplacement(sb, "thank you");
			}
		}
		// Complete the transfer to the StringBuffer
		matcher.appendTail(sb);
		// Print the result
		System.out.println(sb.toString());
		
		System.out.println("\n******************************\n");
		
		// Let's try that again using the $n escape in the replacement
		sb.setLength(0);
		matcher.reset();
		String replacement = "$1hank you";
		// Loop while matches are encountered
		while (matcher.find()) {
			matcher.appendReplacement(sb, replacement);
		}
		// Complete the transfer to the StringBuffer
		matcher.appendTail(sb);
		// Print the result
		System.out.println(sb.toString());
		// and once more, the easy way (because this example is simple)
		System.out.println(matcher.replaceAll(replacement));
		// one last time, using only the String
		System.out.println(input.replaceAll(regex, replacement));
	}
}