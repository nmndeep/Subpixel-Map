/*SPSAM ALGORITHM INSTEAD OF PROPOSED MODEL*/
package end_mem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SPSAM {
	static double[][][] abundanc= new double[26][26][4];
	static int count=0;
	static double[][][] population=new double[26][26][9];


	public  static void main(String[] tion){
		Scanner sc = null;
		////		

		/////////////// INPUTTING ABUNDANC FRACCTIONS FOR CALCULATIONS
		File file_1=new File("E:/crackm1.csv");
		try{
		    sc=new Scanner(file_1);
	    sc.useDelimiter(",|\\n");
		    for(int j=0;j<26;j++){
		      		    	  
		    	for(int k=0;k<26;k++){
		    		for(int i=0;i<4;i++){
		    		abundanc[j][k][i]=Double.parseDouble(sc.next());
		            }
		           // System.out.println(j);
		        }
		    
		}
		}catch(FileNotFoundException e){
		    e.printStackTrace();
		}
		sc.close();
		for(int i=1;i<25;i++){
        	for(int j=1;j<25;j++){
				spss(abundanc,i,j);
			}}
		
	       
	      FileWriter fwriter=null;                                                                                       
				try{                                                                                                           
					fwriter=new FileWriter("E:/vall.csv");                                                                 
				}catch(Exception e){                                                                                           
					e.printStackTrace();                                                                                       
				}                                                                                                              
				PrintWriter pw=new PrintWriter(fwriter);                                                                       
			for(int y=0;y<26;y++){
				for(int h=0;h<26;h++){
				for(int u=0;u<9;u++){ 
					pw.print(population[y][h][u]+",");                                                                             
							}                                                                                              
				pw.print("\n");                                                                                                
				                                                                                                               
			}                    }                                                                                              
			pw.close();                                                                                                        
			try {                                                                                                              
				fwriter.close();                                                                                               
			} catch (IOException e) {                                                                                          
				// TODO Auto-generated catch block                                                                             
				e.printStackTrace();                                                                                           
		} 
		
	}
	/// ATTRACTION MODEL///////////////////////
	public static void spss(double[][][] synthetic,int i, int j ){
		double[] limit=new double[4];
		double[][] AA=new double[9][4];
		double[] check=new double[9];
		double[] value=new double[9];
	limit[0]=(9*abundanc[i][j][0]);
	limit[1]=(9*abundanc[i][j][1]);
	limit[2]=(9*abundanc[i][j][2]);
	limit[3]=(9*abundanc[i][j][3]);

	if(Math.ceil(limit[0])+Math.ceil(limit[1])+Math.ceil(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.ceil(limit[1])+Math.ceil(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.ceil(limit[1])+Math.floor(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.ceil(limit[1])+Math.floor(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.floor(limit[1])+Math.ceil(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.floor(limit[1])+Math.ceil(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.floor(limit[1])+Math.floor(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.ceil(limit[0])+Math.floor(limit[1])+Math.floor(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.ceil(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.ceil(limit[1])+Math.ceil(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.ceil(limit[1])+Math.ceil(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.ceil(limit[1])+Math.floor(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.ceil(limit[1])+Math.floor(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.ceil(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.floor(limit[1])+Math.ceil(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.floor(limit[1])+Math.ceil(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.ceil(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.floor(limit[1])+Math.floor(limit[2])+Math.ceil(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.ceil(limit[3]);
	}
	else if(Math.floor(limit[0])+Math.floor(limit[1])+Math.floor(limit[2])+Math.floor(limit[3])==9){
		limit[0]=Math.floor(limit[0]);
		limit[1]=Math.floor(limit[1]);
		limit[2]=Math.floor(limit[2]);
		limit[3]=Math.floor(limit[3]);
	}
//	System.out.print("lim 0  "+limit[0]+"\t");
//	System.out.print("lim 1  "+limit[1]+"\t");
//	System.out.print("lim 2  "+limit[2]+"\t");
//	System.out.print("lim 3  "+limit[3]+"\t");

	for(int l=0;l<9;l++){
		for(int k=0;k<4;k++){
		if(l==0)
		AA[l][k]=(abundanc[i-1][j-1][k]/0.60+abundanc[i][j-1][k]/0.74+abundanc[i+1][j-1][k]/0.94+abundanc[i-1][j][k]/0.74
				+abundanc[i+1][j][k]/1.374+abundanc[i-1][j+1][k]/1.49+abundanc[i][j+1][k]/1.374+abundanc[i+1][j+1][k]/1.88);
		if(l==2)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.49+abundanc[i][j-1][k]/0.74+abundanc[i+1][j-1][k]/0.60+abundanc[i-1][j][k]/1.374
					+abundanc[i+1][j][k]/0.74+abundanc[i-1][j+1][k]/1.88+abundanc[i][j+1][k]/1.374+abundanc[i+1][j+1][k]/0.94);
		if(l==6)
			AA[l][k]=(abundanc[i-1][j-1][k]/0.94+abundanc[i][j-1][k]/1.374+abundanc[i+1][j-1][k]/1.88+abundanc[i-1][j][k]/0.74
					+abundanc[i+1][j][k]/1.374+abundanc[i-1][j+1][k]/0.60+abundanc[i][j+1][k]/0.74+abundanc[i+1][j+1][k]/1.49);
		if(l==8)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.88+abundanc[i][j-1][k]/1.374+abundanc[i+1][j-1][k]/1.49+abundanc[i-1][j][k]/1.374
					+abundanc[i+1][j][k]/0.74+abundanc[i-1][j+1][k]/0.94+abundanc[i][j+1][k]/0.74+abundanc[i+1][j+1][k]/0.60);
		if(l==1)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.11+abundanc[i][j-1][k]/0.66+abundanc[i+1][j-1][k]/1.11+abundanc[i-1][j][k]/1.05
					+abundanc[i+1][j][k]/1.05+abundanc[i-1][j+1][k]/1.66+abundanc[i][j+1][k]/1.33+abundanc[i+1][j+1][k]/1.66);
			
		if(l==3)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.11+abundanc[i][j-1][k]/1.05+abundanc[i+1][j-1][k]/1.66+abundanc[i-1][j][k]/0.66
					+abundanc[i+1][j][k]/1.33+abundanc[i-1][j+1][k]/1.11+abundanc[i][j+1][k]/1.05+abundanc[i+1][j+1][k]/1.66);
		if(l==5)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.66+abundanc[i][j-1][k]/1.05+abundanc[i+1][j-1][k]/1.11+abundanc[i-1][j][k]/1.33
					+abundanc[i+1][j][k]/0.66+abundanc[i-1][j+1][k]/1.66+abundanc[i][j+1][k]/1.05+abundanc[i+1][j+1][k]/1.11);
		if(l==7)
			AA[l][k]=(abundanc[i-1][j-1][k]/1.66+abundanc[i][j-1][k]/1.33+abundanc[i+1][j-1][k]/1.66+abundanc[i-1][j][k]/0.05
					+abundanc[i+1][j][k]/1.05+abundanc[i-1][j+1][k]/1.11+abundanc[i][j+1][k]/0.66+abundanc[i+1][j+1][k]/1.11);
		
		else{
			AA[l][k]=(abundanc[i-1][j-1][k]/1.414+abundanc[i][j-1][k]/1+abundanc[i+1][j-1][k]/1.414+abundanc[i-1][j][k]/1
					+abundanc[i+1][j][k]/1+abundanc[i-1][j+1][k]/1.414+abundanc[i][j+1][k]/1+abundanc[i+1][j+1][k]/1.414);
					}
		}
		count++;
	}
	for(int l=0;l<9;l++){
		double sum=0;
	for(int p=0;p<4;p++){
		sum+=AA[l][p];
	}
	for(int p=0;p<4;p++){
		AA[l][p]/=sum;
	}

	}
	
	double q;
	double temp;		int c_0=0,c_1=0,c_2=0,c_3=0;

	for(int p=0;p<9;p++){
		double max=0;
		int max_2=0;
		for(int l=0;l<4;l++){
			check[l]=(AA[p][l]*9);
			}
		for(int r=0;r<4;r++)
			Math.floor(check[r]);
		for(int r=0;r<4;r++){
			if(check[r]>max){
				max=check[r];
				value[p]=r;
			}
		}

		}
		
//		else
//			population[i][j][p]=5;System.out.print(population[i][j][p]+"\t");


	for(int p=0;p<9;p++){
System.out.print(value[p]+"\t");}
	System.out.println();

	for(int p=0;p<9;p++){
	if(value[p]==0&&c_0<limit[0]){
		population[i][j][p]=value[p];
		c_0++;
	}
	else if(value[p]==1&&c_1<limit[1]){
		population[i][j][p]=value[p];
		c_1++;
	}						
	else if(value[p]==2&&c_1<limit[2]){
		population[i][j][p]=value[p];
		c_2++;
	}else if(value[p]==3&&c_1<limit[3]){
		population[i][j][p]=value[p];
		c_3++;
	}
		
	}
	}}
	