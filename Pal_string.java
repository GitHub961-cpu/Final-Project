package Palindromes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pal_string 
{
	private String text;
	public Pal_string(String t) 
	{
		if(isPalindrome(t) == true) 
		{
			/* if palindrome true, it checks if it exists in Database
			 *  if it exists in Database, it will increment the counter value by 1
			 *  if not exist, it will be entered to Database 
			 *  appropriate messages will be passed to Palindrome class
			 */
			String cleanT = t.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			ArrayList<String> phrases = new ArrayList<String>();
			int count = 0;
			
			//mysql connection start
			//config error for timezone, now it's working 
			String connectionString = "jdbc:mysql://localhost/palindromes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
			String dbLogin = "javauser2";
			String dbPassword = "j4v4us3r?";
			
			String sql1 = "SELECT * FROM PALINDROME";
		
			Connection conn = null;
				try 
				{
					conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
					if (conn != null) 
					{
						System.out.println("Database connection successful.");
						Statement stmt1 = conn.createStatement();
						ResultSet rs1 = stmt1.executeQuery(sql1);
						while (rs1.next()) 
						{
							phrases.add(rs1.getString("phrase"));
						}
						if(existInDB(phrases, cleanT) == true) 
						{
							//only problem now is if a string contains single ' sql is giving error, I don't know how to escape that
							String sql2 = "UPDATE PALINDROME SET COUNTER = (COUNTER+1) WHERE PHRASE = '" + getPhrase(phrases, cleanT) + "';";
							Statement stmt2 = conn.createStatement();
							stmt2.executeUpdate(sql2);
								
							String sql3 = "SELECT COUNTER FROM PALINDROME WHERE PHRASE = '" + getPhrase(phrases, cleanT) + "';";
							Statement stmt3 = conn.createStatement();
							ResultSet rs2 = stmt3.executeQuery(sql3);
							if(rs2.next())
							{
								count = rs2.getInt("counter");
								String msg = "Yes, it is palindrome that does exist in database and it has been checked " + count + " times before";
								this.text = msg;
							}
						}
						else 
						{
							//same escaping single ' quote problem
							String sql4 = "INSERT INTO PALINDROME (PHRASE, COUNTER) VALUES ('" + t + "', 0);"; 
							Statement stmt4 = conn.createStatement();
							stmt4.executeUpdate(sql4);
							String error = "Yes, it is palindrome, but not found in database";
							this.text = error;
						}
					}
				}
				catch (Exception i) 
				{
					System.out.println("Database connection failed.");
					i.printStackTrace();
				}
				//mysql connection ends 
		}
		else 
		{
			String wmsg = "No, it is not palindrome";
			this.text = wmsg;
		}
	}
	public String getPal_string() 
	{
		return text;
	}
	
	//this cleans the string from white space, special characters and checks for palindrome
	static boolean isPalindrome(String text) 
	{
		String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	    int length = clean.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) 
	    {
	        char forwardChar = clean.charAt(forward++);
	        char backwardChar = clean.charAt(backward--);
	        if (forwardChar != backwardChar)
	            return false;
	    }
	    return true;
	}
	//this checks if clean text exit in database
	static boolean existInDB(ArrayList<String> phrases, String cleanT) 
	{
		String cleanPhrase = "";
		for(String phrase : phrases) 
		{
			if(cleanT.equals(cleanPhrase = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}
	//this almost same as ^ except returns a single phrase so I can increment the counter using it
	static String getPhrase(ArrayList<String> phrases, String cleanT) 
	{
		String cleanPhrase = "";
		String nm = "No Match found";
		for(String phrase : phrases) 
		{
			if(cleanT.equals(cleanPhrase = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()))
			{
				return phrase;
			}
		}
		return nm;
	}
}
