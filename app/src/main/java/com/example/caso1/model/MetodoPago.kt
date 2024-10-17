package com.example.caso1.model

abstract class MetodoPago {
    abstract val detalles: String
}

data class TarjetaCredito(
    val numero: String,
    val fechaCaducidad: String,
    val tipo: String
) : MetodoPago() {
    override val detalles: String = "Tarjeta: $tipo, Número: $numero"
}

data class Efectivo(val moneda: String) : MetodoPago() {
    override val detalles: String = "Pago en efectivo en $moneda"
}

data class Cheque(val nombre: String, val entidadBancaria: String) : MetodoPago() {
    override val detalles: String = "Cheque emitido por $nombre, Banco: $entidadBancaria"
}
