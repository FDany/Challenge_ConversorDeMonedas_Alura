import models.ConsultaMoneda;
import models.Monedas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

    public static void menu(){
        System.out.println("\n********* Menu *********");
        System.out.println("1) Dolar => Peso argentino");
        System.out.println("2) Peso argentino => Dolar");
        System.out.println("3) Real brasileño => Dolar");
        System.out.println("4) Dolar => Real brasileño");
        System.out.println("5) Dolar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dolar");
        System.out.println("7) Salir");
    }

    public static void main(String[] args) {

        ConsultaMoneda operacion = new ConsultaMoneda();

        /*
        double numeroCientifico = 2.6093E-4;
        BigDecimal numeroDecimal = BigDecimal.valueOf(numeroCientifico);
        numeroDecimal.stripTrailingZeros();
        System.out.println(numeroCientifico * 2);
        */
        /*
        Recuerda que BigDecimal es útil cuando necesitas realizar operaciones que requieren una precisión arbitraria,
        como operaciones financieras o cálculos científicos, donde la precisión de punto flotante podría introducir
        errores. Además, ten en cuenta que algunas operaciones pueden arrojar excepciones como ArithmeticException
        si el resultado no puede ser representado con precisión exacta. Para manejar estas excepciones, debes envolver
        tus operaciones con bloques try-catch.
         */

        //System.out.println(df.format(operacion.consulta("USD","ARS").conversion_rates().get("USD")).replace(",","."));


        //System.out.printf("%.10f\n",operacion.consulta("COP","USD").conversion_rates().get("COP"));

        menu();
        System.out.println("Ingrese la opcion: ");
        Scanner lectura = new Scanner(System.in);
        int opcion = lectura.nextInt();

        BigDecimal resultado;

        while(opcion!=7){
            try {
                //double lista = consulta.consulta("ARS","USD");

                switch (opcion) {
                    case 1:
                        System.out.println("Dolar a Peso argentino");
                        resultado = BigDecimal.valueOf( operacion.consulta("ARS", "USD") );
                        System.out.println("1" + " Dolar => " + resultado + " Peso/s argentino");
                        break;
                    case 2:
                        System.out.println("Peso argentino a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "ARS") );
                        System.out.println("1" + " Peso/s argentino => " + resultado + " dolar/es");
                        break;
                    case 3:
                        System.out.println("Dolar a Real brasileño");
                        resultado = BigDecimal.valueOf( operacion.consulta("BRL", "USD") );
                        System.out.println("1" + " Dolar => " + resultado + " Real/es brasileño");
                        break;
                    case 4:
                        System.out.println("Real brasileño a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "BRL") );
                        System.out.println("1" + " Real/es brasileños => " + resultado + " dolar/es");
                        break;
                    case 5:
                        System.out.println("Dolar a Peso colombiano");
                        resultado = BigDecimal.valueOf( operacion.consulta("COP", "USD") );
                        System.out.println("1" + " Dolar => " + resultado + " peso/s colombiano");
                        break;
                    case 6:
                        System.out.println("Peso colombiano a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "COP") );
                        System.out.println("1" + " peso/s colombiano => " + resultado + " dolar/es");
                        break;
                    case 7:
                        break;
                }

                //System.out.println(lista.conversion_rates().get("ARS"));
                //System.out.println(lista);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Saliendo de la aplicacion.");
            }

            menu();
            System.out.println("Ingrese la opcion: ");
            opcion = lectura.nextInt();

        }

    }
}
