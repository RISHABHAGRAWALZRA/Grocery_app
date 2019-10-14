package com.example.groceryapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.groceryapp.Util;

import java.util.ArrayList;

public class GroceryItem implements Parcelable {
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private String Category;
    private int avilableAmount;
    private double price;
    private int popularityPoint;
    private int userPoint;
    private ArrayList<Reviews> reviews;

    public GroceryItem(String name, String description,
                       String imageUrl, String category, int avilableAmount,
                       double price) {

        this.id = Util.getId();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        Category = category;
        this.avilableAmount = avilableAmount;
        this.price = price;
        this.popularityPoint = 0;
        this.userPoint = 0;
        this.reviews = new ArrayList<>();
    }

    protected GroceryItem(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        Category = in.readString();
        avilableAmount = in.readInt();
        price = in.readDouble();
        popularityPoint = in.readInt();
        userPoint = in.readInt();
        reviews = in.createTypedArrayList(Reviews.CREATOR);
    }

    public static final Creator<GroceryItem> CREATOR = new Creator<GroceryItem>() {
        @Override
        public GroceryItem createFromParcel(Parcel in) {
            return new GroceryItem(in);
        }

        @Override
        public GroceryItem[] newArray(int size) {
            return new GroceryItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getAvilableAmount() {
        return avilableAmount;
    }

    public void setAvilableAmount(int avilableAmount) {
        this.avilableAmount = avilableAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPopularityPoint() {
        return popularityPoint;
    }

    public void setPopularityPoint(int popularityPoint) {
        this.popularityPoint = popularityPoint;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public ArrayList<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", Category='" + Category + '\'' +
                ", avilableAmount=" + avilableAmount +
                ", price=" + price +
                ", popularityPoint=" + popularityPoint +
                ", userPoint=" + userPoint +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(imageUrl);
        parcel.writeString(Category);
        parcel.writeInt(avilableAmount);
        parcel.writeDouble(price);
        parcel.writeInt(popularityPoint);
        parcel.writeInt(userPoint);
        parcel.writeTypedList(reviews);
    }
}
