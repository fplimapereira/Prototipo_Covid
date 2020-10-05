package com.flpereira.prototipocovid.util

import androidx.databinding.BindingAdapter
import com.flpereira.prototipocovid.data.network.response.WorldCasesResponse
import org.eazegraph.lib.charts.PieChart

@BindingAdapter("loadData")
fun bindingData(pieChart: PieChart, response: WorldCasesResponse) {
}