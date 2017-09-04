/**
 * code for solving abundance maps using non negative least square     very important
 * @author  Naman Deep Singh
 */

package end_mem;
import java.util.ArrayList;
import java.util.List;
import Jama.Matrix;

public class NNLSSolver
{

public double[][] yahoo(double[][] aa,double[][] bb)	{
		Matrix A =new Matrix(aa);	
		//A.constructWithCopy(aa);
		//A.print(14, 10);
		Matrix b = new Matrix(bb);
	//	b.constructWithCopy(bb);
		//Matrix x = A.solve(b);
		//x.print(7, 5);
		Matrix xNNLS = solveNNLS(A,b);
		//xNNLS.print(7, 5);
		double[][] aas=xNNLS.getArray();
		
		return aas;
		
	}
	
	public static Matrix solveNNLS(Matrix A,Matrix b)
	{
		int iterations;
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> z = new ArrayList<Integer>();
		int i = 0;
		int xm = A.getColumnDimension();
		int xn = 1;
		while (i < A.getColumnDimension())
		z.add(i++);
		Matrix x = new Matrix(xm,xn);
		for(iterations = 0; iterations < 300*A.getColumnDimension()*A.getRowDimension(); iterations++)
		{
			//System.out.println(z.size() + " " + p.size());
			Matrix w = A.transpose().times(b.minus(A.times(x)));
			//w.print(7, 5);
			if(z.size() == 0 || isAllNegative(w))
			{
				//System.out.println("Computation should break");
				//We are done with the computation. Break here!
				break;//Should break out of the outer while loop.
			}
			//Step 4
			int t = z.get(0);
			double max = w.get(t, 0);
			for (i = 1; i < z.size(); i++)
			{
				if (w.get(z.get(i), 0) > max)
				{
					t = z.get(i);
					max = w.get(z.get(i), 0);
				}
			}
			//Step 5
			p.add(t);
			z.remove((Integer)t);
			boolean allPositive = false;
			while(!allPositive)
			{
				//Step 6
				Matrix Ep = new Matrix(b.getRowDimension(),p.size());
				for (i = 0; i < p.size(); i++)
					for (int j = 0; j < Ep.getRowDimension(); j++)
						Ep.set(j, i, A.get(j, p.get(i)));
				Matrix Zprime = Ep.solve(b);
				Ep = null;
				Matrix Z = new Matrix(xm,xn);
				for (i = 0; i < p.size(); i++)
					Z.set(p.get(i), 0, Zprime.get(i, 0));
				//Step 7
				allPositive = true;
				for (i = 0; i < p.size(); i++)
					allPositive &= Z.get(p.get(i), 0) > 0;
				if (allPositive)
					x = Z;
				else
				{
					double alpha = Double.MAX_VALUE;
					for (i = 0; i < p.size(); i++)
					{
						int q = p.get(i);
						if (Z.get(q,0) <= 0)
						{
							double xq = x.get(q, 0);
							if (xq / (xq - Z.get(q,0)) < alpha)
								alpha = xq / (xq - Z.get(q,0));
						}
					}
					//Finished getting alpha. Onto step 10
					x = x.plus(Z.minus(x).times(alpha));
					for (i = p.size() - 1; i >= 0; i--)
						if (Math.abs(x.get(p.get(i),0)) < 1e-15)//Close enough to zero, no?
							z.add(p.remove(i));
				}
			}
		}
		return x;
	}
	private static boolean isAllNegative(Matrix w)
	{
		boolean result = true;
		int m = w.getRowDimension();
		for (int i = 0; i < m; i++)
			result &= w.get(i, 0) <= 1e-15;
		return result;
	}
}
