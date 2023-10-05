import java.io.File;
import java.util.Scanner;

public class MainAB {

    static Scanner sc = new Scanner(System.in);
    static File currentFile;
    static boolean isRoot = true;

    public static void main(String[] args) {

        while (next()) {
            System.out.println("current path --------> " + getCurrentFilePath());
            switch (chooseOption()) {
                case 1 -> intoDirectory();
                case 2 -> showInfo();
                case 3 -> backToRoot();
                default -> System.err.println("No hay esta opcion");
            }
        }
    }

    private static void intoDirectory() {
        if (isRoot) {
            chooseRoot();
        } else {
            chooseDirectory();
        }
    }

    public static void backToRoot() {
        currentFile = null;
        isRoot = true;
    }

    public static boolean next() {
        System.out.print("next: ");
        String decision = sc.nextLine();
        return decision.equals("yes");
    }

    public static void chooseRoot() {
        for (File root: File.listRoots()) {
            System.out.println(root);
        }
        System.out.println("Eliges un disco: ");
        String disk = sc.nextLine();
        if (diskExist(disk)) {
            currentFile = new File(disk);
            isRoot = false;
        } else {
            System.out.println("No existe disco");
        }
    }

    public static boolean diskExist(String disk) {
        for (File root: File.listRoots()) {
            if (root.equals(new File(disk))) {
                return true;
            }
        }
        return false;
    }

    public static void chooseDirectory() {
        for (File file: currentFile.listFiles()) {
            if (file!=null && file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
        System.out.print("Eliges un directorio: ");
        String fileChoosed = sc.nextLine();
        if (fileExist(fileChoosed)) {
            currentFile = new File(currentFile, fileChoosed);
        } else {
            System.out.println("No existe fichero");
        }
    }

    public static boolean fileExist(String file) {
        for (File files: currentFile.listFiles()) {
            if (files.getName().equals(file)) {
                return true;
            }
        }
        return false;
    }

    public static int chooseOption() {
        System.out.println("1 = entrar directorio 2 = mostrar directorio actual 3 = volver al raiz");
        System.out.print("Eliges: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static void showInfo() {
        for (File file: currentFile.listFiles()) {
            if (file!=null) {
                System.out.println("--------------------------------");
                System.out.println("nombre de fichero: " + file);
                System.out.println("ruta: " + file.getAbsoluteFile());
                System.out.println("lectura: " + file.canRead());
                System.out.println("escritura: " + file.canWrite());
                System.out.println("size: " + file.length());
                System.out.println("tipo: " + (file.isDirectory()? "directorio" : "fichero"));
                System.out.println("--------------------------------");
            }
        }
    }

    public static String getCurrentFilePath() {
        if (currentFile != null) {
            return currentFile.getAbsolutePath();
        } else {
            return "root";
        }
    }
}