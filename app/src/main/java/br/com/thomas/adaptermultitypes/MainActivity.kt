package br.com.thomas.adaptermultitypes

import android.os.Bundle
import android.transition.TransitionManager
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import br.com.thomas.adaptermultitypes.adapter.DashAdapter
import br.com.thomas.adaptermultitypes.adapter.TypesFactoryImp
import br.com.thomas.adaptermultitypes.model.DashModel
import br.com.thomas.adaptermultitypes.model.TopToolbar
import br.com.thomas.adaptermultitypes.model.Topics
import br.com.thomas.adaptermultitypes.model.topicOptions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TransitionInterface {

    private val dashAdapter = DashAdapter(TypesFactoryImp(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun delayItem() {
        recycleContainer?.run { TransitionManager.beginDelayedTransition(this) }
    }

    private fun init() {
        recycleContainer?.apply {
            //(itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
                override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    if (e.action == MotionEvent.ACTION_DOWN && rv.scrollState == RecyclerView.SCROLL_STATE_SETTLING) {
                        rv.stopScroll()
                    }
                    return false
                }
                override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
            })
            adapter = dashAdapter
        }
        dashAdapter.addItems(buildList())
    }

    private fun buildList(): List<DashModel> {
        return listOf(
            TopToolbar(
                "Léon: The Professional", "Genre:  Crime, Drama, Thriller"
            , "1993"),
            Topics(buildTopicoptions()),
            Topics(buildTopicoptions()),
            TopToolbar(
                "Léon: The Professional", "Genre:  Crime, Drama, Thriller"
                , "1993"),
            Topics(buildTopicoptions()),
            Topics(buildTopicoptions())
        )
    }

    private fun buildTopicoptions() : List<topicOptions>{
        return listOf(
            topicOptions(
                "111111111111111", "222222222222"
            ),
            topicOptions(
                "111111111111111", "222222222222"
            ),
            topicOptions(
                "111111111111111", "222222222222"
            ),
            topicOptions(
                "111111111111111", "222222222222"
            )
        )
    }
}
