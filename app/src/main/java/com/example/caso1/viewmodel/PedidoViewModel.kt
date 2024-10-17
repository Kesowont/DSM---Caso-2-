package com.example.caso1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caso1.model.Pedido
import com.example.caso1.model.Producto
import com.example.caso1.model.EstadoPedido
import com.example.caso1.model.MetodoPago

class PedidoViewModel : ViewModel() {
    private val _pedidos = MutableLiveData<List<Pedido>>()
    val pedidos: LiveData<List<Pedido>> = _pedidos

    init {
        cargarPedidos()
    }

    private fun cargarPedidos() {
        // Simulación de pedidos
        val pedido1 = Pedido(
            id = 1,
            productos = listOf(Producto("Producto A", 10.0, 2)),
            total = 20.0,
            estado = EstadoPedido.PENDIENTE,
            metodoPago = MetodoPago.Efectivo("USD"),
            fecha = "2024-10-16"
        )

        val pedido2 = Pedido(
            id = 2,
            productos = listOf(Producto("Producto B", 15.0, 1)),
            total = 15.0,
            estado = EstadoPedido.PROCESANDO,
            metodoPago = MetodoPago.TarjetaCredito("123456789", "12/24", "VISA"),
            fecha = "2024-10-17"
        )

        _pedidos.value = listOf(pedido1, pedido2)
    }
}
