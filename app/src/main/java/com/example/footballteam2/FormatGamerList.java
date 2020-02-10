package com.example.footballteam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FormatGamerList extends AppCompatActivity {

    TextView team_1;
    TextView team_2;
    TextView team_3;
    int[] mas;
    boolean[] checked;
    String[] names;
    ArrayList list1 = new ArrayList();
    ArrayList list2 = new ArrayList();
    ArrayList list3 = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format_gamer_list);

        team_1 = findViewById(R.id.team_1);
        team_2 = findViewById(R.id.team_2);
        team_3 = findViewById(R.id.team_3);

        //Получение данных от главного активити
        Intent intent = getIntent();
        //mas = intent.getIntArrayExtra("com.example.footballteam.mas");
        checked = intent.getBooleanArrayExtra("key");
        names = intent.getStringArrayExtra("key2");
        Log.i("key0", Arrays.toString(names));

        spisok(checked);
        Log.i("key0", Arrays.toString(mas));
        sbor_komand_random(mas);

        //выводим на экран отсортированный список игроков
        team_1.setText(display_gamer_list(list1, names));

        team_2.setText(display_gamer_list(list2, names));

        team_3.setText(display_gamer_list(list3, names));
    }

    public int[] spisok(boolean[] checked) {
        mas = new int[checked.length];
        for (int j = 0; j < mas.length; j++){
            mas[j] = -1;
        }
        for (int i = 0; i < checked.length; i++) {
            if (checked[i]) {
                mas[i] = i;
            }
        }
        return mas;
    }

    //Сортировка играков по скилам на три команды(листа) при помощи рандома
    public void sbor_komand_random(int[] mas) {
        ArrayList<Integer> list = new ArrayList();
        list.add(0, 10000);


        ArrayList list4 = new ArrayList();
        ArrayList<Integer> sort = new ArrayList();
        ArrayList newList = new ArrayList();

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == -1) {
                continue;
            } else {
                list.add(mas[i]);
            }
        }

        for (int i = 1; i < list.size(); i += 3) {// 8
            for (int j = i; j <= i + 2 && j < list.size(); j++) {//
                //1, 2, 3
                sort.add(list.get(j));

            }
            //заполнение листа рандомными значениями на три команды
            //рандомим по три человека
            Collections.shuffle(sort);
            for (int a = 0; a < sort.size(); a++) {
                newList.add(sort.get(a));
            }
            sort.clear();
        }

        int count = 1;
        int a = 0, b = 0, c = 0;
        //Обрабатываем окончательный лист и раскидываем игроков по трем командам в виде индексов массива.
        for (int j = 0; j < newList.size(); j++) {
            switch (count) {
                case 1:
                    list1.add(newList.get(j));
                    Log.i("key", "List" + count + " " + a + " = " + list1.get(a));
                    a++;
                    break;
                case 2:
                    list2.add(newList.get(j));
                    Log.i("key", "List" + count + " " + b + " = " + list1.get(b));
                    b++;
                    break;
                case 3:
                    list3.add(newList.get(j));
                    Log.i("key", "List" + count + " " + c + " = " + list1.get(c));
                    c++;
                    break;
            }
            count++;
            if (count == 4)
                count = 1;
        }
    }

    //связываем значения из массива с индексами в списки игроков.
    public String display_gamer_list(ArrayList list, String[] names){//)
        String nameText = "";
        for (int i = 0; i < list.size(); i++) {
            nameText += names[((int)list.get(i))] + "\n";
        }
        return nameText;

    }
}
