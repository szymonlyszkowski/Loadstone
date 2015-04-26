package loadstone.model.object;

import loadstone.model.DataModel;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 23.02.15.
 */

public class LoadstoneTotalDataObjectModel implements DataModel{

    private String name;
    private double latitude;
    private double longitude;
    private double accuracy;
    private int satellites;
    private int priority;
    private int userid;

    /**
     * DO NOT CREATE CONSTRUCTOR IN THIS CLASS !!!
     */
    @PrimaryKey(autoIncrement = true)
    private int id;
    @Override
    public String getName() {
        return name;
    }
    @Override
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



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LoadstoneTotalDataObjectModel that = (LoadstoneTotalDataObjectModel) o;

        if (Double.compare(that.accuracy, accuracy) != 0)
            return false;
        if (id != that.id)
            return false;
        if (Double.compare(that.latitude, latitude) != 0)
            return false;
        if (Double.compare(that.longitude, longitude) != 0)
            return false;
        if (priority != that.priority)
            return false;
        if (satellites != that.satellites)
            return false;
        if (userid != that.userid)
            return false;
        if (!name.equals(that.name))
            return false;

        return true;
    }

}

