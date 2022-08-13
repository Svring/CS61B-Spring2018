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

    public static void main(String[] args) {
        /* canvas */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p: planets) { p.draw();}

        /* animation */
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time != T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: planets) { p.draw();}
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        /* final print */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

/* I have to say, this is the most exciting game I've ever made */
/* Though the style of my code isn't that beautiful, I'll fix this next time */