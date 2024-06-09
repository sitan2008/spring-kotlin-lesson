package com.example.kotlin_rest_api.transformer

interface Transformer <A, B>  {
    fun transform(source: A): B
}