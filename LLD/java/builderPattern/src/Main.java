public class Main {
    public static void main(String[] args) {
        // https://github.com/anurag1004?tab=repositories
        URL url = new URL.URLBuilder()
                .setDomain("github")
                .setTopLevelDomain("com")
                .setPath("anurag004")
                .setQueryParams("tab=repositories")
                .setProtocol("https").build();
        System.out.println(url);
    }
}
