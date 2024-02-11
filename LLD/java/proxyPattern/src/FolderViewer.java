import file.DataFile;
import file.TextFile;
import proxy.DataFileProxy;

public class FolderViewer {
    public static void main(String[] args) {
        // using proxy
        // say user opens a folder
        // the program will show only metadata
        DataFile file1 = new DataFileProxy("/Users/anuragverma/IdeaProjects/learning-system-design/LLD/java/resources/dummyfiles/file1.txt");
        DataFile file3 = new DataFileProxy("/Users/anuragverma/IdeaProjects/learning-system-design/LLD/java/resources/dummyfiles/file3.txt");
        // user clicks a file
        file1.showContent(); // loads complete file
        file3.showContent();
        // without using proxy, whole text file is getting loaded into memory
        DataFile file2 = new TextFile("/Users/anuragverma/IdeaProjects/learning-system-design/LLD/java/resources/dummyfiles/file2.txt");
        file2.showContent();
    }
}
