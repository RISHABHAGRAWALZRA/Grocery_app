package com.example.groceryapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Reviews implements Parcelable {

    private int groceryItemId;
    private String username;
    private String date;
    private String text;

    public Reviews(int groceryItemId, String username, String date, String text) {
        this.groceryItemId = groceryItemId;
        this.username = username;
        this.date = date;
        this.text = text;
    }


    public static final Creator<Reviews> CREATOR = new Creator<Reviews>() {
        @Override
        public Reviews createFromParcel(Parcel in) {
            return new Reviews(in);
        }

        @Override
        public Reviews[] newArray(int size) {
            return new Reviews[size];
        }
    };

    public int getGroceryItemId() {
        return groceryItemId;
    }

    public void setGroceryItemId(int groceryItemId) {
        this.groceryItemId = groceryItemId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Creator<Reviews> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "groceryItemId=" + groceryItemId +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    protected Reviews(Parcel in) {
        groceryItemId = in.readInt();
        username = in.readString();
        date = in.readString();
        text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(groceryItemId);
        parcel.writeString(username);
        parcel.writeString(date);
        parcel.writeString(text);
    }


}
