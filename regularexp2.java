/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author shambo
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class regularexp2{

 public boolean isregularexp2(String emailAddress){
   String  expression="^((ab[c]*d)|([a]+(b|c)*[d]*)|(a|[b]+|c)*)$";
   CharSequence inputStr = emailAddress;
   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
   Matcher matcher = pattern.matcher(inputStr);
   return matcher.matches();

 }
 public static void main(String args[]){
    regularexp2 vea = new regularexp2();
    Scanner in=new Scanner(System.in);
    String emailAddress;
    System.out.println("Enter any string to validate");
    emailAddress= in.nextLine();
    
    if(vea.isregularexp2(emailAddress)){
     System.out.println(emailAddress + " is a valid string.");
   }else{
     System.out.println(emailAddress + " is an invalid string.");
   }
 }
}
