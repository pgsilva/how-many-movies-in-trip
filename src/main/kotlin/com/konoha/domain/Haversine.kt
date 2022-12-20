package com.konoha.domain

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.*

infix fun Coordinate.distanceKmTo(to: Coordinate): Double {
    val distanceLat = Math.toRadians(to.first - this.first)
    val distanceLon = Math.toRadians(to.second - this.second)

    val originLat = Math.toRadians(this.first)
    val destinationLat = Math.toRadians(to.first)

    val a = sin(distanceLat / 2).pow(2.0) + sin(distanceLon / 2).pow(2.0) * cos(originLat) * cos(destinationLat)
    val c = 2 * asin(sqrt(a))

    return BigDecimal(EARTH_RADIUS_KM * c).setScale(2, RoundingMode.HALF_UP).toDouble()
}

fun timeSpentAt(distanceKm: Double, speedKmH: Double): Hours {
    val time = distanceKm / speedKmH
    return BigDecimal(time).setScale(2, RoundingMode.HALF_UP).toDouble()
}