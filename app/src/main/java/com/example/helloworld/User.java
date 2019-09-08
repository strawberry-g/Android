package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

import javax.crypto.spec.PSource;
import java.io.Serializable;

//第一种自动序列化implements Serializable
//第二种手动序列化implements Serializable
public class User implements Parcelable {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //手动序列化
        parcel.writeString(getName());
        parcel.writeInt(getAge());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(),parcel.readInt());
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };
}
