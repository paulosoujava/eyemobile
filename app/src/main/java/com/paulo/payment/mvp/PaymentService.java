package com.paulo.payment.mvp;

import com.paulo.payment.entity.Payment;

import java.util.ArrayList;
import java.util.List;

abstract class PaymentService {

    public static List<Payment> geLoadPAyments() {
        List<Payment> list = new ArrayList<>();

        list.add(new Payment("Dinheiro"));
        list.add(new Payment("Débito"));
        list.add(new Payment("Crédito"));
        list.add(new Payment("V.R."));
        list.add(new Payment("Cupom"));

        return list;
    }
}
