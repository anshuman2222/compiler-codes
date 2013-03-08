package compiler;
import java.io.*;
class transition
{
   public static void main(String args[])
  {
      try{
		// Open the file that is the first 
		// command line parameter
                //int f=1;
		FileInputStream fstream = new FileInputStream("transition1.txt");
		// Get the object of DataInputStream
                int i=0,j=0;
                
                StringBuilder str=new StringBuilder();
                StringBuilder strLine1=null;
		DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                FileWriter fstream1 = new FileWriter("transitionout.txt");
                BufferedWriter out = new BufferedWriter(fstream1);
		String strLine;
                int m=1,n=1;
                
              
               
            	String tab[][]=new String[10][10];
                tab[0][0]="*";
                for(int k=0;k<10;k++)
                {
                    for(int l=0;l<10;l++)
                       tab[k][l]="";
                   
                }   
                //Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
                    int flag=0;
                    strLine1=new StringBuilder(strLine);
                    strLine1.append(" ");
                    strLine=strLine1.toString();
                    int sindex=0;int fl=0;
                  while(j<strLine.length())  
                 {       if(Character.isLowerCase(strLine.charAt(j)) && flag==0)
                          {
                                    sindex=j;
                                    j++;    
                                    flag=1;
                                    //fl=0;

                           } 
                          else if(Character.isLowerCase(strLine.charAt(j)) && flag==1) 
                          {
                              j++;

                          }
                          else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                          {
                                   
                                       for(int p=1;p<n;p++)
                                       {
                                           
                                           if(tab[0][p].equals(strLine.substring(sindex, j)))
                                                    fl=1;
                                          
                                       }
                                        if(fl==0)
                                        { tab[0][n++]=strLine.substring(sindex, j);
                                            
                                        }
                                        fl=0;
                                        
                                        flag=0;
                                        j++;
                              
                              
                          }
                          else if(Character.isSpaceChar(strLine.charAt(j)) && flag==1 )
                          {
                              for(int p=1;p<n;p++)
                                       {
                                                if(tab[0][p].equals(strLine.substring(sindex, j)))
                                                    fl=1;
                                       }
                                        if(fl==0)
                                        { tab[0][n++]=strLine.substring(sindex, j);}
                                        fl=0;
                                        
                                        flag=0;
                                        j++;      
                              
                          }
                          else
                          {
                                j++;
                          }
                  }         
                  
                  //detecting number of states
                  sindex=0;fl=0;j=0;flag=0;
                  while(j<strLine.length())  
                 {       if(Character.isUpperCase(strLine.charAt(j)))
                          {
                                   
                                       for(int p=1;p<m;p++)
                                       {
                                           
                                           if(tab[p][0].equals(strLine.substring(j, j+1)))
                                                    fl=1;
                                          
                                       }
                                        if(fl==0)
                                        { tab[m++][0]=strLine.substring(j, j+1);
                                            
                                        }
                                        fl=0;
                                        j++;
                              
                              
                          }
                          else
                          {
                                j++;
                          }
                  }tab[m++][0]="qf";        
                  
                //searching and mapping the states 
                 sindex=0;fl=0;j=0;flag=0;int r=0,c=0;
                 
                             while(j<strLine.length())  
                            {       str.delete(0,str.length());
                                    if(Character.isUpperCase(strLine.charAt(j)) && flag==0)
                                    {
                                        sindex=j;
                                            
                                                for(int p=1;p<n;p++)
                                                {
                                                    if(tab[p][0].equals(strLine.substring(sindex, j+1)))
                                                            fl=p;
                                                }
                                                if(fl>0)
                                                { r=fl;}
                                                fl=0;
                                    
                                            int index=strLine.indexOf(">", j)+1;
                                            if(index<strLine.length() && index!=0)
                                            {    j=index;
                                                flag=1;
                                            }
                                            else {break;}
                                           
                                            
                                    }
                                     else if(Character.isUpperCase(strLine.charAt(j)) && flag==1)
                                    {
                                       // System.out.println("hi");
                                        
                                        sindex=j;
                                        j++;
                                        //right linear
                                        while(j<strLine.length())
                                        {
                                            
                                            if(Character.isSpaceChar(strLine.charAt(j)) && flag==1 )
                                            {
                                                for(int p=1;p<n;p++)
                                                {
                                                    if(tab[0][p].equals(strLine.substring(sindex+1, j)))
                                                            fl=p;
                                                }
                                                if(fl>0)
                                                {   str.delete(0,str.length());
                                                    str.append(tab[r][fl]).append("|");
                                                   str.append(strLine.substring(sindex, sindex+1)); 
                                                    tab[r][fl]=str.toString();
                                                }
                                                fl=0;

                                                flag=0;
                                                j++;
                                                break;     
                                            }
                                            else {j++;}
                                        
                                        
                                        }
                                        
                                    }        
                                    else if(Character.isLowerCase(strLine.charAt(j)) && flag==1)
                                    {
                                        sindex=j;
                                        j++;
                                        //right linear
                                        while(j<strLine.length())
                                        {
                                            if(Character.isUpperCase(strLine.charAt(j)))
                                            {
                                                   
                                                for(int p=1;p<n;p++)
                                                {
                                                    if(tab[0][p].equals(strLine.substring(sindex, j)))
                                                            fl=p;
                                                }
                                                if(fl>0)
                                                {  str.delete(0,str.length());
                                                    str.append(tab[r][fl]).append("|");
                                                   str.append(strLine.substring(sindex, sindex+1)); 
                                                    tab[r][fl]=str.toString();}
                                                fl=0;

                                                flag=0;
                                                j++;
                                                break;      

                                            }
                                            else if(Character.isSpaceChar(strLine.charAt(j)) && flag==1 ) //works for both left and right linear grammar
                                            {
                                                for(int p=1;p<n;p++)
                                                {
                                                    if(tab[0][p].equals(strLine.substring(sindex, j)))
                                                            fl=p;
                                                }
                                                if(fl>0)
                                                { str.delete(0,str.length());
                                                    str.append(tab[r][fl]).append("|");
                                                   str.append("qf"); 
                                                    tab[r][fl]=str.toString();
                                                    
                                                }
                                                fl=0;

                                                flag=0;
                                                j++;
                                                break;     
                                            }
                                            else {j++;}
                                        
                                        
                                        }
                                        
                                    } 
                                   
                                    else
                                      {
                                            j++;
                                      }
                  } 
                  
                     
                
                System.out.println(strLine);
                }
                System.out.println("---------------------Transition Table----------------");
                for(int k=0;k<m;k++)
                {
                    for(int l=0;l<n;l++)
                    {    System.out.print(tab[k][l]+'\t'+'\t');
                         out.write(tab[k][l]+'\t'+'\t');   
                    }
                    System.out.println();
                    out.newLine();
                }    
                //out.write(str.toString()+'\n');
                //System.out.println(str);
                //System.out.println(strLine);
                                
		//Close the input stream
		in.close();
                out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error : " + e.getMessage());
		}
	}
}

