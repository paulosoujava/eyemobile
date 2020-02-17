package com.paulo.payment.mvp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.paulo.payment.PaymentActivity;
import com.paulo.payment.R;
import com.paulo.payment.entity.Payment;
import com.paulo.payment.util.MyKeys;
import com.paulo.payment.util.Utils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements Contract.Ctrl {


    Context context;
    private List<String> values = new ArrayList<>();
    Contract.View presenter;

    private String total = "";

    public Presenter(Context context, Contract.View presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void click(String type) {
        if (total.isEmpty()) {
            Utils.alertWarning("Valor inválido", presenter.getContext()).show();
            return;
        }
        Intent it = new Intent(context, PaymentActivity.class);
        it.putExtra(MyKeys.PAY_TYPE, type);
        it.putExtra(MyKeys.PAY_VALUE, total);
        context.startActivity(it);

    }

    public void addValue(String v) {
        if (values.size() != 6)
            values.add(v);
    }

    public void checkEnter() {
        if (!values.isEmpty())
            values.remove(values.size() - 1);
        else
            total = "";
    }

    public void updateUI(TextView vs_1, boolean isBack) {

        String str = "";

        if (isBack) {
            vs_1.setText("00,00");
            values.clear();
            total = "";
            return;
        }

        boolean flag = true;

        if (values.isEmpty()) vs_1.setText("00,00");

        for (int idx = 0; idx < values.size(); idx++) {
            if (idx == 4) {
                flag = false;
                String n = values.get(0) + "." + values.get(1) + "" + values.get(2) + "" + values.get(3) + ",0" + values.get(4);
                vs_1.setText(n);
                total = n;
            } else if (idx >= 5) {
                String n = values.get(0) + "." + values.get(1) + "" + values.get(2) + "" + values.get(3) + "," + values.get(4) + "" + values.get(5);
                vs_1.setText(n);
                total = n;
            } else {
                str += values.get(idx);
            }

        }
        if (!values.isEmpty() && flag) {
            Long valor = new Long(str);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            vs_1.setText(nf.format(valor).replace("R$", ""));
            total = (nf.format(valor).replace("R$", ""));
        }
    }

    public List<Payment> geLoadPAyments() {
        return PaymentService.geLoadPAyments();
    }

    public void clickKeyboard(List<View> numbs) {
        for (View v : numbs) {


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (v.getId()) {
                        case R.id.lb_one:

                            addValue("1");
                            break;
                        case R.id.lb_two:
                            addValue("2");
                            break;
                        case R.id.lb_three:
                            addValue("3");
                            break;
                        case R.id.lb_four:
                            addValue("4");
                            break;
                        case R.id.lb_five:
                            addValue("5");
                            break;
                        case R.id.lb_six:
                            addValue("6");
                            break;
                        case R.id.lb_seven:
                            addValue("7");
                            break;
                        case R.id.lb_nine:
                            addValue("9");
                            break;
                        case R.id.lb_eight:
                            addValue("8");
                            break;
                        case R.id.lb_zero:
                            addValue("0");
                            break;
                        case R.id.lb_enter:
                            checkEnter();

                            break;
                    }

                    presenter.updateUI();
                }

            });

        }
    }
}
