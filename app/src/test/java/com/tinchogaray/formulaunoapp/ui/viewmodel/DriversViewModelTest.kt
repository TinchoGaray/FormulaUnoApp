package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tinchogaray.formulaunoapp.domain.GetDrivers
import com.tinchogaray.formulaunoapp.domain.GetRandomDriver
import com.tinchogaray.formulaunoapp.domain.model.Driver
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DriversViewModelTest {

    @RelaxedMockK
    private lateinit var getDrivers: GetDrivers

    @RelaxedMockK
    private lateinit var getRandomDriver: GetRandomDriver

    lateinit var driversViewModel: DriversViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        driversViewModel = DriversViewModel(getDrivers, getRandomDriver)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when view model is created at the first time then get all drivers and set first value`() = runTest {
        val firstDriver: Driver = mockk(relaxed = true)
        val secondDriver: Driver = mockk(relaxed = true)
        val driverList = listOf(firstDriver, secondDriver)
        coEvery { getDrivers() } returns driverList

        driversViewModel.onCreate()

        assertEquals(driversViewModel.driverModel.value, firstDriver)
    }

    @Test
    fun `when randomDriver is called then return a driver set on livedata`() = runTest {
        val driver: Driver = mockk(relaxed = true)
        coEvery { getRandomDriver() } returns driver

        driversViewModel.randomDriver()

        assertEquals(driversViewModel.driverModel.value, driver)
    }

    @Test
    fun `when randomDriver is called and getRandomDriver return null then keep the last value`() = runTest {
        val driver: Driver = mockk(relaxed = true)
        driversViewModel.driverModel.value = driver
        coEvery { getRandomDriver() } returns null

        driversViewModel.randomDriver()

        assertEquals(driversViewModel.driverModel.value, driver)
    }
}