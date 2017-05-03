//package com.softgroup.fishingplus.screens;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.ImageView;
//
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.softgroup.fishingplus.R;
//import com.softgroup.fishingplus.models.Photo;
//
//import java.util.ArrayList;
//
//
//public class PhotoActivity extends AppCompatActivity {
//
//    private ImageView photoFromGalery;
//    private FirebaseStorage storage;
//    private StorageReference ref;
//    private RecyclerView recyclerView;
//    private PhotoAdapter photoAdapter;
//    ArrayList<Photo> photoList;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recycler_photo);
//
//        photoList = getIntent().getParcelableArrayListExtra("kk");
//
//      //  photoList = (ArrayList<Photo>) addFoto();
//
//        Log.v("PhotoActivity", "Размер = " + photoList.size());
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_photo);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        updateUI();
//
////        ref = FirebaseStorage.getInstance().getReference().child("chat_photos");
////        photoFromGalery = (ImageView) findViewById(R.id.image_view_photo_galery);
//
//    }
//
////    public List<Photo> addFoto() {
////        ArrayList<Photo> photoList = new ArrayList<>();
////        Photo photo = new Photo();
////        photo.setImage(String.valueOf(R.drawable.camera_alt_black_24dp));
////        photo.setImage(String.valueOf(R.drawable.cast_ic_mini_controller_play_large));
////        photoList.add(photo);
////
////
////        return photoList;
////    }
//    public void updateUI() {
////        List<Photo> photoList = new ArrayList<>();
//
//        if (photoAdapter == null) {
//            photoAdapter = new PhotoAdapter(photoList);
//            recyclerView.setAdapter(photoAdapter);
//        } else {
//            photoAdapter.notifyDataSetChanged();
//        }
//    }
//}
