package proxy;

import file.DataFile;
import file.TextFile;
import metadata.Metadata;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DataFileProxy implements DataFile {
    private DataFile proxifedDataFile; // original obj ref
    private Metadata metadata;
    private final String path;
    public DataFileProxy(String path){
        this.path = path;
        loadMetadata(); // load only file metadata
        showMetadata(); // show meta data
    }
    private void loadMetadata(){
        try {
            Path path1 = Paths.get(path);
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(path), BasicFileAttributes.class);
            metadata = new Metadata(path1.getFileName().toString(), attributes.size(), attributes.creationTime());
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    private void showMetadata(){
        System.out.println(metadata.toString());
    }
    @Override
    public void showContent() {
        // load whole file only when it is required to be shown
        if(proxifedDataFile==null){
            proxifedDataFile = new TextFile(path);
        }
        proxifedDataFile.showContent();
    }
}
