package com.example.jarrodgeraldsgarage.simpletodolist.db;

/**
 * Created by gerar_000 on 7/29/2015.
 */
//
import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "com.example.jarrodgeraldsgarage.simpletodolist.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";

    public class Columns {
        public static final String TASK = "task";
        public static final String _ID = BaseColumns._ID;
    }
}
