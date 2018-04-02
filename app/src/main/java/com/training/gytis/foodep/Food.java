package com.training.gytis.foodep;

import android.media.*;

/**
 * Created by Gytis on 2017-11-15.
 */

public class Food {
    String _name;
    String _description;
    Image icon;

    public Food(String name){
        _name = name;
        _description = "";
        icon = null;
    }

    public Food(String _name, String _description, Image icon) {
        this._name = _name;
        this._description = _description;
        this.icon = icon;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }
}
