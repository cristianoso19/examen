import java.util.Scanner;

public class RegistroPersonas {

    public static void main(String[] args) {
        //LITERAL A
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[5];
        char[] sexos = new char[5];
        int[] edades = new int[5];
        double[] alturas = new double[5];
        double[] pesos = new double[5];
        double[] imc = new double[5];

        int contador = 0;
        while (contador < 5) {
            System.out.println("Ingrese los datos de la persona " + (contador + 1) + ":");
            System.out.print("Nombre: ");
            nombres[contador] = scanner.nextLine();

            System.out.print("Sexo (M/F): ");
            sexos[contador] = scanner.nextLine().charAt(0);

            System.out.print("Edad: ");
            edades[contador] = Integer.parseInt(scanner.nextLine());

            System.out.print("Altura (en metros): ");
            alturas[contador] = Double.parseDouble(scanner.nextLine());

            System.out.print("Peso (en kg): ");
            pesos[contador] = Double.parseDouble(scanner.nextLine());

            // Calcular el IMC y almacenarlo en la estructura imc
            imc[contador] = calcularIMC(pesos[contador], alturas[contador]);

            contador++;
        }
        
        //LITERAL I
        mostrarDatos(nombres, sexos, edades, alturas, pesos, imc);
        contarSexos(sexos);
        contarNinos(edades);
        evaluarIMC(imc);
        calcularPromedio(edades);

        String personaMayorEdad = personaMayorEdad(nombres, edades);
        if (personaMayorEdad != null) {
            System.out.println("La persona de mayor edad es: " + personaMayorEdad);
        } else {
            System.out.println("No se han ingresado personas.");
        }
    }

    //LITERAL B    
    public static void mostrarDatos(String[] nombres, char[] sexos, int[] edades, double[] alturas, double[] pesos) {
        System.out.println("\nDatos ingresados correctamente:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Persona " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Sexo: " + sexos[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Altura: " + alturas[i] + " metros");
            System.out.println("Peso: " + pesos[i] + " kg\n");
        }
    }

    //LITERAL C
    public static void contarSexos(char[] sexos) {
        int hombres = 0;
        int mujeres = 0;

        for (char sexo : sexos) {
            if (sexo == 'M' || sexo == 'm') {
                hombres++;
            } else if (sexo == 'F' || sexo == 'f') {
                mujeres++;
            }
        }

        System.out.println("Cantidad de hombres: " + hombres);
        System.out.println("Cantidad de mujeres: " + mujeres);
    }

    //LITERAL D
    public static void contarNinos(int[] edades) {
        int ninos = 0;

        for (int edad : edades) {
            if (edad < 13) {
                ninos++;
            }
        }

        System.out.println("Cantidad de niños (menores de 13 años): " + ninos);
    }

    //LITERAL E
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    //LITERAL F
     public static void evaluarIMC(double[] imc) {
        System.out.println("\nEvaluación del IMC:");

        for (int i = 0; i < 5; i++) {
            String estadoIMC = "";
            if (imc[i] < 18.5) {
                estadoIMC = "delgada";
            } else if (imc[i] >= 18.5 && imc[i] <= 22) {
                estadoIMC = "normal";
            } else {
                estadoIMC = "obesa";
            }

            System.out.println("Persona " + (i + 1) + " - IMC: " + imc[i] + " - Estado: " + estadoIMC);
        }
    }

    //LITERAL G
    public static void calcularPromedio(int[] edades) {
        int sumaEdades = 0;
        for (int edad : edades) {
            sumaEdades += edad;
        }

        double promedioEdades = (double) sumaEdades / edades.length;

        System.out.println("\nPromedio de edades: " + promedioEdades);
    }

    //LITERAL H
    public static String personaMayorEdad(String[] nombres, int[] edades) {
        if (edades.length == 0) {
            return null; // No hay personas ingresadas
        }

        int indiceMayorEdad = 0;
        for (int i = 1; i < edades.length; i++) {
            if (edades[i] > edades[indiceMayorEdad]) {
                indiceMayorEdad = i;
            }
        }

        return nombres[indiceMayorEdad];
    }

}
