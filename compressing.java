package compiler;
import java.io.*;
class compressing 
{
   public static void main(String args[])
  {
      try{
		// Open the file that is the first 
		// command line parameter
                //int f=1;
		FileInputStream fstream = new FileInputStream("comp.txt");
		// Get the object of DataInputStream
                int i=0,j=0;
		DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                FileWriter fstream1 = new FileWriter("compout.txt");
                BufferedWriter out = new BufferedWriter(fstream1);
		String strLine;
                char match=';';
                StringBuilder str=new StringBuilder();
            	
		//Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
                    int flag=0;                 
                    //StringBuilder str1=new StringBuilder();
                    	// Print the content on the console
                    i=0;
			//System.out.println (strLine);
                      //  out.write(strLine);
                      while(i<strLine.length())  
                      {  
                        if(Character.isUpperCase(strLine.charAt(i)) && flag==0 && strLine.charAt(i)!=match)
                        {     flag=1;  
                                out.write(str.toString()+'\n');
                                System.out.println(str);
                                System.out.println();
                                str.delete(0, str.length());
                                str.append(strLine.charAt(i)).append('-').append('>');
                                match=strLine.charAt(i);
                                j=strLine.indexOf('>');
                                i=j+1;
                                //System.out.println(str);
                               //out.write(str.toString());
                        }
                        else if(Character.isLetter(strLine.charAt(i)) && flag==1)
                        {     flag=1;  
                                str.append(strLine.charAt(i));
                                
                                //out.write(str.toString());
                                i++;
                        }
                        else if(Character.isUpperCase(strLine.charAt(i)) && flag==0 && strLine.charAt(i)==match)
                        {     flag=1;  
                                str.append('|').append(' ');
                                match=strLine.charAt(i);
                                j=strLine.indexOf('>');
                                i=j+1;
                                //System.out.println(str);
                               //out.write(str.toString());
                        }
                        
                    }
                    
                }
                out.write(str.toString()+'\n');
                System.out.println(str);
                System.out.println();
                                
		//Close the input stream
		in.close();
                out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}

