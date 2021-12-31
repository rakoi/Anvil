package com.anvil.rakoi.anvil.entities.Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CallbackMetaData {

    @JsonProperty("Item")
    public List<ItemItem> Item;

    public CallbackMetaData() {
    }

    public CallbackMetaData(List<ItemItem> item) {
        Item = item;
    }

    public List<ItemItem> getItem() {
        return Item;
    }

    public void setItem(List<ItemItem> item) {
        Item = item;
    }

    @Override
    public String toString() {
        return "CallbackMetaData{" +
                "Item=" + Item +
                '}';
    }
}
