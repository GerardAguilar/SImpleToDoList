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

    private TaskDBHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        SQLiteDatabase sqlDB = new TaskDBHelper(this).getWritableDatabase();
//        Cursor cursor = sqlDB.query(TaskContract.TABLE,
//                new String[]{TaskContract.Columns.TASK},
//                null,null,null,null,null);
//
//        cursor.moveToFirst();
//        while(cursor.moveToNext()) {
//            Log.d("MainActivity cursor",
//                    cursor.getString(
//                            cursor.getColumnIndexOrThrow(
//                                    TaskContract.Columns.TASK)));
//        }


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
                myDiag.show(getFragmentManager(),"Diag");
                //AlertDialog.Builder builder = new AlertDialog.Builder(this);

//                Dialog builder = new Dialog(this);
//                builder.setContentView(R.layout.frag_four_button_dialog);
//                builder.show();

//                LayoutInflater inflater = getLayoutInflater();
//                //inflate view for alertdialog since we are using multiple views inside a viewgroup (root = Layout top-level) (linear, relative, framelayout etc..)
//                //inflater.inflate(R.layout.fragment_search, container, false)
//                View view = inflater.inflate(R.layout.frag_four_button_dialog, container, false);

//                Button IUButton = (Button) view.findViewById(R.id.ImpUrg); // etc.. for button2,3,4.
//                Button NUButton = (Button) view.findViewById(R.id.NotImpUrg);
//                Button INButton = (Button) view.findViewById(R.id.ImpNotUrg);
//                Button NNButton = (Button) view.findViewById(R.id.NotImpNotUrg);

//                builder.setView(view);
//                builder.show();

//                builder.setTitle("Add a task");
//                builder.setMessage("What do you want to do?");
//                final EditText inputField = new EditText(this);
//                builder.setView(inputField);



//                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
////                        Log.d("MainActivity",inputField.getText().toString());
//                        String task = inputField.getText().toString();
//                        Log.d("MainActivity",task);
//
//                        TaskDBHelper helper = new TaskDBHelper(MainActivity.this);
//                        SQLiteDatabase db = helper.getWritableDatabase();
//                        ContentValues values = new ContentValues();
//
//                        values.clear();
//                        values.put(TaskContract.Columns.TASK, task);
//
//                        db.insertWithOnConflict(TaskContract.TABLE, null, values,
//                                SQLiteDatabase.CONFLICT_IGNORE);
//
//                        updateUI();
//                    }
//                });

//                builder.setNegativeButton("Cancel",null);

                //builder.create().show();
                return true;

            // ... other code

            default:
                return false;
        }
    }
//This is just for fragments or views
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (view != null) {
//            ViewGroup parentViewGroup = (ViewGroup) view.getParent();
//            if (parentViewGroup != null) {
//                parentViewGroup.removeAllViews();
//            }
//        }
//    }

    private void updateUI() {
        helper = new TaskDBHelper(MainActivity.this);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor = sqlDB.query(TaskContract.TABLE,
                new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK},
                null, null, null, null, null);

        ListAdapter listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.task_view,
                cursor,
                new String[] { TaskContract.Columns.TASK},
                new int[] { R.id.taskTextView},
                0
        );
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);
//        this.setListAdapter(listAdapter);
    }

    public void onDoneButtonClick(View view) {
        View v = (View) view.getParent();
        TextView taskTextView = (TextView) v.findViewById(R.id.taskTextView);
        String task = taskTextView.getText().toString();

        String sql = String.format("DELETE FROM %s WHERE %s = '%s'",
                TaskContract.TABLE,
                TaskContract.Columns.TASK,
                task);


        helper = new TaskDBHelper(MainActivity.this);
        SQLiteDatabase sqlDB = helper.getWritableDatabase();
        sqlDB.execSQL(sql);
        updateUI();
    }
}
