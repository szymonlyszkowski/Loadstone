package loadstone.model.poi;

import loadstone.model.object.LoadstoneTotalDataObjectModel;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 01.03.15.
 */
public class POI {

    private String category;
    private String name;
    private double latitude;
    private double longitude;

    POI(LoadstoneTotalDataObjectModel loadstoneTotalDataObjectModel, String category) {
        this.category = category;
        this.name = loadstoneTotalDataObjectModel.getName();
        this.latitude = loadstoneTotalDataObjectModel.getLatitude();
        this.longitude = loadstoneTotalDataObjectModel.getLongitude();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
