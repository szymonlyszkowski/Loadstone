package loadstone.api;/**
 * Copyright (c) 2014 TomTom International B.V. All rights reserved.
 * TomTom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 15.03.15.
 */
public class CategoriesTree {

    public HashMap<String,NACE_Categories> getCategoriesTree() {
        return categoriesTree;
    }

    private HashMap<String,NACE_Categories> categoriesTree;

    public CategoriesTree() {
        categoriesTree = new HashMap<>();
        categoriesTree.put("usługa", NACE_Categories.SERVICES);
        categoriesTree.put("warsztat", NACE_Categories.AUTOMOTIVE);
    }
}
