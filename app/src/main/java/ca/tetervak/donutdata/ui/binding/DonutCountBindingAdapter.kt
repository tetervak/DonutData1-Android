package ca.tetervak.donutdata.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.donutdata.R
import ca.tetervak.donutdata.domain.Donut

@BindingAdapter("donutCount")
fun bindDonutCount(textView: TextView, list: List<Donut>?){
    val count = list?.size ?: 0
    textView.text =
        textView.resources.getQuantityString(R.plurals.donut_count, count, count)
}