package com.example.domain

data class User(val id: Id, val name: Name, val publishDate: PublishDate)

data class Id(val value: Int)
data class Name(val value: String)
data class PublishDate(val value: String)
