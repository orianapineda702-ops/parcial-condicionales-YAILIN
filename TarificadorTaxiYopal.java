import java.util.Scanner;

public class TarificadorTaxiYopal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v, h, p, e;
        double km, tarifa = 0, min = 0, rec = 0, des = 0, sub, total;
        String d, l, r;
        boolean noche = false;

        System.out.print("Vehiculo: ");
        v = sc.nextInt();

        System.out.print("Km: ");
        km = sc.nextDouble();

        System.out.print("Hora: ");
        h = sc.nextInt();

        System.out.print("Domingo S/N: ");
        d = sc.next();

        System.out.print("Lluvia S/N: ");
        l = sc.next();

        System.out.print("Rural S/N: ");
        r = sc.next();

        System.out.print("Pasajero: ");
        p = sc.nextInt();

        System.out.print("Edad: ");
        e = sc.nextInt();

        if (v < 1 || v > 3) {

            System.out.println("Vehiculo invalido");

        } else if (km <= 0) {

            System.out.println("Km invalidos");

        } else if (h < 0 || h > 23) {

            System.out.println("Hora invalida");

        } else {

            if (v == 1) {
                tarifa = 1200;
                min = 5000;
            } else if (v == 2) {
                tarifa = 2000;
                min = 8000;
            } else {
                tarifa = 2800;
                min = 12000;
            }

            sub = km * tarifa;

            if (sub < min) {
                sub = min;
            }

            if (h >= 22 || h < 5) {
                noche = true;
            }

            if (noche) rec += 20;
            if (d.equals("S")) rec += 15;
            if (l.equals("S")) rec += 10;
            if (r.equals("S")) rec += 25;

            total = sub + (sub * rec / 100);

            if (p == 1) {
                des = 10;
            } else if (p == 2) {
                des = 8;
            } else if (p == 3) {

                // CONDICIONAL ANIDADA

                if (e >= 60) {
                    des = 12;
                } else {
                    System.out.println("No es adulto mayor");
                }
            }

            total = total - (total * des / 100);

            if (r.equals("N") && total < min) {
                total = min;
            }

            System.out.println("Total: $" + (int) total);
        }

        sc.close();
    }
}