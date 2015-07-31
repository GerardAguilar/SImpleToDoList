package com.example.jarrodgeraldsgarage.simpletodolist;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.jarrodgeraldsgarage.simpletodolist.db.TaskContract;
import com.example.jarrodgeraldsgarage.simpletodolist.db.TaskDBHelper;

/**
 * Created by gerar_000 on 7/29/2015.
 */
public class FourButtonDialogFrag extends DialogFragment{

    private static final String tag = "FourButtonDialogFrag";
    private TaskDBHelper helper;
    private Button IU;
    private Button NU;
    private Button IN;
    private Button NN;
    private EditText inputField;

    private View mainActivityView;
    private ListView listView;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_four_button_dialog,
                container, false);

        mainActivityView = inflater.inflate(R.layout.activity_main, container, false);

        inputField = (EditText) v.findViewById(R.id.InputText);

        IU= (Button) v.findViewById(R.id.ImpUrg);
        IU.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String task = inputField.getText().toString();
                        Log.d("MainActivity",task);

                        helper = new TaskDBHelper(getActivity());
                        SQLiteDatabase db = helper.getWritableDatabase();
                        ContentValues values = new ContentValues();

                        values.clear();
                        values.put(TaskContract.Columns.TASK, task);

                        db.insertWithOnConflict(TaskContract.TABLE,null,values,
                                SQLiteDatabase.CONFLICT_IGNORE);

                        Log.d("FourButtonDialogFrag", task);
                        updateUI();
                        dismiss();
                    }
                }
        );



        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("MainActivity", "3");


        return v;
    }



    private void updateUI() {
        Log.d("MainActivity", "Blank");
        helper = new TaskDBHelper(getActivity());
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor = sqlDB.query(TaskContract.TABLE,
                new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK},
                null, null, null, null, null);

        ListAdapter listAdapter = new SimpleCursorAdapter(
                getActivity(),
                R.layout.task_view,
                cursor,
                new String[] { TaskContract.Columns.TASK},
                new int[] { R.id.taskTextView},
                0
        );
        //adb is here
        //C:\Users\gerar_000\AppData\Local\Android\android-sdk\platform-tools>
        //use the following to access the db
//        adb shell
//        cd data/data/com.example.jarrodgeraldsgarage.simpletodolist
//        ls
//        sqlite3 com.example.TodoList.tasks.db
//                .dump



                listView = (ListView)mainActivityView.findViewById(R.id.list);
        listView.setAdapter(listAdapter);
//        this.setListAdapter(listAdapter);
        Log.d("FourButtonDialogFrag", "Blank2");
    }

//    private void clickedIU(){
//        Log.d("MainActivity", "clickedIU");
//
//    }

//
}
