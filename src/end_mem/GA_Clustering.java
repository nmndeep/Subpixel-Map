/**
 *  CODE FOR CALCULATING POPULATION USING FITNESS AND GENETIC ALGORITHM
 *  @author  Naman Deep Singh
 */

package end_mem;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


import javax.swing.JOptionPane;




public class GA_Clustering {
	static Synthetic sy=new Synthetic();
	static double[][][] abundanc= new double[26][26][4];
	static double[][] attraction=sy.syn();
	static int popSize = 40;
	static double[][] population=new double[40][9];
    public static double[] Fitness=new double[40];
    public static double[][][] best_plt=new double[26][26][9];
	static double[] limit=new double[4];

    

    public static void initialization(int i, int j,double[][] synthetic){
		int a=i,b=j;
		Random random=new Random();
		int zoom=9;
		double[][] pop_each=new double[1][zoom];

	//	double[][] population = new double[popSize][zoom];

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

		}
    }
    
	private static double fitness(double[][] s, int i, int j) {
		
		double FITCONTEXT=0;
		double[] Fit=new double[4];
		//double fitness=0;
		double max=0;
		double fitt=0;

		double[][] dss=new double[3][3];
		double[][] class_map=new double[26][26];
		for(int end_mem=0;end_mem<4;end_mem++){
		if(abundanc[i][j][end_mem]>0.65){
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
	double sum_S=0;
	for(int k=0;k<3;k++){
		for(int l=0;l<3;l++){
			for(int end_mem=0;end_mem<3;end_mem++){				
			sum_S+=abundanc_rel[k][l][end_mem];
		}
			}
	} 
	sum_S/=9;
	fitt=sum_S-(FITCONTEXT);
return fitt;
}
	
	 private static double[] rouletteWheelSelect()
	    {
	        double sumFitness = 0;
	        double [] fitnessArray = new double[40];
	        double fitness;
	        
	        for(int i = 0; i < 40; i++)
	        {
//	            Fitness[i] = population[i].getFitness();
	            sumFitness += Fitness[i];
	            fitnessArray[i] = Fitness[i];
	        }
	        
	        double rangeMin = 0, rangeMax = sumFitness;
	        
	        Random r = new Random();                
	        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();        
	        if(randomValue < 0) randomValue *= -1;
	        randomValue %= rangeMax - 1;
	        
	        for(int i = 0; i < 40; i++)
	        {
	            if(randomValue <= fitnessArray[i])
	            {
	                return population[i];
	            }
	            else
	            {
	                randomValue -= fitnessArray[i];
	            }
	        }
	        
	        return population[40 - 1];
	        // this shouldn't actually ever happen
	    }
	    
	
	 public static double[] selectParent()
	    {

	            return rouletteWheelSelect();

	    }
	
	
	
	public static double[] getCrossover()
    {

     return arithmeticCrossover(selectParent(), selectParent());
    }
	
	

	    
	    private static double[] arithmeticCrossover(double[] parent1, double[] parent2)
	    {
	       // DataPoint [] centroids = new DataPoint[numClusters];
	    	double[] cent=new double[9];
	        for(int x = 0; x < parent1.length; x++)
	        {
	          cent[x]=(parent1[x]+parent2[x])/2.0;
	            
	        }
	        
	        return cent;
	    }

    
	    public static void doMutation(double[] chromosome)
	    {
//	        if(mutationType == 1)
//	        {
//	            swapMutation(chromosome);
//	        }
//	        else
//	        {
	            guassianMutation(chromosome);
	     
	    }
	    
	    private static void guassianMutation(double[] mutator)
	    {
	    	int rangeMin = 0, rangeMax = 9;
	        
	        Random r = new Random();                
	        int randomValue1 = rangeMin + (rangeMax - rangeMin) * r.nextInt();        
	        if(randomValue1 < 0) randomValue1 *= -1;
	        randomValue1 %= rangeMax - 1;   
	        
	       // DataPoint swap1 = mutator.centroids[randomValue1];
	        int ind1=randomValue1;
	        r = new Random();      
	        
	        int randomValue2 =  randomValue1;
	        while(randomValue2 == randomValue1)
	        {
	            randomValue2 = rangeMin + (rangeMax - rangeMin) * r.nextInt();        
	            if(randomValue2 < 0) randomValue2 *= -1;
	            randomValue2 %= rangeMax - 1;   
	        }
	        
	       // DataPoint swap2 = mutator.centroids[randomValue2];
	         int ind2=randomValue2;               
	        // then select a random dimension
	        rangeMax = 4;
	        
	        r = new Random();                
	        int randomValue = rangeMin + (rangeMax - rangeMin) * r.nextInt();        
	        if(randomValue < 0) randomValue *= -1;
	        randomValue %= rangeMax - 1;
	         double temp1=mutator[ind1];
	         double temp2=mutator[ind2];
	         mutator[ind1]=temp2;
	         mutator[ind2]=temp1;
	        }
	    
//	    private double getNextGaussian()
//	    {
//	        Random r = new Random();
//	        double v1, v2, s;
//	        do {
//	            v1 = (2 * r.nextDouble() - 1) * 0.1;   // between -0.1 and 0.1
//	            v2 = (2 * r.nextDouble() - 1) * 0.1;   // between -0.1 and 0.1
//	            s = v1 * v1 + v2 * v2;
//	        } while (s >= 1 || s == 0);
//	        double multiplier = Math.sqrt(-2 * Math.log(s) / s);
//	        //nextNextGaussian = v2 * multiplier;
//	        //haveNextNextGaussian = true;
//	        return v1 * multiplier;        
//	    }
//	    
    
    public static void main(String[] args) throws IOException {  
    	
    	Scanner sc = null;
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
   
        double[][] new_population=new double[40][9];
        int new_pop_index=0;
        int t=0,maxiter=20;
        double probability=0.95;  // can be varied to get best result set
        
        for(int i=1;i<25;i++){
        	for(int j=1;j<25;j++){
        		System.out.println(i+"\t"+j);
        		initialization(i,j,attraction);
     //  while(t<maxiter){
    	   for(int y=0;y<40;y++){
    	   for(int q=0;q<9;q++){
    	   new_population[y][q]=population[y][q];
    	   }
    	   }
    	   new_pop_index=1;    	   
    	   Random r;
    	   while(new_pop_index<40){
    		   double crossoverProbability=0.80; // can be varied to get best result set
    		   r=new Random();
    		   // CROSSOVER   
    		   double randomValue=r.nextDouble();
    		   if(randomValue<0) randomValue*=-1;
    		   randomValue%=1;
    		   if(randomValue<=probability){
    			   for(int q=0;q<9;q++)
    			   new_population[new_pop_index][q]=population[new_pop_index][q]; 
    		   }
    		   
    		   double[] temp=new double[9];
    		   temp=getCrossover();
    		   for(int s=0;s<9;s++)
        		   System.out.print(temp[s]);
        		   	System.out.println("***********");
    		   	new_population[new_pop_index]=temp;
    		   	
    		   	//MUTATION
    		   	
    		    r = new Random();                
                randomValue = r.nextDouble();        
                if(randomValue < 0) randomValue *= -1;
                randomValue %= 1;                     
                
				if(randomValue >= crossoverProbability)
                {
                    doMutation(new_population[new_pop_index]);
                }
                new_pop_index++;
                                
    	   }
    	   double[][] pop_ech=new double[1][9];
    	   double[] fit_val=new double[40];
    	   for(int k=0;k<40;k++){
    		   for(int l=0;l<9;l++){
    	  population[k][l]=new_population[k][l];
       pop_ech[0][l]=population[k][l];
    		   } 
    		  fit_val[k]= fitness(pop_ech,i,j);
    	   }
    	   double max=0;
    	   int index=0;
    	   for(int k=0;k<40;k++){
    		  if(fit_val[k]>max){
    			  max=fit_val[k];
    			  index=k;
    		  }
    	   }
    	   for(int y=0;y<9;y++){
    	   best_plt[i][j][y]=population[index][y];
    	   
    	  }
    	   int c_0=0,c_1=0,c_2=0,c_3=0;
    	   for(int y=0;y<9;y++){
    	   if(best_plt[i][j][y]%1!=0){
    		   double a=Math.round(best_plt[i][j][y]);
    		   if(a==0&& c_0<limit[0]){
    			   best_plt[i][j][y]=a;
    			   c_0++;
    		   }
    		   else if(a==1&& c_1<limit[1]){
    			   best_plt[i][j][y]=a;
    			   c_1++;
    		   }
    		   else if(a==2&& c_2<limit[2]){
    			   best_plt[i][j][y]=a;
    			   c_2++;
    		   }
    		   else if(a==3&& c_3<limit[3]){
    			   best_plt[i][j][y]=a;
    			   c_3++;
    		   }
    	   }
    	   }
       }
         
    }
//}  
        for(int i=0;i<26;i++){
	for(int j=0;j<26;j++){
		for(int y=0;y<9;y++){
	if(best_plt[i][j][y]%1!=0){
		best_plt[i][j][y]=Math.round(best_plt[i][j][y]);
	}
        System.out.print(best_plt[i][j][y]+"\t");
	   }
	   System.out.println();
	}}
        
        FileWriter fwriter=null;                                                                                       
		try{                                                                                                           
			fwriter=new FileWriter("E:/gasol_new1.csv");                                                                 
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
}
    }