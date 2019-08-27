package com.example.mydebby;

import android.content.DialogInterface;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    DatabaseHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar_settings);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        TextView clearHistory = findViewById(R.id.clear_history);
        clearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbHelper = new DatabaseHelper(SettingsActivity.this);
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                showAlertDialog();
            }
        });



    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this,R.style.MyDialogTheme);
        builder.setTitle("Are you sure?");
        builder.setMessage("All the history will be deleted");

        String positiveText = "yes";
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myDbHelper.deleteHistory();
                    }
                });

        String negativeText = "No";
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog dialog = builder.create();
        //Display dialog
        dialog.show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            //press back
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}
