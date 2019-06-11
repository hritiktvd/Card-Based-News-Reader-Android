package com.hritik.articlereader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    //serialisedname: The parameter (value) of this annotation is the name to be used when serialising and deserialising objects.
    //For example, the Java field source is represented as "source" in JSON.
    //expose:An annotation that indicates this member should be exposed for JSON serialization or deserialization.

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
