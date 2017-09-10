package th.`in`.droid.keddit.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.*
import th.`in`.droid.keddit.R
import th.`in`.droid.keddit.adapter.NewsAdapter
import th.`in`.droid.keddit.extension.inflate
import th.`in`.droid.keddit.model.RedditNewsItem

class NewsFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it, // number of comments
                        1457207701L - it * 200, // time
                        "http://lorempixel.com/200/200/technics/$it", // image url
                        "url"
                )
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    companion object {

        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

}
