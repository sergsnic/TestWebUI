package com.sergsnic.lesson4;

public class AreaTriangle {
    public double areaTriangle(double a, double b, double c) throws AreaTriangleException{
        if (a <= 0 || b <= 0 || c <= 0) throw new AreaTriangleException();
        if (a >= c + b || b >= a + c || c >= a + b) throw new AreaTriangleException();
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }
}
