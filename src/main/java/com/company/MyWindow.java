package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MyWindow extends Application
{

    protected final TextArea txtInfo;
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    protected synchronized  void appendInfoLine(String line)
    {
        /**
         * FX thread
         */
        final String text=String.format("%s-%s\n",dateFormat.format(new Date()),line);
        //  txtInfo.appendText(text);
        Platform.runLater(()->txtInfo.appendText(text));
    }

    protected MyWindow()
    {
        txtInfo=new TextArea();
        txtInfo.setFont(new Font(16d));
        // txtInfo.setEditable(false);
        txtInfo.setWrapText(false);
    }


}
