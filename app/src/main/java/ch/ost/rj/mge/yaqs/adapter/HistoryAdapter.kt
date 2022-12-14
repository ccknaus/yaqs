package ch.ost.rj.mge.yaqs.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.yaqs.model.Link
import java.text.SimpleDateFormat
import java.util.*

interface HistoryAdapterSelectedCallback {
    fun elementSelected(link: Link)
    fun elementsCount(count: Int)
    fun elementDelete(link: Link)
}

class HistoryAdapter(private val callback : HistoryAdapterSelectedCallback) : RecyclerView.Adapter<HistoryViewHolder>() {
    private var links: List<Link> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateLinkList(links: List<Link>) {
        this.links = links
        notifyDataSetChanged()
        callback.elementsCount(itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val context: Context = parent.context
        val view: View = LayoutInflater
            .from(context)
            .inflate(
                android.R.layout.simple_list_item_2,
                parent,
                false
            )
        val linkTextView = view.findViewById<TextView>(android.R.id.text1)
        val timeTextView = view.findViewById<TextView>(android.R.id.text2)
        return HistoryViewHolder(view, linkTextView, timeTextView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val link: Link = links[position]
        holder.linkTextView.text = link.url
        holder.timeTextView.text = SimpleDateFormat("dd.MM.yy hh:mm:ss", Locale.ENGLISH).format(link.time).toString()
        callback.elementsCount(itemCount)
        holder.itemView.setOnClickListener{
            setFadeAnimation(holder.itemView)
            callback.elementSelected(link)
        }
        holder.itemView.setOnLongClickListener{ v: View ->
            v.isLongClickable = true
            callback.elementDelete(link)
            true
        }
    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        view.startAnimation(anim)
    }

    override fun getItemCount(): Int {
        return links.size
    }
}