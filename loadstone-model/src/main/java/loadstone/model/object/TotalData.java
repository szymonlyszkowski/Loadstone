package loadstone.model.object;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 23.02.15.
 */

public class TotalData {

    /**
     * @author Szymon.Lyszkowski@tomtom.com on 08.02.15.
     */

    private String name;
    private double latitude;
    private double longitude;
    private double accuracy;
    private int sattelites;
    private int priority;
    private int userid;

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

    public int getSattelites() {
        return sattelites;
    }

    public void setSattelites(int sattelites) {
        this.sattelites = sattelites;
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

}
