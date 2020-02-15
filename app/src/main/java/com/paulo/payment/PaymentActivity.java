package com.paulo.payment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class PaymentActivity extends AppCompatActivity {

    LinearLayout back;
    TextView title;
    TextView value;
    TextView addrres;
    TextView date;
    TextView type;
    TextView place;
    TextView confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent it = getIntent();
        if (it != null) {

            Bundle bundle = it.getExtras();
            String total = bundle.getString("Payment_value");
            String typePayment = bundle.getString("Payment_type");

            iniIds();
            value.setText(total);
            type.setText(typePayment);

            date.setText(getDate());
        } else {
            finish();
        }
    }


    void iniIds() {

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/din_condensed_bold.ttf");
        title = findViewById(R.id.title);
        title.setTypeface(font);

        Typeface fontRec = Typeface.createFromAsset(getAssets(), "fonts/tahoma.ttf");
        value = findViewById(R.id.value);
        value.setTypeface(fontRec);
        addrres = findViewById(R.id.address);
        addrres.setTypeface(fontRec);
        type = findViewById(R.id.type);
        type.setTypeface(fontRec);
        date = findViewById(R.id.date);
        date.setTypeface(fontRec);
        place = findViewById(R.id.place);
        place.setTypeface(fontRec);

        confirm = findViewById(R.id.confirm);
        Typeface fontBtn = Typeface.createFromAsset(getAssets(), "fonts/tahoma_bold.ttf");
        confirm.setTypeface(fontBtn);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    String getDate() {
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6

        int month = cal.get(Calendar.MONTH); // 5
        int year = cal.get(Calendar.YEAR); // 2016

        return (dayOfWeek + "/" + month + 1 + "/" + year + " Horas: " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
    }

}
