package dados;

import java.io.*;

public class RepositorioFileUtil {
    public static Object lerDoArquivo(String filename) {
        Object instanciaLocal = null;

        File in = new File(filename);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);

            // Se alguma exceção ocorrer, um objeto NULL será retornado
            instanciaLocal = ois.readObject();
        } catch (Exception e) {
            System.out.println("Não há arquivo com o nome '" + filename + "' para ser processado. Um novo arquivo será criado");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                }
            }
        }

        return instanciaLocal;
    }

    public static boolean salvarArquivo(Object obj, String filename) {
//        if (obj == null) {
//            return false;
//        }
        File out = new File(filename);
        if(!out.exists()) {
            try {
                out.createNewFile();
            } catch (Exception e) {
                System.out.println("Não foi possível criar o arquivo");
                e.printStackTrace();
                return false;
            }
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            fos.flush();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
