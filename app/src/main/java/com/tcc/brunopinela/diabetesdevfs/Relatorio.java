package com.tcc.brunopinela.diabetesdevfs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.utils.Date;

import java.util.Calendar;

public class Relatorio {

    public void GerarRelatorioDia(SQLiteDatabase bancoDados, Date dia) {

        Cursor dadosDia = bancoDados.rawQuery("SELECT Glicose, Dia WHERE ")

        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
                , new GraphViewData(2, 1.5d)
                , new GraphViewData(3, 2.5d)
                , new GraphViewData(4, 1.0d)
        });

        http://android-graphview.org/#doc_howto
        http://stackoverflow.com/questions/17945912/get-string-date-time-and-int-from-sqlite-database-in-android
    }

}