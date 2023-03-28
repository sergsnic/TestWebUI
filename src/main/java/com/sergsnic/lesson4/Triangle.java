package com.sergsnic.lesson4;
//import static com.sergsnic.lesson4.AreaTriangle.areaTriangle;
public class Triangle {
    public static void main(String[] args) throws AreaTriangleException {
        AreaTriangle triangle = new AreaTriangle();
        System.out.println("S = " + triangle.areaTriangle(25,25,30));
    }
}
