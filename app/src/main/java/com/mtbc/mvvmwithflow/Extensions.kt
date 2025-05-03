package com.mtbc.mvvmwithflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response


    fun parseError(response: Response<*>): String {
        return try {
// Assume the error response is in JSON format
            val errorBody = (response.errorBody() as ResponseBody).string()
            val jsonObject = JSONObject(errorBody)
            jsonObject.getString("message") // Extract the "message" field
        } catch (e: Exception) {
            "An unknown error occurred"
        }
    }
fun AppCompatActivity.moveToActivity(target: Class<*>) {
    startActivity(Intent(this, target))
    finish()
}
