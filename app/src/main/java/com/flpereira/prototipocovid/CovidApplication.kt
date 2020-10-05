package com.flpereira.prototipocovid

import android.app.Application
import com.flpereira.prototipocovid.data.network.MyApi
import com.flpereira.prototipocovid.data.network.NetworkConnectionInterceptor
import com.flpereira.prototipocovid.data.repository.WorldCasesRepository
import com.flpereira.prototipocovid.ui.worldcases.WorldViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CovidApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@CovidApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { WorldCasesRepository(instance()) }
        bind() from provider { WorldViewModelFactory(instance()) }

    }

}