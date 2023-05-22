package com.example.marveltest.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}