package com.example.praktikum6;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page, @Query("per_page") int perPage);
    @GET("api/users/{id}")
    Call<UserDetailResponse> getUserDetails(@Path("id") int userId);
}
