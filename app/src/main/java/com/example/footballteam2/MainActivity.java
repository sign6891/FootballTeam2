package com.example.footballteam2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter; //связывает наши данные с макетом RecyclerView
    private RecyclerView.LayoutManager layoutManager; //Управляет расположением элементов в RecyclerView
    ArrayList<RecyclerViewUser> recyclerViewUser = new ArrayList<>();
    RecyclerViewAdapter.Barr barr = new RecyclerViewAdapter.Barr();
    String[] list;
    //boolean[] mas = barr.getChecked();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_user();
    }

    public void list_user() {
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Никита", "н"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Миша", "н"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Парень в серой майке))", "н"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Миша из Атлантиса", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Женя", "н"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Никита Низнаемов", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Дима(Я)", "з"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Дима(С Никитой)", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Антон", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Игорь Краснов", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Кирилл Z", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "ВестХем", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Паша", "з"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Ань", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Серега", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Парень в черной майки(шустрый)", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Парень в синих шортах(с Никитой)", "п"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Ильдар", "з"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Илья - Чувак в очках", "з"));
        recyclerViewUser.add(new RecyclerViewUser(R.drawable.ic_photo_camera_black_24dp, "Олег", "з"));

        recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(recyclerViewUser, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        list = new String[recyclerViewUser.size()];
        for (int i = 0; i < recyclerViewUser.size(); i++) {
            list[i] = recyclerViewUser.get(i).getNameUser();
        }
    }
    //Переход на новое Активити с передачей ему данных user
    public void go(View view) {
        Intent intent = new Intent(MainActivity.this, FormatGamerList.class);
        intent.putExtra("key", barr.getChecked());
        intent.putExtra("key2", list);
        startActivity(intent);
    }

}
