package com.paulo.payment.mvp;

public interface Contract {

    interface Ctrl {
        void click(String type);
    }

    interface View {
        void updateUI();
    }

}
