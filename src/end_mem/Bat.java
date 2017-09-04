/**
 *  CODE FOR IMPLEMENTING BAT ALGORITHM
 *  @UTHOR : NAMAN DEEP SINGH
 */
package end_mem;

import java.util.Random;

public class Bat
{
    private int n;
    private float A, r;
    private float Qmin, Qmax;
    private int d;
    private int NofGen;
    private float fmax;
    private int fmaxIndex;
    private float Fnew;
    private int loopCounter;

    private float Q[], V[][], Sol[][], UL_bound[][], fitness[], S[][], Best[];

    private Random myRand;

    public Bat(
            int NBats,
            float loudness,
            float pulseRate,
            float minFreq,
            float maxFreq,
            int NofGeneration,
            int dimension
            )
    {
        n = NBats;
        A = loudness;
        r = pulseRate;
        Qmin = minFreq;
        Qmax = maxFreq;
        NofGen = NofGeneration;
        int NoSubpixel=9;
        d = NoSubpixel;

        S = new float[n][d];
        Best = new float[d];
        UL_bound = new float[2][d];

        //default bounds 
        for(int i = 0 ;  i < d ; i++)
        {
            UL_bound[0][i] = 0;
            UL_bound[1][i] =  2;
        }

        loopCounter = 0;
        myRand = new Random();

        Q = new float[n];
        for(int i = 0 ; i < n ; i++)
            Q[i] = 0;

        V = new float[n][d];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < d ; j++)
                V[i][j] = 0;

    }



    public void intial()
    {

        Sol = new float[n][d];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < d ; j++)
            {
                float t = (float) myRand.nextGaussian();
                //(upper -lower)*rand + lower
                Sol[i][j] = t * (UL_bound[1][j] - UL_bound[0][j]) + UL_bound[0][j]; ///INITIALIZATION'S.....
            }

 
        fitness = new float[n];
        for(int i = 0 ; i < n ; i++)
            fitness[i] = function(Sol[i]);

        //finding fmin
        fmax = fitness[0];
        fmaxIndex = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if (fitness[i] > fmax)
            {
                fmax = fitness[i];
                fmaxIndex = i;
            }
        }

        //setting best
        for(int j = 0 ; j < d ; j++)
            Best[j] = Sol[fmaxIndex][j];

    }

    public void start()
    {

        while(loopCounter < NofGen)
        {

            for(int i = 0 ; i < n ; i++)
            {

                Q[i] = Qmin + (Qmin - Qmax)* myRand.nextFloat();

                for(int j = 0 ; j < d ; j++)
                    V[i][j] = V[i][j] + (Sol[i][j]-Best[j])*Q[i];

                for(int j = 0 ; j < d ; j++)
                    S[i][j] = Sol[i][j] + V[i][j]; 

                Sol[i] = simpleBounds(Sol[i]);

                if(myRand.nextFloat() > r)          
                    for(int j = 0 ; j < d ; j++)
                        S[i][j] =  (float) (Best[j] + (.001 * myRand.nextFloat()) );

                Fnew = function(S[i]);

                if(Fnew >= fitness[i] && myRand.nextFloat() < A)
                {
                    for(int j = 0 ; j < d ; j++)
                        Sol[i][j] = S[i][j];

                    fitness[i] = Fnew;
                }

                if(Fnew >= fmax)
                {
                    fmax = Fnew;
                    for(int j = 0 ; j < d ; j++)
                        Best[j] = S[i][j];
                } 

            }
            loopCounter++;

        }

    }

    public float[] simpleBounds(float p[])
    {
        for(int i = 0 ; i < d ; i++)
        {
            if(p[i] < UL_bound[0][i])
                p[i] = UL_bound[0][i];

            if(p[i] > UL_bound[1][i])
                p[i] = UL_bound[1][i];
        }
        return p;
    }
    float function(float p[])
    {
        // Sphere function with fmin=0 at (0,0,...,0)
        float sum = 0;
        for(int i = 0 ;  i < p.length  ; i++)
            sum = sum + p[i]*p[i];
        return sum;

    }
    public float printResult()
    {
        System.out.println("After " + loopCounter + "Repeats :");

        for(int i = 0 ; i < d ; i++)
            System.out.print(Best[i] + ", ");

        System.out.println ( "F(x)  = " + fmax);
        return fmax;
    }

    public void set_UL_Bound(int n, float L, float U)
    {
        if( n < d && n >= 0)
        {
            UL_bound[0][n] = L;
            UL_bound[1][n] = U;
        }
    }   




}