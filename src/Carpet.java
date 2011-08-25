import java.awt.Color;

public class Carpet
{
    public Carpet(double N_in)
    {
        StdDraw.setXscale(-1, N_in + 1);
        StdDraw.setYscale(-1, N_in + 1);

        StdDraw.clear(StdDraw.BLACK);
        
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.square(N_in/2, N_in/2, N_in/2);

        StdDraw.setPenColor(Color.WHITE);
        StdDraw.square(N_in/2, N_in/2, N_in/2 - 1.0);
        
        int itr = 1;
        
        draw(N_in, itr, Color.WHITE);
        
        while (true)
        {
            if (StdDraw.hasNextKeyTyped())
            {
                char c = StdDraw.nextKeyTyped();
                
                if (c == 'a')
                    draw(N_in, itr++, Color.WHITE);
            }
        }      
    
    }

    private void draw(double N_in, int itr, Color color)
    {
        double N_center;
        
        StdDraw.setPenColor(color);

        N_center = N_in / Math.pow(3, itr);
        
        for (double j = 0.0; j < N_in; j += 3 * N_center)
        {
            for (double i = 0.0; i < N_in; i += 3 * N_center)
            {
                StdDraw.filledSquare(3*N_center / 2 + i, (3*N_center / 2 + j), N_center / 2);
                StdDraw.filledSquare(3*N_center / 2 + j, (3*N_center / 2) + i, N_center / 2);
                StdDraw.filledSquare(N_in - (3*N_center / 2 + j), (3*N_center / 2 + i), N_center / 2);
                StdDraw.filledSquare(3*N_center / 2 + i, N_in - (3*N_center / 2 + j), N_center / 2);            
            }
        }
    } 
    
    public static void main(String args[])
    {
        Carpet app = new Carpet(Math.pow(3.0, 6.0));
    }
}
