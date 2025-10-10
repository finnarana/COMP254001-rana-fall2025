//Fatimah Rana 301342519 Centennial College || COMP254 Lab03 Ex03
//All code written by Fatimah Rana

//Implement a recursive method with calling signature find(path, filename) that reports all entries of the file system rooted at the given path having the given file name. Test the method with a real path, filename from your file system. Hint: Review use of the java.io.File class and the week 5 examples.

import java.io.File;

public class FatimahRana_COMP254Lab3_Ex3 {

    public static void main(String[] args) {
        File directoy = new File("/Users/fatimahrana/Desktop");
        String filename = "happy.png";
        String filename1 = "CIformulas.png";

        find(directoy, filename);
        find(directoy, filename1);

    }

    //find(path, filename)
    public static void find(File path, String filename) {

        //checking if the path is a directory, if true then
        if (path.exists() && path.isDirectory()) {
            File files[] = path.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        find(file, filename); // recursively finds the filename within the 'File' path
                    } else {
                        if (file.getName().equals(filename)) {
                            System.out.println(file.getAbsolutePath()); // if it is found then it should hopefully print the files that it foudn within the directory
                        }
                    }
                }
            }
        }

    }
}

