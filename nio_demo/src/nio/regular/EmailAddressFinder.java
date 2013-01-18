package nio.regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Validates email addresses.
 * 
 * Regular expression found in the Regular Expression Library at regxlib.com.
 * Quoting from the site, "Email validator that adheres directly to the
 * specification for email address naming. It allows for everything from
 * ipaddress and country-code domains, to very rare characters in the username."
 * 
 * @author Michael Daudel (mgd@ronsoft.com) (original)
 * @author Ron Hitchens (ron@ronsoft.com) (hacked)
 */
public class EmailAddressFinder {
	public static void main(String[] argv) {
		if (argv.length < 1) {
			System.out.println("usage: emailaddress ...");
		}

		// Compile the email address detector pattern
		Pattern pattern = Pattern
				.compile("([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]"
						+ "{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))"
						+ "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)", Pattern.MULTILINE);
		// Make a Matcher object for the pattern
		Matcher matcher = pattern.matcher("");
		// Loop through the args and find the addrs in each one
		for (int i = 0; i < argv.length; i++) {
			boolean matched = false;
			System.out.println("");
			System.out.println("Looking at " + argv[i] + " ...");
			// Reset the Matcher to look at the current arg string
			matcher.reset(argv[i]);
			// Loop while matches are encountered
			while (matcher.find()) {
				// found one
				System.out.println("\t" + matcher.group());
				matched = true;
			}
			if (!matched) {
				System.out.println("\tNo email addresses found");
			}
		}
	}
}
