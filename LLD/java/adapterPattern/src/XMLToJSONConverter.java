public class XMLToJSONConverter implements XMLConverter{
    private XML xmlData;
    public XMLToJSONConverter(XML xmlData){
        this.xmlData  = xmlData;
    }
    @Override
    public JSON convertToJSON() {
        // dummy processing
        String converted = xmlData.toString().replace("<","{")
                            .replace(">","}")
                            .replace("/","");
        return new JSON(converted);
    }
}
