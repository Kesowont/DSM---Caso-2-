package com.example.caso1.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caso1.model.Pedido
import com.example.caso1.model.ProductoPedido

@Composable
fun PedidoItem(pedido: Pedido) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Pedido ID: ${pedido.id}")
            Text("Cliente: ${pedido.cliente.nombre}, Dirección: ${pedido.cliente.direccion}")
            Text("Estado: ${pedido.estado}")
            Text("Total: ${pedido.total}")
            Text("Fecha: ${pedido.fecha}")
            Text("Método de Pago: ${pedido.metodoPago.detalles}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Productos:")
            pedido.productos.forEach { productoPedido: ProductoPedido ->
                val producto = productoPedido.producto
                Text("- ${producto.nombre}: ${productoPedido.cantidad} x ${producto.precio} + ${producto.impuesto * 100}% impuesto")
                Text("  Existencias restantes: ${producto.existencias}")
            }
        }
    }
}
