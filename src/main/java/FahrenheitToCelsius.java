import java.util.Scanner;


public class FahrenheitToCelsius {

    public static void main(String[] args) {

        System.out.println("Introduzca una temperatura en fahrenheit");
        //creamos objeto scanner
        Scanner sc = new Scanner(System.in);
        //leemos string
        String farstr = sc.nextLine();
        //reemplazamos . por , para evitar un problema de locale
        farstr.replace(".", ";");
        //cambiamos string por double
        double far = Double.parseDouble(farstr);
        //aplicamos la fórmula matemática que cambia fahrenheit a celsius
        far = 5*((far-32)/9);
        //cambiamos double a int
        int cel = (int) Math.round(far);
        System.out.println(farstr + " farenheit convertido a celsius es : " + cel);

    }
}
