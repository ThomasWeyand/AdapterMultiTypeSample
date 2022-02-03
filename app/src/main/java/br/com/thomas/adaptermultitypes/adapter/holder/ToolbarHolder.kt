package br.com.thomas.adaptermultitypes.adapter.holder

import android.view.View
import br.com.thomas.adaptermultitypes.adapter.DashInterface
import br.com.thomas.adaptermultitypes.model.TopToolbar
import kotlinx.android.synthetic.main.toolbar_text_layout.view.*

class ToolbarHolder(view: View, private val dashInterface: DashInterface) :
    DashViewHolder<TopToolbar>(view) {
    override fun bind(item: TopToolbar) {
        itemView.apply {
            item.let { toolbar ->
                toolbar.isExpanded = dashInterface.getExpandedPosition() == adapterPosition
                sub_item.visibility = if (toolbar.isExpanded) View.VISIBLE else View.GONE
                isActivated = toolbar.isExpanded
                item_title.text = toolbar.name
                sub_item_genre.text = toolbar.genre
                sub_item_year.text = toolbar.year
                setOnClickListener {
                    if (toolbar.isExpanded)
                        dashInterface.notifySingularItem(-1)
                    else
                        dashInterface.notifySingularItem(adapterPosition)
                }
            }
        }
    }
}