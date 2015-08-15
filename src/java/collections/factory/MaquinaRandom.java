package collections.factory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class MaquinaRandom {

    private final static String[] nmes;

    static {
        nmes = new String[13];
        nmes[0] = "Joao";     nmes[1] = "Maria";      nmes[2] = "Mateus";      nmes[3] = "Tiago";
        nmes[4] = "Marta";    nmes[5] = "Keila";      nmes[6] = "José";        nmes[7] = "Marina";
        nmes[8] = "Jorge";    nmes[9] = "Douglas";    nmes[10] = "Otávio";     nmes[11] = "Marcus";
        nmes[12] = "Guilherme";
    }
    
    public static String getRandomNme() {//Retorna um nome contido na lista nmes.
        Integer taman = nmes.length;
        return nmes[(int) (Math.random() * taman)];
    }
    
    public static String getRandomStr(int taman) {
        //Randomiza um string, com "taman" caracteres, usando as letras contidas na String AB.
        String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(taman);
        for (int i = 0; i < taman; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static Integer getRandomTel() {
        //Randomiza um numero entre 0 e 8.999.999 e soma com 1.000.000, retornando um numero de 7 digitos.
        return (int) (Math.random() * 8999999 + 1000000);
    }

    public static String getRandomRg() {//Randomiza um numero e o transforma em string.
        String rg;
        rg = Integer.toString((int) (Math.random() * 8999999 + 1000000));
        return rg;
    }

    public static java.util.Date getRandomDta() {// Randomiza uma data entre 1940 e 1995
        Random rnd;
        java.util.Date dt;
        long ms;
        rnd = new Random();
        //   -946771200000L = valor Epoch de 1º de Janeiro de 1940   
        ms = -946771200000L + (Math.abs(rnd.nextLong()) % (55L * 365 * 24 * 60 * 60 * 1000));
        //                                                 ^^  = quantos anos(neste caso 55) aós 1940 será gerado
        dt = new java.util.Date(ms);
        return dt;
    }

    public static Boolean getRandomBoolean() { //Terona um boolean randomico
        return new Random().nextBoolean();
    }

    public static BigDecimal getRandomVlr(int taman) { //Gera um valor BIGDECIMAL randomico
        BigInteger n = BigInteger.TEN.pow(taman);      //taman é a "extensão", "dimensão" do numero(sem contar a vírgula) por exemplo: 
        Random r = new Random();                       //taman 6 gera um numero entre 0000,00 e 9999,99; 8 entre 000000,00 e 999999,99;
        BigDecimal vlr = new BigDecimal(geraBigInteger(r, n), 2);
        return vlr;
    }

    private static BigInteger geraBigInteger(Random r, BigInteger n) {//Metodo usado pelo getRandomVlr
        BigInteger vlr;
        do {
            vlr = new BigInteger(n.bitLength(), r);
        } while (vlr.compareTo(n) >= 0);
        return vlr;
    }
    

    public static String getRandomStr2(int taman) {//Randomiza um string, com "taman" caracteres.
        String vogMi = "aeiou";
        String conMi = "bcdfghjklmnpqrstvwxyz";
        String vogMa = "AEIOU";
        String conMa = "BCDFGHJKLMNPQRSTVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(taman);
        sb.append(conMa.charAt(rnd.nextInt(conMa.length())));
        for (int i = 1; i < taman; i++) {
            if (i % 2 == 0) {
                sb.append(conMi.charAt(rnd.nextInt(conMi.length())));
            } else {
                sb.append(vogMi.charAt(rnd.nextInt(vogMi.length())));
            }
        }
        return sb.toString();
    }
}
