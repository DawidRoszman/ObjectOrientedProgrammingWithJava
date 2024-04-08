import java.lang.Math;

class Cylinder {
    private float radius;
    private float height;

    public float getRadius() {
        return radius;
    }

    public float getHeight() {
        return height;
    }

    public Cylinder(float radius, float height) {
        this.radius = radius;
        this.height = height;
    }

    public Cylinder() {
    }

    public void setRadius(float radius) {
        if (radius <= 0) {
            throw new ArithmeticException("Radius cannot be less or equal to 0");
        }
        this.radius = radius;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            throw new ArithmeticException("Radius cannot be less or equal to 0");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return Math.round(Math.PI * Math.pow(radius, 2));
    }

    public double calculateSideArea() {
        return Math.PI * 2 * radius * height;
    }

    public double calculateArea() {
        return 2 * calculateSurfaceArea() * calculateSideArea();
    }

    public double calculateVolume() {
        return calculateSurfaceArea() * height;
    }

}
