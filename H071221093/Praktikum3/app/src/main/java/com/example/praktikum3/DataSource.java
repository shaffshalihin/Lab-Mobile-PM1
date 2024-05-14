package com.example.praktikum3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<ProfileModel> profiles = generateDummyProfiles();


    private static ArrayList<ProfileModel> generateDummyProfiles() {
        ArrayList<ProfileModel> profiles = new ArrayList<>();
        profiles.add(new ProfileModel("rezkyymaulana_", R.drawable.alif, R.drawable.liamonguitar, "19JT", "1", "Alif Rezky Maulana", "Hello, I'm Rezky.", R.drawable.alif, "ini Caption"));
        profiles.add(new ProfileModel("adrian", R.drawable.adrian, R.drawable.punk, "950", "299", "Ammar Tyo", "Hello, I'm Ammar.", R.drawable.adrian,"ini Caption"));
        profiles.add(new ProfileModel("shaff", R.drawable.shaffff, R.drawable.guwe, "1,002", "388", "Shaff solehah", "Hello, I'm shaff.", R.drawable.shaffff,"ini Caption"));
        profiles.add(new ProfileModel("rama", R.drawable.rama, R.drawable.ramatidur, "1,444", "540", "Ramadhan", "Hello, I'm rama.", R.drawable.rama,"ini Caption"));
        profiles.add(new ProfileModel("ojan", R.drawable.ojan, R.drawable.squire, "901", "205", "Ojan Jrot", "Hello, I'm ojan.", R.drawable.ojan,"ini Caption"));
        profiles.add(new ProfileModel("arni", R.drawable.arni, R.drawable.ayyub, "785", "555", "Fadel Mustapa", "Hello, I'm fadel.", R.drawable.arni,"ini Caption"));
        profiles.add(new ProfileModel("rafli", R.drawable.rafli, R.drawable.noel, "8,000", "812", "Adrian Tegar", "Hello, I'm adrian.", R.drawable.rafli,"ini Caption"));
        profiles.add(new ProfileModel("aan", R.drawable.aan, R.drawable.priscilla, "456", "200", "Alqa Je'ne", "Hello, I'm alqa.", R.drawable.aan,"ini Caption"));
        profiles.add(new ProfileModel("wali", R.drawable.wali, R.drawable.thomyorke, "744", "124", "Trisman Frenchcrop", "Hello, I'm trisman.", R.drawable.rama,"ini Caption"));
        profiles.add(new ProfileModel("jokowi", R.drawable.jokowi, R.drawable.dakota, "1", "2", "Wali Mulet", "Hello, I'm wali.", R.drawable.jokowi,"ini Caption"));
        return profiles;
    }
}