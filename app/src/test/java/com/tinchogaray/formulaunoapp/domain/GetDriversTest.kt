package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.domain.driver.GetDrivers
import com.tinchogaray.formulaunoapp.domain.model.Driver
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetDriversTest {

    @RelaxedMockK
    private lateinit var driversRepository: DriversRepository

    lateinit var getDrivers: GetDrivers

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getDrivers = GetDrivers(driversRepository)
    }

    @Test
    fun `when invoke getDrivers and the api doesnt return anything then get values from database`() = runBlocking {
        coEvery { driversRepository.getAllDriversFromApi() } returns emptyList()

        getDrivers()

        coVerify(exactly = 1) { driversRepository.getAllDriversFromDatabase() }
    }

    @Test
    fun `when invoke getDrivers and the api return something then get values from api`() = runBlocking {
        val driver: Driver = mockk(relaxed = true)
        val driverList = listOf(driver)
        coEvery { driversRepository.getAllDriversFromApi() } returns driverList

        val response = getDrivers()

        coVerify(exactly = 1) { driversRepository.getAllDriversFromApi() }
        coVerify(exactly = 0) { driversRepository.getAllDriversFromDatabase() }
        assertEquals(response, driverList)
    }
}