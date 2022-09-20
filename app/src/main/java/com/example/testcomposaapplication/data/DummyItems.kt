package com.example.testcomposaapplication.data

class DummyItems {

    fun getDummyList() = listOf(
        ListItem.Header("Ночь"),
        ListItem.Record("00:00", "Спать"),
        ListItem.Record("01:00", "Спать"),
        ListItem.Record("02:00", "Спать"),
        ListItem.Record("03:00", "Спать"),
        ListItem.Record("04:00", "Спать"),
        ListItem.Record("05:00", "Спать"),
        ListItem.Header("Утро"),
        ListItem.Record("06:00", "Подьем"),
        ListItem.Record("07:00", "И так далее список дел"),
        ListItem.Record("08:00", "Чтобы выходил за пределы экрана"),
        ListItem.Record("09:00", "Для желающих усложнить можно попробовать сделать список с разными ViewType (заголовок “День” и список дел, заголовок “Утро” и список дел)"),
    )

}