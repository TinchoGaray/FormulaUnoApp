package com.tinchogaray.formulaunoapp.domain.model

import com.tinchogaray.formulaunoapp.data.model.constructor.ConstructorModel

data class Constructor (
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String
)

fun ConstructorModel.toDomain() = Constructor(constructorId, url, name, nationality)
