package com.example.groceryapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.groceryapp.Models.GroceryItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Util {
    private static int id=0;

    public Util(){

    }

    public static int getId(){
        id++;
        return id;
    }

    public ArrayList<GroceryItem> getAllitems(Context context){

        Gson gson=new Gson();
        SharedPreferences sharedPreferences=context.getSharedPreferences("fake_database",Context.MODE_PRIVATE);
        Type type=new TypeToken<ArrayList<GroceryItem>>(){}.getType();
        ArrayList<GroceryItem> allItems=gson.fromJson(sharedPreferences.getString("allItems",null),type);
        return allItems;
    }

    public void initDatabase(Context context){

        SharedPreferences sharedPreferences=context.getSharedPreferences("fake_database",context.MODE_PRIVATE);

        Gson gson=new Gson();

        Type type=new TypeToken<ArrayList<GroceryItem>>(){}.getType();
        ArrayList<GroceryItem> possibleItems =gson.fromJson(sharedPreferences.getString("allItems",""),type);

        if(possibleItems==null){
            initallItems(context);
        }


    }

    private void initallItems(Context context){

        SharedPreferences sharedPreferences=context.getSharedPreferences("fake_database",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        Gson gson=new Gson();
        ArrayList<GroceryItem> allItems =new ArrayList<>();

        String name="";
        String desc="";
        String imgurl="";
        String cat="";
        double price=0.0;
        int amt=0;

        name="Soda";
        desc=" carbonated water. Soft drink, a sweetened, carbonated, and usually flavored drink";
        imgurl="https://www.fodors.com/wp-content/uploads/2019/03" +
                "/HERO_Worlds_Best_Soda_Bundaberg_shutterstock_679079920.jpg";
        cat="Soft drink";
        price=65.0;
        amt=123;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));

        name="Bread";
        desc="Salt, fat and leavening agents such as yeast and baking soda are common ingredients";
        imgurl="https://www.kingarthurflour.com/sites/default/files/recipe_legacy/1496-3-large.jpg";
        cat="Food";
        price=25.5;
        amt=50;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Ketchup";
        desc=" a sauce is a liquid, cream, or semi-solid food, served on or used in preparing other foods";
        imgurl="https://images-na.ssl-images-amazon.com/images/I/71VTUSE6CiL._SL1500_.jpg";
        cat="Sauce";
        price=80.0;
        amt=63;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Pickle";
        desc="Pickling is the process of preserving or extending the lifespan of food by either anaerobic fermentation in brine or immersion in vinegar";
        imgurl="https://www.aforkstale.com/wp-content/uploads/2017/02/fire-and-ice-pickles.jpg";
        cat="Food";
        price=60.0;
        amt=15;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Milk";
        desc="Milk is a nutrient-rich, white liquid food produced by the mammary glands of mammals";
        imgurl="https://www.hindustantimes.com" +
                "/rf/image_size_960x540/HT/p2/2018/09/20/Pictures/_61433f0c-bcb9-11e8-95ec-91800d079bb4.jpg";
        cat="Milk";
        price=25.0;
        amt=100;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Chips";
        desc="Potato chips, or crisps, are thin slices of potato that have been deep fried or baked until crunchy";
        imgurl="https://nationalpostcom.files.wordpress.com/2019/02/gettyimages-951699022.jpg?quality=80&strip=all&w=780";
        cat="Snacks";
        price=15.0;
        amt=200;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Cereals";
        desc="A cereal is any grass cultivated (grown) for the edible components of its grain";
        imgurl="https://www.foodbusinessnews.net/ext/resources/2019/5/RTECereal_Lead.jpg?1556799041";
        cat="Snacks";
        price=152.0;
        amt=60;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Salt";
        desc="Salt is a mineral composed primarily of sodium chloride";
        imgurl="https://i1.wp.com/gginews.in/wp-content/uploads" +
                "/2019/06/Tata-Salt-Contains-Poison-US-Lab-Report-1.jpg?resize=620%2C349";
        cat="Spices";
        price=20.0;
        amt=40;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Butter";
        desc="Rendering butter, removing the water and milk solids," +
                " produces clarified butter or ghee, which is almost entirely butterfat";
        imgurl="https://katrajdairy.com/wp-content/uploads/2017/08/Butter-Thumbnail.jpg";
        cat="Food";
        price=65.0;
        amt=65;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Coffee";
        desc="Coffee is more than just a drink: It's a culture, an economy, an art, a science";
        imgurl="https://img.etimg.com/thumb/msid-66650613,width-643,imgsize-801611,resizemode-4/coffee.jpg";
        cat="Food";
        price=212.0;
        amt=15;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));

        name="Cooking Oil";
        desc="It is also used in food preparation and flavouring not involving heat";
        imgurl="https://www.inforum.com/incoming/4643863-78p7da" +
                "-090519.F.FF.Scoop43OliveOil1/alternates/BASE_LANDSCAPE/090519.F.FF.Scoop43OliveOil1";
        cat="Oil";
        price=430.0;
        amt=30;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Pasta";
        desc="Pasta is a type of food typically made from an unleavened dough of durum wheat flour mixed with water";
        imgurl="https://www.indianhealthyrecipes.com/wp-content/uploads/2019/05/masala-pasta-480x270.jpg";
        cat="Food";
        price=55.0;
        amt=120;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Hair Oil";
        desc="Best for hair";
        imgurl="https://5.imimg.com/data5/EM/BK/MY-7778582/bajaj-hair-oil-500x500.jpg";
        cat="Oil";
        price=112.0;
        amt=79;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Ariel";
        desc="Laundry detergent, or washing powder, is a type of detergent (cleaning agent) that is added for cleaning laundry.";
        imgurl="https://images-na.ssl-images-amazon.com/images/I/81VRlBWP97L._SL1500_.jpg";
        cat="Detergent";
        price=151.0;
        amt=400;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="CloseUp";
        desc="Toothpaste is a paste or gel dentifrice used with a toothbrush to clean and maintain the aesthetics and health of teeth.";
        imgurl="https://images-na.ssl-images-amazon.com/images/I/61xBMNoz8wL._SL1000_.jpg";
        cat="Toothpaste";
        price=57.0;
        amt=80;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));


        name="Soap";
        desc="";
        imgurl="https://cdn.shopify.com/s/files/1/1293/8895/products/white.jpg?v=1517504396";
        cat="Soap";
        price=0.0;
        amt=0;
        allItems.add(new GroceryItem(name,desc,imgurl,cat,amt,price));

        String finalstring=gson.toJson(allItems);
        editor.putString("allItems",finalstring);
        editor.commit();
    }
}
