package com.paulo.payment.mvp;

import android.content.Context;

public interface Contract {

    interface Ctrl {
        void click(String type);
    }

    interface View {
        void updateUI();
        Context getContext();
    }

}
