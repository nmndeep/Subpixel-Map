/*
 *  FOR ABUNDANCE GENERATION OF THE DATA THROUGH ACEE
 */

package end_mem;                                                                                                               
                                                                                                                               
import java.io.File;                                                                                                           
import java.io.FileNotFoundException;                                                                                          
import java.io.FileWriter;                                                                                                     
import java.io.IOException;                                                                                                    
import java.io.PrintWriter;                                                                                                    
import java.util.Scanner;                                                                                                      
                                                                                                                               
                                                                                                                               
                                                                                                                               
public class ground{                                                                                                      
                                                                                                                               
	public static void main(String[] pop) throws FileNotFoundException{                                                        
	                                                                                                                           
		double[][] pix_spec=new double[204][676];                                                                              
		int k;                                                                                                                 
		int nData=204;                                                                                                         
		//long count=0;                                                                                                        
		long nDim=676;                                                                                                         
		File file_1=new File("E:/yabadgu.csv");                                                                                
				Scanner sc;                                                                                                    
		try{                                                                                                                   
            sc=new Scanner(file_1);                                                                                            
                                                                                                                               
            sc.useDelimiter(",|\\n");                                                                                          
                                                                                                                               
            for(int j=0;j<nDim;j++){                                                                                           
                //for(int i=0;i<imgDim1;i++){                                                                                  
                    for( k=0;k<nData;k++){                                                                                     
                        pix_spec[k][j]=Double.parseDouble(sc.next());                                                          
                    }                                                                                                          
                    System.out.println(j);                                                                                     
                }                                                                                                              
                                                                                                                               
        }                                                                                                                      
        catch(FileNotFoundException e){                                                                                        
            e.printStackTrace();                                                                                               
        }                                                                                                                      
                                                                                                                               
	                                                                                                                           
	            /*  FastICA test = null;                                                                                       
		           	try{ test = new FastICA(pix_spec,3);}                                                                      
	          	catch(FastICAException  f)                                                                                     
	          	{f.printStackTrace();}                                                                                         
                                                                                                                               
		           	double[][] end=test.getICVectors();                                                                        
		*/                                                                                                                     
                                                                                                                               
		double[][] end_spec=new double[204][4];                                                                                
		double[][] c=new double[4][676];                                                                                       
		double[][] c_fin=new double[4][676];                                                                                   
                                                                                                                               
		int[] loc=new int[4];                                                                                                  
		                                                                                                                       
                                                                                                                               
		double eth=0.1;          // TUNING FACTOR DEPENDING ON THE ABUNDANCE FRACTIONS CALCULATED                                                                                               
		                                                                                                                       
	                                                                                                                           
			for( k=0;k<204;k++){                                                                                               
				end_spec[k][0]=pix_spec[k][3];                                                                                 
			}                                                                                                                  
			for( k=0;k<204;k++){                                                                                               
				end_spec[k][1]=pix_spec[k][76];                                                                               
			}                                                                                                                  
			for( k=0;k<204;k++){                                                                                               
				end_spec[k][2]=pix_spec[k][350];                                                                               
			}                                                                                                                  
			for( k=0;k<204;k++){                                                                                               
				end_spec[k][3]=pix_spec[k][675];                                                                               
			}                                                                                                                  
			                                                                                                                   
			                                                                                                                   
			                                                                                                                   
		NNLSSolver nnls=new NNLSSolver();                                                                                      
int count=0;                                                                                                                   
double max=0;                                                                                                                  
double sum=0;                                                                                                                  
//for(int j=0;j<4;j++){                                                                                                          
//	double max_1=0;                                                                                                                
//                                                                                                                
//	do{                                                                                                                        
count++;                                                                                                                       
System.out.println(count);                                                                                                     
max=0;                                                                                                                         
	for(int i=0;i<676;i++){
		sum=0;                                                                                              
			double[][] pix_ech=new double[204][1];                                                                             
		for(int m=0;m<204;m++){                                                                                                
			pix_ech[m][0]=pix_spec[m][i];                                                                                      
		}                                                                                                                      
		double[][] total=nnls.yahoo(end_spec,pix_ech);                                                                         
                                                                                                                               
	for(int l=0;l<4;l++){                                                                                                      
		c[l][i]=total[l][0];                                                                                                   
                                                                                                                               
	}	                                                                                                                       
//	//for(int y=0;y<4;y++){                                                                                                    
System.out.println(i);                                                                                                     
//	if(c[j][i]>max){                                                                                                           
//		max=c[j][i];                                                                                                           
//		System.out.println(max+"\t"+"-----"+i);                                                                                
//	}                                                                                                                          
	for(int y=0;y<4;y++){                                                                                                      
		sum+=c[y][i];                                                                                                          
	}                                                                                                                          
for(int p=0;p<4;p++){                                                                                                          
c_fin[p][i]=c[p][i]/sum;   
System.out.print(c_fin[p][i]+"\t");
}      
System.out.println();
		}	                                                                                                                   
	                                                                                                                           
	                                                                                                                           
	                                                                                                                           
// CHANGING THE SPECTRA IN THE END MEMBER ARRAY WITH THE NEW UPDATED SPECTRA FROM THE PIXEL ARRAY....                          
	                                                                                                                           
//	for(int p=0;p<676;p++){                                                                                                    
//		if(c_fin[j][p]>max_1){                                                                                                 
//			loc[j]=p;    
//			max_1=c_fin[j][p];
//			for(k=0;k<204;k++){                                                                                                
//			end_spec[k][j]=pix_spec[k][p];                                                                                     
//			}                                                                                                                  
//		}                                                                                                                      
//	}                                                                                                                          
	                                                                                                                           
//	}while(max>1+eth);                                                                                                         
//                                                                                                                               
//	}                                                                                                                          
                                                                                                                               
			for(int cou=0;cou<4;cou++)                                                                                         
			System.out.print(loc[cou]+"\t");                                                                                   
		                                                                                                                       
			                                                                                                                   
				FileWriter fwriter=null;                                                                                       
				try{                                                                                                           
					fwriter=new FileWriter("E:/crack.txt");                                                                 
				}catch(Exception e){                                                                                           
					e.printStackTrace();                                                                                       
				}                                                                                                              
				PrintWriter pw=new PrintWriter(fwriter);                                                                       
			for(int i=0;i<676;i++){                                                                                            
				for(int j=0;j<4;j++){                                                                                          
						pw.print(c_fin[j][i]+",");                                                                             
								}                                                                                              
				pw.print("\n");                                                                                                
				                                                                                                               
			}                                                                                                                  
			pw.close();                                                                                                        
			try {                                                                                                              
				fwriter.close();                                                                                               
			} catch (IOException e) {                                                                                          
				// TODO Auto-generated catch block                                                                             
				e.printStackTrace();                                                                                           
			}                                                                                                                  
			                                                                                                                   
}                                                                                                                              
                                                                                                                               
                                                                                                                               
}                                                                                                                              
                                                                                                                               