/**
 * CODE FOR SUBPIXEL POPULATION AFTER USING BAT ALGORITHM..
 * 
 *BAT CODE HAS BEEN COMMENTED (CURRENTLY USING DIRECT BYPASS)
 * @UTHOR  : NAMAN DEEP SINGH
 * 
 */

package end_mem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class expFINN {
	//public FINN(){
		static Synthetic sy=new Synthetic();
		static double[][][] abundanc= new double[26][26][4];
		static double[][] attraction=sy.syn();
		static int popSize = 40;
		static int zoom=9;
	    private static int n;
	    private static double A;
		private static double r;
	    private static double Qmin;
		private static double Qmax;

	    private static int d;
	  private static int NofGen;
	   // private double fmax;
	    //private int fmaxIndex;
	    public static double[] Fitness=new double[40];
	    private static double Fnew;
	    static double[] Best;
	  //  private int loopCounter;
        static double[][] UL_bound = new double[2][9];
		static double[][] population=new double[40][9];
		static double[][][] best_plt=new double[26][26][9];

	
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
		Scanner sc1 = null;
		File file_2=new File("E:/nvaadata.csv");
		double[][] kk=new double[26][26];
		try{
		    sc=new Scanner(file_2);
	    sc.useDelimiter(",|\\n");
		    for(int j=0;j<26;j++){
		      		    	  
		    	for(int k=0;k<26;k++){
		    		kk[j][k]=Double.parseDouble(sc.next());
		        }
		    
		}
		}catch(FileNotFoundException e){
		    e.printStackTrace();
		}
		sc.close();

		int i,j;
		/// ALL THE FOLLOWING CAN BE TUNED/VARIED
		 n = 40;//NBats;
	     A = 1;//loudness;
	     r = 10;//pulseRate;
	     Qmin = 12;//minFreq;
	        Qmax = 22;//maxFreq;
	        NofGen = 8;//NofGeneration;
	        int NoSubpixel=9;
	        d = NoSubpixel;//NoSubpixel;
////////////
	        
	        double[][] S = new double[n][d];
	        double[] Best = new double[d];
			

	        //default bounds 
	        for(int u = 0 ;  u < d ; u++)
	        {
	            UL_bound[0][u] = 0;
	            UL_bound[1][u] =  3;
	        }
	       // int loopCounter = 0;
	        Random myRand = new Random();

	        double[]Q = new double[n];
	        for(int v = 0 ; v < n ; v++)
	            Q[v] = 0;

	        double[][] V = new double[n][d];
	        for(i = 0 ; i < n ; i++)
	            for( j = 0 ; j < d ; j++)
	                V[i][j] = 0;
	        ////////////////////////////////////////
	       
	        int t=0,maxiter=30;
	        for(i=1;i<25;i++){
	        	
			for(j=1;j<25;j++){
			    				intialization(i,j,attraction);

			    	
			     
		/*	    double BestfitVal=0,prevFitness=0;
			    for(int k=0;k<popSize;k++){
			    	for(int l=0;l<d;l++){
			    		Sol[k][l]=population[k][l];
			    	}
			    }
				Sol=population;
				while(t<maxiter){
					int bestIndex=getMaxPos(Fitness);
					if(t==0||Fitness[bestIndex]<BestfitVal){
						BestfitVal=Fitness[bestIndex];
						for(j = 0 ; j < d ; j++){
	                        Best[j] = Sol[bestIndex][j];
						}
					}
					prevFitness = BestfitVal;
					
					for(int po = 0 ; po < popSize ; po++){
						double[][] S_ech=new double[1][d];
		                Q[po] = (double) (Qmin + (Qmin - Qmax)* myRand.nextGaussian());

		                for(int l = 0;l < d ; l++)
		                    V[po][l] = V[po][l] + (Sol[po][l]-Best[l])*Q[po];

		                for( j = 0 ; j < d ; j++){
		                    S[po][j] = Math.round(Sol[po][j] + V[po][j]);
//                    	S[po][j]=Math.round(S[po][j]);

	                        S[po] = simpleBounds(S[po]);
		                }
		                if(myRand.nextFloat() > r)          
		                    for( j = 0 ; j < d ; j++){
		                        S[po][j] =  (float) (Best[j] + (.001 * myRand.nextGaussian()) );
		                		S[po][j]=Math.round(S[po][j]);
		                		S[po] = simpleBounds(S[po]);
		                		S_ech[0][j]=S[po][j];}
                        Fnew=fitness(S_ech,i,j);
		                if(Fnew >= Fitness[po] && myRand.nextFloat() < A)
		                {
		                    for( j = 0 ; j < d ; j++)
		                        Sol[po][j] = S[po][j];
		                        Sol[po] = simpleBounds(Sol[po]);

		                    Fitness[po] = Fnew;
		                }

		                if(Fnew >= BestfitVal)
		                {
		                    BestfitVal = Fnew;
		                    for( j = 0 ; j < d ; j++)
		                        Best[j] = S[po][j];
		                } 

		            }
					
					if(BestfitVal-prevFitness<0.001)
						break;
                    for(int p = 0 ; p < d ; p++)
					best_plt[i][j][p]=Best[p]; 		/// FINAL VALUES FOR THE ANSWER
*/
				}
//				 for(int p = 0 ; p < d ; p++)
//					 System.out.print(best_plt[i][j][p]+"\t"+"------------");
//				
				}
				

			// PRINTING POPULATION IN AN EXTERNAL FILE
	        
      FileWriter fwriter=null;                                                                                       
			try{                                                                                                           
				fwriter=new FileWriter("E:/rob55.csv");                                                                 
			}catch(Exception e){                                                                                           
				e.printStackTrace();                                                                                       
			}                                                                                                              
			PrintWriter pw=new PrintWriter(fwriter);                                                                       
		for(int y=0;y<26;y++){
			for(int h=0;h<26;h++){
			for(int u=0;u<9;u++){ 
					pw.print(best_plt[y][h][u]+",");                                                                             
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
			}// EXTERNAL FOR-I

	public static int getMaxPos(double[] fitness2){
		int pos=0;
		double maxVal=fitness2[pos];
		for(int i=0;i<fitness2.length;i++){
			if(fitness2[i]>maxVal){
				pos=i;
				maxVal=fitness2[i];
			}
		}
		return pos;
	}
	
	



	private static void intialization(int i, int j,double[][] synthetic) {
		double[] limit=new double[4];
		int a=i,b=j;
		Random random=new Random();
		double[][] pop_each=new double[1][zoom];

		double[][] population = new double[popSize][zoom];
//		
//
		//////   CONDITION CHECKING FOR POPULATION GENERATION //// 
		
		limit[0]=(9*abundanc[i][j][0]);
		//System.out.println("lim 0  "+limit[0]);
		limit[1]=(9*abundanc[i][j][1]);
		//System.out.println("lim 1  "+limit[1]);
		limit[2]=(9*abundanc[i][j][2]);
		//System.out.println("lim 2  "+limit[2]);
		limit[3]=(9*abundanc[i][j][3]);
		//System.out.println("lim 3  "+limit[3]);
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
//////////////////		
		// POPULATION GENERATION  //
		
		for(int q=0;q<popSize;q++){
			for(int l=0;l<zoom;l++){
					population[q][l]=-1;}}
		for(int k=0;k<popSize;k++){
			int c_0=0,c_1=0,c_2=0,c_3=0;
			int max=3,min=0;
			
				for(int l=0;l<zoom;l++){
				while(population[k][l]==-1){
				int rn=random.nextInt(max - min + 1) + min;
				if(rn==0&&c_0<limit[0]){
					population[k][l]=rn;
					c_0++;
				}
				else if(rn==1&&c_1<limit[1]){
					population[k][l]=rn;
					c_1++;
				}						
				else if(rn==2&&c_2<limit[2]){
					population[k][l]=rn;
					c_2++;
				}
				else if(rn==3&&c_3<limit[3]){
					population[k][l]=rn;
					c_3++;
				}
			}
				pop_each[0][l]=population[k][l];
			}

		
			Fitness[k]=fitness(pop_each,a,b);
			//System.out.println(Fitness[k]+"\t"+"fitness val");
				
		}
		 // BYPASS FOR BEST FITNESS  
		double max=0;
		int ind=0;
		for(int k=0;k<40;k++){
			if(Fitness[k]>max){
				max=Fitness[k];
				ind=k;
			}
		}
		for(int u=0;u<9;u++){
			best_plt[a][b][u]=population[ind][u];
		}
	}
	

    public static double[] simpleBounds(double[] s)
    {
        for(int i = 0 ; i < d ; i++)
        {
            if(s[i] < UL_bound[0][i])
                s[i] = UL_bound[0][i];

            if(s[i] > UL_bound[1][i])
                s[i] = UL_bound[1][i];
        }
        return s;
    }

    
    // CALCULATION OF FITNESS FUNCTION 
    
	private static double fitness(double[][] s, int i, int j) {
		
				double FITCONTEXT=0;
				double[] Fit=new double[4];
				//double fitness=0;
				double max=0;
				double fitt=0;

				double[][] dss=new double[3][3];
				double[][] class_map=new double[26][26];
				for(int end_mem=0;end_mem<4;end_mem++){
				if(abundanc[i][j][end_mem]>0.65)     // CAN BE VARIED
				{
					class_map[i][j]=end_mem;
				}
					else if(abundanc[i][j][end_mem]> max){
						max=abundanc[i][j][end_mem];
						class_map[i][j]=end_mem;
					}
				}
				int count=0;
				for(int k=0;k<3;k++){
					for(int l=0;l<3;l++){
						dss[k][l]=s[0][count];
						count++;
					}}
				double[][][] abundanc_chn=new double[26][26][4];
				double[][][] abundanc_rel=new double[3][3][4];
				double[][] attract=new double[26][26];
			for(int end_mem=0;end_mem<4;end_mem++){
			for(int k=0;k<3;k++){
			for(int l=0;l<3;l++){
			double sum=0;
			double pp=0;
			double sum_abun=0;
			if(class_map[i][j]==dss[k][l]){
			for(int p1=i-1;p1<=i+1;p1++){
				for(int p2=j-1;p2<=j+1;p2++){
					pp=1;
				if(k==0&&l==0){
				pp=Math.sqrt(Math.pow((p1-(i-0.33)),2)+Math.pow((p2-(j-0.33)),2));
				}
				else if(k==0&&l==1){
					pp=Math.sqrt(Math.pow((p1-(i-0.33)),2)+Math.pow((p2-(j)),2));
					}
				else if(k==0&&l==2){
					pp=Math.sqrt(Math.pow((p1-(i-0.33)),2)+Math.pow((p2-(j+0.33)),2));
					}
				else if(k==1&&l==0){
					pp=Math.sqrt(Math.pow((p1-(i)),2)+Math.pow((p2-(j-0.33)),2));
					}
				else if(k==1&&l==1){
					pp=Math.sqrt(Math.pow((p1-(i)),2)+Math.pow((p2-(j)),2));
					if(pp==0)pp=1;
					}
				else if(k==1&&l==2){
					pp=Math.sqrt(Math.pow((p1-(i)),2)+Math.pow((p2-(j+0.33)),2));
					}
				else if(k==2&&l==0){
					pp=Math.sqrt(Math.pow((p1-(i+0.33)),2)+Math.pow((p2-(j-0.33)),2));
					}
				else if(k==2&&l==1){
					pp=Math.sqrt(Math.pow((p1-(i+0.33)),2)+Math.pow((p2-(j)),2));
					}
				else if(k==2&&l==2){					
					pp=Math.sqrt(Math.pow((p1-(i+0.33)),2)+Math.pow((p2-(j+0.33)),2));
					}
				
				sum+=(abundanc[p1][p2][end_mem])/pp;
				sum_abun+=abundanc[p1][p2][end_mem];
				
				}				
			}
			sum_abun/=9;
			abundanc_chn[i][j][end_mem]=abundanc[i][j][end_mem]/sum_abun;  /// ABUNDANCE SPATIAL FOR COMPARISON
			abundanc_rel[k][l][end_mem]=sum;
			}
						
			}
				}
		if(Double.isNaN(abundanc_chn[i][j][end_mem]))abundanc_chn[i][j][end_mem]=0.0;

		}//SYNTHETIC IMAGE SI COEFF
			double sum_atr=0,a=0;
			for(int p1=i-1;p1<=i+1;p1++){
				for(int p2=j-1;p2<=j+1;p2++){
					if(Double.isNaN(attraction[p1][p2])){
						attraction[p1][p2]=0;}
					if(attraction[i][j]==0)attraction[i][j]=0.5;
			a=attraction[p1][p2]/attraction[i][j];  			 /// CALCULATE ORIG ATTRACT / SURROU. ATTRACTION ...

			sum_atr+=a;
				}
				}
			sum_atr/=9;
			attract[i][j]=sum_atr;   		// ATTRACTION COEFFICIENT FOR EACH PIXEL...
	//	System.out.println("SI :"+attract[i][j]);

			for(int p=0;p<4;p++){
			if(abundanc_chn[i][j][p]>attract[i][j]){
						Fit[p]=-(Math.abs(abundanc_chn[i][j][p]-attract[i][j]));
					}
					else{
						Fit[p]=(Math.abs(abundanc_chn[i][j][p]-attract[i][j]));
					}
				}
			for(int p=0;p<4;p++)
				FITCONTEXT+=Fit[p];
		//	System.out.println(FITCONTEXT);
			double sum_S=0;
			//System.out.println(FITCONTEXT);
			for(int k=0;k<3;k++){
				for(int l=0;l<3;l++){
					for(int end_mem=0;end_mem<3;end_mem++){				
					sum_S+=abundanc_rel[k][l][end_mem];
				}
					}
			} 
			sum_S/=9;
		//	System.out.println(i+"\t"+j+"\t"+(sum_S));
		//System.out.println("SUM_S fda"+(sum_S-FITCONTEXT));
			fitt=sum_S-(FITCONTEXT);
			//System.out.println("fitt"+(sum_S-FITCONTEXT));
		return fitt;
	}
	
	
}
	