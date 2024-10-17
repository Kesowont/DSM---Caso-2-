package com.example.caso1.model

data class Pedido (
    val id: Int,
    val cliente: Cliente, // Agregación: Cliente puede existir sin el Pedido
    val productos: List<ProductoPedido>, // Composición: Los productos forman parte del pedido
    val total: Double,
    val estado: EstadoPedido,
    val metodoPago: MetodoPago,
    val fecha: String
)
