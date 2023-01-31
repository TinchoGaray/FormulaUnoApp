package com.tinchogaray.formulaunoapp.domain

import com.tinchogaray.formulaunoapp.data.DriversRepository
import com.tinchogaray.formulaunoapp.domain.model.Driver
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class GetRandomDriverTest {

    @RelaxedMockK
    private lateinit var driversRepository: DriversRepository

    lateinit var getRandomDriver: GetRandomDriver

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomDriver = GetRandomDriver(driversRepository)
    }

    @Test
    fun `when invoke getRandomDriver and the database is empty then return null`() = runBlocking {
        coEvery { driversRepository.getAllDriversFromDatabase() } returns emptyList()

        val response = getRandomDriver()

        assertNull(response)
    }

    @Test
    fun `when invoke getRandomDriver and the database isnt empty then return random driver`() = runBlocking {
        val driver: Driver = mockk(relaxed = true)
        val driverList = listOf(driver)
        coEvery { driversRepository.getAllDriversFromDatabase() } returns driverList

        val response = getRandomDriver()

        assertEquals(response, driver)
    }
}