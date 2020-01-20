package com.example.submissionexpert2.gas;

import android.os.Parcel;
import android.os.Parcelable;

//gas -> getter and setter:]

public class MovieModel implements Parcelable {
    private String name, description;
    private Integer photo;

    public MovieModel(){

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

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public MovieModel(String name, String description, Integer photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeValue(this.photo);
    }

    protected MovieModel(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.photo = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
