package th.`in`.droid.keddit.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import th.`in`.droid.keddit.R
import th.`in`.droid.keddit.extension.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    inner class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading))
}
