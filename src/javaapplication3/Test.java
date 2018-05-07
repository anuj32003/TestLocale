package javaapplication3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//import org.apache.commons.lang.StringUtils;

public class Test {
	  private static final TimeZone GMT_ZULU = TimeZone.getTimeZone("GMT:00");
	  private static final String LDAP_DATETIME_FORMAT = "yyyyMMddHHmmss";
	  public static final String EMPTY = "";
	public static void main(String[] args) {
		
		
		System.out.println(Test.daysBetweenDates(convertLdapTime("20171215150309Z"), new Date()));
		System.out.println("Hello World!!!");
		
		// TODO Auto-generated method stub
	/*	StringBuilder payLoad = new StringBuilder();
		boolean hasComment=false;
		int i=1; 
		int maxLength = 600;
		System.out.println(i);
	    while(i <= 1){
	    	i++;
	    	System.out.println(i);
	        String displayText = "CALLED0081BWR IS ILL, PAY REDUCED BY 0.00 NO MED INS COVERS ILL NO DISABILITY INS COVERAGE0026BRWR UNDERSTOOD OCC0081BWR IS ILL, PAY REDUCED BY NULL NO MED INS COVERS ILL NO DISABILITY INS COVERAGE CALLED0081BWR IS ILL, PAY REDUCED BY 0.00 NO MED INS COVERS ILL NO DISABILITY INS COVERAGE0026BRWR UNDERSTOOD OCC0081BWR IS ILL, PAY REDUCED BY NULL NO MED INS COVERS ILL NO DISABILITY INS COVERAGE CALLED0081BWR IS ILL, PAY REDUCED BY 0.00 NO MED INS COVERS ILL NO DISABILITY INS COVERAGE0026BRWR UNDERSTOOD OCC0081BWR IS ILL, PAY REDUCED BY NULL NO MED INS COVERS ILL NO DISABILITY INS COVERAGE CALLED0081BWR IS ILL, PAY REDUCED BY 0.00 NO MED INS COVERS ILL NO DISABILITY INS COVERAGE0026BRWR UNDERSTOOD OCC0081BWR IS ILL, PAY REDUCED BY NULL NO MED INS COVERS ILL NO DISABILITY INS COVERAGE CALLED0081BWR IS ILL, PAY REDUCED BY 0.00 NO MED INS COVERS ILL NO DISABILITY INS COVERAGE0026BRWR UNDERSTOOD OCC0081BWR IS ILL, PAY REDUCED BY NULL NO MED INS COVERS ILL NO DISABILITY INS COVERAGE";
	        // if single note > limited size note then split single note to multiple notes
	        int displayTextlength = 989;
	        if (displayTextlength > maxLength) {
	          int numberOfComment = displayTextlength / maxLength;
	          System.out.println("numberOfComment"+numberOfComment);
	          for (int step = 0; step <= numberOfComment; step++) {
	            int startComment = step * maxLength;
	            int endComment = (step + 1) * maxLength > displayTextlength ? displayTextlength : (step + 1) * maxLength;
	            System.out.println(startComment + "::" + endComment );
	            String comment = displayText.substring(startComment, endComment);
	            payLoad.append(StringUtils.leftPad(comment.length() + "", 4, "0"))
	                   .append(comment);
	            System.out.println(comment);
	            hasComment = true;
	          }
	        } else {
	          payLoad.append(StringUtils.leftPad(displayText.length() + "", 4, "0")).append(displayText);
	          hasComment = true;
	        }
	      }
		
	    System.out.println("Payload:"+payLoad.toString());*/
	}
	
	  public static Date convertLdapTime(String ldapTime) {
		    if (ldapTime == null || ldapTime.length() == 0)
		      return null;

		    try {
		      SimpleDateFormat sdf = new SimpleDateFormat(LDAP_DATETIME_FORMAT);
		      sdf.setTimeZone(GMT_ZULU);
		      // take leftmost 14 chars, ignores the trailing "Z"
		      return sdf.parse(Test.left(ldapTime, 14));
		    } catch (ParseException e) {
		      throw new RuntimeException("Error parsing ldap date time '" + ldapTime + "'", e);
		    }
		  }
	  
	    public static String left(String str, int len) {
	        if (str == null) {
	            return null;
	        }
	        if (len < 0) {
	            return EMPTY;
	        }
	        if (str.length() <= len) {
	            return str;
	        }
	        return str.substring(0, len);
	    }
	
	    public static int daysBetweenDates(Date d1, Date d2){
	        return (int)(d1.getTime()/86400000 - d2.getTime()/86400000);
	      }
}
