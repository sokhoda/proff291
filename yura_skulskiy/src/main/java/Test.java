import java.io.File;

/**
 * Created by Юра on 17.01.2016.
 */
public class Test {
    public static void main(String[] args) {
        File[] root = File.listRoots();

        int i=0;
        int size = root.length;
        System.out.println(size);
        while (i<size) {
            System.out.println(root[i].getAbsolutePath());
            if (root[i].isDirectory()){
                File [] root2 = root[i].listFiles();
                int j=0;
                int size2=root2.length;
                System.out.println("2 size = " + size2);
                while (j<size2){
                    System.out.println(root2[j].getAbsolutePath());
                    j++;
                }
            }
            i++;
        }
    }
}
