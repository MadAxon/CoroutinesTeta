package com.example.testcomposaapplication.data

sealed class ListItem {
    class Header(val text: String): ListItem()
    class Record(val time: String, val text: String): ListItem()
}