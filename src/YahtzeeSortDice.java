/**
 * Created by kadams16 on 12/17/15.
 */
public class YahtzeeSortDice
{
    int first;
    int second;
    int third;
    int fourth;
    int fifth;

    /* constructor: initializes the private data by sorting the order of the dice */
    public YahtzeeSortDice(int a, int b, int c, int d, int e)
    {
        int x;
        for(int i=0;i<5;i++) {
            if(a>b) {
                x = a;
                a = b;
                b = x;
            }
            if(b>c) {
                x = b;
                b = c;
                c = x;
            }
            if(c>d) {
                x = c;
                c = d;
                d = x;
            }
            if(d>e) {
                x = d;
                d = e;
                e = x;
            }
        }
        first = a;
        second = b;
        third = c;
        fourth = d;
        fifth = e;
    }


    /* returns the minimum of the five numbers */
    public int getFirst()
    {
        return first;
    }

    /* returns the second smallest of the five number */
    public int getSecond()
    {
        return second;
    }

    /* returns the middle of the five numbers */
    public int getThird()
    {
        return third;
    }

    /* returns the second largest of the five numbers */
    public int getFourth()
    {
        return fourth;
    }

    /* returns the biggest of the five numbers */
    public int getFifth()
    {
        return fifth;
    }
}
