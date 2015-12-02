package com.modules.gobeyond.module_login;

import android.provider.BaseColumns;

public class userContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public userContract() {}

    /* Inner class that defines the table contents */
    public static abstract class userEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_ENTRY_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}