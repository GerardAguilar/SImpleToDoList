package com.example.jarrodgeraldsgarage.simpletodolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.jarrodgeraldsgarage.simpletodolist.db.TaskContract;
import com.example.jarrodgeraldsgarage.simpletodolist.db.TaskDBHelper;


public class MainActivity extends ActionBarActivity {

//    private TaskDBHelper helper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        updateUI();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                FourButtonDialogFrag myDiag=new FourButtonDialogFrag();
                Log.d("MainActivity", "1");

                Log.d("MainActivity", "2");
                myDiag.show(getFragmentManager(), "Diag");



                return true;

            // ... other code

            default:
                return false;
        }
    }



}
