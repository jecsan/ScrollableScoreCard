package com.example.jsantiago.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_score.view.*

/**
 * Created by jsantiago on 1/10/18.
 */
class ScoreAdapter : RecyclerView.Adapter<ScoreAdapter.ScoreVH>() {

    val scores: List<Score> = ArrayList<Score>().apply {
        for (i in 0..12) {
            add(Score(i))
        }
    }

    override fun onBindViewHolder(holder: ScoreVH, position: Int) {
        holder.itemView.valueTv.text = "${scores[position].v}"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreVH =
            ScoreVH(LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false))

    override fun getItemCount(): Int = scores.size


    class ScoreVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}