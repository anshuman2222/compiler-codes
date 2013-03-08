package compiler;
import java.io.*;
class email_file
{
   public static void main(String args[])
  {
      try{
		// Open the file that is the first 
		// command line parameter
                //int f=1;
                int rem=0;int flag=0;
		FileInputStream fstream = new FileInputStream("email.txt");
		// Get the object of DataInputStream
                
               DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                FileWriter fstream1 = new FileWriter("emailout.txt");
                BufferedWriter out = new BufferedWriter(fstream1);
		String str=null;
                int i=0;
                //Read File Line By Line
		while ((str = br.readLine()) != null) 	{
                    StringBuilder str2=new StringBuilder();flag=0;rem=0;
                  for(i=0;i<str.length();i++)  
                  {
                      //System.out.println("hi");
                        if(str.charAt(i)!=' ' && flag==0)
                        {   str2.append(str.charAt(i));
                            flag=1;
                        }    
                        else if(str.charAt(i)!=' ' && flag==1)
                        {   continue;

                        }
                        else if(str.charAt(i)==' ' && flag==1)
                        {    str2.append("_"); flag=0; rem=str2.lastIndexOf("_"); }
                        else if(str.charAt(i)==' ' && flag==0)
                        {   continue;

                        }
                        
                      
                  }
                   //System.out.println(flag);
                   if(i==str.length())
                   {
                       i--;
                       if(flag==1)
                       {while(str.charAt(i)!=' ' && i!=0 )
                       {
                           i--;
                       }
                       }
                       else if(flag==0)
                       {   str2.deleteCharAt(rem);

                           while(str.charAt(i)==' ' && i!=0 )
                            {
                                i--;
                            }//reached last character
                           i--;
                            while(str.charAt(i)!=' ' && i!=0 )
                            {
                                i--;
                            }
                       }    

                       if(i!=0)
                       { i+=2;}else{ str2.delete(0,str2.length());  }
                        while(i<str.length()&& str.charAt(i)!=' ')
                       {  str2.append(str.charAt(i)); i++; }
                       str2.append("@bitmesra.ac.in");
                   }
                   System.out.println(str2.toString());
                   out.write(str2.toString());
                   out.newLine();
                  
                       
                   
                  }
                 
                
                
                
                
                                
		//Close the input stream
		in.close();
                out.close();
      }catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}

