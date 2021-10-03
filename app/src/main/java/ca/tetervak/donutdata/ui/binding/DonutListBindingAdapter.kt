package ca.tetervak.donutdata.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.tetervak.donutdata.domain.Donut
import ca.tetervak.donutdata.ui.donutlist.DonutListAdapter

@BindingAdapter("donutList")
fun bindDonutList(recyclerView: RecyclerView, list: List<Donut>?){
    if(list is List<Donut>){
        val adapter = recyclerView.adapter as DonutListAdapter
        adapter.submitList(list)
    }
}