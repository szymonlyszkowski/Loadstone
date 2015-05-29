package loadstone.api.classification.loadstone;

import loadstone.model.poi.categories.NACE_Categories;

import java.util.HashMap;

/**
 * @author Szymon.Lyszkowski@tomtom.com on 27.05.15.
 */
public final class LoadstoneBOW {

    private static final HashMap<String, NACE_Categories> loadstoneBOW = new HashMap<>();
    static {
        loadstoneBOW.put("bankomat", NACE_Categories.K);
        loadstoneBOW.put("parking", NACE_Categories.H);
        loadstoneBOW.put("kościół", NACE_Categories.U);
        loadstoneBOW.put("kurier",NACE_Categories.J);
        loadstoneBOW.put("pgp", NACE_Categories.J);
        loadstoneBOW.put("szkoła", NACE_Categories.P);
        loadstoneBOW.put("atm", NACE_Categories.K);
        loadstoneBOW.put("cmentarz", NACE_Categories.U);
        loadstoneBOW.put("supermarket", NACE_Categories.G);
        loadstoneBOW.put("apteka", NACE_Categories.Q);
        loadstoneBOW.put("bank", NACE_Categories.K);
        loadstoneBOW.put("krzyż", NACE_Categories.U);
        loadstoneBOW.put("most", NACE_Categories.H);
        loadstoneBOW.put("spożywczy", NACE_Categories.I);
        loadstoneBOW.put("restauracja", NACE_Categories.I);
        loadstoneBOW.put("sklep", NACE_Categories.G);
        loadstoneBOW.put("plac", NACE_Categories.H);
        loadstoneBOW.put("hotel", NACE_Categories.I);
        loadstoneBOW.put("euronet", NACE_Categories.K);
        loadstoneBOW.put("bunkier", NACE_Categories.R);
        loadstoneBOW.put("pomnik", NACE_Categories.R);
        loadstoneBOW.put("jezioro", NACE_Categories.A);
        loadstoneBOW.put("poczta", NACE_Categories.J);
        loadstoneBOW.put("rynek", NACE_Categories.A);
        loadstoneBOW.put("jedzenie", NACE_Categories.I);
        loadstoneBOW.put("katolicki", NACE_Categories.U);
        loadstoneBOW.put("pko", NACE_Categories.K);
        loadstoneBOW.put("samochodowy", NACE_Categories.G);
        loadstoneBOW.put("warsztat", NACE_Categories.G);
        loadstoneBOW.put("szlak", NACE_Categories.A);
        loadstoneBOW.put("biedronka", NACE_Categories.G);
        loadstoneBOW.put("orlen", NACE_Categories.D);
        loadstoneBOW.put("lpg", NACE_Categories.D);
        loadstoneBOW.put("straż", NACE_Categories.O);
        loadstoneBOW.put("myjnia", NACE_Categories.T);
        loadstoneBOW.put("urząd", NACE_Categories.O);
        loadstoneBOW.put("przychodnia", NACE_Categories.Q);
        loadstoneBOW.put("leśniczówka", NACE_Categories.A);
        loadstoneBOW.put("muzeum", NACE_Categories.R);
        loadstoneBOW.put("ratusz", NACE_Categories.N);
        loadstoneBOW.put("pekao", NACE_Categories.K);
        loadstoneBOW.put("pizza", NACE_Categories.I);
        loadstoneBOW.put("śniadaniem", NACE_Categories.I);
        loadstoneBOW.put("nocleg", NACE_Categories.I);
        loadstoneBOW.put("fabryka", NACE_Categories.C);
        loadstoneBOW.put("osp", NACE_Categories.O);
        loadstoneBOW.put("szpital", NACE_Categories.Q);
        loadstoneBOW.put("kapliczka", NACE_Categories.R);
        loadstoneBOW.put("policja", NACE_Categories.O);
        loadstoneBOW.put("fastfood", NACE_Categories.I);
        loadstoneBOW.put("paczkomat", NACE_Categories.H);
        loadstoneBOW.put("dealer", NACE_Categories.G);
        loadstoneBOW.put("paliwo", NACE_Categories.D);
        loadstoneBOW.put("dom", NACE_Categories.S);
        loadstoneBOW.put("zjazd", NACE_Categories.NOT_CLASSIFIED);
        loadstoneBOW.put("bar", NACE_Categories.I);
        loadstoneBOW.put("pub", NACE_Categories.I);
        loadstoneBOW.put("bzwbk", NACE_Categories.K);
        loadstoneBOW.put("hipermarket", NACE_Categories.G);
        loadstoneBOW.put("lidl", NACE_Categories.G);
        loadstoneBOW.put("park", NACE_Categories.A);
        loadstoneBOW.put("tesco", NACE_Categories.A);
        loadstoneBOW.put("stadion", NACE_Categories.U);
        loadstoneBOW.put("uczelnia", NACE_Categories.P);
        loadstoneBOW.put("biblioteka", NACE_Categories.P);
        loadstoneBOW.put("biletomat", NACE_Categories.H);
        loadstoneBOW.put("basen", NACE_Categories.R);
        loadstoneBOW.put("zajazd", NACE_Categories.I);
        loadstoneBOW.put("galeria", NACE_Categories.R);
        loadstoneBOW.put("ing", NACE_Categories.K);
        loadstoneBOW.put("wypożycz", NACE_Categories.H);
        loadstoneBOW.put("zakwaterowanie", NACE_Categories.I);



    }

    private LoadstoneBOW() {
    }

    public static HashMap<String, NACE_Categories> getLoadstoneBOW() {
        return loadstoneBOW;
    }


}
