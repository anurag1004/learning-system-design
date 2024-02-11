public class XML {
    String data;
    String type = "uncompressed-xml";
    public XML(String data){
        this.data = data;
    }
    @Override
    public String toString(){
        return this.data;
    }
}
