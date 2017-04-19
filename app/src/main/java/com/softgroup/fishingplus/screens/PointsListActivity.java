package com.softgroup.fishingplus.screens;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointAdapter;

import java.util.ArrayList;
import java.util.List;


public class PointsListActivity extends AppCompatActivity {
    private static final String TAG = PointsListActivity.class.getName();
    RecyclerView recyclerViewPoints;

    private List<Point> points = new ArrayList<>();


    private void updateUI(List<Point> point) {
        if (recyclerViewPoints.getAdapter() == null) {
            recyclerViewPoints.setAdapter(new PointAdapter(point));
        } else {
            PointAdapter adapter = (PointAdapter) recyclerViewPoints.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_list);

        recyclerViewPoints = (RecyclerView) findViewById(R.id.recycler_view_points);

        updateUI(points);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_points_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_create_new_points:
                createPointsMethod();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private List<Point> createPointsMethod() {
        final List<Point> points = new ArrayList<>();

        final AlertDialog.Builder builder = new AlertDialog.Builder(PointsListActivity.this);
        builder.setTitle("Enter your product");

        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.alert_dialog_detail_poin, null);
        builder.setView(dialogView);
        final EditText editTextName = (EditText) dialogView.findViewById(R.id.edit_text_point_title);
        final EditText editTextDescription = (EditText) dialogView.findViewById(R.id.edit_text_point_description);

        Log.v(TAG, "editTextName" + editTextName);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        if (!Utils.isBlankField(editTextName) && !Utils.isBlankField(editTextDescription)) {
                            Point point = new Point();

                            point.setName(editTextName.getText().toString());
                            point.setDescription(editTextDescription.getText().toString());
                            points.add(point);
                            updateUI(points);
                        } else {
                            Toast.makeText(PointsListActivity.this, "Entry not saved", Toast.LENGTH_SHORT).show();

                            dialog.cancel();
                        }
                    }
                }
        );
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        AlertDialog dialog = builder.create();
        dialog.show();
        return points;
    }

}

