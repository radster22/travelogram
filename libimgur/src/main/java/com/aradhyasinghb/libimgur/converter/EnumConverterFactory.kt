package com.aradhyasinghb.libimgur.converter

import com.squareup.moshi.Json
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.Exception
import java.lang.reflect.Type


enum class EnumConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<Enum<*>, String>? {
        if (type is Class<*> && type.isEnum){
        Converter<Enum<*>, String> {

            //TODO enum ka kuch hai dekh le, ig wo api vid main 1.51.05 ke ass pass mil jayega

            try {
                enum.name.javaClass.getField(enum.name).getAnnotation(Json::class.java).name
            } catch (e: Exception){
                null
            }
        }
    } else{
        null
    }
    }
}