//
package com.ui.espresso

import android.content.Context
import java.io.IOException


class DataAssetsJsonFetch(@JvmField var assetFileName: String, @JvmField var context: Context) {
    @JvmName("getJsonDataAsset")
    fun getJsonDataFromAsset(): String?{
        return this.getJsonDataFromAsset(context = this.context, fileName = this.assetFileName)
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
