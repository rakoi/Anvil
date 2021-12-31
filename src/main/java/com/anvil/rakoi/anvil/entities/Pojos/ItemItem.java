package com.anvil.rakoi.anvil.entities.Pojos;


public class ItemItem {

    public String Value;
    public String Name;

    public ItemItem() {
    }

    public ItemItem(String value, String name) {
        Value = value;
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "ItemItem{" +
                "Value='" + Value + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
