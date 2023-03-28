package com.sergsnic.lesson4;

public class Box {
    private Integer ballCount;

    public Box() {
        ballCount = 0;
    }

    public Integer getBallCount() {
        return ballCount;
    }
    public void addBall(){
        ballCount ++;
    }
    public void deleteBall() throws BoxIsEmptyException {
        if(ballCount==0) {
            throw new BoxIsEmptyException();
        }
        ballCount--;

    }
}
