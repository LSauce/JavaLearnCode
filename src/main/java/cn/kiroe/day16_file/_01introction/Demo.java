package cn.kiroe.day16_file._01introction;

import java.io.File;

/**
 * @author kiro
 * @description:
 * @data 16:16 31/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        // /Users/kiro/Code/TrainingCourse/JavaLearnCode/JavaLearnCode
        //
        String path = "/Users/kiro/Code/TrainingCourse/JavaLearnCode/JavaLearnCode";
        String path2 = ".././";



        //File (String pathname)
        File file = new File("pom.xml");
        System.out.println(file.exists());
        // File (String parent, Sting child)
        File file1 = new File("/", "pom.xml");
        // File (File parent, String child)
        File file2 = new File(new File("/"), "pom.xml");
        System.out.println("file1 + file2 = " + file1 + file2);


    }
}
