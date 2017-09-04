 /**
  *  CODE FOR FITNEES CALCULATION WITHOUT BAT
  *  @UTHOR : NAMAN DEEP SINGH
  */


package end_mem;

import java.util.Random;

public class FINN {
	//public FINN(){
		static abundanc mb=new abundanc();
		static double  abundanc[][][]=mb.abundance();
		
	
	public static void people(double[][] synthetic){
		int i,j;
		
			for(i=0;i<150;i++){
			for(j=0;j<30;j++){
				double[] Fitness=new double[40];
				double[][] population=new double[50][9];
				int c_0=0,c_2=0,c_1=0,min=0,max=2;
				for(int k=0;k<40;k++){
					for(int l=0;l<9;l++){
							population[k][l]=-1;
					}
					}
				double[] limit=new double[3];
				Random random=new Random();
				limit[0]=Math.round(9*abundanc[i][j][0]);
				System.out.println(limit[0]);
				limit[1]=Math.round(9*abundanc[i][j][1]);
				System.out.println(limit[1]);
				limit[2]=Math.round(9*abundanc[i][j][2]);
				System.out.println(limit[2]);
				System.out.println("*************************");
				for(int k=0;k<40;k++){
					c_0=0;c_1=0;c_2=0;
					double[][] pop_each=new double[1][9];
					for(int l=0;l<9;l++){
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
					}
						pop_each[0][l]=population[k][l];
					}
					Fitness[k]=fitness(pop_each,i,j,synthetic);
					System.out.println(Fitness[k]);
				}
				

			}//EXTERNAL FOR-J
			}// EXTERNAL FOR-I
			}// EXTERNAL FUNCTION

	
	
	private static double fitness(double[][] pop_each, int i, int j, double[][] attraction) {
		
				double FITCONTEXT=0;
				double fitness=0;
				double max=0;
				double[][] dss=new double[3][3];
				double[][] class_map=new double[150][30];
				for(int end_mem=0;end_mem<3;end_mem++){
				if(abundanc[i][j][end_mem]>0.7){
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
						dss[k][l]=pop_each[0][count];
						count++;
					}}
				double[][][] abundanc_chn=new double[150][30][3];
				double[][][] abundanc_rel=new double[3][3][3];
				double[][] attract=new double[150][30];
			double pp=0;
			for(int end_mem=0;end_mem<3;end_mem++){
			for(int k=0;k<3;k++){
			for(int l=0;l<3;l++){
			double sum=0;
			double sum_atr=0;
			double sum_abun=0;
			if(class_map[i][j]==dss[k][l]){
			for(int p1=i-1;p1<=i+1;p1++){
			for(int p2=j-1;p2<=j+1;p2++){
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
				sum_atr+=attraction[i][j]/attraction[p1][p2];  			 /// CALCULATE ORIG ATTRACT / SURROU. ATTRACTION ...
			}
			}
			sum_abun/=9;
			sum_atr/=9;
			abundanc_chn[i][j][end_mem]=abundanc[i][j][end_mem]/sum_abun;  /// ABUNDANCE SPATIAL FOR COMPARISON
			attract[i][j]=sum_atr;   		/// ATTRACTION COEFFICIENT FOR EACH PIXEL...
			System.out.println("ATTRACTION SPATIAL "+sum_atr+"\t"+"ABUNDANCE SPATIAL "+abundanc_chn[i][j][end_mem]);
			abundanc_rel[k][l][end_mem]=sum;
			System.out.println("abundanc_rel : "+abundanc_rel[k][l][end_mem]);
			}
						
			}
				}
		}
			for(int p=0;p<3;p++){
					if(abundanc_chn[i][j][p]>attract[i][j]){
						FITCONTEXT=-(Math.abs(abundanc_chn[i][j][p]-attract[i][j]));
					}
					else{
						FITCONTEXT=(Math.abs(abundanc_chn[i][j][p]-attract[i][j]));
					}
				}
			double sum_S=0;
			for(int k=0;k<3;k++){
				for(int l=0;l<3;l++){
					for(int end_mem=0;end_mem<3;end_mem++){				
					sum_S+=abundanc_rel[k][l][end_mem];
				}}
			}
		
		
		fitness=sum_S-FITCONTEXT;
		
		return fitness;
	}
}
	