package com.tinchogaray.formulaunoapp.data.model

class DriversProvider {

    //TODO: Almacenar los drivers en una BD
    //Actualmente se usa la variable para almacenar todos los drivers
    companion object {
        var drivers: List<Drivers> = emptyList()
    }
}
