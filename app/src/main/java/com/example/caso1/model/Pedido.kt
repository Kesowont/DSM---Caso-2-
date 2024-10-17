package com.example.caso1.model

data class Pedido(
    val id: Int,
    val productos: List<Producto>,
    val total: Double,
    val estado: EstadoPedido,
    val metodoPago: MetodoPago,
    val fecha: String
)
