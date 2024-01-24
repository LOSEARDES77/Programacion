import java.util.Vector;

public class tests {
    public static void main(String[] args) {
        System.out.println(comprobarDni("28748206T"));
    }

    public static char getLetra(int dni){
        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int pos = dni % 23;
        return tablaLetras.charAt(pos);
    }

    private static boolean comprobarDni(String dni){
        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero;
        if (dni.length() != 9)
            return false;
        try {
            numero = Integer.parseInt(dni.substring(0,8));
        }catch (NumberFormatException ignored){
            return false;
        }

        int pos = numero % 23;
        return tablaLetras.charAt(pos) == dni.charAt(8);

    }

}
