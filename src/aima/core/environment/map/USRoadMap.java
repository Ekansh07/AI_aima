package aima.core.environment.map;

public class USRoadMap extends ExtendableMap {

    public USRoadMap() {
        initMap(this);
    }

    public static final String AUSTIN = "Austin";
    public static final String CHARLOTTE = "Charlotte";
    public static final String SAN_FRANCISCO = "SanFranscisco";
    public static final String LOS_ANGELES = "LosAngeles";
    public static final String NEW_YORK = "NewYork";
    public static final String CHICAGO = "Chicago";
    public static final String SEATTLE = "Seattle";
    public static final String SANTA_FE = "SantaFe";
    public static final String BAKERS_VILLE = "BakersVille";
    public static final String BOSTON = "Boston";
    public static final String DALLAS = "Dallas";

    public static void initMap(ExtendableMap map) {
        map.clear();
        map.addBidirectionalLink(LOS_ANGELES, SAN_FRANCISCO, 383.0);
        map.addBidirectionalLink(LOS_ANGELES, AUSTIN, 1377.0);
        map.addBidirectionalLink(LOS_ANGELES, BAKERS_VILLE, 153.0);
        map.addBidirectionalLink(SAN_FRANCISCO, BAKERS_VILLE, 283.0);
        map.addBidirectionalLink(SAN_FRANCISCO, SEATTLE, 807.0);
        map.addBidirectionalLink(SEATTLE, SANTA_FE, 1453.0);
        map.addBidirectionalLink(SEATTLE, CHICAGO, 2064.0);
        map.addBidirectionalLink(BAKERS_VILLE, SANTA_FE, 864.0);
        map.addBidirectionalLink(AUSTIN, DALLAS, 195.0);
        map.addBidirectionalLink(SANTA_FE, DALLAS, 640.0);
        map.addBidirectionalLink(BOSTON, AUSTIN, 1963.0);
        map.addBidirectionalLink(DALLAS, NEW_YORK, 1548.0);
        map.addBidirectionalLink(AUSTIN, CHARLOTTE, 1200.0);
        map.addBidirectionalLink(CHARLOTTE, NEW_YORK, 634.0);
        map.addBidirectionalLink(NEW_YORK, BOSTON, 225.0);
        map.addBidirectionalLink(BOSTON, CHICAGO, 983.0);
        map.addBidirectionalLink(CHICAGO, SANTA_FE, 1272.0);
        map.addBidirectionalLink(BOSTON, SAN_FRANCISCO, 3095.0);

        // distances and directions
        // reference location: Dallas
        map.setDistAndDirToRefLocation(AUSTIN, 182, 117);
        map.setDistAndDirToRefLocation(CHARLOTTE, 929, 360);
        map.setDistAndDirToRefLocation(SAN_FRANCISCO, 1230, 74);
        map.setDistAndDirToRefLocation(LOS_ANGELES, 1100, 82);
        map.setDistAndDirToRefLocation(NEW_YORK, 1368, 282);
        map.setDistAndDirToRefLocation(CHICAGO, 800, 142);
        map.setDistAndDirToRefLocation(SEATTLE, 1670, 25);
        map.setDistAndDirToRefLocation(SANTA_FE, 560, 260);
        map.setDistAndDirToRefLocation(BAKERS_VILLE, 1282, 202);
        map.setDistAndDirToRefLocation(BOSTON, 1551, 102);
        map.setDistAndDirToRefLocation(DALLAS, 0, 92);
    }
}