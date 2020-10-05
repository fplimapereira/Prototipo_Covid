package com.flpereira.prototipocovid.ui.worldcases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.flpereira.prototipocovid.R
import com.flpereira.prototipocovid.util.Coroutines
import kotlinx.android.synthetic.main.world_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class WorldFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: WorldViewModelFactory by instance()
    private lateinit var viewModel: WorldViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this, factory).get(WorldViewModel::class.java)
        bindUI()
        return inflater.inflate(R.layout.world_fragment, container, false)


    }

    private fun bindUI() = Coroutines.main {
        loader.start()
        // Unresolved reference on "observe" and "Type inference failed" on "Observer"
        //viewModel.worldCasesData.await().observe(viewLifecycleOwner, Observer {)
    }

}
