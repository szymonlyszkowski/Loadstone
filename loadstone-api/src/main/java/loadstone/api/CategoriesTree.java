package loadstone.api;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class CategoriesTree {

    public HashMap<String,Categories> getCategoriesTree() {
        return categoriesTree;
    }

    private HashMap<String,Categories> categoriesTree;

    public CategoriesTree() {
        categoriesTree = new HashMap<>();
        categoriesTree.put("usługa",Categories.SERVICES);
        categoriesTree.put("warsztat",Categories.AUTOMOTIVE);
    }
}
