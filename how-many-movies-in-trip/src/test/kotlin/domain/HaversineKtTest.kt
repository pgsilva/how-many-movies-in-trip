package domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HaversineKtTest {

    @Test
    fun `should calculate distance in KM and how time will spent on a plane between Los Angeles and Tokyo`() {
        val losAngeles = Coordinate(34.053490, -118.245319)
        val tokyo = Coordinate(35.670479, 139.740921)

        val distanceActual = losAngeles distanceKmTo tokyo

        assertEquals(8815.29, distanceActual) { "Distances is not equal" }

        val timeSpentAtActual = timeSpentAt(distanceActual, PLANE_AVERAGE_SPEED_KM_H)

        assertEquals(11.02, timeSpentAtActual)
    }

    @Test
    fun `should calculate distance in KM and how time will spent on a car between Santo Andre and Alagoas`() {
        val santoAndre = Coordinate(-23.655314, -46.5320878)
        val alagoas = Coordinate(-9.5713058, -36.7819505)

        val distanceActual = santoAndre distanceKmTo alagoas

        assertEquals(1877.97, distanceActual) { "Distances is not equal" }

        val timeSpentAtActual = timeSpentAt(distanceActual, CAR_AVERAGE_SPEED_KM_H)

        assertEquals(23.47, timeSpentAtActual)
    }
}