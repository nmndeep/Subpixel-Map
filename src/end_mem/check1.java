/**
 * CLASSWISE PIXEL MAPPING ACCURACY CHECKING
 * @UTHOR : NAMAN DEEP AINGH
 * 
 */

package end_mem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class check1 {
	public static void main(String[] io){
	double[][] abundanc=new double[4][676];
//	double[][][] aaa=new double[26][26][4];
	int[][] pp=new int[26][26];
	int k;
	int nData=4;
	int count=0;
	long nDim=676;
	File file_1=new File("E:/crackm1.csv");  // RESULT OBTAINED FROM ACEE
			Scanner sc = null;
	try{
        sc=new Scanner(file_1);
        
        sc.useDelimiter(",|\\n");

        for(int j=0;j<nDim;j++){
            //for(int i=0;i<imgDim1;i++){
                for( k=0;k<nData;k++){
                    abundanc[k][j]=Double.parseDouble(sc.next());
                }
                System.out.println(j);
            }
        
    }
    catch(FileNotFoundException e){
        e.printStackTrace();
    }
	sc.close();
	int count_0=0,count_1=0,count_2=0,count_3=0;
	for(int j=0;j<26;j++){
		for( k=0;k<26;k++){
		if(abundanc[0][count]>0.80){
			pp[j][k]=12;
			count_0++;
			
		}
		else if(abundanc[1][count]>0.60){
			pp[j][k]=13;
			count_1++;
			}
		else if(abundanc[2][count]>0.60){
			pp[j][k]=14;
			count_2++;
		}
		else if(abundanc[3][count]>0.90){
			pp[j][k]=10;
			count_3++;
			}
		else{
			pp[j][k]=0;
		}
		count++;

	}
	}
	File file_2=new File("E:/nvaadata.csv");
	Scanner sc1;
	double[][] grt=new double[26][26];
	int correct=0,wrong=0;

try{
sc1=new Scanner(file_2);

sc1.useDelimiter(",|\\n");
for(int j=0;j<26;j++){
        for(int p=0;p<26;p++){
            grt[j][p]=Double.parseDouble(sc1.next());
            }
       System.out.println(j+"****");
    }

}
catch(FileNotFoundException e){
e.printStackTrace();
}

int grt_0 = 0,grt_1=0,grt_2=0,grt_3=0;
for(int i=0;i<26;i++){
	for(int j=0;j<26;j++){
		if(grt[i][j]==12)
			grt_0++;
		else if(grt[i][j]==13)
			grt_1++;
		else if(grt[i][j]==14)
			grt_3++;
		else if(grt[i][j]==10)
				grt_3++;
		if(grt[i][j]==pp[i][j]){
			correct++;}
			else
				wrong++;
		}
	}
//double e=0;
//e=grt_0/count_0;
//System.out.println(e);
////sc1.close();
//e=grt_1/count_1;
//System.out.println(e);
//e=grt_2/count_2;
//System.out.println(e);
//e=grt_3/count_3;
//System.out.println(e);
double percta=0;
percta=correct/676.0;
double kuka=wrong/676.0;
double p_1=grt_0/33.0;
double p_2=grt_0/181.0;
double p_3=grt_0/233.0;
double p_4=grt_0/31.0;


System.out.println((p_1)+"\t"+(p_2)+"\t"+(p_3)+"\t"+(p_4));
System.out.println(percta+"\t"+kuka);
}
	
	}

