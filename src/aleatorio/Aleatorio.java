package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alba
 */
public class Aleatorio {

    private static RandomAccessFile raf;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos", "tachas"};
        int[] prices = {3, 4, 5};
        String f1, f2, s1 = "", s2 = ""; //no se puede poner null xq incluye la palabra 'null'

        raf = new RandomAccessFile("texto11.txt", "rw");

        for (int i = 0; i < codes.length; i++) {
            //CON REPLACE: asi vemos que si no aplicamos el replace al final 
            //para quitar los espacios, estos quedan, aunque no se vean
            f1 = String.format("%-3s", codes[i]).replace(" ", "0");
            f2 = String.format("%-10s", descricion[i]).replace(" ", "0");

//            f1 = String.format("%-3s", codes[i]);
//            f2 = String.format("%-10s", descricion[i]);
            raf.writeChars(f1);
            raf.writeChars(f2);
            raf.writeInt(prices[i]);
        }

        int n = 2;

        raf.seek((n - 1) * 30); //la 1ª posicion empieza en 0 bytes, la 2ª en 30,
        //la 3ª en 60... y asi sucesivamente

        for (int a = 0; a < 13; a++) { //longitud total de cada registro, en caracteres
            if (a < 3) { //longitud del codigo, si es mayor la posicion es la descripcion
                s1 += raf.readChar();
            } else {
                s2 += raf.readChar();
            }
        }

        //CON REPLACE
        Products pr = new Products(s1.replace("0", ""), s2.replace("0", ""), raf.readInt());
        
        //REPLACE PARA QUITAR LOS BLANCOS
//        Products pr = new Products(s1.replace(" ", ""), s2.replace(" ", ""), raf.readInt());

        System.out.println(pr.toString());
        raf.close();
    }

}
