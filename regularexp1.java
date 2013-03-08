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
public class regularexp1{

 public boolean regularexp1(String emailAddress){
   String  expression="^((110[1]*)|(0[0]+1))+|(10[1]*)$";
   CharSequence inputStr = emailAddress;
   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
   Matcher matcher = pattern.matcher(inputStr);
   return matcher.matches();

 }
 public static void main(String args[]){
    regularexp1 vea = new regularexp1();
    Scanner in=new Scanner(System.in);
    String emailAddress;
    System.out.println("Enter any string to validate");
    emailAddress= in.nextLine();
    
    if(vea.regularexp1(emailAddress)){
     System.out.println(emailAddress + " is a valid string.");
   }else{
     System.out.println(emailAddress + " is an invalid string.");
   }
 }
}
