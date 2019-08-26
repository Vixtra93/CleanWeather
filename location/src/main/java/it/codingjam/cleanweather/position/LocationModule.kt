package it.codingjam.cleanweather.position

import android.app.Application
import it.codingjam.cleanweather.domain.LocationManager
import it.codingjam.cleanweather.utils.getOrCreateAppComponent

interface LocationComponent {
    val locationManager: LocationManager
}

private class LocationComponentImpl(application: Application) : LocationComponent {
    override val locationManager by lazy {
        AndroidLocationManager(application)
    }
}

val Application.locationComponent: LocationComponent
    get() = getOrCreateAppComponent {
        LocationComponentImpl(this)
    }