package br.com.thomas.adaptermultitypes.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.forEach
import br.com.thomas.adaptermultitypes.adapter.DashInterface
import br.com.thomas.adaptermultitypes.model.DashModel
import br.com.thomas.adaptermultitypes.model.Topics
import kotlinx.android.synthetic.main.topic_layout.view.*

class TopicViewHolder(view: View, dashInterface: DashInterface) : DashViewHolder<Topics>(view) {
    override fun bind(item: Topics) {
        val set = ConstraintSet()
        val topic = item
        var interator = 0
        val textList = mutableListOf<TextView>()
        for(option in topic.topicOptions){
            itemView.container?.run {
                textList.add(TextView(context))
                textList.get(interator).apply {
                    textSize = 16.0f
                    text = option.title
                }
                textList.get(interator).id = View.generateViewId()
                addView(textList.get(interator))
                set.clone(this)
                if(textList.size > 1)
                    set.connect(textList.get(interator).id, ConstraintSet.TOP, textList.get(interator.dec()).id, ConstraintSet.BOTTOM, 32)
                else
                set.connect(textList.get(interator).id, ConstraintSet.TOP, this.id, ConstraintSet.TOP, 16)
                set.connect(textList.get(interator).id, ConstraintSet.START, this.id, ConstraintSet.START)
                set.applyTo(this)
                interator++
            }
        }
    }
}