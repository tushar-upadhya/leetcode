class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour * 60 + minutes) * 0.5;
        double minAngle = minutes * 6;

        double angle = Math.abs(hourAngle - minAngle);

        if(angle <= 180.0) return angle;
        else
        return 360.0 - angle;
    }
}