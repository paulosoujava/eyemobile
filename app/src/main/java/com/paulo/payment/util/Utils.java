package com.paulo.payment.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;

import androidx.fragment.app.DialogFragment;



public class Utils extends DialogFragment {


    public static AlertDialog alertWarning(String warningText, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Opss");
        builder.setMessage(warningText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

    public static  Typeface getFontCondesendBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/din_condensed_bold.ttf");
    }
    public static  Typeface getFontTahoma(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/tahoma.ttf");
    }
    public static  Typeface getFontTahomaBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/tahoma_bold.ttf");
    }

}


