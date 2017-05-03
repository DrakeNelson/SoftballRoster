package com.drakenelson.softballroster.Database;

/**
 * Created by user on 4/24/2017.
 */

public class CrimeSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRST_NAME = "fname";
            public static final String LAST_NAME = "lname";
            public static final String NUMBER = "num";
            public static final String POSITIONS = "positions";
            public static final String LAST_UPDATE = "last_update";
            public static final String ISPITCHER = "pitcher";
            public static final String ISCATCHER = "catcher";
            public static final String ISINFIELD = "infield";
            public static final String ISOUTFIELD = "outfield";

        }
    }

}
