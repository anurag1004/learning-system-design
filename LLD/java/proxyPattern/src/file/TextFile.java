package file;

import metadata.Metadata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class TextFile implements DataFile {
    private final String path;
    private StringBuilder content;
    public TextFile(String path){
        this.path = path;
        this.content = new StringBuilder();
        loadFile();
    }
    public void loadFile(){
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @Override
    public void showContent() {
        System.out.println(content.toString());
    }
}
