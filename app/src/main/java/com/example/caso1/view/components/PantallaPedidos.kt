package com.example.caso1.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caso1.model.Pedido
import com.example.caso1.viewmodel.PedidoViewModel

@Composable
fun PantallaPedidos(modifier: Modifier = Modifier, viewModel: PedidoViewModel = viewModel()) {
    val pedidos = viewModel.pedidos.observeAsState(listOf())

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(pedidos.value) { pedido ->
            PedidoItem(pedido)
        }
    }
}
