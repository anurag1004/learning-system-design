package metadata;

import java.nio.file.attribute.FileTime;

public class Metadata {
    private String name;
    private long size;
    private FileTime creationTime;

    public Metadata(String name, long size, FileTime creationTime) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }
    public String toString(){
        return String.format("name:%s, %,d bytes, %s\n", name, size, creationTime);
    }
}
