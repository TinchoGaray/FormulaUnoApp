package com.tinchogaray.formulaunoapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriversProvider @Inject constructor() {

    //TODO: Almacenar los drivers en una BD
    //Actualmente se usa la variable para almacenar todos los drivers
    var drivers: List<Drivers> = emptyList()

}
