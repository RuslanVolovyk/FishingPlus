package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.models.FriendlyMessage;

import java.util.ArrayList;
import java.util.List;


public class PhotoActivity extends AppCompatActivity {

    private static final String TAG = PhotoActivity.class.getName();
    private ImageView photoFromGalery;
    private FirebaseStorage storage;
    private StorageReference ref;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private ArrayList<FriendlyMessage> photoList;
    private DatabaseReference mDatabase;
    private ChildEventListener childEventListener;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_photo);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase =  firebaseDatabase.getReference().child("messages");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_photo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<String> listPhoto = new ArrayList<>();

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    FriendlyMessage match = postSnapshot.getValue(FriendlyMessage.class);

                    String photo = match.getPhoto();
                    if (photo != null){
                        listPhoto.add(photo);

                    }

                   // String name = postSnapshot.child("photo").getValue(String.class);
                   // Log.i(TAG, "Referee " + name);
                }

                photoAdapter = new PhotoAdapter(listPhoto);
                recyclerView.setAdapter(photoAdapter);

               Log.i(TAG, "Referee " + listPhoto);
               Log.i(TAG, "Referee " + listPhoto.size());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled ", databaseError.toException());
                // ...
            }
        });
    }
}
