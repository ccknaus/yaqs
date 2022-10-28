package ch.ost.rj.mge.yaqs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.yaqs.model.Link
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class HistoryAdapter: RecyclerView.Adapter<HistoryViewHolder>() {
    private var links: List<Link> = ArrayList()

    fun updateLinkList(links: List<Link>) {
        this.links = links
        notifyItemChanged(this.links.lastIndex)
//        notifyDataSetChanged()
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
        holder.timeTextView.text = SimpleDateFormat("dd.MM.yy hh:mm:ss").format(link.time).toString()
//        holder.timeTextView.text = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm:ss")
    }

    override fun getItemCount(): Int {
        return links.size
    }
}