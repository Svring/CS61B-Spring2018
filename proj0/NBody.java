public class NBody {
    @SuppressWarnings("unused")
    public static double readRadius(String address) {
        In in = new In(address);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    @SuppressWarnings("unused")
    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[]{};
        for (int i = 0; i < number; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet planet = new Planet(xP, yP, xV, yV, m, img);
            planets = helper(planets, planet);
        }
        return planets;
    }

    private static Planet[] helper(Planet[] planets, Planet p) {
        Planet[] a = new Planet[planets.length + 1];
        System.arraycopy(planets, 0, a, 0, planets.length);
        a[planets.length] = p;
        return a;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p: planets) { p.draw();}
    }
}