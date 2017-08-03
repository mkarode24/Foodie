package com.example.shahnawazmandal.shruti;

/**
 * Created by shahnawaz mandal on 9/05/2017.
 */
public class products {

    private int _id;
    private String _productname;
    private String _data;
    private String _address;
    private String _password;

    public products() {
    }

    public products(String productname,String data,String address,String password) {
        this._address=address;
        this._password=password;
        this._productname = productname;
        this._data=data;
    }

 /*   public products(String productname,String password) {
        this._address="shruti";
        this._password=password;
        this._productname = productname;
        this._data="";
    }*/


    public String get_productname() {
        return _productname;
    }

    public String get_data() {
        return _data;
    }
    public void set_data(String _data) {
        this._data = _data;
    }



    public String get_address() {
        return _address;
    }
    public void set_address(String _address) {
        this._address = _address;
    }



    public String get_password() {
       return _password;
    }
   public void set_password(String _password) {
        this._password = _password;
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }
}

