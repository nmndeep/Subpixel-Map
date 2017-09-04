/**
 * AN ARBITRARY TESTING PROGRAM
 */

package end_mem;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class tester{
	public static void main(String[] df) throws IOException{
		double[][] pix_spec=new double[7138][204];
		double[][] ans=new double[4][204];
		double[][][] uiu=new double[83][86][204];
		double[][][] kkk=new double[26][26][204];

	File file_1=new File("E:/salinas.csv");
	Scanner sc;
	
try{
    sc=new Scanner(file_1);
    sc.useDelimiter(",|\\n");

    for(int j=0;j<7138;j++){
        //for(int i=0;i<imgDim1;i++){
            for(int k=0;k<204;k++){
                pix_spec[j][k]=Double.parseDouble(sc.next());
            }
            System.out.println(j);
        }
    
}catch(FileNotFoundException e){
    e.printStackTrace();
}
int count=0;
for(int i=0;i<83;i++){
	for(int j=0;j<86;j++){
		for(int k=0;k<204;k++){
			uiu[i][j][k]=pix_spec[count][k];
		}
		count++;
	}
}
//int c=0,p=0;
//for(int i=56;i<=81;i++){
//	for(int j=0;j<=25;j++){
//		for(int k=0;k<204;k++){
//	 kkk[c][p][k]=uiu[i][j][k];
//}
//		p++;
//	}
//	c++;}


//	FileOutputStream f1=new FileOutputStream("E:/abc.txt");	
		    FileWriter fWriter = new FileWriter ("E:/yabadgu.txt");
	    PrintWriter pWriter = new PrintWriter (fWriter);
	//DataOutputStream d1=new DataOutputStream(f1);
	for(int i=56;i<=81;i++){
		for(int j=0;j<=25;j++){
		for(int k=0;k<204;k++){
			pWriter.print(uiu[i][j][k]+",");
		}
		pWriter.print("\n");
	}
	}
	pWriter.close();
	fWriter.close();
//f1.close();
	}
}