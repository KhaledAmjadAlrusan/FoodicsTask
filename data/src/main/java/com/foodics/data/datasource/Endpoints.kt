package com.foodics.data.datasource

sealed class Endpoints(val path: String) {
    object GetProducts : Endpoints("products.json?key=ec57b510")
    object GetCategories : Endpoints("categories.json?key=ec57b510")
}
