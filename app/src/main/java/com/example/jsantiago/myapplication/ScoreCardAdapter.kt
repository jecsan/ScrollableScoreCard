package com.example.jsantiago.myapplication

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import kotlinx.android.synthetic.main.item_participant.view.*

/**
 * Created by jsantiago on 1/10/18.
 */
class ScoreCardAdapter : RecyclerView.Adapter<ScoreCardAdapter.ScoreCardVH>() {

    var lastEvent: MotionEvent? = null
    var adapterPosition = 0

    val items: List<ScoreCard> = ArrayList<ScoreCard>().apply {
        add(ScoreCard("John"))
        add(ScoreCard("Mon"))
        add(ScoreCard("wat"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("sdfgsdgfd"))
        add(ScoreCard("John"))
        add(ScoreCard("Mon"))
        add(ScoreCard("wat"))
        add(ScoreCard("John"))
        add(ScoreCard("Mon"))
        add(ScoreCard("wat"))
        add(ScoreCard("John"))
        add(ScoreCard("Mon"))
        add(ScoreCard("wat"))
        add(ScoreCard("John"))
        add(ScoreCard("Mon"))
        add(ScoreCard("wat"))


    }

    val map: HashMap<Int, View> = HashMap()


    override fun onBindViewHolder(holder: ScoreCardVH, position: Int) {
        Log.d("Joed", "$position ${holder.itemView.scoreRv.scrollX}")
        holder.itemView.scoreRv.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false).apply {
        }

        holder.itemView.scoreRv.adapter = ScoreAdapter()


        val item = items[position]
        holder.itemView.nameTv.text = item.name

        holder.itemView.scoreRv.layoutManager.scrollToPosition(adapterPosition)

        map.put(position, holder.itemView.scoreRv)

        holder.itemView.scoreRv.setOnTouchListener { v, event ->
            lastEvent = event

            if (event.source != -InputDevice.SOURCE_CLASS_NONE) {
                for ((key, value) in map) {
                    if (key != position) {

                        //To prevent triggering other touch listeners
                        event.source = InputDevice.SOURCE_CLASS_NONE
                        value.onTouchEvent(event)

                    }
                }
                    adapterPosition = (holder.itemView.scoreRv.layoutManager as LinearLayoutManager).getPosition(holder.itemView)
                    Log.d("Joed", "Adapter position${adapterPosition}")
            }

            return@setOnTouchListener false

        }

        holder.itemView.scoreRv.onFlingListener = object : RecyclerView.OnFlingListener(){
            override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                return true
            }

        }

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)

        Log.d("Joed", "onAttachedToRecyclerView")
    }

    override fun onViewAttachedToWindow(holder: ScoreCardVH) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.scoreRv?.layoutManager?.scrollToPosition(adapterPosition)


    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.d("Joed", "onDetachedFromRecyclerView")
    }

    override fun onViewDetachedFromWindow(holder: ScoreCardVH?) {
        super.onViewDetachedFromWindow(holder)
        Log.d("Joed", "onViewDetachedFromWindow")

    }

    override fun onViewRecycled(holder: ScoreCardVH?) {
        super.onViewRecycled(holder)
        Log.d("Joed", "onViewRecycled")
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreCardVH =
            ScoreCardVH(LayoutInflater.from(parent.context).inflate(R.layout.item_participant, parent, false))


    class ScoreCardVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}