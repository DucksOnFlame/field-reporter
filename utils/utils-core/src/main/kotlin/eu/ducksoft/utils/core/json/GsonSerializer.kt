package eu.ducksoft.utils.core.json

import com.google.gson.Gson


class GsonSerializer {
    companion object {

        fun <T> toJson(obj: T): String {
            val gson = Gson()
            return gson.toJson(obj)
        }

        fun <T> fromJson(serializedObj: String, clazz: Class<T>): T {
            val gson = Gson()
            return gson.fromJson(serializedObj, clazz)
        }
    }
}