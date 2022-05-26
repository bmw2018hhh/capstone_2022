package com.example.myapplication;

import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;


public class  Food implements Serializable{

    private  String mName;
    private int mAmount;
    private int mQuantity;

    Intent intent;


    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    public Food(){}

    public Food(String mName, int mAmount) {
        this.mName = mName;
        this.mAmount = mAmount;
        this.mQuantity = 1;
    }

    public String getmName() {
        return mName;
    }

    public int getmAmount() {
        return mAmount;
    }

    public int getmQuantity(){
        return mQuantity;
    }

    public void addToQuantity(){
        this.mQuantity += 1;
    }

    public void removeFromQuantity(){
        if(this.mQuantity > 1){
            this.mQuantity -= 1;
        }
    }


}