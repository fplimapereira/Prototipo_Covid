package com.flpereira.prototipocovid.ui.worldcases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flpereira.prototipocovid.data.repository.WorldCasesRepository

class WorldViewModelFactory(
    private val repository: WorldCasesRepository): ViewModelProvider.NewInstanceFactory() {

    override fun<T: ViewModel?> create(modelClass: Class<T>): T{
        return WorldViewModel(repository) as T
    }
}