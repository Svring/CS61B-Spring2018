public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    public double calcDistance(Planet p) {
        double distance;
        double Xdis = p.xxPos - xxPos;
        double Ydis = p.yyPos - yyPos;
        distance = Math.sqrt(Xdis * Xdis + Ydis * Ydis);
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double force;
        force = G * ((mass * p.mass) / Math.pow(calcDistance(p), 2));
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double force;
        double Xdis = p.xxPos - xxPos;
        force = calcForceExertedBy(p) * (Xdis / calcDistance(p));
        return force;
    }

    public double calcForceExertedByY(Planet p) {
        double force;
        double Ydis = p.yyPos - yyPos;
        force = calcForceExertedBy(p) * (Ydis / calcDistance(p));
        return force;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double force = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.equals(p[i])) {
                continue;
            } else {
                force += calcForceExertedByX(p[i]);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double force = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.equals(p[i])) {
                continue;
            } else {
                force += calcForceExertedByY(p[i]);
            }
        }
        return force;
    }
}