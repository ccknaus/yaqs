package ch.ost.rj.mge.yaqs.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.yaqs.model.Link
import java.text.SimpleDateFormat
import java.util.*

interface HistoryAdapterSelectedCallback {
    fun elementSelected(link : Link)
}

class HistoryAdapter(val callback : HistoryAdapterSelectedCallback) : RecyclerView.Adapter<HistoryViewHolder>() {
    private var links: List<Link> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateLinkList(links: List<Link>) {
        this.links = links
        notifyDataSetChanged()
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
        // holder.row_linearlayout.setBackgroundColor(Color.parseColor("#567845"))
        holder.itemView.setOnClickListener{ _ ->
            callback.elementSelected(link)
        }

    }

    override fun getItemCount(): Int {
        return links.size
    }
}