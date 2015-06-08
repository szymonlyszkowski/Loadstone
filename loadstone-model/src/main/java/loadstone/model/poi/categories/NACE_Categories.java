package loadstone.model.poi.categories;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public enum NACE_Categories {

    A("A - Agriculture, forestry and fishing"),
    B("B - Mining and quarrying "),
    C("C - Manufacturing "),
    D("D - Electricity, gas, steam and air conditioning supply "),
    E("E - Water supply; sewerage; waste managment and remediation activities "),
    F("F - Construction "),
    G("G - Wholesale and retail trade; repair of motor vehicles and motorcycles "),
    H("H - Transporting and storage"),
    I("I - Accommodation and food service activities "),
    J("J - Information and communication "),
    K("K - Financial and insurance activities "),
    L("L - Real estate activities "),
    M("M - Professional, scientific and technical activities "),
    N("N - Administrative and support service activities "),
    O("O - Public administration and defence; compulsory social security "),
    P("P - Education"),
    Q("Q - Human health and social work activities "),
    R("R - Arts, entertainment and recreation "),
    S("S - Other services activities "),
    T("T - Activities of households as employers; undifferentiated goods - and services - producing activities of households for own use "),
    U("U - Activities of extraterritorial organisations and bodies "),
    NOT_CLASSIFIED("Not classified");

    private final String categoryDescription;

    private NACE_Categories(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public static NACE_Categories returnCategoryIfFirstEncounteredContains(String description) {
        NACE_Categories[] categories = NACE_Categories.values();
        for (NACE_Categories category : categories) {
            if (category.getCategoryDescription().contains(description))
                return category;
        }
        return NOT_CLASSIFIED;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
