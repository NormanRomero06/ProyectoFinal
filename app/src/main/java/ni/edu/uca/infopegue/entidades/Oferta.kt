package ni.edu.uca.infopegue.entidades

class Oferta(
    val nombreOferta: String,
    val descripcionOferta: String,
    val contactoOf: String,
    val ubicacion: String,
    val requisito: String
) {
    var key: String = ""
    var eliminado: Boolean = false

}