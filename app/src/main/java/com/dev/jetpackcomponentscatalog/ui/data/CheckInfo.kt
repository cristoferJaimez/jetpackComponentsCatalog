package com.dev.jetpackcomponentscatalog.ui.data

data class CheckInfo(val title: String, var selected: Boolean = false, var onCheckedChange: (Boolean) -> Unit)