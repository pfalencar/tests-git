package br.com.pfa.pontovirgula;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Pattern Class - Defines a pattern (to be used in a search)
 * Matcher Class - Used to search for the pattern
 * PatternSyntaxException Class - Indicates syntax error in a regular expression pattern
 */
public class RegexJava {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher("Visit W3Schools!");
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("Match found");
	    } else {
	      System.out.println("Match not found");
	    }

	}

}
