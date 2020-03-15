import java.math.BigInteger;

public class Padovan {
    static int[] intVals=new int[3];
    static long[] longVals = new long[3];
    static BigInteger[] bigIntVals = new BigInteger[3];

    public static void main(String[] args) {
        System.out.println(getPadovan(1000000));
        System.out.println(getPadovan(101));
        System.out.println(getPadovan(102));
        System.out.println(getPadovan(103));
    }


        public static BigInteger getPadovan (long power)
        {
            intVals[0]=1;
            intVals[1]=1;
            intVals[2]=1;
            if(power <3)
                return BigInteger.ONE;

            System.out.println("..........Int.........");
            int pow = padovanInt(power);

            if(pow==power)
                return BigInteger.valueOf(intVals[((int)power%3+2)%3]);
            else
                pow = padovanLong(pow,power);

            System.out.println("...........Long.........");

            if(pow==power)
                return BigInteger.valueOf(longVals[((int)power%3+2)%3]);

            System.out.println("...........Big Integer.........");

            bigIntVals[0]=BigInteger.valueOf(longVals[0]);
            bigIntVals[1]=BigInteger.valueOf(longVals[1]);
            bigIntVals[2]=BigInteger.valueOf(longVals[2]);

            while(pow<power) {
                bigIntVals[pow%3]=bigIntVals[pow%3].add(bigIntVals[(pow%3+1)%3]);
                pow++;
            }

            return  bigIntVals[pow%3];
        }

        public static int padovanInt(long power) {
            int i=3;
            while(i<power) {
                int k = intVals[i%3]+intVals[(i%3+1)%3];
                if (k<0) {
                    return i-1;
                }
                intVals[i%3]=k;
                i++;
            }
            System.out.println("Int i:" + i);
            System.out.println(intVals[0] +" " + intVals[1] +" " + intVals[2]);
            return i;

        }

        public static int padovanLong(int currentPower, long power) {
            int i = currentPower;
            longVals[0] = intVals[0];
            longVals[1] = intVals[1];
            longVals[2] = intVals[2];

            while(i<power) {
                long k = longVals[i%3]+longVals[(i%3+1)%3];
                if (k<0) {
                    return i-1;
                }
                longVals[i%3]=k;
                i++;
            }
            System.out.println("long i:" + i);

            System.out.println(longVals[0] +" " + longVals[1] +" " + longVals[2]);
            return i;

        }
}
