public class URL {
    private String protocol = "";
    private String subdomain = "";
    private String domain = "";
    private String topLevelDomain = "";
    private String path = "";
    private String queryParams = "";
    private String fragment = "";
    private int port = -1;

    public URL(URLBuilder urlBuilder){
        this.protocol = urlBuilder.protocol;
        this.subdomain = urlBuilder.subdomain;
        this.domain = urlBuilder.domain;
        this.topLevelDomain = urlBuilder.topLevelDomain;
        this.path = urlBuilder.path;
        this.queryParams = urlBuilder.queryParams;
        this.fragment = urlBuilder.fragment;
    }
    public String toString(){
        String baseUrl = "";
        if(!protocol.isEmpty()){
            baseUrl+=protocol+"://";
        }
        if(!subdomain.isEmpty()){
            baseUrl+=subdomain+".";
        }
        if(!domain.isEmpty()){
            baseUrl+=domain+".";
        }
        if(!topLevelDomain.isEmpty()){
            baseUrl+=topLevelDomain;
        }
        if(port!=-1){
            baseUrl+=":"+ port;
        }
        if(!path.isEmpty()){
            baseUrl+="/"+path;
        }
        if(!queryParams.isEmpty()){
            baseUrl+="?"+queryParams;
        }
        if(!fragment.isEmpty()){
            baseUrl+="#"+fragment;
        }
        return baseUrl;
    }
    public String getProtocol() {
        return protocol;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getDomain() {
        return domain;
    }

    public String getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getPath() {
        return path;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public String getFragment() {
        return fragment;
    }

    public int getPort() {
        return port;
    }

    public static class URLBuilder{
        private String protocol = "";
        private String subdomain = "";
        private String domain = "";
        private String topLevelDomain = "";
        private String path = "";
        private String queryParams = "";
        private String fragment = "";
        private int port = -1;

        public URLBuilder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public URLBuilder setSubdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public URLBuilder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public URLBuilder setTopLevelDomain(String topLevelDomain) {
            this.topLevelDomain = topLevelDomain;
            return this;
        }

        public URLBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public URLBuilder setQueryParams(String queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public URLBuilder setFragment(String fragment) {
            this.fragment = fragment;
            return this;
        }

        public URLBuilder setPort(int port) {
            this.port = port;
            return this;
        }
        public URL build(){
            return new URL(this);
        }
    }
}
