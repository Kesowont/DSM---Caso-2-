package com.example.caso1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caso1.model.EstadoPedido
import com.example.caso1.model.MetodoPago
import com.example.caso1.model.Pedido
import com.example.caso1.model.Producto
import com.example.caso1.ui.theme.Caso1Theme
import com.example.caso1.viewmodel.PedidoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Caso1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPedidos(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaPedidos(modifier: Modifier = Modifier, viewModel: PedidoViewModel = viewModel()) {
    val pedidos = viewModel.pedidos.observeAsState(listOf())

    LazyColumn(modifier = modifier) {
        items(pedidos.value) { pedido ->
            PedidoItem(pedido)
        }
    }
}

@Composable
fun PedidoItem(pedido: Pedido) {
    Text(text = "Pedido ID: ${pedido.id} - Total: ${pedido.total} - Estado: ${pedido.estado}")
}

@Preview(showBackground = true)
@Composable
fun PedidoItemPreview() {
    Caso1Theme {
        PedidoItem(
            Pedido(
                id = 1,
                productos = listOf(Producto("Producto A", 10.0, 2)),
                total = 20.0,
                estado = EstadoPedido.PENDIENTE,
                metodoPago = MetodoPago.Efectivo("USD"),
                fecha = "2024-10-16"
            )
        )
    }
}
