/*
 * CREATION OF IMAGE FOR PIXEL MAPPING VIA ACEE ...
 @UTHOR   :  NAMAN DEEP SINGH
 */

package end_mem;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class aviris_1 {
	public static void main(String[] df){
	double[][] abundanc=new double[4][676];
//	double[][][] aaa=new double[26][26][4];
	int[][] pp=new int[26][26];
	int k;
	int nData=4;
	int count=0;
	long nDim=676;
	File file_1=new File("E:/crackm1.csv");
			Scanner sc;
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
//		for(int j=0;j<26;j++){
//			for( k=0;k<26;k++){
//			for(int i=0;i<4;i++){
//				aaa[j][k][i]=abundanc[i][count];
//			//	System.out.print(aaa[j][k][i]+"\t");
//		}
//		//	System.out.println();
//			count++;
//	}}
		
		int count_1=0;
		for(int j=0;j<26;j++){
			for( k=0;k<26;k++){
			if(abundanc[0][count]>0.80){
				pp[j][k]=12;
				
			}
			else if(abundanc[1][count]>0.60){
				pp[j][k]=13;
				}
			else if(abundanc[2][count]>0.60){
				pp[j][k]=14;
			}
			else if(abundanc[3][count]>0.90){
				pp[j][k]=10;
				}
			else{
				pp[j][k]=0;
				count_1++;
			}
			count++;

		}
		}
		System.out.println(count_1);
	
	 //Display connected components
    File binaryConnCompImg=new File("E:/PIXEL_2.png");
    BufferedImage image = new BufferedImage(26, 26, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
            if (pp[i][j] == 12) {
                image.setRGB(j, i, Color.GREEN.getRGB());
            } else if(pp[i][j]==13){
                image.setRGB(j, i, Color.ORANGE.getRGB());
            }
            else if(pp[i][j]==14){
                image.setRGB(j, i, Color.BLUE.getRGB());
            }
            else if(pp[i][j]==10){
                image.setRGB(j, i, Color.RED.getRGB());
            }
            else{
            	image.setRGB(j,i,Color.WHITE.getRGB());
            }
        }
    }

    try{
        ImageIO.write(image,"png", binaryConnCompImg);
    }
    catch(IOException e){
        e.printStackTrace();
    }
    FileWriter fwriter=null;                                                                                       
	try{                                                                                                           
		fwriter=new FileWriter("E:/mygrnd.csv");                                                                 
	}catch(Exception e){                                                                                           
		e.printStackTrace();                                                                                       
	}                                                                                                              
	PrintWriter pw=new PrintWriter(fwriter);                                                                       
for(int y=0;y<26;y++){
	for(int h=0;h<26;h++){
			pw.print(pp[y][h]+",");                                                                             
	                                                                                                               
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
