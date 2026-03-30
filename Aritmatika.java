public class Aritmatika {

    // STATIC METHOD (penjumlahan & pengurangan)
    public static int penjumlahan(int a, int b){
        return a + b;
    }

    public static int pengurangan(int a, int b){
        return a - b;
    }

    // NON STATIC METHOD (perkalian & pembagian)
    public int perkalian(int a, int b){
        return a * b;
    }

    public double pembagian(double a, double b){
        return a / b;
    }

    // METHOD NON STATIC untuk menyederhanakan pecahan
    public void sederhana(int pembilang, int penyebut){
        int gcd = 1;

        for(int i = 1; i <= pembilang && i <= penyebut; i++){
            if(pembilang % i == 0 && penyebut % i == 0){
                gcd = i;
            }
        }

        pembilang /= gcd;
        penyebut /= gcd;

        System.out.println("Hasil sederhana: " + pembilang + "/" + penyebut);
    }
}
