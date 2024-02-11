public class JSON {
    String data;
    String type="uncompressed-json";
    public JSON(String data){
        this.data = data;
    }
    @Override
    public String toString(){
        return this.data;
    }
}
