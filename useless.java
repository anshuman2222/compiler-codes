package compiler;
import java.io.*;
class useless
{
   public static void main(String args[])
  {
      try{
		// Open the file that is the first 
		// command line parameter
                //int f=1;
		FileInputStream fstream = new FileInputStream("useless1.txt");
		// Get the object of DataInputStream
                int i=0,j=0,nt=0;
                char n_t=0;
                StringBuilder str=new StringBuilder();
                StringBuilder strLine1=null;
		DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                FileWriter fstream1 = new FileWriter("uselessout.txt");
                BufferedWriter out = new BufferedWriter(fstream1);
		String strLine;
                
                char terminal[]=new char[10];
                char non_terminal[]=new char[10];
               
            	
                //Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
                    int flag=0;
                    strLine1=new StringBuilder(strLine);
                    strLine1.append(" ");
                    strLine=strLine1.toString();
                  while(j<strLine.length())  
                  {  if(Character.isLowerCase(strLine.charAt(j)))
                    {
                            for(int k=0;k<i;k++)
                            {
                                if(terminal[k]==strLine.charAt(j))
                                    flag=1;
                            }
                            if(flag==0)
                            { terminal[i++]=strLine.charAt(j);}
                            flag=0;
                            
                    } 
                    j++;
                  }  
                  System.out.println("i="+i);
                  int fl=0;//non-terminal counter
                  for(int k=0;k<i;k++)  //i is length of terminal array
                  {    j=0;flag=0;
                    System.out.println("k :"+k+"  i :"+i);
                    while(j<strLine.length())  //round 2
                    {
                       System.out.println("length"+strLine.length());
                       System.out.println("j :"+j);
                        
                        if(Character.isUpperCase(strLine.charAt(j)) && flag==0)
                        {
                                
                                n_t=strLine.charAt(j);
                                int index=strLine.indexOf(">", j)+1;
                                if(index<strLine.length() && index!=0)
                                {    j=index;
                                flag=1;}
                                else {break;}
                                System.out.println("upper and index :"+index);
                                    
                        }
                        else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                        {
                                
                                n_t=strLine.charAt(j);
                                int index=strLine.indexOf(" ", j)+1;
                                if(index<strLine.length() && index!=0)
                                {    j=index;
                                flag=0;}
                                else {break;}
                                System.out.println("upper and index :"+index);
                                    
                        }
                        
                        else if(strLine.charAt(j)==terminal[k] && flag==1)
                        { j++;
                          while(j<strLine.length())
                          {
                                if(Character.isLowerCase(strLine.charAt(j)))
                                {
                                    j++;
                                    System.out.println("lower");
                                }
                                else if(Character.isSpaceChar(strLine.charAt(j)))
                                {
                                        
                                       for(int p=0;p<nt;p++)
                                       {
                                                if(non_terminal[p]==n_t)
                                                    fl=1;
                                       }
                                        if(fl==0)
                                        { non_terminal[nt++]=n_t;}
                                        fl=0;// test wheter non terminal is previously present in the no_terminal array
                                        flag=0;
                                        //j++;
                                        System.out.println("space");
                                        break;
                                }
                                else if(Character.isUpperCase(strLine.charAt(j)))
                                {
                                        flag=0;
                                        int index=strLine.indexOf(' ', j)+1;
                                        System.out.println("index :"+index);
                                        if(index < strLine.length() && index!=0)
                                            j=index;
                                        System.out.println("j :"+j);
                                        System.out.println("upper again out");
                                        break;
                                }
                                else
                                {
                                    j++;
                                    System.out.println("else");
                                }
                                
                          }
                         }
                        else{
                            j++;
                        }
                    }
                  }
                       
                   System.out.println("Array of terminal");
                  for(int k=0;k<i;k++)
                    System.out.println(terminal[k]);
                
                  System.out.println("Array of non-terminal");
                  for(int k=0;k<nt;k++)
                    System.out.println(non_terminal[k]);
                 
                  
                  //round 3
                  System.out.println("round 3");
                  j=0;flag=0;fl=0;
                  while(j<strLine.length())
                  {
                       System.out.println("length"+strLine.length());
                       System.out.println("j :"+j);
                        if(Character.isUpperCase(strLine.charAt(j)) && flag==0)
                        {
                            n_t=strLine.charAt(j);    
                            int index=strLine.indexOf(">", j)+1;
                                if(index<strLine.length() && index!=0)
                                {    j=index;
                                flag=1;}
                                else {break;}
                                System.out.println("upper and index :"+index);
                            
                        }    
                        else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                        {
                           System.out.println("j detect :"+j);
                            for(int p=0;p<nt;p++)
                             {
                                 if(non_terminal[p]==strLine.charAt(j))
                                 {                   fl=1; System.out.println("found");}
                                 
                             }
                             if(fl==0)
                             {
                                         flag=0;
                                         int index=strLine.indexOf(" ",j)+1;
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                             flag=0;}
                                         else {break;}
                             
                             } 
                             else{
                                 j++;
                             }
                             fl=0;
                        }
                        else if(Character.isLowerCase(strLine.charAt(j)) && flag==1)
                        {
                            j++;
                        }
                        else if(Character.isSpaceChar(strLine.charAt(j)) && flag==1)
                        {
                                       for(int p=0;p<nt;p++)
                                       {
                                                if(non_terminal[p]==n_t)
                                                    fl=1;
                                       }
                                        if(fl==0)
                                        { non_terminal[nt++]=n_t;}
                                        fl=0;//      
                                        flag=0;
                                        j++;
                        }
                        else{j++;}
                  
                  }
                   System.out.println("Array of terminal");
                  for(int k=0;k<i;k++)
                    System.out.println(terminal[k]);
                
                  System.out.println("Array of non-terminal");
                  for(int k=0;k<nt;k++)
                    System.out.println(non_terminal[k]);
                  
                  //round 4
                  System.out.println("round 4");
                   j=0;flag=0;fl=0;
                  while(j<strLine.length())
                  {
                       System.out.println("length"+strLine.length());
                       System.out.println("j :"+j);   
                        if(Character.isUpperCase(strLine.charAt(j)) && flag==0)
                        {
                            n_t=strLine.charAt(j);    
                           int index=strLine.indexOf(">", j)+1;
                                if(index<strLine.length() && index!=0)
                                {    j=index;
                                flag=1;}
                                else {break;}
                                System.out.println("upper and index :"+index);
                            
                            
                        }    
                        else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                        {
                            for(int p=0;p<nt;p++)
                             {
                                 if(non_terminal[p]==strLine.charAt(j))
                                 {                    fl=1; System.out.println("found nt"); }
                             }
                             if(fl==0)
                             {
                                        int index=strLine.indexOf(" ",j)+1;
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                             flag=0;}
                                         else {break;}
                                       
                             
                             } 
                             else{
                                 j++;
                             }
                             fl=0;
                        }
                        else if(Character.isLowerCase(strLine.charAt(j)) && flag==1)
                        {
                                         int index=strLine.indexOf(" ",j)+1;
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                             flag=0;}
                                         else {break;}
                        }
                        else if(Character.isSpaceChar(strLine.charAt(j)) && flag==1)
                        {
                            for(int p=0;p<nt;p++)
                                       {
                                                if(non_terminal[p]==n_t)
                                                    fl=1;
                                       }
                                        if(fl==0)
                                        { non_terminal[nt++]=n_t;}
                                        fl=0;//      
                                        flag=0;
                                        j++;     
                            
                            
                           
                        }
                        else{j++;}
                  
                  }
                  System.out.println("Array of terminal");
                  for(int k=0;k<i;k++)
                    System.out.println(terminal[k]);
                
                  System.out.println("Array of non-terminal");
                  for(int k=0;k<nt;k++)
                    System.out.println(non_terminal[k]);
                
                
                
                
                
                 //round 5 final list
                  System.out.println("round 5");
                   j=0;flag=0;fl=0;
                   int a_flag=0;
                   
                   int sindex=0;
                  while(j<strLine.length())
                  {
                       System.out.println("length"+strLine.length());
                       System.out.println("j :"+j);   
                        if(Character.isUpperCase(strLine.charAt(j)) && flag==0)
                        {
                           
                            for(int p=0;p<nt;p++)
                             {
                                 if(non_terminal[p]==strLine.charAt(j))
                                 {                    fl=1; System.out.println("found nt"); sindex=j; 
                                        int index=strLine.indexOf(">", j)+1;
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                            flag=1;
                                            break;
                                        }
                                        else {break;}
                                                    
                                 
                                 }
                             }
                             if(fl==0)
                             {
                                        int index=strLine.indexOf(" ",j)+1;
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                             flag=0;}
                                         else {break;}
                                       
                             
                             } 
                             
                             fl=0;
                            
                            
                            
                            System.out.println("upper and index :"+sindex);
                            
                            
                        }    
                        else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                        {
                            for(int p=0;p<nt;p++)
                             {
                                 if(non_terminal[p]==strLine.charAt(j))
                                 {                    fl=1; System.out.println("found nt1");
                                                      if(a_flag==0)
                                                      {
                                                          str.append(strLine1, sindex, j+1);
                                                         System.out.println(str);
                                                            a_flag=1;
                                                      }
                                                      else 
                                                      {    str.append(strLine1.charAt(j)) ;
                                                           System.out.println(str); 
                                                      }
                                 }
                             }
                             if(fl==0)
                             {
                                       /* int index=strLine.indexOf(" ",j);
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                             //flag=0;
                                        }
                                         else {break;}
                                       */System.out.println(strLine1);
                                         System.out.println("index of j:"+j);
                                         
                                         System.out.println(strLine.indexOf(strLine.charAt(j)));
                                         strLine1.replace(j, j+1," ");
                                        System.out.println("       "+strLine1.charAt(j));
                                 
                                 System.out.println(strLine1);
                                 j++;
                             
                             } 
                             else{
                                 j++;
                             }
                             fl=0;
                        }
                        else if(Character.isLowerCase(strLine.charAt(j)) && flag==1)
                        {
                                        for(int p=0;p<i;p++)
                             {
                                 if(terminal[p]==strLine.charAt(j))
                                 {                    fl=1; System.out.println("found t");
                                                      if(a_flag==0)
                                                      { 
                                                          
                                                          
                                                          str.append(strLine1, sindex, j+1);  
                                                            a_flag=1;
                                                      }
                                                      else 
                                                      {    str.append(strLine1.charAt(j)) ;                 }
                                 }
                             }
                             if(fl==0)
                             {
                                        /*int index=strLine.indexOf(" ",j);
                                        if(index<strLine.length() && index!=0)
                                        {    j=index;
                                            // flag=0;
                                        }
                                         else {break;}
                                  
                                       */System.out.println(strLine1);
                                         strLine1.replace(strLine.indexOf(strLine.charAt(j)), strLine.indexOf(strLine.charAt(j))+1," ");
                                        System.out.println("       "+strLine.charAt(j));
                                 
                                 System.out.println(strLine1);
                                 j++;
                             
                             } 
                             else{
                                 j++;
                             }
                             fl=0;
                        }
                        else if(Character.isSpaceChar(strLine.charAt(j)) && flag==1)
                        {
                            str.append("  ");
                            a_flag=0;
                            flag=0;
                            System.out.println("j blank:"+j);
                            j++;     
                            
                            
                           
                        }
                        else{j++;}
                  
                  }
                 
                System.out.println(strLine);
                }
                
                out.write(str.toString()+'\n');
                System.out.println(str);
                //System.out.println(strLine);
                                
		//Close the input stream
		in.close();
                out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}

