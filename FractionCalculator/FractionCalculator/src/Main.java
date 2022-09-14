import java.util.Scanner;

public class Main {

    private class GCF extends Thread{

        int numerator;
        int denominator;
        int gcf;

        GCF(int numerator,int denominator){
            this.numerator=numerator;
            this.denominator=denominator;
        }

        public void run(){
            this.gcf=reduce(this.numerator,this.denominator);
        }
        public int reduce(int numerator, int denominator) {
            return denominator == 0 ? numerator : reduce(denominator, numerator % denominator);
        }
    }

    private class FractionMultiply extends Thread{
        Fraction firstFraction;
        Fraction secondFraction;

        Fraction resultedFraction;

        FractionMultiply(Fraction firstFraction,Fraction secondFraction){
            this.firstFraction=firstFraction;
            this.secondFraction=secondFraction;
        }

        public void run(){
            resultedFraction=multiply(firstFraction,secondFraction);
        }

        public Fraction multiply(Fraction firstFraction,Fraction secondFraction){
            return new Fraction(firstFraction.numerator*secondFraction.numerator,firstFraction.denominator*secondFraction.denominator);
        }
    }

    public String multiplyFractions(String input) throws ZeroDenominatorException,IllegalArgumentException {

        String fractions[]=input.split("x");

        if(fractions.length==1)
            throw new IllegalArgumentException();

        Fraction firstFraction=new Fraction(fractions[0]);

        Fraction secondFraction=new Fraction(fractions[1]);

        if(firstFraction.denominator==0 || secondFraction.denominator==0)
             throw new ZeroDenominatorException();

        GCF gcf1=new GCF(firstFraction.numerator,firstFraction.denominator);
        GCF gcf2=new GCF(secondFraction.numerator,secondFraction.denominator);
        FractionMultiply fractionMultiply=new FractionMultiply(firstFraction,secondFraction);

        gcf1.start();
        gcf2.start();
        fractionMultiply.start();

        while(fractionMultiply.isAlive() || gcf1.isAlive() || gcf2.isAlive()){};

        if(firstFraction.numerator!=0) {
            firstFraction.numerator /= (gcf1.gcf);
            firstFraction.denominator /= (gcf1.gcf);
            fractionMultiply.resultedFraction.numerator/=(gcf1.gcf);
            fractionMultiply.resultedFraction.denominator/=(gcf1.gcf);
        }
        if(secondFraction.numerator!=0) {
            secondFraction.numerator /= (gcf2.gcf);
            secondFraction.denominator /= (gcf2.gcf);
            fractionMultiply.resultedFraction.numerator/=(gcf2.gcf);
            fractionMultiply.resultedFraction.denominator/=(gcf2.gcf);
        }

       return input+" returns "+firstFraction.toString()+"x"+secondFraction.toString()+"="+fractionMultiply.resultedFraction.toString();
    }

}
