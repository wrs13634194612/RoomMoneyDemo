package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HelloActivity extends FragmentActivity {
    double all = 0;
    double yearFactor = 0;
    double monthFactor = 0;
    double yearInt = 0;
    double monthInt = 0;
    double liMonth = 0;
    double benMonth = 0;
    double allMonth = 0;
    double remainMoney = 0;
    double javaMoney = 0;
    private HashMap<Integer, LoanBean> map;
    private GroupInfoAdapter mAdapter;
    private RecyclerView rv_group;
    private List<LoanBean> list;
    private EditText et_year_factor;
    private EditText et_all;
    private EditText et_year_int;
    private Button btn_search, btn_search2;
    private EditText et_year;
    private EditText et_month;
    private EditText et_day;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();
        list = new ArrayList<>();
        all = 1000000;
        yearFactor = 0.06;
        monthFactor = yearFactor / 12;
        yearInt = 30;
        monthInt = yearInt * 12;
        liMonth = remainMoney * monthFactor;
        benMonth = remainMoney / monthInt;
        allMonth = liMonth + benMonth;
        remainMoney = all - javaMoney;
        for (int i = 0; i < monthInt; i++) {
            map.put(i, new LoanBean(i, all, ((monthInt+1)*all*monthFactor)/2+all,yearFactor, monthFactor, yearInt, monthInt,
                    (all - ((remainMoney / monthInt) * (i + 1))) * monthFactor,
                    remainMoney / monthInt,
                    (all - ((remainMoney / monthInt) * (i + 1))) * monthFactor + remainMoney / monthInt,
                    all - ((remainMoney / monthInt) * (i + 1)),
                    (remainMoney / monthInt) * (i + 1),
                    (i + 8) / 12 + 2022,
                    (i + 8) % 12,
                    9));
        }
        System.out.println(map);
        if (!list.isEmpty()) {
            list.clear();
        }
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            list.add(map.get(iter.next()));
        }
        rv_group = findViewById(R.id.rv_group);
        et_year_factor = findViewById(R.id.et_year_factor);
        et_all = findViewById(R.id.et_all);
        et_year_int = findViewById(R.id.rt_year_int);
        btn_search = findViewById(R.id.btn_search);
        btn_search2 = findViewById(R.id.btn_search2);

        et_year = findViewById(R.id.et_year);
        et_month = findViewById(R.id.et_month);
        et_day = findViewById(R.id.et_day);

        mAdapter = new GroupInfoAdapter(HelloActivity.this, list);
        rv_group.setLayoutManager(new LinearLayoutManager(HelloActivity.this));
        rv_group.setAdapter(mAdapter);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etYearFactorString = et_year_factor.getText().toString();
                String etAllString = et_all.getText().toString();
                String etYearIntString = et_year_int.getText().toString();
                String currentYear = et_year.getText().toString();
                String currentMonth = et_month.getText().toString();
                String currentDay = et_day.getText().toString();
                all = Double.parseDouble(etAllString) * 10000;
                yearFactor = Double.parseDouble(etYearFactorString) / 100;
                monthFactor = yearFactor / 12;
                yearInt = Double.parseDouble(etYearIntString);
                monthInt = yearInt * 12;
                liMonth = remainMoney * monthFactor;
                benMonth = remainMoney / monthInt;
                allMonth = liMonth + benMonth;
                remainMoney = all - javaMoney;
                for (int i = 0; i < monthInt; i++) {
                    map.put(i, new LoanBean(i, all, ((monthInt+1)*all*monthFactor)/2+all,yearFactor, monthFactor, yearInt,
                            monthInt, (all - ((remainMoney / monthInt) * (i + 1))) * monthFactor, remainMoney / monthInt,
                            (all - ((remainMoney / monthInt) * (i + 1))) * monthFactor + remainMoney / monthInt,
                            all - ((remainMoney / monthInt) * (i + 1)),
                            (remainMoney / monthInt) * (i + 1),
                            (i + Integer.parseInt(currentMonth)) / 12 + Integer.parseInt(currentYear),
                            (i + Integer.parseInt(currentMonth)) % 12,
                            Integer.parseInt(currentDay)));
                }
                System.out.println(map);
                if (!list.isEmpty()) {
                    list.clear();
                }
                Iterator<Integer> iter = map.keySet().iterator();
                while (iter.hasNext()) {
                    list.add(map.get(iter.next()));
                }
                mAdapter.notifyDataSetChanged();
            }
        });


        btn_search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etYearFactorString = et_year_factor.getText().toString();
                String etAllString = et_all.getText().toString();
                String etYearIntString = et_year_int.getText().toString();
                String currentYear = et_year.getText().toString();
                String currentMonth = et_month.getText().toString();
                String currentDay = et_day.getText().toString();
                all = Double.parseDouble(etAllString) * 10000;
                yearFactor = Double.parseDouble(etYearFactorString) / 100;
                monthFactor = yearFactor / 12;
                yearInt = Double.parseDouble(etYearIntString);
                monthInt = yearInt * 12;
                liMonth = remainMoney * monthFactor;
                benMonth = remainMoney / monthInt;
                allMonth = liMonth + benMonth;
                remainMoney = all - javaMoney;
                for (int i = 0; i < monthInt; i++) {
                    map.put(i, new LoanBean(i, all,
                            (all * (yearFactor / 12) * Math.pow((yearFactor / 12 + 1), 360) / (Math.pow((yearFactor / 12 + 1), 360) - 1))*monthInt,
                            yearFactor, monthFactor, yearInt,
                            monthInt,
                            all * monthFactor,
                            all * monthFactor * Math.pow((monthFactor + 1), monthInt) / (Math.pow((monthFactor + 1), monthInt) - 1) - all * monthFactor,
                            all * monthFactor * Math.pow((monthFactor + 1), monthInt) / (Math.pow((monthFactor + 1), monthInt) - 1),
                            all - (all * monthFactor * Math.pow((monthFactor + 1), monthInt) / (Math.pow((monthFactor + 1), monthInt) - 1) - all * monthFactor) * (i + 1),
                            (all * monthFactor * Math.pow((monthFactor + 1), monthInt) / (Math.pow((monthFactor + 1), monthInt) - 1) - all * monthFactor) * (i + 1),
                            (i + Integer.parseInt(currentMonth)) / 12 + Integer.parseInt(currentYear),
                            (i + Integer.parseInt(currentMonth)) % 12,
                            Integer.parseInt(currentDay)));
                }
                System.out.println(map);
                if (!list.isEmpty()) {
                    list.clear();
                }
                Iterator<Integer> iter = map.keySet().iterator();
                while (iter.hasNext()) {
                    list.add(map.get(iter.next()));
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
