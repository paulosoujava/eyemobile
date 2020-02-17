package com.paulo.payment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.paulo.payment.mvp.Contract;
import com.paulo.payment.mvp.Presenter;
import com.paulo.payment.util.Utils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Contract.View {

    Presenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<View> numbs = new ArrayList<>();
    TextView vs_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new Presenter(this, this);
        initIds();
        mAdapter = new MyAdapter(presenter.geLoadPAyments(), this, presenter);
        recyclerView.setAdapter(mAdapter);

        controllerDots();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.updateUI(vs_1, true);
    }

    @Override
    public void updateUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                presenter.updateUI(vs_1, false);

            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }


    private void controllerDots() {
        final ImageView dot_one = findViewById(R.id.dot_one);
        final ImageView dot_two = findViewById(R.id.dot_two);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dx == 0) {
                    dot_one.setImageResource(R.drawable.circle_dots_close);
                    dot_two.setImageResource(R.drawable.circle_dots);
                } else if (dx > 3) {
                    dot_one.setImageResource(R.drawable.circle_dots_close);
                    dot_two.setImageResource(R.drawable.circle_dots);
                } else {
                    dot_two.setImageResource(R.drawable.circle_dots_close);
                    dot_one.setImageResource(R.drawable.circle_dots);
                }
            }
        });
    }

    //BIND THE IDS TEXT VIEW NAD SET CUSTOM FONT NAD CLICK KEYBOARD
    void initIds() {

        vs_1 = findViewById(R.id.lb_unid_1);
        Typeface font = Utils.getFontCondesendBold(this);
        vs_1.setTypeface(font);
        TextView total = findViewById(R.id.lb_total);
        TextView lb_prefix = findViewById(R.id.lb_prefix);
        total.setTypeface(font);
        lb_prefix.setTypeface(font);

        //keyboard 1 - 0  and enter
        numbs.add(findViewById(R.id.lb_one));
        TextView n1 = findViewById(R.id.lb_one);
        n1.setTypeface(font);
        numbs.add(findViewById(R.id.lb_two));
        TextView n2 = findViewById(R.id.lb_one);
        n2.setTypeface(font);
        numbs.add(findViewById(R.id.lb_three));
        TextView n3 = findViewById(R.id.lb_one);
        n3.setTypeface(font);
        numbs.add(findViewById(R.id.lb_four));
        TextView n4 = findViewById(R.id.lb_one);
        n4.setTypeface(font);
        numbs.add(findViewById(R.id.lb_five));
        TextView n5 = findViewById(R.id.lb_one);
        n5.setTypeface(font);
        numbs.add(findViewById(R.id.lb_six));
        TextView n6 = findViewById(R.id.lb_one);
        n6.setTypeface(font);
        numbs.add(findViewById(R.id.lb_seven));
        TextView n7 = findViewById(R.id.lb_one);
        n7.setTypeface(font);
        numbs.add(findViewById(R.id.lb_eight));
        TextView n8 = findViewById(R.id.lb_one);
        n8.setTypeface(font);
        numbs.add(findViewById(R.id.lb_nine));
        TextView n9 = findViewById(R.id.lb_one);
        n9.setTypeface(font);
        numbs.add(findViewById(R.id.lb_zero));
        TextView n0 = findViewById(R.id.lb_one);
        n0.setTypeface(font);
        numbs.add(findViewById(R.id.lb_enter));


        presenter.clickKeyboard(numbs);
    }


}
