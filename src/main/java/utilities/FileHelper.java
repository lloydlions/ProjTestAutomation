package utilities;

import org.testng.annotations.Optional;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {


    public static File findFile(String filename){
        File dir = new File(System.getProperty("user.dir"));
        File[] files = dir.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return name.startsWith(filename) && name.endsWith(".csv");
            }
        });

        return files[0];
    }

}
