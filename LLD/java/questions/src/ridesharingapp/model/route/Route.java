package ridesharingapp.model.route;

public class Route {
    private final String origin;
    private final String dest;

    public Route(String origin, String dest) {
        this.origin = origin;
        this.dest = dest;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }
}
