package loadstone.model.object;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 23.02.15.
 */

public class TotalData {

    private String name;
    private double latitude;
    private double longitude;
    private double accuracy;
    private int satellites;
    private int priority;
    private int userid;


    public TotalData(double accuracy, int id, double latitude, double longitude, String name, int priority, int satellites, int userid) {
        this.accuracy = accuracy;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.priority = priority;
        this.satellites = satellites;
        this.userid = userid;
    }

    @PrimaryKey(autoIncrement = true)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override public String toString() {
        return "TotalData{" +
                "Accuracy=" + accuracy +
                ", Name='" + name + '\'' +
                ", Latitude=" + latitude +
                ", Longitude=" + longitude +
                ", Satellites=" + satellites +
                ", Priority=" + priority +
                ", Userid=" + userid +
                ", Id=" + id +
                '}';
    }

}
