package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointSingle;

import java.util.List;

/**
 * Created by Администратор on 19.04.2017.
 */

public class PointListFragment extends Fragment {

    private static final String TAG = PointListFragment.class.getName();
    private RecyclerView recyclerView;
    private PointAdapter pointAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.point_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_points);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    public void updateUI(){

        PointSingle pointSingle = PointSingle.get(getActivity());
        List<Point>pointList=pointSingle.getPointList();

        pointAdapter = new PointAdapter(pointList);
        recyclerView.setAdapter(pointAdapter);


    }
    public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
        private List<Point> pointList;
        private LayoutInflater inflater;


        public PointAdapter(List<Point> pointList) {
            this.pointList = pointList;
            setHasStableIds(true);

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                inflater = LayoutInflater.from(getActivity());
                View view = inflater.inflate(R.layout.point_item, parent,false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(PointAdapter.ViewHolder holder, int position) {
            Point point = pointList.get(position);
            holder.bind(point);

        }

        @Override
        public int getItemCount() {
            return pointList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private TextView pointName;
            private TextView time;
            private ImageButton showOnTheMap;

            private TextView pointDescription;

            private TextView temperature;
            private TextView pressure;
            private TextView humidity;
            private TextView wind;
            private TextView condition;

            Point point;

            public ViewHolder create(LayoutInflater inflater, ViewGroup parent) {
                return new ViewHolder(inflater.inflate(R.layout.point_item, parent, false));
            }


            public ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                pointName = (TextView) itemView.findViewById(R.id.text_view_name_point);
                time = (TextView) itemView.findViewById(R.id.text_view_date_point);
                showOnTheMap = (ImageButton)itemView.findViewById(R.id.image_button_show_location_on_the_map);

//
//            pointDescription = (TextView) itemView.findViewById(R.id.point_description);
            }

            public void bind(Point point) {
                this.point = point;
                pointName.setText(point.getName());
                time.setText(Utils.getCurrentDate());
              //  showOnTheMap.


//                pointDescription.setText(point.getDescription());

            }

            @Override
            public void onClick(View view) {

                Log.v(TAG, "Нажатие" + point.getName());

            }
        }
    }

}
