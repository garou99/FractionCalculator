public class Fraction{
    int numerator;
    int denominator;

    public Fraction(String fraction){
        String numeratorDenominator[]=fraction.split("/");

        if(numeratorDenominator.length==1)
            throw new IllegalArgumentException();

        this.numerator=Integer.parseInt(numeratorDenominator[0]);
        this.denominator=Integer.parseInt(numeratorDenominator[1]);
    }
    public Fraction(int numerator,int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }

    public String toString(){
        return String.valueOf(this.numerator)+"/"+String.valueOf(this.denominator);
    }
}
