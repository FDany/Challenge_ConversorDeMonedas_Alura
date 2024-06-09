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

        menu();
        System.out.println("Ingrese la opcion: ");
        Scanner lectura = new Scanner(System.in);
        int opcion = lectura.nextInt();

        double monto;
        BigDecimal resultado;
        // Dato BigDecimal es necesario ya que el tipo de dato float comvierte algunos numeros en notacion cientifica.

        while(opcion!=7){
            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Dolar a Peso argentino");
                        resultado = BigDecimal.valueOf( operacion.consulta("ARS", "USD") );

                        System.out.println("Ingrese la cantidad de dolares a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " Dolar/es => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " Peso/s argentino");
                        break;
                    case 2:
                        System.out.println("Peso argentino a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "ARS") );

                        System.out.println("Ingrese la cantidad de pesos a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " Peso/s argentino => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " dolar/es");
                        break;
                    case 3:
                        System.out.println("Dolar a Real brasileño");
                        resultado = BigDecimal.valueOf( operacion.consulta("BRL", "USD") );

                        System.out.println("Ingrese la cantidad de dolares a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " Dolar => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " Real/es brasileño");
                        break;
                    case 4:
                        System.out.println("Real brasileño a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "BRL") );

                        System.out.println("Ingrese la cantidad de reales a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " Real/es brasileños => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " dolar/es");
                        break;
                    case 5:
                        System.out.println("Dolar a Peso colombiano");
                        resultado = BigDecimal.valueOf( operacion.consulta("COP", "USD") );

                        System.out.println("Ingrese la cantidad de reales a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " Dolar => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " peso/s colombiano");
                        break;
                    case 6:
                        System.out.println("Peso colombiano a Dolar");
                        resultado = BigDecimal.valueOf( operacion.consulta("USD", "COP") );

                        System.out.println("Ingrese la cantidad de reales a convertir: ");
                        monto = lectura.nextDouble();

                        System.out.println(monto + " peso/s colombiano => " + ( resultado.multiply( new BigDecimal(monto) ) ) + " dolar/es");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                //System.out.println("Saliendo de la aplicacion.");
            }

            menu();
            System.out.println("Ingrese la opcion: ");
            opcion = lectura.nextInt();

        }
        System.out.println("Saliendo del programa.");

    }
}
