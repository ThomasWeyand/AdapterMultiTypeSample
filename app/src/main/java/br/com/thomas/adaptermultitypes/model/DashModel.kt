package br.com.thomas.adaptermultitypes.model

import br.com.thomas.adaptermultitypes.R

sealed class DashModel(val type: Int)
data class TopToolbar(
    val name: String,
    val genre: String,
    val year: String,
    var isExpanded: Boolean = false
) : DashModel(R.layout.toolbar_text_layout)

data class HeaderListr(val cards: List<HeaderCard>) : DashModel(R.layout.header_list)
data class Topics(val topicOptions: List<topicOptions>) : DashModel(R.layout.topic_layout)