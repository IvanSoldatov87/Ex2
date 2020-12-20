package api;


public class GeoLocation implements geo_location {
    private double x;
    private double y;
    private double z;

    public GeoLocation() {
    }


    public GeoLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void setX(double x) {

        this.x = x;
    }


    public void setY(double ny) {

        this.y = y;
    }


    public void setZ(double nz) {

        this.z = z;
    }


    @Override
    public double x() {

        return this.x;
    }

    @Override
    public double y() {

        return this.y;
    }

    @Override
    public double z() {

        return this.z;
    }

    @Override
    public double distance(geo_location g) {
        double sum = Math.pow(this.x - g.x(), 2)+Math.pow(this.y - g.y(), 2)+Math.pow(this.z - g.z(), 2);
        double result = Math.sqrt(sum);
        return result;
    }

}
