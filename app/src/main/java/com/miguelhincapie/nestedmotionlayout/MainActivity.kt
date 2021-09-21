package com.miguelhincapie.nestedmotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.miguelhincapie.nestedmotionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TripsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        setUpMotionLayoutListener()
    }

    private fun initAdapter() {
        adapter = TripsAdapter(generateDummyContent())
        binding.recyclerView.adapter = adapter
    }

    //region from MotionLayout.TransitionListener
    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {
        updateNestedMotionLayout(motionLayout)
    }

    override fun onTransitionChange(
        motionLayout: MotionLayout?,
        startId: Int,
        endId: Int,
        progress: Float
    ) {
        updateNestedMotionLayout(motionLayout)
    }

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
        updateNestedMotionLayout(motionLayout)
    }

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {
        updateNestedMotionLayout(motionLayout)
    }
    //endregion

    private fun updateNestedMotionLayout(motionLayout: MotionLayout?) = motionLayout?.let {
        with(binding) {
            if (it.id == rootContainer.id) {
                headerContainer.progress = it.progress
                childHeaderContainer.progress = it.progress
            }
        }
    }

    private fun setUpMotionLayoutListener() = with(binding) {
        rootContainer.setTransitionListener(this@MainActivity)
        headerContainer.setTransitionListener(this@MainActivity)
        childHeaderContainer.setTransitionListener(this@MainActivity)
    }

    private fun generateDummyContent(): Array<Trip> {
        return arrayOf(
            Trip(
                R.drawable.ic_baseline_airplane_ticket_24,
                "Travel 1 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airport_shuttle_24,
                "Travel 2 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_anchor_24,
                "Travel 3 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airplane_ticket_24,
                "Travel 4 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airport_shuttle_24,
                "Travel 5 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_anchor_24,
                "Travel 6 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airplane_ticket_24,
                "Travel 7 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airport_shuttle_24,
                "Travel 8 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_anchor_24,
                "Travel 9 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airplane_ticket_24,
                "Travel 10 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airport_shuttle_24,
                "Travel 11 dummy description"
            ),
            Trip(
                R.drawable.ic_baseline_airport_shuttle_24,
                "Travel 12 dummy description"
            )
        )
    }
}