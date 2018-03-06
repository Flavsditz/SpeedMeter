package fly.speedmeter.grub;

public class Data {
    private boolean isRunning;
    private long time;
    private long timeStopped;
    private boolean isFirstTime;

    private double distanceMeters;
    private double currentSpeed;
    private double maxSpeed;

    private GpsServiceUpdate onGpsServiceUpdate;

    private Data() {
        isRunning = false;
        distanceMeters = 0;
        currentSpeed = 0;
        maxSpeed = 0;
        timeStopped = 0;
    }

    Data(GpsServiceUpdate onGpsServiceUpdate){
        this();
        setOnGpsServiceUpdate(onGpsServiceUpdate);
    }

    void setOnGpsServiceUpdate(GpsServiceUpdate onGpsServiceUpdate){
        this.onGpsServiceUpdate = onGpsServiceUpdate;
    }

    void update(){
        onGpsServiceUpdate.update();
    }

    void addDistance(double distance){
        distanceMeters = distanceMeters + distance;
    }

    public double getDistance(){
        return distanceMeters;
    }

    double getMaxSpeed() {
        return maxSpeed;
    }

    double getAverageSpeed(){
        double average;
        if (time <= 0) {
            average = 0.0;
        } else {
            average = (distanceMeters / time) * 3600;
        }
        return average;
    }

    double getAverageSpeedMotion(){
        double motionTime = time - timeStopped;
        double average;
        if (motionTime <= 0){
            average = 0.0;
        } else {
            average = (distanceMeters / motionTime) * 3600;
        }
        return average;
    }

    void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        if (currentSpeed > maxSpeed){
            maxSpeed = currentSpeed;
        }
    }

    boolean isFirstTime() {
        return isFirstTime;
    }

    void setFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    boolean isRunning() {
        return isRunning;
    }

    void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    void setTimeStopped(long timeStopped) {
        this.timeStopped += timeStopped;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    long getTime() {
        return time;
    }

    void setTime(long time) {
        this.time = time;
    }
}

