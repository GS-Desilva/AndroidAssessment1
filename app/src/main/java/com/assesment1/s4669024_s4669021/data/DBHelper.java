package com.assesment1.s4669024_s4669021.data;

//importing the necessary classes
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//defining a helper class to manage the SQLite database
public class DBHelper extends SQLiteOpenHelper {
        //creating the database
        public static final String DATABASE_NAME = "garage.db";
        //creating the table
        public static final String TABLE_NAME = "car";
        //declaring the attributes
        public static final String CAR_ID = "id";
        public static final String CAR_BRAND = "brand";
        public static final String CAR_MODEL = "model";
        public static final String CAR_PRICE = "price";

        //constructor declaration
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        //creating a table in the database
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CAR_INFO = "CREATE TABLE " + TABLE_NAME
                    + "(" + CAR_ID + " INTEGER " + "PRIMARY KEY AUTOINCREMENT, "
                    + CAR_BRAND + " TEXT, "
                    + CAR_MODEL + " TEXT, "
                    + CAR_PRICE + " INTEGER)";

            db.execSQL(CAR_INFO);
        }

        //will be implemented when the database needs to be upgraded to a new version
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        //inserting data into the table car in the database
        public boolean insertData(String brand, String model, int price) {
            SQLiteDatabase db = this.getWritableDatabase();
            //creating a new instance of the ContentValues class
            ContentValues contentValues = new ContentValues();

            //adding data to the specific columns in the table car
            contentValues.put(CAR_BRAND, brand);
            contentValues.put(CAR_MODEL, model);
            contentValues.put(CAR_PRICE, price);

            // insert a record into the table car
            long result = db.insert(TABLE_NAME, null, contentValues);

            return result != -1;
        }

        //retrieves the price of a car based on the given brand and model from the database
        @SuppressLint("Range")
        public int getPrice(String brand, String model) {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {CAR_PRICE};
            String selection = CAR_BRAND + " = ? AND " + CAR_MODEL + " = ? ";
            String[] selectionArgs = {brand, model};

            Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

            int price = -1;

            if (cursor.moveToFirst()) {
                price = cursor.getInt(cursor.getColumnIndex(CAR_PRICE));
            }

            cursor.close();
            return price;
        }
}


