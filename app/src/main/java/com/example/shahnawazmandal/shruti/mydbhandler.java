package com.example.shahnawazmandal.shruti;

/**
 * Created by shahnawaz mandal on 9/05/2017.
 */
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shahnawaz mandal on 12/02/2017. to handle the database things
 */
public class mydbhandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 14;
    private static final String DATABASE_NAME = "products.db";
    private static final String COLUMN_ID_ = "_id";
    private static final String TABLE_PRODUCTS = "products";  //table name
    private static final String COLUMN_PRODUCTNAME = "productname";

    private static final String COLUMN_DATA = "data";

    private static final String COLUMN_ADDRESS = "address";

    private static final String COLUMN_PASSWORD = "password";

    public mydbhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_PRODUCTS + " ("+
                COLUMN_ID_+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_PRODUCTNAME + " TEXT  , " +
                COLUMN_DATA + " TEXT , " +
                COLUMN_ADDRESS + " TEXT , " +
                COLUMN_PASSWORD + " TEXT " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_PRODUCTS);
        onCreate(db);

    }


    //add new row
    public void addProduct(products product) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN_PRODUCTNAME, product.get_productname());
        values.put(COLUMN_DATA,product.get_data());

        values.put(COLUMN_ADDRESS,product.get_address());

        values.put(COLUMN_PASSWORD,product.get_password());

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }


    //verify password

    public int verify(String username,String pass)
    {
        SQLiteDatabase db = getWritableDatabase();
        int flag=0;
        String query= " select " + COLUMN_PRODUCTNAME + " from "+ TABLE_PRODUCTS + " where "+ COLUMN_PASSWORD + " = "+ "'"+ pass + "'; " ;

        Cursor c= db.rawQuery(query, null);

        String n=" ";
        if(c.moveToFirst()) {
            do {
                 n=c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME));

            } while (c.moveToNext());
        }

        if(!n.equals(null)) {

            if(n.equals(username))
                flag=1;
            db.close();
            return flag;
        }


          db.close();
         return flag;








    }


    // delete a row

    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + TABLE_PRODUCTS + " where " + COLUMN_PRODUCTNAME + " =\"" + productName + "\";");

    }


    //to update

    public void updateProduct(String productName,String data){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("update  "+ TABLE_PRODUCTS + " set "+ COLUMN_DATA+"  = '"+data + "' where  "+ COLUMN_PRODUCTNAME
                + " = '"+ productName + "' ;");
    }


    //get address

    public String getAddress(String username)
    {
        SQLiteDatabase db= getWritableDatabase();

        String query= " select " + COLUMN_ADDRESS + " from "+ TABLE_PRODUCTS + " where "+ COLUMN_PRODUCTNAME + " = "+ "'"+ username + "'; " ;

        Cursor c= db.rawQuery(query, null);

        String n=" ";
        if(c.moveToFirst()) {
            do {
                n=c.getString(c.getColumnIndex(COLUMN_ADDRESS));

            } while (c.moveToNext());
        }

       return  n;

    }


    //to display

    public String[] databaseToString()
    {
        String[] dbString= new String[2];
        SQLiteDatabase db = getWritableDatabase();

        String query= "select * from "+TABLE_PRODUCTS + ";";

        Cursor c= db.rawQuery(query,null);



        if(c.moveToFirst()) {
            do {
                String n=c.getString(c.getColumnIndex("productname"));
                if (n!=null) {

                    dbString[0] += n;
                    dbString[0] += "\n";

                    String n1=c.getString(c.getColumnIndex("data"));
                    dbString[1] += n1;
                    dbString[1] += "\n";


                }
            } while (c.moveToNext());
        }

        db.close();


        return dbString;


    }



    public String databaseToString1()
    {
        String dbString= "";
        SQLiteDatabase db = getWritableDatabase();

        String query= "select * from "+TABLE_PRODUCTS + " where 1" ;

        Cursor c= db.rawQuery(query,null);



        if(c.moveToFirst()) {
            do {
                String n=c.getString(c.getColumnIndex("data"));
                String n1=c.getString(c.getColumnIndex("productname"));
                String n2=c.getString(c.getColumnIndex("address"));
                String n3=c.getString(c.getColumnIndex("password"));
                if (n!=null) {

                    dbString = dbString+n+n1+n2+n3;
                    dbString += "\n";

                }
            } while (c.moveToNext());
        }

        db.close();


        return dbString;


    }

    // public String search(String productname){

    // }



    public String access_record(String n)

    {
        String dbString= "";
        SQLiteDatabase db = getWritableDatabase();

        String query= "select data from "+TABLE_PRODUCTS + " where productname = '"+ n + "';"  ;

        Cursor c= db.rawQuery(query,null);



        if(c.moveToFirst()) {
            do {
                String n1=c.getString(c.getColumnIndex("data"));
                if (n1!=null) {

                    dbString = dbString+n1;
                    dbString += "\n";

                }
            } while (c.moveToNext());
        }

        db.close();


        return dbString;


    }

}

