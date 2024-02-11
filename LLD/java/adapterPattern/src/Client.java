public class Client {
    public static void main(String[] args) {
        // our current business logic is working with xml data, Adaptee interface: XML
        XML xmlData = new XML("<START><TITLE>HELLO</TITLE></START>");
        // Our Analytics lib (client) only works with JSON, Target interface: JSON
        // adapter
        XMLConverter adapter = new XMLToJSONConverter(xmlData);
        AnalyticsLib analyticsLib = new AnalyticsLib();
        analyticsLib.doAnalysis(adapter.convertToJSON());

    }
}
