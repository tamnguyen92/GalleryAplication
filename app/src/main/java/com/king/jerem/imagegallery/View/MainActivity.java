package com.king.jerem.imagegallery.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.king.jerem.imagegallery.Adapter.GalleryAdapter;

import com.king.jerem.imagegallery.Presenter.LPresenterLoadGallery;
import com.king.jerem.imagegallery.R;


import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewShowGallery,View.OnClickListener {
   Button btnsubmit;
   EditText txturl;
   LPresenterLoadGallery lPresenterLoadGallery;
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();
        AddEvent();
        GetDataControll();
        lPresenterLoadGallery.GetListUrl("");
    }

    private void AddEvent() {
        btnsubmit.setOnClickListener(this);
    }

    private void GetDataControll() {



    }

    private void AddControl() {
        recyclerView=findViewById(R.id.recycleview);
        lPresenterLoadGallery=new LPresenterLoadGallery(this);
        txturl=findViewById(R.id.txturl);
        btnsubmit=findViewById(R.id.btnsubmit);

    }

    @Override
    public void ShowAllImage(List<String> list_URL) {
        Toast.makeText(MainActivity.this,list_URL.size()+"",Toast.LENGTH_LONG).show();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        GalleryAdapter adapter=new GalleryAdapter(MainActivity.this,list_URL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ShowError(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        String urls=txturl.getText().toString();
        lPresenterLoadGallery.GetListUrl(urls);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        modelGetUrl=new ModelGalery_getURL();
//        list_URL=modelGetUrl.getListUrl();
//        Toast.makeText(MainActivity.this,list_URL.size()+"",Toast.LENGTH_LONG).show();
//
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
//        GalleryAdapter adapter=new GalleryAdapter(MainActivity.this,list_URL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//
//    }
}
