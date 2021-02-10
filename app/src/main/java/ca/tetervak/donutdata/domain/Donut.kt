package ca.tetervak.donutdata.domain

data class Donut(
    val id: String?,
    val name: String,
    val description: String,
    val rating: Float,
    val lowFat: Boolean = false
)