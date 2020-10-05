package com.flpereira.prototipocovid.ui.worldcases

import androidx.lifecycle.ViewModel
import com.flpereira.prototipocovid.data.repository.WorldCasesRepository
import com.flpereira.prototipocovid.util.lazyDeferred

class WorldViewModel(repository: WorldCasesRepository): ViewModel() {

    val worldCasesData by lazyDeferred{
            repository.getWorldCasesData()
    }

}