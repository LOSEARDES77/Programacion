import org.example.Video;

import javax.swing.*;
import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {
        String[] s = new String[1];
        s[0] = "a";
        String b = "b";
        s = arrAdd(s, b);
        for (String c : s){
            System.out.println(c);
        }
        // int response = JOptionPane.showConfirmDialog(null, "Vas a eliminar:\n"+"" + "\n¿Estas seguro?", "¿Seguro?",JOptionPane.YES_NO_OPTION);
        // System.out.println(response);

        System.out.println(null instanceof Video);
    }

    private static <T> T[] arrAdd(T[] arr, T o){
        T[] tmp = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length+1);
        for (int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
        tmp[arr.length] = o;
        return tmp;
    }
}
