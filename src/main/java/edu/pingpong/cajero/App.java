package edu.pingpong.cajero;
import java.text.MessageFormat;
import java.util.Scanner;

public class App {



    public static TarjetaCredito tarjetaCreditoo;
    public static TarjetaDebito tarjetaDebitoo;

    public static int[][] carga_billetes;

    public static void main(String[] args) {
        tt();
    }


    public static void tt(){

        boolean works = false;

        

        do{

            try{
                Scanner ask = new Scanner(System.in);
                System.out.println("Elige una de las opciones" + "\n" +
                "[1] Sacar dinero" + "\n" +
                "[2] Salir");
                int selected = ask.nextInt();
                
                if(selected == 1){

                    carga_billetes = new int[][] {{500, 1}, {200, 3}, {100, 0}, {50, 0},
                    {20, 0}, {10, 18}, {5, 25}};

                    CajeroAutomatico micajero = new CajeroAutomatico();
                    micajero.setBilletes(carga_billetes);
                    tarjetaCreditoo = new TarjetaCredito("87654321b", 2222, "Javi", "Javi", 1000,5000);
                    tarjetaDebitoo = new TarjetaDebito("12345678a", 1111, "Fran", "Fran", 20000);
                    micajero.getListaTarjeta().add(tarjetaCreditoo);
                    micajero.getListaTarjeta().add(tarjetaDebitoo);
                    mostrarTarjeta();
                    mostrarCajero();
                    sacarDinero();
                    
                    
                    
                }

                else{
                    if(selected == 2){
                        System.out.println("Thanks for using the program!!");
                        break;
                    }
                }
            }  
                catch(Exception error){
                    System.out.println("Something went wrong!");
                
                    }
            }while(!works);
    }


    public static void mostrarTarjeta(){


        System.out.println("DATOS DE LA TARJETA DEL CLIENTE" + "\n" + 
        "=========================================" + "\n" +
        "Nombre: " + tarjetaDebitoo.nombre + "\n" +
        "Apellido: " + tarjetaDebitoo.apellido + "\n" +
        "NIF:" + tarjetaDebitoo.NIF + "\n" + 
        "Tarjeta de débito: " + "\n" +
        "Saldo:" + tarjetaDebitoo.getSaldoDisponible() + "\n" +
        "===================================================" + "\n" +
        "DATOS DE LA TARJETA DEL CLIENTE" + "\n" +
        "Nombre: " + tarjetaCreditoo.nombre + "\n" +
        "Apellido: " + tarjetaCreditoo.apellido + "\n" +
        "NIF:" + tarjetaCreditoo.NIF + "\n" + 
        "Tarjeta de credito: " + "\n" +
        "Saldo:" + tarjetaCreditoo.getSaldoDisponible() + "\n" + 
        "Crédito: " + tarjetaCreditoo.getCreditoDisponible()
        );
    }

        public static void mostrarCajero(){
            System.out.println(MessageFormat.format("{0} billetes de {1}",carga_billetes[0][1],carga_billetes[1][0]));
        }

        public static void sacarDinero(){


                try{
                    Scanner retire_money = new Scanner(System.in);
                    Scanner nif = new Scanner(System.in);
                    Scanner pin = new Scanner(System.in);

                    System.out.println("Elige una de las opciones" + "\n" +
                    "[1] Sacar diner0" + "\n" +
                    "[2] Salir");
                    int money = retire_money.nextInt();
                    
                        if(money == 1){
                            System.out.println("Has elegido sacar dinero:" + "\n" + "\n" +
                            "Dame el NIF:"
                            );
                        String niff = nif.nextLine();


                        System.out.println("Dame el PIN");
                        int num_pin = pin.nextInt();

                            if(niff.equals(tarjetaCreditoo.NIF) && num_pin == tarjetaCreditoo.PIN || niff.equals(tarjetaDebitoo.NIF) && num_pin == tarjetaDebitoo.PIN){
                                Scanner retirarDinero = new Scanner(System.in);
                                System.out.println("¿que cantidad deseas sacar?");
                                int dinero = retirarDinero.nextInt();



                            }
                            else{
                                System.out.println("Something went wrong in the process!");
                            }

                        }



                        
                        else{
                            if(money == 2){
                                System.out.println("You canceled the process");
                            }
                        }
                    }
                
                catch(Exception errorr){
                    System.out.println("Couldn't withdrawn the money");
                }
            
        }


}
