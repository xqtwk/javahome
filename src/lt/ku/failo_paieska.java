package lt.ku;
import java.io.*;
import java.util.*;
public class failo_paieska {
    public void find(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    find(name,fil);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    System.out.println(fil.getParentFile() + "\\" + fil.getName());
                }
            }
    }
    public static void main(String[] args) {
        failo_paieska search = new failo_paieska();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ieskomo failo pavadinimas: " );
        String name = scan.next();
        System.out.println("Katalogo, kuriame reikia ieskoti, pavadinimas: ");
        String directory = scan.next();
        search.find(name,new File(directory));
    }

}
