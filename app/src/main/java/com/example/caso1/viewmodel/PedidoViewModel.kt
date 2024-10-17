package com.example.caso1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caso1.model.*

class PedidoViewModel : ViewModel() {
    private val _pedidos = MutableLiveData<List<Pedido>>()
    val pedidos: LiveData<List<Pedido>> = _pedidos

    init {
        cargarPedidos()
    }

    private fun cargarPedidos() {
        // Simulación de productos en el inventario
        val PS5 = Producto("Play Station 5", 3000.0, 0.12, 50)
        val almohada = Producto("Almohada", 25.0, 0.08, 200)

        val cliente1 = Cliente(
            id = 1,
            nombre = "Ivan Sulca",
            direccion = "Mi casita",
            telefono = "982256192"
        )

        // Creación del pedido con productos y cantidades
        val pedido1 = Pedido(
            id = 1,
            cliente = cliente1,
            productos = listOf(
                ProductoPedido(PS5, 1), // 2 unidades de Producto A
                ProductoPedido(almohada, 5)  // 1 unidad de Producto B
            ),
            total = calcularTotal(listOf(
                ProductoPedido(PS5, 1),
                ProductoPedido(almohada, 5)
            )),
            estado = EstadoPedido.PENDIENTE,
            metodoPago = Efectivo("PEN"),
            fecha = "17/10/2024"
        )

        // Intentamos reducir existencias basado en el pedido
        try {
            pedido1.productos.forEach { productoPedido ->
                productoPedido.producto.reducirExistencias(productoPedido.cantidad)
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

        _pedidos.value = listOf(pedido1)
    }

    private fun calcularTotal(productos: List<ProductoPedido>): Double {
        return productos.sumOf { it.producto.calcularPrecioConImpuesto() * it.cantidad }
    }
}
