/**
 * Creating subpixel mapping image from the population sets
 * @author Naman Deep Singh
 */

package end_mem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;


//import javax.imageio.ImageIO;

public class Sub_pix {
	public static void main(String[] attract){
		
		double[][][][] im_show=new double[26][26][3][3];
		int k;
//		int[] class_map=new int[4500];
//		int nData=73;
//		long nDim=450000;
//		double[][] attraction=new double[150][30];
		


//		File file_1=new File("E:/salinasA/bulla.csv");
//				Scanner sc;
	int count=0;
	double[] a={Subpixel population set path


};
	try{
//            sc=new Scanner(file_1);
//            sc.useDelimiter(",|\\n");

            for(int j=0;j<26;j++){
                    for( k=0;k<26;k++){
                    	for(int i=0;i<3;i++){
                    		for(int y=0;y<3;y++){
                         im_show[j][k][i][y]=a[count];
                         count++;
                    }
                    		}
                }
            
        }
            }catch(Exception e){
            e.printStackTrace();
        }
		 File binaryConnCompImg=new File("E:/mahmood_grnd.png");
		    BufferedImage image = new BufferedImage(26, 26, BufferedImage.TYPE_INT_RGB);
		    for (int i = 0; i < 26; i++) {
		        for (int j = 0; j < 26; j++) {
		        	int count1=0,count_0=0;
		        	for(int u=0;u<3;u++){
		        		for(int t=0;t<3;t++){
		        			if(count>count_0){
				                image.setRGB(j, i, Color.ORANGE.getRGB());
			            	}
		            if (im_show[i][j][u][t] == 0) {
		            	
		            	count_0++;
		                image.setRGB(j, i, Color.GREEN.getRGB());
		            } else if(im_show[i][j][u][t]==1){
		            	count++;
		                image.setRGB(j, i, Color.ORANGE.getRGB());
		            }
		            else if(im_show[i][j][u][t]==2){
		                image.setRGB(j, i, Color.BLUE.getRGB());
		            }
		            else if(im_show[i][j][u][t]==3){
		                image.setRGB(j, i, Color.RED.getRGB());
		            }
		            else{
		            	image.setRGB(j,i,Color.WHITE.getRGB());
		            }
		        }
		    }
		        }}
		    try{
		        ImageIO.write(image,"png", binaryConnCompImg);
		    }
		    catch(IOException e){
		        e.printStackTrace();
		    }
	}
	
		    }